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

NL: '\r'? '\n' [\t ]* ;

/*
 * Parser Rules
 */

flow: header statement+ ;

qname: ALPHANUM | DOTEXPR ;

header: FLOWSTART WS qname WS? INDENT base inputs? DEDENT NL* ;
// header always ends in a NL

base: BASE WS STRING WS? NL;
 
inputs: FLOWINPUTS (WS short_var)+ WS? NL ;

short_var: ALPHANUM ;

statement: (flow_call | action_call | rrf_call | assignment | log | redirect | finish | ifelse | choice | loop) ;

preassign: variable WS? EQ WS? ;

preassign_catch: variable WS? '|' WS? short_var WS? EQ WS? ;

variable: short_var | IDXEXPR | DOTEXPR | DOTIDXEXPR ;

flow_call: preassign? FLOWCALL WS call (overrides | NL) ;

overrides: INDENT OVERRIDE WS STRING (WS STRING)* WS? NL DEDENT ;
//I don't get why the NL is needed above

action_call: (preassign | preassign_catch)? ACTIONCALL WS call NL ;

rrf_call: preassign? RRFCALL WS STRING (WS variable)? WS? (statusr_block | NL) ;

log: LOG argument+ WS? NL ;

call: qname ('#' ALPHANUM)? argument* WS? ;

argument: WS simple_expr ;

simple_expr: literal | variable | (MINUS variable) ;

literal: BOOL | STRING | UINT | SINT | DECIMAL | NUL;

expression: object_expr | array_expr | simple_expr ;

array_expr: '[' WS? expression* (SPCOMMA expression)* WS? ']' ;

object_expr: '{' WS? keypair* (SPCOMMA keypair)* WS? '}' ;

assignment: preassign expression NL ;

keypair: ALPHANUM WS? ':' WS? expression ;

redirect: REDIRECT WS STRING WS UINT? NL;

finish: FINISH WS (BOOL | variable) WS? NL ;

choice: MATCH WS simple_expr WS TO WS? INDENT option+ DEDENT elseblock? ;

option: simple_expr WS? INDENT statement+ DEDENT ;

ifelse: caseof WS? INDENT statement+ DEDENT elseblock? ;

caseof: WHEN WS boolean_expr boolean_op_expr* ;

boolean_op_expr: WS (AND | OR) WS boolean_expr ;

boolean_expr: simple_expr WS IS WS (NOT WS)? simple_expr ;

elseblock: OTHERWISE WS? INDENT statement+ DEDENT ;

loop: REPEAT WS (variable | UINT) WS MAXTIMES WS? INDENT statement+ quit_stmt? DEDENT ;

quit_stmt: QUIT WS caseof WS? NL elseblock? ;

statusr_block: INDENT STATUS_REQ WS? INDENT statusr_allow statusr_reply statusr_until DEDENT DEDENT ;

statusr_allow: ALLOW WS (variable | UINT) WS SECS WS? NL;

statusr_reply: REPLY WS call NL ;

statusr_until: UNTIL WS boolean_expr WS? NL;

/*
 * Lexer Rules
 */

fragment DIGIT : [0-9] ;
fragment CH : [a-zA-Z_] ;
fragment ALNUM : CH (CH | DIGIT)* ;
fragment SPACES: [\t ]+ ;
fragment COMMA: ',' ;

COMMENT: '//' ~[\r\n]* -> skip ;

FLOWSTART: 'Flow' ;

BASE: 'Basepath' ;

FLOWINPUTS: 'Inputs' ;

LOG: 'Log' ;

FLOWCALL: 'Trigger' ;

ACTIONCALL: 'Call' ;

RRFCALL: 'RRF' ;

STATUS_REQ: 'Status requests' ;

ALLOW: 'Allow for' ;

REPLY: 'Reply' ;

UNTIL: 'Until' ;

OVERRIDE: 'Override templates' ;

WHEN: 'When' ;

OTHERWISE: 'Otherwise' ;

REPEAT: 'Repeat' ;

MATCH: 'Match' ;

QUIT: 'Quit' ;

FINISH: 'Finish' ;

REDIRECT: 'Redirect' ;

IS: 'is' ;

NOT: 'not' ;

AND: 'and' ;

OR: 'or' ;

SECS: 'seconds' ;

TO: 'to' ;

MAXTIMES: 'times at most' ;

EQ: '=' ;

MINUS: '-' ;

NUL: 'null' ;

BOOL: 'false' | 'true' ;

STRING: '"' [\u0009\u0020\u0021\u0023-\u007E\u0080-\u008C\u00A0-\uFFFF]* '"' ;
//horizontal tab, space, exclamation mark, ASCII chars from hash(#) to tilde(~), plus other printable unicode chars 

UINT : DIGIT+ ;

SINT : MINUS UINT ;

DECIMAL: (SINT | UINT) '.' UINT ;

ALPHANUM: ALNUM ;

DOTEXPR: ALNUM ('.' ALNUM )+ ;

IDXEXPR: ALNUM '[' UINT ']' ;

DOTIDXEXPR: ALNUM ('[' UINT ']')? ('.' ALNUM ('[' UINT ']')? )+ ;

SPCOMMA: SPACES? NL* COMMA SPACES? NL* ;

WS: SPACES ;	//Entails "spaces" (plural)
