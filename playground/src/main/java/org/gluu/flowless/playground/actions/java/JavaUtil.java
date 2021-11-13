package org.gluu.flowless.playground.actions.java;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.gluu.flowless.playground.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.util.Pair;

public class JavaUtil {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    private static final Pattern qualifiedJavaClassName = Pattern.compile("^\\w+(\\.\\w+)*$");
    
    /*
    public static String checkJavaSyntaxValidity(String javaSource) {
        
        String packageName = null;
        try {
            CompilationUnit cu = StaticJavaParser.parse(javaSource);
            packageName = cu.findFirst(PackageDeclaration.class)
                    .map(PackageDeclaration::getNameAsString).orElse("");
        } catch (ParseProblemException e) {
            String error;
            if (e.getProblems().isEmpty()) {
                error = e.getMessage();
            } else {
                error = e.getProblems().get(0).getVerboseMessage();
            }
            logger.error(error);
        }

        return packageName;
        
    }*/
    
    public static Pair<String, String> checkJavaSyntaxValidity(String javaSource) {
        
        Pair<String, String> qName;
        try {            
            class MyVisitor extends VoidVisitorAdapter<Void> {
                
                String packageName;
                String className;
                
                @Override
                public void visit(PackageDeclaration pd, Void arg) {
                    packageName = pd.getNameAsString();
                }
                
                @Override
                public void visit(ClassOrInterfaceDeclaration cd, Void arg) {
                    
                    if (!cd.isInnerClass() && !cd.isLocalClassDeclaration() && cd.isPublic()) {
                        className = cd.getNameAsString();
                        //logger.debug("class {} is public: {}", className, cd.isPublic());
                    }

                }
                
            }
            
            CompilationUnit cu = StaticJavaParser.parse(javaSource);
            MyVisitor visitor = new MyVisitor();
            visitor.visit(cu, null);            
                    
            logger.debug("Visited: {} {}", visitor.packageName, visitor.className);
            qName = new Pair<>(visitor.packageName, visitor.className);
            
        } catch (ParseProblemException e) {
            String error;
            if (e.getProblems().isEmpty()) {
                error = e.getMessage();
            } else {
                error = e.getProblems().get(0).getVerboseMessage();
            }
            logger.error(error);
            qName = new Pair<>(null, null);
        }
        return qName;
        
    }
    
    public static List<MethodDeclaration> getPublicStaticMethodDeclarations(String javaSource,
            String qualifiedNameCls) {
        
        List<MethodDeclaration> decls = Collections.emptyList();
        try {
            CompilationUnit cu = StaticJavaParser.parse(javaSource);
            decls = cu.findAll(MethodDeclaration.class).stream().filter(md -> 
                            md.isPublic() && md.isStatic() && 
                            md.findAncestor(ClassOrInterfaceDeclaration.class)
                                    .map(cd -> cd.getFullyQualifiedName().orElse(null))
                                    .map(qualifiedNameCls::equals).orElse(false)
                    )
                    .collect(Collectors.toList());
        } catch (ParseProblemException e) {
            logger.error(e.getMessage(), e);
        }
        return decls;

        
    }
    
    private static String guessQualifiedPackageName(String javaSource) {
        
        String fqdn;
        String pack = "package";
        int from = 0;
        
        do {
            fqdn = null;
            int i = javaSource.indexOf(pack, from);
            if (i >= 0) {
                int j = javaSource.indexOf(";", i + 1);
                
                if (j > 0) {
                    fqdn = javaSource.substring(i + pack.length() + 1, j).strip();

                    //System.out.println("Candidate fqdn " + fqdn);
                    if (qualifiedJavaClassName.matcher(fqdn).matches()) {
                        break;
                    } else {
                        fqdn = null;
                        from = i + pack.length();
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        } while (from < javaSource.length());
        
        return fqdn;
        
    }
    
    public static void main(String ...args) throws Exception {
    
        //aaaaab
        //package co
        //package co; + variants
        //package pa.co;
        //wtf in the package of sin;
        //package blah ; package boo; + variants
        //String q = guessQualifiedPackageName("package pa.co;");
        //logger.info(q);
        
        String clas = "@wt package gay; class C {} class A { class B {} }";

        CompilationUnit cu = StaticJavaParser.parse(
                Paths.get("/home/jgomer/Downloads/jetty/jetty-base/at/scripts/org/gluu/flowless/dsl/Transpiler.groovy"));
        /*MethodDeclaration decl = cu.findAll(MethodDeclaration.class).stream()
                .filter(d -> d.isPublic() && d.isStatic())
                    .collect(Collectors.toList()).get(0);*/
        
        cu.findAll(MethodDeclaration.class).forEach(md -> {
            String fqdn = md.findAncestor(ClassOrInterfaceDeclaration.class)
                    .map(cd -> cd.getFullyQualifiedName().orElse("!")).orElse("?");
            logger.debug("Method {} from {} is void {}", md.getDeclarationAsString(false, false, true), fqdn, md.getType().isVoidType());
        });
        
    }
    
}
