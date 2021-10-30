package org.gluu.flowless.playground.actions;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.javadoc.JavadocBlockTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.javaparser.javadoc.JavadocBlockTag.Type.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleMethodDeclaration {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MethodDeclaration methodDeclaration;
    
    public SimpleMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public String getDeclaration() {
        return methodDeclaration.getDeclarationAsString(false, false, true);
    }
    
    public Action makeAction(String clsName) {

        Action a = new Action();
        a.setId(String.format("%s#%s", clsName, methodDeclaration.getName().asString()));

        Javadoc javaDoc = methodDeclaration.getJavadoc().orElse(null);

        if (javaDoc != null) {
            
            boolean deprecated = false;
            String thrws = "";
            String output = "";
            List<Input> inputs = new ArrayList<>();
            
            for (JavadocBlockTag block : javaDoc.getBlockTags()) {
                switch (block.getType()) {
                    case AUTHOR:
                        a.setAuthor(block.getContent().toText());
                        break;
                    case DEPRECATED:
                        deprecated = true;
                        break;
                    case PARAM:
                        //logger.debug("param {}", block.getContent().toText());
                            Input input = new Input();
                            input.setName(block.getName().orElse(""));
                            inputs.add(input);
                        break;
                    case RETURN:
                        output = block.getContent().toText();
                        break;
                    case THROWS:
                        thrws += ", (" + block.getName().orElse("") + ")" + block.getContent().toText();
                        break;            
                }
            }
            
            String desc = javaDoc.getDescription().toText();
            if (deprecated) {
                desc = "This method is deprecated!. " + desc;
            }
            
            if (thrws.length() > 0) {
                if (output.length() > 0) {
                    output += ". ";
                }
                output += "Errors can be thrown: " + thrws.substring(2);
            }
            
            a.setDescription(desc);
            a.setOutput(output);
            a.setInputs(inputs);
            
        }
        
        return a;
    }
    
}
