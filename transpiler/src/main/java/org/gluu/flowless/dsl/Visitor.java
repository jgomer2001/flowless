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

    private static Logger logger = LoggerFactory.getLogger(Visitor.class);
    private static Set<Integer> INCLUDE_SYMBOLS;
    private static Set<Integer> RULES_AS_TEXT;
    
    static {
        Integer[] includeSymbols = new Integer[] {
            AuthnFlowParser.NOT, AuthnFlowParser.AND, AuthnFlowParser.OR, AuthnFlowParser.MINUS,
            AuthnFlowParser.NUL, AuthnFlowParser.BOOL, AuthnFlowParser.STRING,
            AuthnFlowParser.UINT, AuthnFlowParser.SINT, AuthnFlowParser.DECIMAL,
            AuthnFlowParser.ALPHANUM, AuthnFlowParser.DOTEXPR, AuthnFlowParser.IDXEXPR, AuthnFlowParser.DOTIDXEXPR
        };
        
        INCLUDE_SYMBOLS = new HashSet(Arrays.asList(includeSymbols));
        
        Integer[] asIs = new Integer[] {
            AuthnFlowParser.RULE_expression, AuthnFlowParser.RULE_object_expr,
            AuthnFlowParser.RULE_array_expr, AuthnFlowParser.RULE_simple_expr          
        };
        
        RULES_AS_TEXT = new HashSet(Arrays.asList(asIs));
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

                RuleContext rc = (RuleContext) child;
                int ind = rc.getRuleIndex();
                
                if (RULES_AS_TEXT.contains(ind)) {
                    elem = Saplings.elem(getRuleName(ind)).withText(rc.getText());
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

    public static SaplingDocument document(ParseTree tree, int ruleIndex) {
        return Saplings.doc().withChild(visitElement(tree, ruleIndex));
    }

}
