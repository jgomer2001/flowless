package org.gluu.flowless.playground.actions.java;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.javadoc.JavadocBlockTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import org.gluu.flowless.playground.actions.Action;
import org.gluu.flowless.playground.actions.Name;

import static com.github.javaparser.javadoc.JavadocBlockTag.Type.*;

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
            List<Name> inputs = new ArrayList<>();
            
            for (JavadocBlockTag block : javaDoc.getBlockTags()) {
                switch (block.getType()) {
                    case AUTHOR:
                        a.setAuthor(block.getContent().toText());
                        break;
                    case DEPRECATED:
                        deprecated = true;
                        break;
                    case PARAM:
                            Name input = new Name();
                            input.setDisplayName(block.getName().orElse(""));
                            input.setDescription(block.getContent().toText());
                            inputs.add(input);
                        break;
                    case RETURN:
                        output = block.getContent().toText();
                        break;
                    case THROWS:
                        thrws += ", (" + block.getName().orElse("") + ") " + block.getContent().toText();
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
            
            Name name = new Name();
            name.setDescription(desc);
            a.setName(name);
            
            a.setOutput(output);
            a.setInputs(inputs);
        }
        
        return a;
    }
    
}
