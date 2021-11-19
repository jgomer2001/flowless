// Generated from AuthnFlow.g4 by ANTLR 4.9.2
package org.gluu.flowless.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AuthnFlowParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NL=8, COMMENT=9, 
		FLOWSTART=10, BASE=11, FLOWINPUTS=12, LOG=13, FLOWCALL=14, ACTIONCALL=15, 
		RRFCALL=16, STATUS_REQ=17, ALLOW=18, REPLY=19, UNTIL=20, OVERRIDE=21, 
		WHEN=22, OTHERWISE=23, REPEAT=24, MATCH=25, QUIT=26, FINISH=27, REDIRECT=28, 
		IS=29, NOT=30, AND=31, OR=32, SECS=33, TO=34, MAXTIMES=35, EQ=36, MINUS=37, 
		NUL=38, BOOL=39, STRING=40, UINT=41, SINT=42, DECIMAL=43, ALPHANUM=44, 
		DOTEXPR=45, IDXEXPR=46, DOTIDXEXPR=47, SPCOMMA=48, WS=49, INDENT=50, DEDENT=51;
	public static final int
		RULE_flow = 0, RULE_qname = 1, RULE_header = 2, RULE_base = 3, RULE_inputs = 4, 
		RULE_short_var = 5, RULE_statement = 6, RULE_preassign = 7, RULE_preassign_catch = 8, 
		RULE_variable = 9, RULE_flow_call = 10, RULE_overrides = 11, RULE_action_call = 12, 
		RULE_rrf_call = 13, RULE_log = 14, RULE_call = 15, RULE_argument = 16, 
		RULE_simple_expr = 17, RULE_literal = 18, RULE_expression = 19, RULE_array_expr = 20, 
		RULE_object_expr = 21, RULE_assignment = 22, RULE_keypair = 23, RULE_redirect = 24, 
		RULE_finish = 25, RULE_choice = 26, RULE_option = 27, RULE_ifelse = 28, 
		RULE_caseof = 29, RULE_boolean_op_expr = 30, RULE_boolean_expr = 31, RULE_elseblock = 32, 
		RULE_loop = 33, RULE_quit_stmt = 34, RULE_statusr_block = 35, RULE_statusr_allow = 36, 
		RULE_statusr_reply = 37, RULE_statusr_until = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"flow", "qname", "header", "base", "inputs", "short_var", "statement", 
			"preassign", "preassign_catch", "variable", "flow_call", "overrides", 
			"action_call", "rrf_call", "log", "call", "argument", "simple_expr", 
			"literal", "expression", "array_expr", "object_expr", "assignment", "keypair", 
			"redirect", "finish", "choice", "option", "ifelse", "caseof", "boolean_op_expr", 
			"boolean_expr", "elseblock", "loop", "quit_stmt", "statusr_block", "statusr_allow", 
			"statusr_reply", "statusr_until"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'#'", "'['", "']'", "'{'", "'}'", "':'", null, null, "'Flow'", 
			"'Basepath'", "'Inputs'", "'Log'", "'Trigger'", "'Call'", "'RRF'", "'Status requests'", 
			"'Allow for'", "'Reply'", "'Until'", "'Override templates'", "'When'", 
			"'Otherwise'", "'Repeat'", "'Match'", "'Quit'", "'Finish'", "'Redirect'", 
			"'is'", "'not'", "'and'", "'or'", "'seconds'", "'to'", "'times at most'", 
			"'='", "'-'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "NL", "COMMENT", "FLOWSTART", 
			"BASE", "FLOWINPUTS", "LOG", "FLOWCALL", "ACTIONCALL", "RRFCALL", "STATUS_REQ", 
			"ALLOW", "REPLY", "UNTIL", "OVERRIDE", "WHEN", "OTHERWISE", "REPEAT", 
			"MATCH", "QUIT", "FINISH", "REDIRECT", "IS", "NOT", "AND", "OR", "SECS", 
			"TO", "MAXTIMES", "EQ", "MINUS", "NUL", "BOOL", "STRING", "UINT", "SINT", 
			"DECIMAL", "ALPHANUM", "DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", 
			"WS", "INDENT", "DEDENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AuthnFlow.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AuthnFlowParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FlowContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitFlow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitFlow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlowContext flow() throws RecognitionException {
		FlowContext _localctx = new FlowContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_flow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			header();
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				statement();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QnameContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public TerminalNode DOTEXPR() { return getToken(AuthnFlowParser.DOTEXPR, 0); }
		public QnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterQname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitQname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitQname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QnameContext qname() throws RecognitionException {
		QnameContext _localctx = new QnameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_qname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==ALPHANUM || _la==DOTEXPR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode FLOWSTART() { return getToken(AuthnFlowParser.FLOWSTART, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public QnameContext qname() {
			return getRuleContext(QnameContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public BaseContext base() {
			return getRuleContext(BaseContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public InputsContext inputs() {
			return getRuleContext(InputsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(AuthnFlowParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AuthnFlowParser.NL, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FLOWSTART);
			setState(87);
			match(WS);
			setState(88);
			qname();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(89);
				match(WS);
				}
			}

			setState(92);
			match(INDENT);
			setState(93);
			base();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLOWINPUTS) {
				{
				setState(94);
				inputs();
				}
			}

			setState(97);
			match(DEDENT);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(98);
				match(NL);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseContext extends ParserRuleContext {
		public TerminalNode BASE() { return getToken(AuthnFlowParser.BASE, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode STRING() { return getToken(AuthnFlowParser.STRING, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public BaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseContext base() throws RecognitionException {
		BaseContext _localctx = new BaseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_base);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(BASE);
			setState(105);
			match(WS);
			setState(106);
			match(STRING);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(107);
				match(WS);
				}
			}

			setState(110);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputsContext extends ParserRuleContext {
		public TerminalNode FLOWINPUTS() { return getToken(AuthnFlowParser.FLOWINPUTS, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public List<Short_varContext> short_var() {
			return getRuleContexts(Short_varContext.class);
		}
		public Short_varContext short_var(int i) {
			return getRuleContext(Short_varContext.class,i);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitInputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitInputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_inputs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(FLOWINPUTS);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					match(WS);
					setState(114);
					short_var();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(120);
				match(WS);
				}
			}

			setState(123);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Short_varContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public Short_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterShort_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitShort_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitShort_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_varContext short_var() throws RecognitionException {
		Short_varContext _localctx = new Short_varContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_short_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ALPHANUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Flow_callContext flow_call() {
			return getRuleContext(Flow_callContext.class,0);
		}
		public Action_callContext action_call() {
			return getRuleContext(Action_callContext.class,0);
		}
		public Rrf_callContext rrf_call() {
			return getRuleContext(Rrf_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LogContext log() {
			return getRuleContext(LogContext.class,0);
		}
		public RedirectContext redirect() {
			return getRuleContext(RedirectContext.class,0);
		}
		public FinishContext finish() {
			return getRuleContext(FinishContext.class,0);
		}
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(127);
				flow_call();
				}
				break;
			case 2:
				{
				setState(128);
				action_call();
				}
				break;
			case 3:
				{
				setState(129);
				rrf_call();
				}
				break;
			case 4:
				{
				setState(130);
				assignment();
				}
				break;
			case 5:
				{
				setState(131);
				log();
				}
				break;
			case 6:
				{
				setState(132);
				redirect();
				}
				break;
			case 7:
				{
				setState(133);
				finish();
				}
				break;
			case 8:
				{
				setState(134);
				ifelse();
				}
				break;
			case 9:
				{
				setState(135);
				choice();
				}
				break;
			case 10:
				{
				setState(136);
				loop();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreassignContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AuthnFlowParser.EQ, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public PreassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterPreassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitPreassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitPreassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreassignContext preassign() throws RecognitionException {
		PreassignContext _localctx = new PreassignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_preassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			variable();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(140);
				match(WS);
				}
			}

			setState(143);
			match(EQ);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(144);
				match(WS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Preassign_catchContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Short_varContext short_var() {
			return getRuleContext(Short_varContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AuthnFlowParser.EQ, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public Preassign_catchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preassign_catch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterPreassign_catch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitPreassign_catch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitPreassign_catch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preassign_catchContext preassign_catch() throws RecognitionException {
		Preassign_catchContext _localctx = new Preassign_catchContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_preassign_catch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			variable();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(148);
				match(WS);
				}
			}

			setState(151);
			match(T__0);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(152);
				match(WS);
				}
			}

			setState(155);
			short_var();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(156);
				match(WS);
				}
			}

			setState(159);
			match(EQ);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(160);
				match(WS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Short_varContext short_var() {
			return getRuleContext(Short_varContext.class,0);
		}
		public TerminalNode IDXEXPR() { return getToken(AuthnFlowParser.IDXEXPR, 0); }
		public TerminalNode DOTEXPR() { return getToken(AuthnFlowParser.DOTEXPR, 0); }
		public TerminalNode DOTIDXEXPR() { return getToken(AuthnFlowParser.DOTIDXEXPR, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				short_var();
				}
				break;
			case IDXEXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(IDXEXPR);
				}
				break;
			case DOTEXPR:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(DOTEXPR);
				}
				break;
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(DOTIDXEXPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Flow_callContext extends ParserRuleContext {
		public TerminalNode FLOWCALL() { return getToken(AuthnFlowParser.FLOWCALL, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public OverridesContext overrides() {
			return getRuleContext(OverridesContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public Flow_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterFlow_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitFlow_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitFlow_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flow_callContext flow_call() throws RecognitionException {
		Flow_callContext _localctx = new Flow_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_flow_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(169);
				preassign();
				}
			}

			setState(172);
			match(FLOWCALL);
			setState(173);
			match(WS);
			setState(174);
			call();
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(175);
				overrides();
				}
				break;
			case NL:
				{
				setState(176);
				match(NL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverridesContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode OVERRIDE() { return getToken(AuthnFlowParser.OVERRIDE, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public List<TerminalNode> STRING() { return getTokens(AuthnFlowParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(AuthnFlowParser.STRING, i);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public OverridesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrides; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterOverrides(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitOverrides(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitOverrides(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverridesContext overrides() throws RecognitionException {
		OverridesContext _localctx = new OverridesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_overrides);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(INDENT);
			setState(180);
			match(OVERRIDE);
			setState(181);
			match(WS);
			setState(182);
			match(STRING);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					match(WS);
					setState(184);
					match(STRING);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(190);
				match(WS);
				}
			}

			setState(193);
			match(NL);
			setState(194);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Action_callContext extends ParserRuleContext {
		public TerminalNode ACTIONCALL() { return getToken(AuthnFlowParser.ACTIONCALL, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public Preassign_catchContext preassign_catch() {
			return getRuleContext(Preassign_catchContext.class,0);
		}
		public Action_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterAction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitAction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitAction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_callContext action_call() throws RecognitionException {
		Action_callContext _localctx = new Action_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_action_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(196);
				preassign();
				}
				break;
			case 2:
				{
				setState(197);
				preassign_catch();
				}
				break;
			}
			setState(200);
			match(ACTIONCALL);
			setState(201);
			match(WS);
			setState(202);
			call();
			setState(203);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rrf_callContext extends ParserRuleContext {
		public TerminalNode RRFCALL() { return getToken(AuthnFlowParser.RRFCALL, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode STRING() { return getToken(AuthnFlowParser.STRING, 0); }
		public Statusr_blockContext statusr_block() {
			return getRuleContext(Statusr_blockContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Object_exprContext object_expr() {
			return getRuleContext(Object_exprContext.class,0);
		}
		public Rrf_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rrf_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterRrf_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitRrf_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitRrf_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rrf_callContext rrf_call() throws RecognitionException {
		Rrf_callContext _localctx = new Rrf_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rrf_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(205);
				preassign();
				}
			}

			setState(208);
			match(RRFCALL);
			setState(209);
			match(WS);
			setState(210);
			match(STRING);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(211);
				match(WS);
				setState(212);
				variable();
				}
				break;
			case 2:
				{
				setState(213);
				object_expr();
				}
				break;
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(216);
				match(WS);
				}
			}

			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(219);
				statusr_block();
				}
				break;
			case NL:
				{
				setState(220);
				match(NL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogContext extends ParserRuleContext {
		public TerminalNode LOG() { return getToken(AuthnFlowParser.LOG, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public LogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitLog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogContext log() throws RecognitionException {
		LogContext _localctx = new LogContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_log);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LOG);
			setState(225); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(224);
					argument();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(227); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(229);
				match(WS);
				}
			}

			setState(232);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public QnameContext qname() {
			return getRuleContext(QnameContext.class,0);
		}
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_call);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			qname();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(235);
				match(T__1);
				setState(236);
				match(ALPHANUM);
				}
			}

			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(239);
					argument();
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(245);
				match(WS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public Simple_exprContext simple_expr() {
			return getRuleContext(Simple_exprContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(WS);
			setState(249);
			simple_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_exprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(AuthnFlowParser.MINUS, 0); }
		public Simple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterSimple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitSimple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitSimple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_exprContext simple_expr() throws RecognitionException {
		Simple_exprContext _localctx = new Simple_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_simple_expr);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUL:
			case BOOL:
			case STRING:
			case UINT:
			case SINT:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				literal();
				}
				break;
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				variable();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(253);
				match(MINUS);
				setState(254);
				variable();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(AuthnFlowParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(AuthnFlowParser.STRING, 0); }
		public TerminalNode UINT() { return getToken(AuthnFlowParser.UINT, 0); }
		public TerminalNode SINT() { return getToken(AuthnFlowParser.SINT, 0); }
		public TerminalNode DECIMAL() { return getToken(AuthnFlowParser.DECIMAL, 0); }
		public TerminalNode NUL() { return getToken(AuthnFlowParser.NUL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Object_exprContext object_expr() {
			return getRuleContext(Object_exprContext.class,0);
		}
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public Simple_exprContext simple_expr() {
			return getRuleContext(Simple_exprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				object_expr();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				array_expr();
				}
				break;
			case MINUS:
			case NUL:
			case BOOL:
			case STRING:
			case UINT:
			case SINT:
			case DECIMAL:
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				simple_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_exprContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SPCOMMA() { return getTokens(AuthnFlowParser.SPCOMMA); }
		public TerminalNode SPCOMMA(int i) {
			return getToken(AuthnFlowParser.SPCOMMA, i);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterArray_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitArray_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitArray_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_exprContext array_expr() throws RecognitionException {
		Array_exprContext _localctx = new Array_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__2);
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(265);
				match(WS);
				}
				break;
			}
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				{
				setState(268);
				expression();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(274);
				match(SPCOMMA);
				setState(275);
				expression();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(281);
				match(WS);
				}
			}

			setState(284);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Object_exprContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public List<KeypairContext> keypair() {
			return getRuleContexts(KeypairContext.class);
		}
		public KeypairContext keypair(int i) {
			return getRuleContext(KeypairContext.class,i);
		}
		public List<TerminalNode> SPCOMMA() { return getTokens(AuthnFlowParser.SPCOMMA); }
		public TerminalNode SPCOMMA(int i) {
			return getToken(AuthnFlowParser.SPCOMMA, i);
		}
		public Object_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterObject_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitObject_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitObject_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_exprContext object_expr() throws RecognitionException {
		Object_exprContext _localctx = new Object_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_object_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__4);
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(287);
				match(WS);
				}
				break;
			}
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALPHANUM) {
				{
				{
				setState(290);
				keypair();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(296);
				match(SPCOMMA);
				setState(297);
				keypair();
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(303);
				match(WS);
				}
			}

			setState(306);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			preassign();
			setState(309);
			expression();
			setState(310);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeypairContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public KeypairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keypair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterKeypair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitKeypair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitKeypair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeypairContext keypair() throws RecognitionException {
		KeypairContext _localctx = new KeypairContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keypair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(ALPHANUM);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(313);
				match(WS);
				}
			}

			setState(316);
			match(T__6);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(317);
				match(WS);
				}
			}

			setState(320);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RedirectContext extends ParserRuleContext {
		public TerminalNode REDIRECT() { return getToken(AuthnFlowParser.REDIRECT, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode STRING() { return getToken(AuthnFlowParser.STRING, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public TerminalNode UINT() { return getToken(AuthnFlowParser.UINT, 0); }
		public RedirectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterRedirect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitRedirect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitRedirect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RedirectContext redirect() throws RecognitionException {
		RedirectContext _localctx = new RedirectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_redirect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(REDIRECT);
			setState(323);
			match(WS);
			setState(324);
			match(STRING);
			setState(325);
			match(WS);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UINT) {
				{
				setState(326);
				match(UINT);
				}
			}

			setState(329);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinishContext extends ParserRuleContext {
		public TerminalNode FINISH() { return getToken(AuthnFlowParser.FINISH, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public TerminalNode BOOL() { return getToken(AuthnFlowParser.BOOL, 0); }
		public Object_exprContext object_expr() {
			return getRuleContext(Object_exprContext.class,0);
		}
		public FinishContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finish; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterFinish(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitFinish(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitFinish(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinishContext finish() throws RecognitionException {
		FinishContext _localctx = new FinishContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_finish);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(FINISH);
			setState(332);
			match(WS);
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				{
				setState(333);
				match(BOOL);
				}
				break;
			case T__4:
				{
				setState(334);
				object_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(337);
				match(WS);
				}
			}

			setState(340);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(AuthnFlowParser.MATCH, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public Simple_exprContext simple_expr() {
			return getRuleContext(Simple_exprContext.class,0);
		}
		public TerminalNode TO() { return getToken(AuthnFlowParser.TO, 0); }
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public ElseblockContext elseblock() {
			return getRuleContext(ElseblockContext.class,0);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(MATCH);
			setState(343);
			match(WS);
			setState(344);
			simple_expr();
			setState(345);
			match(WS);
			setState(346);
			match(TO);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(347);
				match(WS);
				}
			}

			setState(350);
			match(INDENT);
			setState(352); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(351);
				option();
				}
				}
				setState(354); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(356);
			match(DEDENT);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(357);
				elseblock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public Simple_exprContext simple_expr() {
			return getRuleContext(Simple_exprContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			simple_expr();
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(361);
				match(WS);
				}
			}

			setState(364);
			match(INDENT);
			setState(366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(365);
				statement();
				}
				}
				setState(368); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(370);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfelseContext extends ParserRuleContext {
		public CaseofContext caseof() {
			return getRuleContext(CaseofContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseblockContext elseblock() {
			return getRuleContext(ElseblockContext.class,0);
		}
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitIfelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			caseof();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(373);
				match(WS);
				}
			}

			setState(376);
			match(INDENT);
			setState(378); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(377);
				statement();
				}
				}
				setState(380); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(382);
			match(DEDENT);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(383);
				elseblock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseofContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(AuthnFlowParser.WHEN, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public Boolean_exprContext boolean_expr() {
			return getRuleContext(Boolean_exprContext.class,0);
		}
		public List<Boolean_op_exprContext> boolean_op_expr() {
			return getRuleContexts(Boolean_op_exprContext.class);
		}
		public Boolean_op_exprContext boolean_op_expr(int i) {
			return getRuleContext(Boolean_op_exprContext.class,i);
		}
		public CaseofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterCaseof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitCaseof(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitCaseof(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseofContext caseof() throws RecognitionException {
		CaseofContext _localctx = new CaseofContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_caseof);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(WHEN);
			setState(387);
			match(WS);
			setState(388);
			boolean_expr();
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(389);
					boolean_op_expr();
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_op_exprContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public Boolean_exprContext boolean_expr() {
			return getRuleContext(Boolean_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(AuthnFlowParser.AND, 0); }
		public TerminalNode OR() { return getToken(AuthnFlowParser.OR, 0); }
		public Boolean_op_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_op_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterBoolean_op_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitBoolean_op_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitBoolean_op_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_op_exprContext boolean_op_expr() throws RecognitionException {
		Boolean_op_exprContext _localctx = new Boolean_op_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_boolean_op_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(WS);
			setState(396);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(397);
			match(WS);
			setState(398);
			boolean_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_exprContext extends ParserRuleContext {
		public List<Simple_exprContext> simple_expr() {
			return getRuleContexts(Simple_exprContext.class);
		}
		public Simple_exprContext simple_expr(int i) {
			return getRuleContext(Simple_exprContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode IS() { return getToken(AuthnFlowParser.IS, 0); }
		public TerminalNode NOT() { return getToken(AuthnFlowParser.NOT, 0); }
		public Boolean_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterBoolean_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitBoolean_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitBoolean_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_exprContext boolean_expr() throws RecognitionException {
		Boolean_exprContext _localctx = new Boolean_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_boolean_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			simple_expr();
			setState(401);
			match(WS);
			setState(402);
			match(IS);
			setState(403);
			match(WS);
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(404);
				match(NOT);
				setState(405);
				match(WS);
				}
			}

			setState(408);
			simple_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseblockContext extends ParserRuleContext {
		public TerminalNode OTHERWISE() { return getToken(AuthnFlowParser.OTHERWISE, 0); }
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterElseblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitElseblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitElseblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseblockContext elseblock() throws RecognitionException {
		ElseblockContext _localctx = new ElseblockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_elseblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(OTHERWISE);
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(411);
				match(WS);
				}
			}

			setState(414);
			match(INDENT);
			setState(416); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(415);
				statement();
				}
				}
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(420);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(AuthnFlowParser.REPEAT, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode MAXTIMES() { return getToken(AuthnFlowParser.MAXTIMES, 0); }
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode UINT() { return getToken(AuthnFlowParser.UINT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Quit_stmtContext quit_stmt() {
			return getRuleContext(Quit_stmtContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(REPEAT);
			setState(423);
			match(WS);
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				{
				setState(424);
				variable();
				}
				break;
			case UINT:
				{
				setState(425);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(428);
			match(WS);
			setState(429);
			match(MAXTIMES);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(430);
				match(WS);
				}
			}

			setState(433);
			match(INDENT);
			setState(435); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(434);
				statement();
				}
				}
				setState(437); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUIT) {
				{
				setState(439);
				quit_stmt();
				}
			}

			setState(442);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Quit_stmtContext extends ParserRuleContext {
		public TerminalNode QUIT() { return getToken(AuthnFlowParser.QUIT, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public CaseofContext caseof() {
			return getRuleContext(CaseofContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public ElseblockContext elseblock() {
			return getRuleContext(ElseblockContext.class,0);
		}
		public Quit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quit_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterQuit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitQuit_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitQuit_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quit_stmtContext quit_stmt() throws RecognitionException {
		Quit_stmtContext _localctx = new Quit_stmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_quit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(QUIT);
			setState(445);
			match(WS);
			setState(446);
			caseof();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(447);
				match(WS);
				}
			}

			setState(450);
			match(NL);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(451);
				elseblock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statusr_blockContext extends ParserRuleContext {
		public List<TerminalNode> INDENT() { return getTokens(AuthnFlowParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(AuthnFlowParser.INDENT, i);
		}
		public TerminalNode STATUS_REQ() { return getToken(AuthnFlowParser.STATUS_REQ, 0); }
		public Statusr_allowContext statusr_allow() {
			return getRuleContext(Statusr_allowContext.class,0);
		}
		public Statusr_replyContext statusr_reply() {
			return getRuleContext(Statusr_replyContext.class,0);
		}
		public Statusr_untilContext statusr_until() {
			return getRuleContext(Statusr_untilContext.class,0);
		}
		public List<TerminalNode> DEDENT() { return getTokens(AuthnFlowParser.DEDENT); }
		public TerminalNode DEDENT(int i) {
			return getToken(AuthnFlowParser.DEDENT, i);
		}
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public Statusr_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusr_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatusr_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatusr_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatusr_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statusr_blockContext statusr_block() throws RecognitionException {
		Statusr_blockContext _localctx = new Statusr_blockContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_statusr_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(INDENT);
			setState(455);
			match(STATUS_REQ);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(456);
				match(WS);
				}
			}

			setState(459);
			match(INDENT);
			setState(460);
			statusr_allow();
			setState(461);
			statusr_reply();
			setState(462);
			statusr_until();
			setState(463);
			match(DEDENT);
			setState(464);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statusr_allowContext extends ParserRuleContext {
		public TerminalNode ALLOW() { return getToken(AuthnFlowParser.ALLOW, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode SECS() { return getToken(AuthnFlowParser.SECS, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode UINT() { return getToken(AuthnFlowParser.UINT, 0); }
		public Statusr_allowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusr_allow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatusr_allow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatusr_allow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatusr_allow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statusr_allowContext statusr_allow() throws RecognitionException {
		Statusr_allowContext _localctx = new Statusr_allowContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_statusr_allow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(ALLOW);
			setState(467);
			match(WS);
			setState(470);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				{
				setState(468);
				variable();
				}
				break;
			case UINT:
				{
				setState(469);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(472);
			match(WS);
			setState(473);
			match(SECS);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(474);
				match(WS);
				}
			}

			setState(477);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statusr_replyContext extends ParserRuleContext {
		public TerminalNode REPLY() { return getToken(AuthnFlowParser.REPLY, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public Statusr_replyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusr_reply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatusr_reply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatusr_reply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatusr_reply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statusr_replyContext statusr_reply() throws RecognitionException {
		Statusr_replyContext _localctx = new Statusr_replyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_statusr_reply);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(REPLY);
			setState(480);
			match(WS);
			setState(481);
			call();
			setState(482);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statusr_untilContext extends ParserRuleContext {
		public TerminalNode UNTIL() { return getToken(AuthnFlowParser.UNTIL, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public Boolean_exprContext boolean_expr() {
			return getRuleContext(Boolean_exprContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public Statusr_untilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusr_until; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatusr_until(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatusr_until(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatusr_until(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statusr_untilContext statusr_until() throws RecognitionException {
		Statusr_untilContext _localctx = new Statusr_untilContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_statusr_until);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(UNTIL);
			setState(485);
			match(WS);
			setState(486);
			boolean_expr();
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(487);
				match(WS);
				}
			}

			setState(490);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u01ef\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\6\2S\n\2\r\2"+
		"\16\2T\3\3\3\3\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\3\4\3\4\5\4b\n\4\3\4\3\4\7"+
		"\4f\n\4\f\4\16\4i\13\4\3\5\3\5\3\5\3\5\5\5o\n\5\3\5\3\5\3\6\3\6\3\6\7"+
		"\6v\n\6\f\6\16\6y\13\6\3\6\5\6|\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u008c\n\b\3\t\3\t\5\t\u0090\n\t\3\t\3\t\5\t"+
		"\u0094\n\t\3\n\3\n\5\n\u0098\n\n\3\n\3\n\5\n\u009c\n\n\3\n\3\n\5\n\u00a0"+
		"\n\n\3\n\3\n\5\n\u00a4\n\n\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\f\5\f"+
		"\u00ad\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b4\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00bc\n\r\f\r\16\r\u00bf\13\r\3\r\5\r\u00c2\n\r\3\r\3\r\3\r\3\16\3"+
		"\16\5\16\u00c9\n\16\3\16\3\16\3\16\3\16\3\16\3\17\5\17\u00d1\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00d9\n\17\3\17\5\17\u00dc\n\17\3\17\3"+
		"\17\5\17\u00e0\n\17\3\20\3\20\6\20\u00e4\n\20\r\20\16\20\u00e5\3\20\5"+
		"\20\u00e9\n\20\3\20\3\20\3\21\3\21\3\21\5\21\u00f0\n\21\3\21\7\21\u00f3"+
		"\n\21\f\21\16\21\u00f6\13\21\3\21\5\21\u00f9\n\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\5\23\u0102\n\23\3\24\3\24\3\25\3\25\3\25\5\25\u0109\n"+
		"\25\3\26\3\26\5\26\u010d\n\26\3\26\7\26\u0110\n\26\f\26\16\26\u0113\13"+
		"\26\3\26\3\26\7\26\u0117\n\26\f\26\16\26\u011a\13\26\3\26\5\26\u011d\n"+
		"\26\3\26\3\26\3\27\3\27\5\27\u0123\n\27\3\27\7\27\u0126\n\27\f\27\16\27"+
		"\u0129\13\27\3\27\3\27\7\27\u012d\n\27\f\27\16\27\u0130\13\27\3\27\5\27"+
		"\u0133\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u013d\n\31\3"+
		"\31\3\31\5\31\u0141\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u014a"+
		"\n\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u0152\n\33\3\33\5\33\u0155\n"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u015f\n\34\3\34\3\34"+
		"\6\34\u0163\n\34\r\34\16\34\u0164\3\34\3\34\5\34\u0169\n\34\3\35\3\35"+
		"\5\35\u016d\n\35\3\35\3\35\6\35\u0171\n\35\r\35\16\35\u0172\3\35\3\35"+
		"\3\36\3\36\5\36\u0179\n\36\3\36\3\36\6\36\u017d\n\36\r\36\16\36\u017e"+
		"\3\36\3\36\5\36\u0183\n\36\3\37\3\37\3\37\3\37\7\37\u0189\n\37\f\37\16"+
		"\37\u018c\13\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\5!\u0199\n!\3!\3!\3\""+
		"\3\"\5\"\u019f\n\"\3\"\3\"\6\"\u01a3\n\"\r\"\16\"\u01a4\3\"\3\"\3#\3#"+
		"\3#\3#\5#\u01ad\n#\3#\3#\3#\5#\u01b2\n#\3#\3#\6#\u01b6\n#\r#\16#\u01b7"+
		"\3#\5#\u01bb\n#\3#\3#\3$\3$\3$\3$\5$\u01c3\n$\3$\3$\5$\u01c7\n$\3%\3%"+
		"\3%\5%\u01cc\n%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\5&\u01d9\n&\3&\3&\3&"+
		"\5&\u01de\n&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\5(\u01eb\n(\3(\3(\3"+
		"(\2\2)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLN\2\5\3\2./\3\2(-\3\2!\"\2\u0217\2P\3\2\2\2\4V\3\2\2\2\6X\3\2"+
		"\2\2\bj\3\2\2\2\nr\3\2\2\2\f\177\3\2\2\2\16\u008b\3\2\2\2\20\u008d\3\2"+
		"\2\2\22\u0095\3\2\2\2\24\u00a9\3\2\2\2\26\u00ac\3\2\2\2\30\u00b5\3\2\2"+
		"\2\32\u00c8\3\2\2\2\34\u00d0\3\2\2\2\36\u00e1\3\2\2\2 \u00ec\3\2\2\2\""+
		"\u00fa\3\2\2\2$\u0101\3\2\2\2&\u0103\3\2\2\2(\u0108\3\2\2\2*\u010a\3\2"+
		"\2\2,\u0120\3\2\2\2.\u0136\3\2\2\2\60\u013a\3\2\2\2\62\u0144\3\2\2\2\64"+
		"\u014d\3\2\2\2\66\u0158\3\2\2\28\u016a\3\2\2\2:\u0176\3\2\2\2<\u0184\3"+
		"\2\2\2>\u018d\3\2\2\2@\u0192\3\2\2\2B\u019c\3\2\2\2D\u01a8\3\2\2\2F\u01be"+
		"\3\2\2\2H\u01c8\3\2\2\2J\u01d4\3\2\2\2L\u01e1\3\2\2\2N\u01e6\3\2\2\2P"+
		"R\5\6\4\2QS\5\16\b\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\3\3\2\2"+
		"\2VW\t\2\2\2W\5\3\2\2\2XY\7\f\2\2YZ\7\63\2\2Z\\\5\4\3\2[]\7\63\2\2\\["+
		"\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\64\2\2_a\5\b\5\2`b\5\n\6\2a`\3\2\2\2"+
		"ab\3\2\2\2bc\3\2\2\2cg\7\65\2\2df\7\n\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2"+
		"\2gh\3\2\2\2h\7\3\2\2\2ig\3\2\2\2jk\7\r\2\2kl\7\63\2\2ln\7*\2\2mo\7\63"+
		"\2\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\n\2\2q\t\3\2\2\2rw\7\16\2\2st\7"+
		"\63\2\2tv\5\f\7\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw"+
		"\3\2\2\2z|\7\63\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\n\2\2~\13\3\2\2"+
		"\2\177\u0080\7.\2\2\u0080\r\3\2\2\2\u0081\u008c\5\26\f\2\u0082\u008c\5"+
		"\32\16\2\u0083\u008c\5\34\17\2\u0084\u008c\5.\30\2\u0085\u008c\5\36\20"+
		"\2\u0086\u008c\5\62\32\2\u0087\u008c\5\64\33\2\u0088\u008c\5:\36\2\u0089"+
		"\u008c\5\66\34\2\u008a\u008c\5D#\2\u008b\u0081\3\2\2\2\u008b\u0082\3\2"+
		"\2\2\u008b\u0083\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0085\3\2\2\2\u008b"+
		"\u0086\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008a\3\2\2\2\u008c\17\3\2\2\2\u008d\u008f\5\24\13\2\u008e"+
		"\u0090\7\63\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u0093\7&\2\2\u0092\u0094\7\63\2\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\21\3\2\2\2\u0095\u0097\5\24\13\2\u0096\u0098\7\63"+
		"\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\7\3\2\2\u009a\u009c\7\63\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\5\f\7\2\u009e\u00a0\7\63\2\2\u009f"+
		"\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\7&"+
		"\2\2\u00a2\u00a4\7\63\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\23\3\2\2\2\u00a5\u00aa\5\f\7\2\u00a6\u00aa\7\60\2\2\u00a7\u00aa\7/\2"+
		"\2\u00a8\u00aa\7\61\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\25\3\2\2\2\u00ab\u00ad\5\20\t"+
		"\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af"+
		"\7\20\2\2\u00af\u00b0\7\63\2\2\u00b0\u00b3\5 \21\2\u00b1\u00b4\5\30\r"+
		"\2\u00b2\u00b4\7\n\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\27"+
		"\3\2\2\2\u00b5\u00b6\7\64\2\2\u00b6\u00b7\7\27\2\2\u00b7\u00b8\7\63\2"+
		"\2\u00b8\u00bd\7*\2\2\u00b9\u00ba\7\63\2\2\u00ba\u00bc\7*\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2\7\63\2\2\u00c1\u00c0\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\n\2\2\u00c4"+
		"\u00c5\7\65\2\2\u00c5\31\3\2\2\2\u00c6\u00c9\5\20\t\2\u00c7\u00c9\5\22"+
		"\n\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\7\21\2\2\u00cb\u00cc\7\63\2\2\u00cc\u00cd\5"+
		" \21\2\u00cd\u00ce\7\n\2\2\u00ce\33\3\2\2\2\u00cf\u00d1\5\20\t\2\u00d0"+
		"\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\22"+
		"\2\2\u00d3\u00d4\7\63\2\2\u00d4\u00d8\7*\2\2\u00d5\u00d6\7\63\2\2\u00d6"+
		"\u00d9\5\24\13\2\u00d7\u00d9\5,\27\2\u00d8\u00d5\3\2\2\2\u00d8\u00d7\3"+
		"\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00dc\7\63\2\2\u00db"+
		"\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00e0\5H"+
		"%\2\u00de\u00e0\7\n\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0"+
		"\35\3\2\2\2\u00e1\u00e3\7\17\2\2\u00e2\u00e4\5\"\22\2\u00e3\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e9\7\63\2\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\n\2\2\u00eb\37\3\2\2\2\u00ec"+
		"\u00ef\5\4\3\2\u00ed\u00ee\7\4\2\2\u00ee\u00f0\7.\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00f3\5\"\22\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\7\63\2\2\u00f8"+
		"\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9!\3\2\2\2\u00fa\u00fb\7\63\2\2"+
		"\u00fb\u00fc\5$\23\2\u00fc#\3\2\2\2\u00fd\u0102\5&\24\2\u00fe\u0102\5"+
		"\24\13\2\u00ff\u0100\7\'\2\2\u0100\u0102\5\24\13\2\u0101\u00fd\3\2\2\2"+
		"\u0101\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0102%\3\2\2\2\u0103\u0104\t"+
		"\3\2\2\u0104\'\3\2\2\2\u0105\u0109\5,\27\2\u0106\u0109\5*\26\2\u0107\u0109"+
		"\5$\23\2\u0108\u0105\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109"+
		")\3\2\2\2\u010a\u010c\7\5\2\2\u010b\u010d\7\63\2\2\u010c\u010b\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\u0111\3\2\2\2\u010e\u0110\5(\25\2\u010f\u010e"+
		"\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0118\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\62\2\2\u0115\u0117\5"+
		"(\25\2\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011d\7\63"+
		"\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\7\6\2\2\u011f+\3\2\2\2\u0120\u0122\7\7\2\2\u0121\u0123\7\63\2\2"+
		"\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0127\3\2\2\2\u0124\u0126"+
		"\5\60\31\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2"+
		"\u0127\u0128\3\2\2\2\u0128\u012e\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b"+
		"\7\62\2\2\u012b\u012d\5\60\31\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2"+
		"\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e"+
		"\3\2\2\2\u0131\u0133\7\63\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\u0135\7\b\2\2\u0135-\3\2\2\2\u0136\u0137\5"+
		"\20\t\2\u0137\u0138\5(\25\2\u0138\u0139\7\n\2\2\u0139/\3\2\2\2\u013a\u013c"+
		"\7.\2\2\u013b\u013d\7\63\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\7\t\2\2\u013f\u0141\7\63\2\2\u0140\u013f\3"+
		"\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\5(\25\2\u0143"+
		"\61\3\2\2\2\u0144\u0145\7\36\2\2\u0145\u0146\7\63\2\2\u0146\u0147\7*\2"+
		"\2\u0147\u0149\7\63\2\2\u0148\u014a\7+\2\2\u0149\u0148\3\2\2\2\u0149\u014a"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\n\2\2\u014c\63\3\2\2\2\u014d"+
		"\u014e\7\35\2\2\u014e\u0151\7\63\2\2\u014f\u0152\7)\2\2\u0150\u0152\5"+
		",\27\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152\u0154\3\2\2\2\u0153"+
		"\u0155\7\63\2\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3"+
		"\2\2\2\u0156\u0157\7\n\2\2\u0157\65\3\2\2\2\u0158\u0159\7\33\2\2\u0159"+
		"\u015a\7\63\2\2\u015a\u015b\5$\23\2\u015b\u015c\7\63\2\2\u015c\u015e\7"+
		"$\2\2\u015d\u015f\7\63\2\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0162\7\64\2\2\u0161\u0163\58\35\2\u0162\u0161\3"+
		"\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u0168\7\65\2\2\u0167\u0169\5B\"\2\u0168\u0167\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\67\3\2\2\2\u016a\u016c\5$\23\2\u016b\u016d"+
		"\7\63\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2"+
		"\u016e\u0170\7\64\2\2\u016f\u0171\5\16\b\2\u0170\u016f\3\2\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0175\7\65\2\2\u01759\3\2\2\2\u0176\u0178\5<\37\2\u0177\u0179\7\63\2"+
		"\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c"+
		"\7\64\2\2\u017b\u017d\5\16\b\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2"+
		"\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182"+
		"\7\65\2\2\u0181\u0183\5B\"\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		";\3\2\2\2\u0184\u0185\7\30\2\2\u0185\u0186\7\63\2\2\u0186\u018a\5@!\2"+
		"\u0187\u0189\5> \2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188"+
		"\3\2\2\2\u018a\u018b\3\2\2\2\u018b=\3\2\2\2\u018c\u018a\3\2\2\2\u018d"+
		"\u018e\7\63\2\2\u018e\u018f\t\4\2\2\u018f\u0190\7\63\2\2\u0190\u0191\5"+
		"@!\2\u0191?\3\2\2\2\u0192\u0193\5$\23\2\u0193\u0194\7\63\2\2\u0194\u0195"+
		"\7\37\2\2\u0195\u0198\7\63\2\2\u0196\u0197\7 \2\2\u0197\u0199\7\63\2\2"+
		"\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b"+
		"\5$\23\2\u019bA\3\2\2\2\u019c\u019e\7\31\2\2\u019d\u019f\7\63\2\2\u019e"+
		"\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\7\64"+
		"\2\2\u01a1\u01a3\5\16\b\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7\65"+
		"\2\2\u01a7C\3\2\2\2\u01a8\u01a9\7\32\2\2\u01a9\u01ac\7\63\2\2\u01aa\u01ad"+
		"\5\24\13\2\u01ab\u01ad\7+\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2"+
		"\u01ad\u01ae\3\2\2\2\u01ae\u01af\7\63\2\2\u01af\u01b1\7%\2\2\u01b0\u01b2"+
		"\7\63\2\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2"+
		"\u01b3\u01b5\7\64\2\2\u01b4\u01b6\5\16\b\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7"+
		"\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9"+
		"\u01bb\5F$\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2"+
		"\2\u01bc\u01bd\7\65\2\2\u01bdE\3\2\2\2\u01be\u01bf\7\34\2\2\u01bf\u01c0"+
		"\7\63\2\2\u01c0\u01c2\5<\37\2\u01c1\u01c3\7\63\2\2\u01c2\u01c1\3\2\2\2"+
		"\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\7\n\2\2\u01c5\u01c7"+
		"\5B\"\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7G\3\2\2\2\u01c8\u01c9"+
		"\7\64\2\2\u01c9\u01cb\7\23\2\2\u01ca\u01cc\7\63\2\2\u01cb\u01ca\3\2\2"+
		"\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\7\64\2\2\u01ce"+
		"\u01cf\5J&\2\u01cf\u01d0\5L\'\2\u01d0\u01d1\5N(\2\u01d1\u01d2\7\65\2\2"+
		"\u01d2\u01d3\7\65\2\2\u01d3I\3\2\2\2\u01d4\u01d5\7\24\2\2\u01d5\u01d8"+
		"\7\63\2\2\u01d6\u01d9\5\24\13\2\u01d7\u01d9\7+\2\2\u01d8\u01d6\3\2\2\2"+
		"\u01d8\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7\63\2\2\u01db\u01dd"+
		"\7#\2\2\u01dc\u01de\7\63\2\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01df\u01e0\7\n\2\2\u01e0K\3\2\2\2\u01e1\u01e2\7\25\2\2"+
		"\u01e2\u01e3\7\63\2\2\u01e3\u01e4\5 \21\2\u01e4\u01e5\7\n\2\2\u01e5M\3"+
		"\2\2\2\u01e6\u01e7\7\26\2\2\u01e7\u01e8\7\63\2\2\u01e8\u01ea\5@!\2\u01e9"+
		"\u01eb\7\63\2\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3"+
		"\2\2\2\u01ec\u01ed\7\n\2\2\u01edO\3\2\2\2DT\\agnw{\u008b\u008f\u0093\u0097"+
		"\u009b\u009f\u00a3\u00a9\u00ac\u00b3\u00bd\u00c1\u00c8\u00d0\u00d8\u00db"+
		"\u00df\u00e5\u00e8\u00ef\u00f4\u00f8\u0101\u0108\u010c\u0111\u0118\u011c"+
		"\u0122\u0127\u012e\u0132\u013c\u0140\u0149\u0151\u0154\u015e\u0164\u0168"+
		"\u016c\u0172\u0178\u017e\u0182\u018a\u0198\u019e\u01a4\u01ac\u01b1\u01b7"+
		"\u01ba\u01c2\u01c6\u01cb\u01d8\u01dd\u01ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}