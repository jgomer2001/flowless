# Flowless (transpiler)

Generates code runnable through Mozilla Rhino based on a flow description written in DSL.

The transformation chain is: DSL program -> (ANTLR4) parse tree -> (XML) abstract syntax tree -> JS

## How to use

Transpiler logic is in class `org.gluu.flowless.dsl.Transpiler`:

- Method `asXML` converts DSL code to parse tree and then to AST (abstract syntax tree)
- Method `generateJS` converts AST to JS code

For convenience there is a `main` method that can be called from the command line:

```
mvn clean install
mvn -o exec:java -Dexec.mainClass=org.gluu.flowless.dsl.Transpiler -Dexec.args="..."
```

In its basic form two parameters are expected:

1. path of file containing the flow implementation in DSL
1. flow ID (this will be name of the javascript function that will be generated)

The flow ID has to match with ID stored in the flow metadata (json). This correlation is important. 

Currently `main` method outputs to console:
- The AST
- A summary of the flow inputs
- The generated code

**or**

The error details if transpilation failed

## Notes

- The DSL is specified in [this](https://github.com/jgomer2001/flowless/blob/main/transpiler/grammar/AuthnFlow.g4) ANTLR4 grammar

- The transformation chain guarantees that flows cannot:

    - Access Java classes/instances not specified in the original program
    - Access/modify the standard javascript built-in objects directly
    - Conflict with javascript keywords 

- The last step of the transformation chain is carried out by a [Freemarker transformer](https://freemarker.apache.org/docs/xgui_preface.html) that superseded an XSLT stylesheet initially employed
