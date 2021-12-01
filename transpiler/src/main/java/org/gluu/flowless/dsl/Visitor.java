package org.gluu.flowless.dsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.saxon.sapling.SaplingDocument;
import net.sf.saxon.sapling.SaplingElement;
import net.sf.saxon.sapling.SaplingNode;
import net.sf.saxon.sapling.Saplings;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.gluu.flowless.antlr.AuthnFlowParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Visitor {
    
    public static final String FLOWNAME_XPATH_EXPR = "/flow/header/qname/text()";

    private static Logger logger = LoggerFactory.getLogger(Visitor.class);
    private static final Set<Integer> INCLUDE_SYMBOLS;
    private static final Set<Integer> RULES_AS_TEXT;
    private static final Set<String> JS_KEYWORDS;
    
    static {
        Integer[] asText = new Integer[] {
            AuthnFlowParser.RULE_qname, AuthnFlowParser.RULE_short_var, AuthnFlowParser.RULE_variable,
            AuthnFlowParser.RULE_expression, AuthnFlowParser.RULE_object_expr,
            AuthnFlowParser.RULE_array_expr, AuthnFlowParser.RULE_simple_expr
        };
        
        RULES_AS_TEXT = new HashSet(Arrays.asList(asText));

        Integer[] includeSymbols = new Integer[] {
            AuthnFlowParser.NOT, AuthnFlowParser.AND, AuthnFlowParser.OR, AuthnFlowParser.MINUS,
            AuthnFlowParser.NUL, AuthnFlowParser.BOOL, AuthnFlowParser.STRING,
            AuthnFlowParser.UINT, AuthnFlowParser.SINT, AuthnFlowParser.DECIMAL,
            AuthnFlowParser.ALPHANUM, AuthnFlowParser.DOTEXPR, AuthnFlowParser.IDXEXPR, AuthnFlowParser.DOTIDXEXPR
        };
        
        INCLUDE_SYMBOLS = new HashSet(Arrays.asList(includeSymbols));
       
        // Based on https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Lexical_grammar#keywords
        String[] javascriptKeywords = new String[] {
            "break", "case", "catch", "class", "const", "continue", 
            "debugger", "default", "delete", "do", "else", "export", "extends", 
            "finally", "for", "function", "if", "import", "in", "instanceof", "new", 
            "return", "super", "switch", "this", "throw", "try", "typeof", 
            "var", "void", "while", "with", "yield",
            "enum", "await", "let",
            //"special" values
            "undefined", "NaN", "Infinity"
        };
        
        JS_KEYWORDS = new HashSet(Arrays.asList(javascriptKeywords));
        
    }
    
    private static String getRuleName(int ruleIndex) {
        return AuthnFlowParser.ruleNames[ruleIndex];
    }
    
    public static SaplingElement visitElement(ParseTree tree, int ruleIndex) {

        List<SaplingElement> childElements = new ArrayList<>();
        int nchildren = tree.getChildCount();

        for (int i = 0; i < nchildren; i++) {
            ParseTree child = tree.getChild(i);
            SaplingElement elem = null;
            
            if (child instanceof RuleContext) {

                RuleContext ruleCtx = (RuleContext) child;
                int ind = ruleCtx.getRuleIndex();
                
                if (RULES_AS_TEXT.contains(ind)) {
                    //elem = Saplings.elem(getRuleName(ind)).withText(ruleCtx.getText());
                    
                    elem = Saplings.elem(getRuleName(ind))
                            .withText(descendantsTextWithKeywordsCorrection(child));
                } else {
                    elem = visitElement(child, ind);
                }

            } else if (child instanceof TerminalNode) {
                Token token = ((TerminalNode) child).getSymbol();
                int type = token.getType();

                if (INCLUDE_SYMBOLS.contains(type)) {
                    //logger.debug("{} {}", token.getType(), token.getText());
                    String name = AuthnFlowParser.VOCABULARY.getSymbolicName(type);
                    elem = Saplings.elem(name).withText(token.getText());
                }
            }
            
            if (elem != null) {
                childElements.add(elem);                
            }
        }

        return Saplings.elem(getRuleName(ruleIndex))
                .withChild(childElements.toArray(new SaplingNode[0]));

    }

    private static String descendantsTextWithKeywordsCorrection(ParseTree tree) {
        
        String text = null;
        if (tree instanceof RuleContext) {
            RuleContext ruleCtx = (RuleContext) tree;
            int ind = ruleCtx.getRuleIndex();

            if (AuthnFlowParser.RULE_variable == ind || AuthnFlowParser.RULE_short_var == ind) {
                text = correctedVariable(ruleCtx.getText());
            } else {
                text = "";
                for (int i = 0; i < tree.getChildCount(); i++) {
                    text += descendantsTextWithKeywordsCorrection(tree.getChild(i));
                }
            }
        } else if (tree instanceof TerminalNode) {
            Token token = ((TerminalNode) tree).getSymbol();
            text = token.getText();
        }
        return text;  
                     
    }

    private static String correctedVariable(String variable) {

        int dotIndex = variable.indexOf(".");
        int rbIndex = variable.indexOf("[");
        int index;
        
        if (dotIndex != -1) {
            if (rbIndex != -1) {
                index = Math.min(dotIndex, rbIndex);
            } else {
                index = dotIndex;
            }
        } else {
            index = rbIndex;
        }
        
        String identifier =  index == -1 ? variable : variable.substring(0, index);
        if (JS_KEYWORDS.contains(identifier)) {
            logger.trace("Renaming variable {}", variable);
            identifier = "_" + identifier;
        }
        return index == -1 ? identifier : identifier + variable.substring(index);
        
    }
    
    public static SaplingDocument document(ParseTree tree, int ruleIndex, String treeId) {
        return Saplings.doc().withChild(visitElement(tree, ruleIndex).withAttr("id", treeId));
    }

}
//preassign > variable
//preassign_catch > variable
//simple_expr > variable
//simple_expr > MINUS variable
//expression > simple_expr > ...