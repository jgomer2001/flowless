grammar AuthnFlow;

/*
 * Fix for Python-like indentation tokens. See https://github.com/yshavit/antlr-denter
 */

tokens { INDENT, DEDENT }

@lexer::header {
  import com.yuvalshavit.antlr4.DenterHelper;
}

@lexer::members {
  private final DenterHelper denter = DenterHelper.builder()
    .nl(NL)
    .indent(AuthnFlowParser.INDENT)
    .dedent(AuthnFlowParser.DEDENT)
    .pullToken(AuthnFlowLexer.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}

NL: ('\r'? '\n' ' '*);

/*
 * Parser Rules
 */

flow: header statement+ ;

qname: ALPHANUM | DOTEXPR ;

header: FLOWSTART WS qname WS? NL inputs? NL* ;	// header always ends in a NL

inputs: FLOWINPUTS param* WS? NL ;

param: WS ALPHANUM ;


statement: (invocation | assignment | log | accept | reject | ifelse | choice | loop) ;

invocation: (variable WS? EQ WS?)? (flow_call | task_call) NL ;

variable: ALPHANUM | IDXEXPR | DOTEXPR | DOTIDXEXPR ;

flow_call: FLOWCALL WS call ;

task_call: TASKCALL WS call ;

log: LOG argument+ WS? NL ;

call: qname argument* WS?;

argument: WS simple_expr ;

simple_expr: literal | variable ;

literal: BOOL | DECIMAL | STRING ;

expression: object_expr | array_expr | simple_expr ;

array_expr: '[' WS? expression* (SPCOMMA expression)* WS? ']' ;

object_expr: '{' WS? keypair* (SPCOMMA keypair)* WS? '}' ;

assignment: variable WS? EQ WS? expression NL ;

keypair: ALPHANUM WS? ':' WS? expression ;

accept: ACCEPT WS (STRING | object_expr) WS? NL ;

reject: REJECT WS (STRING | object_expr) WS? NL ;

choice: MATCH WS simple_expr WS TO WS? INDENT option+ DEDENT elseblock? ;

option: simple_expr WS? INDENT statement+ DEDENT ;

ifelse: caseof WS? INDENT statement+ DEDENT elseblock? ;

caseof: WHEN WS simple_expr WS IS WS simple_expr ;

elseblock: OTHERWISE WS? INDENT statement+ DEDENT ;

loop: TRY WS simple_expr WS TRYTIMES WS? INDENT statement+ quit_stmt? DEDENT ;

quit_stmt: QUIT WS caseof WS? NL elseblock? ;

/*
 * Lexer Rules
 */

fragment DIGIT : [0-9] ;
fragment CH : [a-zA-Z_] ;
fragment ALNUM : CH (CH | DIGIT)* ;
fragment UINT : DIGIT+ ;
fragment SPACES: [\t ]+ ;
fragment COMMA: ',' ;

COMMENT: '//' ~[\r\n]* -> skip;

FLOWSTART: 'Flow' ;

FLOWINPUTS: 'Inputs:' ;

LOG: 'Log' ;

FLOWCALL: 'Trigger' ;

TASKCALL: 'Call' ;

WHEN: 'When' ;

IS: 'is' ;

OTHERWISE: 'Otherwise' ;

MATCH: 'Match' ;

TO: 'to' ;

TRY: 'Try' ;

TRYTIMES: 'times' ;

QUIT: 'Quit' ;

ACCEPT: 'Accept' ;

REJECT: 'Reject' ;

EQ: '=' ;

BOOL: 'false' | 'true' ;
 
DECIMAL: '-'? UINT ('.' UINT)? ;

STRING: '"' [\u0009\u0020-\u007E\u0080-\u008C\u00A0-\uFFFF]* '"' ;

ALPHANUM: ALNUM ;

DOTEXPR: ALNUM ('.' ALNUM )+ ;

IDXEXPR: ALNUM '[' UINT ']' ;

DOTIDXEXPR: ALNUM ('[' UINT ']')? ('.' ALNUM ('[' UINT ']')? )+ ;

SPCOMMA: SPACES? COMMA SPACES? ;

WS: SPACES ;	//Entails "spaces" (plural)
