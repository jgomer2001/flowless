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
			setState(115); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(113);
					match(WS);
					setState(114);
					short_var();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(119);
				match(WS);
				}
			}

			setState(122);
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
			setState(124);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(126);
				flow_call();
				}
				break;
			case 2:
				{
				setState(127);
				action_call();
				}
				break;
			case 3:
				{
				setState(128);
				rrf_call();
				}
				break;
			case 4:
				{
				setState(129);
				assignment();
				}
				break;
			case 5:
				{
				setState(130);
				log();
				}
				break;
			case 6:
				{
				setState(131);
				redirect();
				}
				break;
			case 7:
				{
				setState(132);
				finish();
				}
				break;
			case 8:
				{
				setState(133);
				ifelse();
				}
				break;
			case 9:
				{
				setState(134);
				choice();
				}
				break;
			case 10:
				{
				setState(135);
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
			setState(138);
			variable();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(139);
				match(WS);
				}
			}

			setState(142);
			match(EQ);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(143);
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
			setState(146);
			variable();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(147);
				match(WS);
				}
			}

			setState(150);
			match(T__0);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(151);
				match(WS);
				}
			}

			setState(154);
			short_var();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(155);
				match(WS);
				}
			}

			setState(158);
			match(EQ);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(159);
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
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				short_var();
				}
				break;
			case IDXEXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(IDXEXPR);
				}
				break;
			case DOTEXPR:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(DOTEXPR);
				}
				break;
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
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
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(168);
				preassign();
				}
			}

			setState(171);
			match(FLOWCALL);
			setState(172);
			match(WS);
			setState(173);
			call();
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(174);
				overrides();
				}
				break;
			case NL:
				{
				setState(175);
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
			setState(178);
			match(INDENT);
			setState(179);
			match(OVERRIDE);
			setState(180);
			match(WS);
			setState(181);
			match(STRING);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(WS);
					setState(183);
					match(STRING);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(189);
				match(WS);
				}
			}

			setState(192);
			match(NL);
			setState(193);
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
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(195);
				preassign();
				}
				break;
			case 2:
				{
				setState(196);
				preassign_catch();
				}
				break;
			}
			setState(199);
			match(ACTIONCALL);
			setState(200);
			match(WS);
			setState(201);
			call();
			setState(202);
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
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(204);
				preassign();
				}
			}

			setState(207);
			match(RRFCALL);
			setState(208);
			match(WS);
			setState(209);
			match(STRING);
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(210);
				match(WS);
				setState(211);
				variable();
				}
				break;
			}
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(214);
				match(WS);
				}
			}

			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(217);
				statusr_block();
				}
				break;
			case NL:
				{
				setState(218);
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
			setState(221);
			match(LOG);
			setState(223); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(222);
					argument();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(227);
				match(WS);
				}
			}

			setState(230);
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
			setState(232);
			qname();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(233);
				match(T__1);
				setState(234);
				match(ALPHANUM);
				}
			}

			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					argument();
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(243);
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
			setState(246);
			match(WS);
			setState(247);
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
			setState(253);
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
				setState(249);
				literal();
				}
				break;
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				variable();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(251);
				match(MINUS);
				setState(252);
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
			setState(255);
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
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				object_expr();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
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
				setState(259);
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
			setState(262);
			match(T__2);
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(263);
				match(WS);
				}
				break;
			}
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				{
				setState(266);
				expression();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(272);
				match(SPCOMMA);
				setState(273);
				expression();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(279);
				match(WS);
				}
			}

			setState(282);
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
			setState(284);
			match(T__4);
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(285);
				match(WS);
				}
				break;
			}
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALPHANUM) {
				{
				{
				setState(288);
				keypair();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(294);
				match(SPCOMMA);
				setState(295);
				keypair();
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(301);
				match(WS);
				}
			}

			setState(304);
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
			setState(306);
			preassign();
			setState(307);
			expression();
			setState(308);
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
			setState(310);
			match(ALPHANUM);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(311);
				match(WS);
				}
			}

			setState(314);
			match(T__6);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(315);
				match(WS);
				}
			}

			setState(318);
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
			setState(320);
			match(REDIRECT);
			setState(321);
			match(WS);
			setState(322);
			match(STRING);
			setState(323);
			match(WS);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UINT) {
				{
				setState(324);
				match(UINT);
				}
			}

			setState(327);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
			setState(329);
			match(FINISH);
			setState(330);
			match(WS);
			setState(333);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				{
				setState(331);
				match(BOOL);
				}
				break;
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				{
				setState(332);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(335);
				match(WS);
				}
			}

			setState(338);
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
			setState(340);
			match(MATCH);
			setState(341);
			match(WS);
			setState(342);
			simple_expr();
			setState(343);
			match(WS);
			setState(344);
			match(TO);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(345);
				match(WS);
				}
			}

			setState(348);
			match(INDENT);
			setState(350); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(349);
				option();
				}
				}
				setState(352); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(354);
			match(DEDENT);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(355);
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
			setState(358);
			simple_expr();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(359);
				match(WS);
				}
			}

			setState(362);
			match(INDENT);
			setState(364); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(363);
				statement();
				}
				}
				setState(366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(368);
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
			setState(370);
			caseof();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(371);
				match(WS);
				}
			}

			setState(374);
			match(INDENT);
			setState(376); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(375);
				statement();
				}
				}
				setState(378); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(380);
			match(DEDENT);
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(381);
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
			setState(384);
			match(WHEN);
			setState(385);
			match(WS);
			setState(386);
			boolean_expr();
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(387);
					boolean_op_expr();
					}
					} 
				}
				setState(392);
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
			setState(393);
			match(WS);
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(395);
			match(WS);
			setState(396);
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
			setState(398);
			simple_expr();
			setState(399);
			match(WS);
			setState(400);
			match(IS);
			setState(401);
			match(WS);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(402);
				match(NOT);
				setState(403);
				match(WS);
				}
			}

			setState(406);
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
			setState(408);
			match(OTHERWISE);
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(409);
				match(WS);
				}
			}

			setState(412);
			match(INDENT);
			setState(414); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(413);
				statement();
				}
				}
				setState(416); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(418);
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
			setState(420);
			match(REPEAT);
			setState(421);
			match(WS);
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				{
				setState(422);
				variable();
				}
				break;
			case UINT:
				{
				setState(423);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(426);
			match(WS);
			setState(427);
			match(MAXTIMES);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(428);
				match(WS);
				}
			}

			setState(431);
			match(INDENT);
			setState(433); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(432);
				statement();
				}
				}
				setState(435); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << MATCH) | (1L << FINISH) | (1L << REDIRECT) | (1L << ALPHANUM) | (1L << DOTEXPR) | (1L << IDXEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUIT) {
				{
				setState(437);
				quit_stmt();
				}
			}

			setState(440);
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
			setState(442);
			match(QUIT);
			setState(443);
			match(WS);
			setState(444);
			caseof();
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(445);
				match(WS);
				}
			}

			setState(448);
			match(NL);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(449);
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
			setState(452);
			match(INDENT);
			setState(453);
			match(STATUS_REQ);
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(454);
				match(WS);
				}
			}

			setState(457);
			match(INDENT);
			setState(458);
			statusr_allow();
			setState(459);
			statusr_reply();
			setState(460);
			statusr_until();
			setState(461);
			match(DEDENT);
			setState(462);
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
			setState(464);
			match(ALLOW);
			setState(465);
			match(WS);
			setState(468);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case DOTEXPR:
			case IDXEXPR:
			case DOTIDXEXPR:
				{
				setState(466);
				variable();
				}
				break;
			case UINT:
				{
				setState(467);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(470);
			match(WS);
			setState(471);
			match(SECS);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(472);
				match(WS);
				}
			}

			setState(475);
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
			setState(477);
			match(REPLY);
			setState(478);
			match(WS);
			setState(479);
			call();
			setState(480);
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
			setState(482);
			match(UNTIL);
			setState(483);
			match(WS);
			setState(484);
			boolean_expr();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(485);
				match(WS);
				}
			}

			setState(488);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u01ed\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\6\2S\n\2\r\2"+
		"\16\2T\3\3\3\3\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\3\4\3\4\5\4b\n\4\3\4\3\4\7"+
		"\4f\n\4\f\4\16\4i\13\4\3\5\3\5\3\5\3\5\5\5o\n\5\3\5\3\5\3\6\3\6\3\6\6"+
		"\6v\n\6\r\6\16\6w\3\6\5\6{\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u008b\n\b\3\t\3\t\5\t\u008f\n\t\3\t\3\t\5\t\u0093"+
		"\n\t\3\n\3\n\5\n\u0097\n\n\3\n\3\n\5\n\u009b\n\n\3\n\3\n\5\n\u009f\n\n"+
		"\3\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\13\3\13\5\13\u00a9\n\13\3\f\5\f\u00ac"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b3\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bb"+
		"\n\r\f\r\16\r\u00be\13\r\3\r\5\r\u00c1\n\r\3\r\3\r\3\r\3\16\3\16\5\16"+
		"\u00c8\n\16\3\16\3\16\3\16\3\16\3\16\3\17\5\17\u00d0\n\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00d7\n\17\3\17\5\17\u00da\n\17\3\17\3\17\5\17\u00de"+
		"\n\17\3\20\3\20\6\20\u00e2\n\20\r\20\16\20\u00e3\3\20\5\20\u00e7\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\5\21\u00ee\n\21\3\21\7\21\u00f1\n\21\f\21\16"+
		"\21\u00f4\13\21\3\21\5\21\u00f7\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\5\23\u0100\n\23\3\24\3\24\3\25\3\25\3\25\5\25\u0107\n\25\3\26\3\26\5"+
		"\26\u010b\n\26\3\26\7\26\u010e\n\26\f\26\16\26\u0111\13\26\3\26\3\26\7"+
		"\26\u0115\n\26\f\26\16\26\u0118\13\26\3\26\5\26\u011b\n\26\3\26\3\26\3"+
		"\27\3\27\5\27\u0121\n\27\3\27\7\27\u0124\n\27\f\27\16\27\u0127\13\27\3"+
		"\27\3\27\7\27\u012b\n\27\f\27\16\27\u012e\13\27\3\27\5\27\u0131\n\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u013b\n\31\3\31\3\31\5\31"+
		"\u013f\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0148\n\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\5\33\u0150\n\33\3\33\5\33\u0153\n\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u015d\n\34\3\34\3\34\6\34\u0161\n"+
		"\34\r\34\16\34\u0162\3\34\3\34\5\34\u0167\n\34\3\35\3\35\5\35\u016b\n"+
		"\35\3\35\3\35\6\35\u016f\n\35\r\35\16\35\u0170\3\35\3\35\3\36\3\36\5\36"+
		"\u0177\n\36\3\36\3\36\6\36\u017b\n\36\r\36\16\36\u017c\3\36\3\36\5\36"+
		"\u0181\n\36\3\37\3\37\3\37\3\37\7\37\u0187\n\37\f\37\16\37\u018a\13\37"+
		"\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\5!\u0197\n!\3!\3!\3\"\3\"\5\"\u019d"+
		"\n\"\3\"\3\"\6\"\u01a1\n\"\r\"\16\"\u01a2\3\"\3\"\3#\3#\3#\3#\5#\u01ab"+
		"\n#\3#\3#\3#\5#\u01b0\n#\3#\3#\6#\u01b4\n#\r#\16#\u01b5\3#\5#\u01b9\n"+
		"#\3#\3#\3$\3$\3$\3$\5$\u01c1\n$\3$\3$\5$\u01c5\n$\3%\3%\3%\5%\u01ca\n"+
		"%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\5&\u01d7\n&\3&\3&\3&\5&\u01dc\n&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\5(\u01e9\n(\3(\3(\3(\2\2)\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\5\3"+
		"\2./\3\2(-\3\2!\"\2\u0214\2P\3\2\2\2\4V\3\2\2\2\6X\3\2\2\2\bj\3\2\2\2"+
		"\nr\3\2\2\2\f~\3\2\2\2\16\u008a\3\2\2\2\20\u008c\3\2\2\2\22\u0094\3\2"+
		"\2\2\24\u00a8\3\2\2\2\26\u00ab\3\2\2\2\30\u00b4\3\2\2\2\32\u00c7\3\2\2"+
		"\2\34\u00cf\3\2\2\2\36\u00df\3\2\2\2 \u00ea\3\2\2\2\"\u00f8\3\2\2\2$\u00ff"+
		"\3\2\2\2&\u0101\3\2\2\2(\u0106\3\2\2\2*\u0108\3\2\2\2,\u011e\3\2\2\2."+
		"\u0134\3\2\2\2\60\u0138\3\2\2\2\62\u0142\3\2\2\2\64\u014b\3\2\2\2\66\u0156"+
		"\3\2\2\28\u0168\3\2\2\2:\u0174\3\2\2\2<\u0182\3\2\2\2>\u018b\3\2\2\2@"+
		"\u0190\3\2\2\2B\u019a\3\2\2\2D\u01a6\3\2\2\2F\u01bc\3\2\2\2H\u01c6\3\2"+
		"\2\2J\u01d2\3\2\2\2L\u01df\3\2\2\2N\u01e4\3\2\2\2PR\5\6\4\2QS\5\16\b\2"+
		"RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\3\3\2\2\2VW\t\2\2\2W\5\3\2\2"+
		"\2XY\7\f\2\2YZ\7\63\2\2Z\\\5\4\3\2[]\7\63\2\2\\[\3\2\2\2\\]\3\2\2\2]^"+
		"\3\2\2\2^_\7\64\2\2_a\5\b\5\2`b\5\n\6\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2"+
		"cg\7\65\2\2df\7\n\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\7\3\2\2"+
		"\2ig\3\2\2\2jk\7\r\2\2kl\7\63\2\2ln\7*\2\2mo\7\63\2\2nm\3\2\2\2no\3\2"+
		"\2\2op\3\2\2\2pq\7\n\2\2q\t\3\2\2\2ru\7\16\2\2st\7\63\2\2tv\5\f\7\2us"+
		"\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2y{\7\63\2\2zy\3\2\2\2"+
		"z{\3\2\2\2{|\3\2\2\2|}\7\n\2\2}\13\3\2\2\2~\177\7.\2\2\177\r\3\2\2\2\u0080"+
		"\u008b\5\26\f\2\u0081\u008b\5\32\16\2\u0082\u008b\5\34\17\2\u0083\u008b"+
		"\5.\30\2\u0084\u008b\5\36\20\2\u0085\u008b\5\62\32\2\u0086\u008b\5\64"+
		"\33\2\u0087\u008b\5:\36\2\u0088\u008b\5\66\34\2\u0089\u008b\5D#\2\u008a"+
		"\u0080\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0083\3\2"+
		"\2\2\u008a\u0084\3\2\2\2\u008a\u0085\3\2\2\2\u008a\u0086\3\2\2\2\u008a"+
		"\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\17\3\2\2"+
		"\2\u008c\u008e\5\24\13\2\u008d\u008f\7\63\2\2\u008e\u008d\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\7&\2\2\u0091\u0093\7\63"+
		"\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\21\3\2\2\2\u0094\u0096"+
		"\5\24\13\2\u0095\u0097\7\63\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0098\u009a\7\3\2\2\u0099\u009b\7\63\2\2\u009a"+
		"\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\5\f"+
		"\7\2\u009d\u009f\7\63\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a2\7&\2\2\u00a1\u00a3\7\63\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a9\5\f\7\2\u00a5\u00a9"+
		"\7\60\2\2\u00a6\u00a9\7/\2\2\u00a7\u00a9\7\61\2\2\u00a8\u00a4\3\2\2\2"+
		"\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\25"+
		"\3\2\2\2\u00aa\u00ac\5\20\t\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\20\2\2\u00ae\u00af\7\63\2\2\u00af\u00b2"+
		"\5 \21\2\u00b0\u00b3\5\30\r\2\u00b1\u00b3\7\n\2\2\u00b2\u00b0\3\2\2\2"+
		"\u00b2\u00b1\3\2\2\2\u00b3\27\3\2\2\2\u00b4\u00b5\7\64\2\2\u00b5\u00b6"+
		"\7\27\2\2\u00b6\u00b7\7\63\2\2\u00b7\u00bc\7*\2\2\u00b8\u00b9\7\63\2\2"+
		"\u00b9\u00bb\7*\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\7\63\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3"+
		"\2\2\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\7\65\2\2\u00c4\31\3\2\2\2\u00c5"+
		"\u00c8\5\20\t\2\u00c6\u00c8\5\22\n\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3"+
		"\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7\21\2\2\u00ca"+
		"\u00cb\7\63\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd\7\n\2\2\u00cd\33\3\2\2"+
		"\2\u00ce\u00d0\5\20\t\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\7\22\2\2\u00d2\u00d3\7\63\2\2\u00d3\u00d6\7"+
		"*\2\2\u00d4\u00d5\7\63\2\2\u00d5\u00d7\5\24\13\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00da\7\63\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00de\5H%\2\u00dc"+
		"\u00de\7\n\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\35\3\2\2"+
		"\2\u00df\u00e1\7\17\2\2\u00e0\u00e2\5\"\22\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e7\7\63\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\7\n\2\2\u00e9\37\3\2\2\2\u00ea\u00ed\5\4\3"+
		"\2\u00eb\u00ec\7\4\2\2\u00ec\u00ee\7.\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f2\3\2\2\2\u00ef\u00f1\5\"\22\2\u00f0\u00ef\3\2\2\2"+
		"\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\7\63\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f7!\3\2\2\2\u00f8\u00f9\7\63\2\2\u00f9\u00fa\5"+
		"$\23\2\u00fa#\3\2\2\2\u00fb\u0100\5&\24\2\u00fc\u0100\5\24\13\2\u00fd"+
		"\u00fe\7\'\2\2\u00fe\u0100\5\24\13\2\u00ff\u00fb\3\2\2\2\u00ff\u00fc\3"+
		"\2\2\2\u00ff\u00fd\3\2\2\2\u0100%\3\2\2\2\u0101\u0102\t\3\2\2\u0102\'"+
		"\3\2\2\2\u0103\u0107\5,\27\2\u0104\u0107\5*\26\2\u0105\u0107\5$\23\2\u0106"+
		"\u0103\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107)\3\2\2\2"+
		"\u0108\u010a\7\5\2\2\u0109\u010b\7\63\2\2\u010a\u0109\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010f\3\2\2\2\u010c\u010e\5(\25\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0116\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\62\2\2\u0113\u0115\5(\25\2\u0114"+
		"\u0112\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\7\63\2\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\6"+
		"\2\2\u011d+\3\2\2\2\u011e\u0120\7\7\2\2\u011f\u0121\7\63\2\2\u0120\u011f"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0125\3\2\2\2\u0122\u0124\5\60\31\2"+
		"\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u012c\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7\62\2\2"+
		"\u0129\u012b\5\60\31\2\u012a\u0128\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012f"+
		"\u0131\7\63\2\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3"+
		"\2\2\2\u0132\u0133\7\b\2\2\u0133-\3\2\2\2\u0134\u0135\5\20\t\2\u0135\u0136"+
		"\5(\25\2\u0136\u0137\7\n\2\2\u0137/\3\2\2\2\u0138\u013a\7.\2\2\u0139\u013b"+
		"\7\63\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2\2\2"+
		"\u013c\u013e\7\t\2\2\u013d\u013f\7\63\2\2\u013e\u013d\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\5(\25\2\u0141\61\3\2\2\2\u0142"+
		"\u0143\7\36\2\2\u0143\u0144\7\63\2\2\u0144\u0145\7*\2\2\u0145\u0147\7"+
		"\63\2\2\u0146\u0148\7+\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\7\n\2\2\u014a\63\3\2\2\2\u014b\u014c\7\35\2"+
		"\2\u014c\u014f\7\63\2\2\u014d\u0150\7)\2\2\u014e\u0150\5\24\13\2\u014f"+
		"\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0153\7\63"+
		"\2\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0155\7\n\2\2\u0155\65\3\2\2\2\u0156\u0157\7\33\2\2\u0157\u0158\7\63"+
		"\2\2\u0158\u0159\5$\23\2\u0159\u015a\7\63\2\2\u015a\u015c\7$\2\2\u015b"+
		"\u015d\7\63\2\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3"+
		"\2\2\2\u015e\u0160\7\64\2\2\u015f\u0161\58\35\2\u0160\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2"+
		"\2\2\u0164\u0166\7\65\2\2\u0165\u0167\5B\"\2\u0166\u0165\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\67\3\2\2\2\u0168\u016a\5$\23\2\u0169\u016b\7\63\2"+
		"\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e"+
		"\7\64\2\2\u016d\u016f\5\16\b\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2"+
		"\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173"+
		"\7\65\2\2\u01739\3\2\2\2\u0174\u0176\5<\37\2\u0175\u0177\7\63\2\2\u0176"+
		"\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\7\64"+
		"\2\2\u0179\u017b\5\16\b\2\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\7\65"+
		"\2\2\u017f\u0181\5B\"\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		";\3\2\2\2\u0182\u0183\7\30\2\2\u0183\u0184\7\63\2\2\u0184\u0188\5@!\2"+
		"\u0185\u0187\5> \2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189=\3\2\2\2\u018a\u0188\3\2\2\2\u018b"+
		"\u018c\7\63\2\2\u018c\u018d\t\4\2\2\u018d\u018e\7\63\2\2\u018e\u018f\5"+
		"@!\2\u018f?\3\2\2\2\u0190\u0191\5$\23\2\u0191\u0192\7\63\2\2\u0192\u0193"+
		"\7\37\2\2\u0193\u0196\7\63\2\2\u0194\u0195\7 \2\2\u0195\u0197\7\63\2\2"+
		"\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199"+
		"\5$\23\2\u0199A\3\2\2\2\u019a\u019c\7\31\2\2\u019b\u019d\7\63\2\2\u019c"+
		"\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\7\64"+
		"\2\2\u019f\u01a1\5\16\b\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\7\65"+
		"\2\2\u01a5C\3\2\2\2\u01a6\u01a7\7\32\2\2\u01a7\u01aa\7\63\2\2\u01a8\u01ab"+
		"\5\24\13\2\u01a9\u01ab\7+\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2"+
		"\u01ab\u01ac\3\2\2\2\u01ac\u01ad\7\63\2\2\u01ad\u01af\7%\2\2\u01ae\u01b0"+
		"\7\63\2\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2"+
		"\u01b1\u01b3\7\64\2\2\u01b2\u01b4\5\16\b\2\u01b3\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7"+
		"\u01b9\5F$\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2"+
		"\2\u01ba\u01bb\7\65\2\2\u01bbE\3\2\2\2\u01bc\u01bd\7\34\2\2\u01bd\u01be"+
		"\7\63\2\2\u01be\u01c0\5<\37\2\u01bf\u01c1\7\63\2\2\u01c0\u01bf\3\2\2\2"+
		"\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\7\n\2\2\u01c3\u01c5"+
		"\5B\"\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5G\3\2\2\2\u01c6\u01c7"+
		"\7\64\2\2\u01c7\u01c9\7\23\2\2\u01c8\u01ca\7\63\2\2\u01c9\u01c8\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\7\64\2\2\u01cc"+
		"\u01cd\5J&\2\u01cd\u01ce\5L\'\2\u01ce\u01cf\5N(\2\u01cf\u01d0\7\65\2\2"+
		"\u01d0\u01d1\7\65\2\2\u01d1I\3\2\2\2\u01d2\u01d3\7\24\2\2\u01d3\u01d6"+
		"\7\63\2\2\u01d4\u01d7\5\24\13\2\u01d5\u01d7\7+\2\2\u01d6\u01d4\3\2\2\2"+
		"\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\7\63\2\2\u01d9\u01db"+
		"\7#\2\2\u01da\u01dc\7\63\2\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01de\7\n\2\2\u01deK\3\2\2\2\u01df\u01e0\7\25\2\2"+
		"\u01e0\u01e1\7\63\2\2\u01e1\u01e2\5 \21\2\u01e2\u01e3\7\n\2\2\u01e3M\3"+
		"\2\2\2\u01e4\u01e5\7\26\2\2\u01e5\u01e6\7\63\2\2\u01e6\u01e8\5@!\2\u01e7"+
		"\u01e9\7\63\2\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3"+
		"\2\2\2\u01ea\u01eb\7\n\2\2\u01ebO\3\2\2\2DT\\agnwz\u008a\u008e\u0092\u0096"+
		"\u009a\u009e\u00a2\u00a8\u00ab\u00b2\u00bc\u00c0\u00c7\u00cf\u00d6\u00d9"+
		"\u00dd\u00e3\u00e6\u00ed\u00f2\u00f6\u00ff\u0106\u010a\u010f\u0116\u011a"+
		"\u0120\u0125\u012c\u0130\u013a\u013e\u0147\u014f\u0152\u015c\u0162\u0166"+
		"\u016a\u0170\u0176\u017c\u0180\u0188\u0196\u019c\u01a2\u01aa\u01af\u01b5"+
		"\u01b8\u01c0\u01c4\u01c9\u01d6\u01db\u01e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}