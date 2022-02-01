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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NL=9, 
		COMMENT=10, FLOWSTART=11, BASE=12, FLOWINPUTS=13, LOG=14, FLOWCALL=15, 
		ACTIONCALL=16, RRFCALL=17, STATUS_REQ=18, ALLOW=19, REPLY=20, UNTIL=21, 
		OVERRIDE=22, WHEN=23, OTHERWISE=24, REPEAT=25, ITERATE=26, MATCH=27, QUIT=28, 
		FINISH=29, RFAC=30, IS=31, NOT=32, AND=33, OR=34, SECS=35, TO=36, MAXTIMES=37, 
		USE=38, EQ=39, MINUS=40, NUL=41, BOOL=42, STRING=43, UINT=44, SINT=45, 
		DECIMAL=46, ALPHANUM=47, QNAME=48, EVALNUM=49, DOTEXPR=50, DOTIDXEXPR=51, 
		SPCOMMA=52, WS=53, INDENT=54, DEDENT=55;
	public static final int
		RULE_flow = 0, RULE_header = 1, RULE_qname = 2, RULE_base = 3, RULE_inputs = 4, 
		RULE_short_var = 5, RULE_statement = 6, RULE_preassign = 7, RULE_preassign_catch = 8, 
		RULE_variable = 9, RULE_flow_call = 10, RULE_overrides = 11, RULE_action_call = 12, 
		RULE_rrf_call = 13, RULE_log = 14, RULE_static_call = 15, RULE_dyn_static_call = 16, 
		RULE_oo_call = 17, RULE_method_call = 18, RULE_argument = 19, RULE_simple_expr = 20, 
		RULE_literal = 21, RULE_expression = 22, RULE_array_expr = 23, RULE_object_expr = 24, 
		RULE_assignment = 25, RULE_keypair = 26, RULE_rfac = 27, RULE_finish = 28, 
		RULE_choice = 29, RULE_option = 30, RULE_ifelse = 31, RULE_caseof = 32, 
		RULE_boolean_op_expr = 33, RULE_boolean_expr = 34, RULE_elseblock = 35, 
		RULE_loop = 36, RULE_loopy = 37, RULE_quit_stmt = 38, RULE_statusr_block = 39, 
		RULE_statusr_allow = 40, RULE_statusr_reply = 41, RULE_statusr_until = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"flow", "header", "qname", "base", "inputs", "short_var", "statement", 
			"preassign", "preassign_catch", "variable", "flow_call", "overrides", 
			"action_call", "rrf_call", "log", "static_call", "dyn_static_call", "oo_call", 
			"method_call", "argument", "simple_expr", "literal", "expression", "array_expr", 
			"object_expr", "assignment", "keypair", "rfac", "finish", "choice", "option", 
			"ifelse", "caseof", "boolean_op_expr", "boolean_expr", "elseblock", "loop", 
			"loopy", "quit_stmt", "statusr_block", "statusr_allow", "statusr_reply", 
			"statusr_until"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'$'", "'#'", "'['", "']'", "'{'", "'}'", "':'", null, null, 
			"'Flow'", "'Basepath'", "'Inputs'", "'Log'", "'Trigger'", "'Call'", "'RRF'", 
			"'Status requests'", "'Allow for'", "'Reply'", "'Until'", "'Override templates'", 
			"'When'", "'Otherwise'", "'Repeat'", "'Iterate over'", "'Match'", "'Quit'", 
			"'Finish'", "'RFAC'", "'is'", "'not'", "'and'", "'or'", "'seconds'", 
			"'to'", "'times max'", "'using'", "'='", "'-'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NL", "COMMENT", 
			"FLOWSTART", "BASE", "FLOWINPUTS", "LOG", "FLOWCALL", "ACTIONCALL", "RRFCALL", 
			"STATUS_REQ", "ALLOW", "REPLY", "UNTIL", "OVERRIDE", "WHEN", "OTHERWISE", 
			"REPEAT", "ITERATE", "MATCH", "QUIT", "FINISH", "RFAC", "IS", "NOT", 
			"AND", "OR", "SECS", "TO", "MAXTIMES", "USE", "EQ", "MINUS", "NUL", "BOOL", 
			"STRING", "UINT", "SINT", "DECIMAL", "ALPHANUM", "QNAME", "EVALNUM", 
			"DOTEXPR", "DOTIDXEXPR", "SPCOMMA", "WS", "INDENT", "DEDENT"
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
			setState(86);
			header();
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				statement();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
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
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(FLOWSTART);
			setState(93);
			match(WS);
			setState(94);
			qname();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(95);
				match(WS);
				}
			}

			setState(98);
			match(INDENT);
			setState(99);
			base();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLOWINPUTS) {
				{
				setState(100);
				inputs();
				}
			}

			setState(103);
			match(DEDENT);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(104);
				match(NL);
				}
				}
				setState(109);
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

	public static class QnameContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public TerminalNode QNAME() { return getToken(AuthnFlowParser.QNAME, 0); }
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
		enterRule(_localctx, 4, RULE_qname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==ALPHANUM || _la==QNAME) ) {
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
			setState(112);
			match(BASE);
			setState(113);
			match(WS);
			setState(114);
			match(STRING);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(115);
				match(WS);
				}
			}

			setState(118);
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
			setState(120);
			match(FLOWINPUTS);
			setState(123); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(121);
					match(WS);
					setState(122);
					short_var();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(125); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(127);
				match(WS);
				}
			}

			setState(130);
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
			setState(132);
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
		public RfacContext rfac() {
			return getRuleContext(RfacContext.class,0);
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
		public LoopyContext loopy() {
			return getRuleContext(LoopyContext.class,0);
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
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				flow_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				action_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				rrf_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				log();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				rfac();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140);
				finish();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				ifelse();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(142);
				choice();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(143);
				loop();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(144);
				loopy();
				}
				break;
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
			match(EQ);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(152);
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
		public Short_varContext short_var() {
			return getRuleContext(Short_varContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AuthnFlowParser.EQ, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(155);
				variable();
				}
			}

			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(158);
				match(WS);
				}
			}

			setState(161);
			match(T__0);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(162);
				match(WS);
				}
			}

			setState(165);
			short_var();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(166);
				match(WS);
				}
			}

			setState(169);
			match(EQ);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(170);
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
		public TerminalNode QNAME() { return getToken(AuthnFlowParser.QNAME, 0); }
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
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				short_var();
				}
				break;
			case QNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(QNAME);
				}
				break;
			case DOTEXPR:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(DOTEXPR);
				}
				break;
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
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
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QnameContext qname() {
			return getRuleContext(QnameContext.class,0);
		}
		public OverridesContext overrides() {
			return getRuleContext(OverridesContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(179);
				preassign();
				}
			}

			setState(182);
			match(FLOWCALL);
			setState(183);
			match(WS);
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(184);
				match(T__1);
				setState(185);
				variable();
				}
				break;
			case ALPHANUM:
			case QNAME:
				{
				setState(186);
				qname();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(189);
					argument();
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(195);
				match(WS);
				}
			}

			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(198);
				overrides();
				}
				break;
			case NL:
				{
				setState(199);
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
			setState(202);
			match(INDENT);
			setState(203);
			match(OVERRIDE);
			setState(204);
			match(WS);
			setState(205);
			match(STRING);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					match(WS);
					setState(207);
					match(STRING);
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(213);
				match(WS);
				}
			}

			setState(216);
			match(NL);
			setState(217);
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
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public Dyn_static_callContext dyn_static_call() {
			return getRuleContext(Dyn_static_callContext.class,0);
		}
		public Static_callContext static_call() {
			return getRuleContext(Static_callContext.class,0);
		}
		public Oo_callContext oo_call() {
			return getRuleContext(Oo_callContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(219);
				preassign();
				}
				break;
			case 2:
				{
				setState(220);
				preassign_catch();
				}
				break;
			}
			setState(223);
			match(ACTIONCALL);
			setState(224);
			match(WS);
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(225);
				dyn_static_call();
				}
				break;
			case 2:
				{
				setState(226);
				static_call();
				}
				break;
			case 3:
				{
				setState(227);
				oo_call();
				}
				break;
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(230);
				match(WS);
				}
			}

			setState(233);
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
		public TerminalNode BOOL() { return getToken(AuthnFlowParser.BOOL, 0); }
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
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(235);
				preassign();
				}
			}

			setState(238);
			match(RRFCALL);
			setState(239);
			match(WS);
			setState(240);
			match(STRING);
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(241);
				match(WS);
				setState(242);
				variable();
				}
				break;
			}
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(245);
				match(WS);
				setState(246);
				match(BOOL);
				}
				break;
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(249);
				match(WS);
				}
			}

			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(252);
				statusr_block();
				}
				break;
			case NL:
				{
				setState(253);
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
			setState(256);
			match(LOG);
			setState(258); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(257);
					argument();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(262);
				match(WS);
				}
			}

			setState(265);
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

	public static class Static_callContext extends ParserRuleContext {
		public QnameContext qname() {
			return getRuleContext(QnameContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Static_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterStatic_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitStatic_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitStatic_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Static_callContext static_call() throws RecognitionException {
		Static_callContext _localctx = new Static_callContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_static_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			qname();
			setState(268);
			match(T__2);
			setState(269);
			method_call();
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

	public static class Dyn_static_callContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Dyn_static_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dyn_static_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterDyn_static_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitDyn_static_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitDyn_static_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dyn_static_callContext dyn_static_call() throws RecognitionException {
		Dyn_static_callContext _localctx = new Dyn_static_callContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dyn_static_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__1);
			setState(272);
			variable();
			setState(273);
			match(T__2);
			setState(274);
			method_call();
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

	public static class Oo_callContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Oo_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oo_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterOo_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitOo_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitOo_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Oo_callContext oo_call() throws RecognitionException {
		Oo_callContext _localctx = new Oo_callContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_oo_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			variable();
			setState(277);
			match(WS);
			setState(278);
			method_call();
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

	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(AuthnFlowParser.ALPHANUM, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitMethod_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_method_call);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(ALPHANUM);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					argument();
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 38, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(WS);
			setState(288);
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
		enterRule(_localctx, 40, RULE_simple_expr);
		try {
			setState(294);
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
				setState(290);
				literal();
				}
				break;
			case ALPHANUM:
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				variable();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(292);
				match(MINUS);
				setState(293);
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
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
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
		enterRule(_localctx, 44, RULE_expression);
		try {
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				object_expr();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
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
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
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
		enterRule(_localctx, 46, RULE_array_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(T__3);
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(304);
				match(WS);
				}
				break;
			}
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				{
				setState(307);
				expression();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(313);
				match(SPCOMMA);
				setState(314);
				expression();
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(320);
				match(WS);
				}
			}

			setState(323);
			match(T__4);
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
		enterRule(_localctx, 48, RULE_object_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(T__5);
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(326);
				match(WS);
				}
				break;
			}
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALPHANUM) {
				{
				{
				setState(329);
				keypair();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPCOMMA) {
				{
				{
				setState(335);
				match(SPCOMMA);
				setState(336);
				keypair();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(342);
				match(WS);
				}
			}

			setState(345);
			match(T__6);
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
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
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
		enterRule(_localctx, 50, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			preassign();
			setState(348);
			expression();
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(349);
				match(WS);
				}
			}

			setState(352);
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
		enterRule(_localctx, 52, RULE_keypair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ALPHANUM);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(355);
				match(WS);
				}
			}

			setState(358);
			match(T__7);
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

	public static class RfacContext extends ParserRuleContext {
		public TerminalNode RFAC() { return getToken(AuthnFlowParser.RFAC, 0); }
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public TerminalNode STRING() { return getToken(AuthnFlowParser.STRING, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public RfacContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rfac; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterRfac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitRfac(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitRfac(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RfacContext rfac() throws RecognitionException {
		RfacContext _localctx = new RfacContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rfac);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(364);
				preassign();
				}
			}

			setState(367);
			match(RFAC);
			setState(368);
			match(WS);
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(369);
				match(STRING);
				}
				break;
			case ALPHANUM:
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				{
				setState(370);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(373);
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
		enterRule(_localctx, 56, RULE_finish);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(FINISH);
			setState(376);
			match(WS);
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				{
				setState(377);
				match(BOOL);
				}
				break;
			case ALPHANUM:
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				{
				setState(378);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(381);
				match(WS);
				}
			}

			setState(384);
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
		enterRule(_localctx, 58, RULE_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(MATCH);
			setState(387);
			match(WS);
			setState(388);
			simple_expr();
			setState(389);
			match(WS);
			setState(390);
			match(TO);
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(391);
				match(WS);
				}
			}

			setState(394);
			match(INDENT);
			setState(396); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(395);
				option();
				}
				}
				setState(398); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NUL) | (1L << BOOL) | (1L << STRING) | (1L << UINT) | (1L << SINT) | (1L << DECIMAL) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0) );
			setState(400);
			match(DEDENT);
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(401);
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
		enterRule(_localctx, 60, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			simple_expr();
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(405);
				match(WS);
				}
			}

			setState(408);
			match(INDENT);
			setState(410); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(409);
				statement();
				}
				}
				setState(412); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
			setState(414);
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
		enterRule(_localctx, 62, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			caseof();
			setState(417);
			match(INDENT);
			setState(419); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(418);
				statement();
				}
				}
				setState(421); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
			setState(423);
			match(DEDENT);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(424);
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
		enterRule(_localctx, 64, RULE_caseof);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(WHEN);
			setState(428);
			match(WS);
			setState(429);
			boolean_expr();
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(430);
					boolean_op_expr();
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		public Boolean_exprContext boolean_expr() {
			return getRuleContext(Boolean_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(AuthnFlowParser.AND, 0); }
		public TerminalNode OR() { return getToken(AuthnFlowParser.OR, 0); }
		public List<TerminalNode> NL() { return getTokens(AuthnFlowParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AuthnFlowParser.NL, i);
		}
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
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
		enterRule(_localctx, 66, RULE_boolean_op_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(436);
				match(NL);
				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(442);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(443);
				match(WS);
				}
			}

			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(446);
				match(NL);
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
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
		enterRule(_localctx, 68, RULE_boolean_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			simple_expr();
			setState(455);
			match(WS);
			setState(456);
			match(IS);
			setState(457);
			match(WS);
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(458);
				match(NOT);
				setState(459);
				match(WS);
				}
			}

			setState(462);
			simple_expr();
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(463);
				match(WS);
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
		enterRule(_localctx, 70, RULE_elseblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(OTHERWISE);
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(467);
				match(WS);
				}
			}

			setState(470);
			match(INDENT);
			setState(472); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(471);
				statement();
				}
				}
				setState(474); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
			setState(476);
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
		public TerminalNode ITERATE() { return getToken(AuthnFlowParser.ITERATE, 0); }
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode USE() { return getToken(AuthnFlowParser.USE, 0); }
		public Short_varContext short_var() {
			return getRuleContext(Short_varContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(AuthnFlowParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(AuthnFlowParser.DEDENT, 0); }
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
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
		enterRule(_localctx, 72, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(478);
				preassign();
				}
			}

			setState(481);
			match(ITERATE);
			setState(482);
			match(WS);
			setState(483);
			variable();
			setState(484);
			match(WS);
			setState(485);
			match(USE);
			setState(486);
			match(WS);
			setState(487);
			short_var();
			setState(488);
			match(INDENT);
			setState(490); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(489);
				statement();
				}
				}
				setState(492); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUIT) {
				{
				setState(494);
				quit_stmt();
				}
			}

			setState(497);
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

	public static class LoopyContext extends ParserRuleContext {
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
		public PreassignContext preassign() {
			return getRuleContext(PreassignContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Quit_stmtContext quit_stmt() {
			return getRuleContext(Quit_stmtContext.class,0);
		}
		public LoopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).enterLoopy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuthnFlowListener ) ((AuthnFlowListener)listener).exitLoopy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuthnFlowVisitor ) return ((AuthnFlowVisitor<? extends T>)visitor).visitLoopy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopyContext loopy() throws RecognitionException {
		LoopyContext _localctx = new LoopyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_loopy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR))) != 0)) {
				{
				setState(499);
				preassign();
				}
			}

			setState(502);
			match(REPEAT);
			setState(503);
			match(WS);
			setState(506);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				{
				setState(504);
				variable();
				}
				break;
			case UINT:
				{
				setState(505);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(508);
			match(WS);
			setState(509);
			match(MAXTIMES);
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(510);
				match(WS);
				}
			}

			setState(513);
			match(INDENT);
			setState(515); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(514);
				statement();
				}
				}
				setState(517); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0) );
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUIT) {
				{
				setState(519);
				quit_stmt();
				}
			}

			setState(522);
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
		public TerminalNode WS() { return getToken(AuthnFlowParser.WS, 0); }
		public CaseofContext caseof() {
			return getRuleContext(CaseofContext.class,0);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 76, RULE_quit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(QUIT);
			setState(525);
			match(WS);
			setState(526);
			caseof();
			setState(527);
			match(NL);
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << LOG) | (1L << FLOWCALL) | (1L << ACTIONCALL) | (1L << RRFCALL) | (1L << WHEN) | (1L << REPEAT) | (1L << ITERATE) | (1L << MATCH) | (1L << FINISH) | (1L << RFAC) | (1L << ALPHANUM) | (1L << QNAME) | (1L << DOTEXPR) | (1L << DOTIDXEXPR) | (1L << WS))) != 0)) {
				{
				{
				setState(528);
				statement();
				}
				}
				setState(533);
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
		enterRule(_localctx, 78, RULE_statusr_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(INDENT);
			setState(535);
			match(STATUS_REQ);
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(536);
				match(WS);
				}
			}

			setState(539);
			match(INDENT);
			setState(540);
			statusr_allow();
			setState(541);
			statusr_reply();
			setState(542);
			statusr_until();
			setState(543);
			match(DEDENT);
			setState(544);
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
		enterRule(_localctx, 80, RULE_statusr_allow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(ALLOW);
			setState(547);
			match(WS);
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHANUM:
			case QNAME:
			case DOTEXPR:
			case DOTIDXEXPR:
				{
				setState(548);
				variable();
				}
				break;
			case UINT:
				{
				setState(549);
				match(UINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(552);
			match(WS);
			setState(553);
			match(SECS);
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(554);
				match(WS);
				}
			}

			setState(557);
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
		public List<TerminalNode> WS() { return getTokens(AuthnFlowParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AuthnFlowParser.WS, i);
		}
		public TerminalNode NL() { return getToken(AuthnFlowParser.NL, 0); }
		public Dyn_static_callContext dyn_static_call() {
			return getRuleContext(Dyn_static_callContext.class,0);
		}
		public Static_callContext static_call() {
			return getRuleContext(Static_callContext.class,0);
		}
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
		enterRule(_localctx, 82, RULE_statusr_reply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(REPLY);
			setState(560);
			match(WS);
			setState(563);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(561);
				dyn_static_call();
				}
				break;
			case ALPHANUM:
			case QNAME:
				{
				setState(562);
				static_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(565);
				match(WS);
				}
			}

			setState(568);
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
		enterRule(_localctx, 84, RULE_statusr_until);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(UNTIL);
			setState(571);
			match(WS);
			setState(572);
			boolean_expr();
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(573);
				match(WS);
				}
			}

			setState(576);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u0245\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\6\2[\n\2\r\2\16\2\\\3\3\3\3\3\3\3\3\5\3c\n\3\3\3\3\3\3\3"+
		"\5\3h\n\3\3\3\3\3\7\3l\n\3\f\3\16\3o\13\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5"+
		"w\n\5\3\5\3\5\3\6\3\6\3\6\6\6~\n\6\r\6\16\6\177\3\6\5\6\u0083\n\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0094\n\b"+
		"\3\t\3\t\5\t\u0098\n\t\3\t\3\t\5\t\u009c\n\t\3\n\5\n\u009f\n\n\3\n\5\n"+
		"\u00a2\n\n\3\n\3\n\5\n\u00a6\n\n\3\n\3\n\5\n\u00aa\n\n\3\n\3\n\5\n\u00ae"+
		"\n\n\3\13\3\13\3\13\3\13\5\13\u00b4\n\13\3\f\5\f\u00b7\n\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00be\n\f\3\f\7\f\u00c1\n\f\f\f\16\f\u00c4\13\f\3\f\5\f\u00c7"+
		"\n\f\3\f\3\f\5\f\u00cb\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d3\n\r\f\r\16"+
		"\r\u00d6\13\r\3\r\5\r\u00d9\n\r\3\r\3\r\3\r\3\16\3\16\5\16\u00e0\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00e7\n\16\3\16\5\16\u00ea\n\16\3\16\3"+
		"\16\3\17\5\17\u00ef\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f6\n\17\3\17"+
		"\3\17\5\17\u00fa\n\17\3\17\5\17\u00fd\n\17\3\17\3\17\5\17\u0101\n\17\3"+
		"\20\3\20\6\20\u0105\n\20\r\20\16\20\u0106\3\20\5\20\u010a\n\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\7\24\u011d\n\24\f\24\16\24\u0120\13\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\5\26\u0129\n\26\3\27\3\27\3\30\3\30\3\30\5\30\u0130\n\30"+
		"\3\31\3\31\5\31\u0134\n\31\3\31\7\31\u0137\n\31\f\31\16\31\u013a\13\31"+
		"\3\31\3\31\7\31\u013e\n\31\f\31\16\31\u0141\13\31\3\31\5\31\u0144\n\31"+
		"\3\31\3\31\3\32\3\32\5\32\u014a\n\32\3\32\7\32\u014d\n\32\f\32\16\32\u0150"+
		"\13\32\3\32\3\32\7\32\u0154\n\32\f\32\16\32\u0157\13\32\3\32\5\32\u015a"+
		"\n\32\3\32\3\32\3\33\3\33\3\33\5\33\u0161\n\33\3\33\3\33\3\34\3\34\5\34"+
		"\u0167\n\34\3\34\3\34\5\34\u016b\n\34\3\34\3\34\3\35\5\35\u0170\n\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0176\n\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36"+
		"\u017e\n\36\3\36\5\36\u0181\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\5\37\u018b\n\37\3\37\3\37\6\37\u018f\n\37\r\37\16\37\u0190\3\37\3"+
		"\37\5\37\u0195\n\37\3 \3 \5 \u0199\n \3 \3 \6 \u019d\n \r \16 \u019e\3"+
		" \3 \3!\3!\3!\6!\u01a6\n!\r!\16!\u01a7\3!\3!\5!\u01ac\n!\3\"\3\"\3\"\3"+
		"\"\7\"\u01b2\n\"\f\"\16\"\u01b5\13\"\3#\7#\u01b8\n#\f#\16#\u01bb\13#\3"+
		"#\3#\5#\u01bf\n#\3#\7#\u01c2\n#\f#\16#\u01c5\13#\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\5$\u01cf\n$\3$\3$\5$\u01d3\n$\3%\3%\5%\u01d7\n%\3%\3%\6%\u01db\n%"+
		"\r%\16%\u01dc\3%\3%\3&\5&\u01e2\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\6&\u01ed"+
		"\n&\r&\16&\u01ee\3&\5&\u01f2\n&\3&\3&\3\'\5\'\u01f7\n\'\3\'\3\'\3\'\3"+
		"\'\5\'\u01fd\n\'\3\'\3\'\3\'\5\'\u0202\n\'\3\'\3\'\6\'\u0206\n\'\r\'\16"+
		"\'\u0207\3\'\5\'\u020b\n\'\3\'\3\'\3(\3(\3(\3(\3(\7(\u0214\n(\f(\16(\u0217"+
		"\13(\3)\3)\3)\5)\u021c\n)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\5*\u0229\n"+
		"*\3*\3*\3*\5*\u022e\n*\3*\3*\3+\3+\3+\3+\5+\u0236\n+\3+\5+\u0239\n+\3"+
		"+\3+\3,\3,\3,\3,\5,\u0241\n,\3,\3,\3,\2\2-\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\5\3\2\61\62\3\2+\60"+
		"\3\2#$\2\u0279\2X\3\2\2\2\4^\3\2\2\2\6p\3\2\2\2\br\3\2\2\2\nz\3\2\2\2"+
		"\f\u0086\3\2\2\2\16\u0093\3\2\2\2\20\u0095\3\2\2\2\22\u009e\3\2\2\2\24"+
		"\u00b3\3\2\2\2\26\u00b6\3\2\2\2\30\u00cc\3\2\2\2\32\u00df\3\2\2\2\34\u00ee"+
		"\3\2\2\2\36\u0102\3\2\2\2 \u010d\3\2\2\2\"\u0111\3\2\2\2$\u0116\3\2\2"+
		"\2&\u011a\3\2\2\2(\u0121\3\2\2\2*\u0128\3\2\2\2,\u012a\3\2\2\2.\u012f"+
		"\3\2\2\2\60\u0131\3\2\2\2\62\u0147\3\2\2\2\64\u015d\3\2\2\2\66\u0164\3"+
		"\2\2\28\u016f\3\2\2\2:\u0179\3\2\2\2<\u0184\3\2\2\2>\u0196\3\2\2\2@\u01a2"+
		"\3\2\2\2B\u01ad\3\2\2\2D\u01b9\3\2\2\2F\u01c8\3\2\2\2H\u01d4\3\2\2\2J"+
		"\u01e1\3\2\2\2L\u01f6\3\2\2\2N\u020e\3\2\2\2P\u0218\3\2\2\2R\u0224\3\2"+
		"\2\2T\u0231\3\2\2\2V\u023c\3\2\2\2XZ\5\4\3\2Y[\5\16\b\2ZY\3\2\2\2[\\\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\3\3\2\2\2^_\7\r\2\2_`\7\67\2\2`b\5\6\4\2"+
		"ac\7\67\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\78\2\2eg\5\b\5\2fh\5\n\6\2"+
		"gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2im\79\2\2jl\7\13\2\2kj\3\2\2\2lo\3\2\2\2"+
		"mk\3\2\2\2mn\3\2\2\2n\5\3\2\2\2om\3\2\2\2pq\t\2\2\2q\7\3\2\2\2rs\7\16"+
		"\2\2st\7\67\2\2tv\7-\2\2uw\7\67\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7"+
		"\13\2\2y\t\3\2\2\2z}\7\17\2\2{|\7\67\2\2|~\5\f\7\2}{\3\2\2\2~\177\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\u0083\7"+
		"\67\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\7\13\2\2\u0085\13\3\2\2\2\u0086\u0087\7\61\2\2\u0087\r\3\2\2\2"+
		"\u0088\u0094\5\26\f\2\u0089\u0094\5\32\16\2\u008a\u0094\5\34\17\2\u008b"+
		"\u0094\5\64\33\2\u008c\u0094\5\36\20\2\u008d\u0094\58\35\2\u008e\u0094"+
		"\5:\36\2\u008f\u0094\5@!\2\u0090\u0094\5<\37\2\u0091\u0094\5J&\2\u0092"+
		"\u0094\5L\'\2\u0093\u0088\3\2\2\2\u0093\u0089\3\2\2\2\u0093\u008a\3\2"+
		"\2\2\u0093\u008b\3\2\2\2\u0093\u008c\3\2\2\2\u0093\u008d\3\2\2\2\u0093"+
		"\u008e\3\2\2\2\u0093\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0092\3\2\2\2\u0094\17\3\2\2\2\u0095\u0097\5\24\13\2\u0096"+
		"\u0098\7\67\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3"+
		"\2\2\2\u0099\u009b\7)\2\2\u009a\u009c\7\67\2\2\u009b\u009a\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\21\3\2\2\2\u009d\u009f\5\24\13\2\u009e\u009d\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2\7\67\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\7\3"+
		"\2\2\u00a4\u00a6\7\67\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a9\5\f\7\2\u00a8\u00aa\7\67\2\2\u00a9\u00a8\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\7)\2\2\u00ac"+
		"\u00ae\7\67\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\23\3\2\2"+
		"\2\u00af\u00b4\5\f\7\2\u00b0\u00b4\7\62\2\2\u00b1\u00b4\7\64\2\2\u00b2"+
		"\u00b4\7\65\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3"+
		"\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\25\3\2\2\2\u00b5\u00b7\5\20\t\2\u00b6"+
		"\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\21"+
		"\2\2\u00b9\u00bd\7\67\2\2\u00ba\u00bb\7\4\2\2\u00bb\u00be\5\24\13\2\u00bc"+
		"\u00be\5\6\4\2\u00bd\u00ba\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c2\3\2"+
		"\2\2\u00bf\u00c1\5(\25\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00c7\7\67\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00cb\5\30\r\2\u00c9\u00cb\7\13\2\2\u00ca\u00c8\3"+
		"\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\27\3\2\2\2\u00cc\u00cd\78\2\2\u00cd\u00ce"+
		"\7\30\2\2\u00ce\u00cf\7\67\2\2\u00cf\u00d4\7-\2\2\u00d0\u00d1\7\67\2\2"+
		"\u00d1\u00d3\7-\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d9\7\67\2\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3"+
		"\2\2\2\u00da\u00db\7\13\2\2\u00db\u00dc\79\2\2\u00dc\31\3\2\2\2\u00dd"+
		"\u00e0\5\20\t\2\u00de\u00e0\5\22\n\2\u00df\u00dd\3\2\2\2\u00df\u00de\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\22\2\2\u00e2"+
		"\u00e6\7\67\2\2\u00e3\u00e7\5\"\22\2\u00e4\u00e7\5 \21\2\u00e5\u00e7\5"+
		"$\23\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00ea\7\67\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\7\13\2\2\u00ec\33\3\2\2\2\u00ed"+
		"\u00ef\5\20\t\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3"+
		"\2\2\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2\7\67\2\2\u00f2\u00f5\7-\2\2\u00f3"+
		"\u00f4\7\67\2\2\u00f4\u00f6\5\24\13\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f8\7\67\2\2\u00f8\u00fa\7,\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00fd\7\67"+
		"\2\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u0101\5P)\2\u00ff\u0101\7\13\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2"+
		"\2\2\u0101\35\3\2\2\2\u0102\u0104\7\20\2\2\u0103\u0105\5(\25\2\u0104\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u0109\3\2\2\2\u0108\u010a\7\67\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3"+
		"\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\13\2\2\u010c\37\3\2\2\2\u010d"+
		"\u010e\5\6\4\2\u010e\u010f\7\5\2\2\u010f\u0110\5&\24\2\u0110!\3\2\2\2"+
		"\u0111\u0112\7\4\2\2\u0112\u0113\5\24\13\2\u0113\u0114\7\5\2\2\u0114\u0115"+
		"\5&\24\2\u0115#\3\2\2\2\u0116\u0117\5\24\13\2\u0117\u0118\7\67\2\2\u0118"+
		"\u0119\5&\24\2\u0119%\3\2\2\2\u011a\u011e\7\61\2\2\u011b\u011d\5(\25\2"+
		"\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\'\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\67\2\2\u0122"+
		"\u0123\5*\26\2\u0123)\3\2\2\2\u0124\u0129\5,\27\2\u0125\u0129\5\24\13"+
		"\2\u0126\u0127\7*\2\2\u0127\u0129\5\24\13\2\u0128\u0124\3\2\2\2\u0128"+
		"\u0125\3\2\2\2\u0128\u0126\3\2\2\2\u0129+\3\2\2\2\u012a\u012b\t\3\2\2"+
		"\u012b-\3\2\2\2\u012c\u0130\5\62\32\2\u012d\u0130\5\60\31\2\u012e\u0130"+
		"\5*\26\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130"+
		"/\3\2\2\2\u0131\u0133\7\6\2\2\u0132\u0134\7\67\2\2\u0133\u0132\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\u0138\3\2\2\2\u0135\u0137\5.\30\2\u0136\u0135"+
		"\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013f\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7\66\2\2\u013c\u013e\5"+
		".\30\2\u013d\u013b\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0144\7\67"+
		"\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\7\7\2\2\u0146\61\3\2\2\2\u0147\u0149\7\b\2\2\u0148\u014a\7\67\2"+
		"\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e\3\2\2\2\u014b\u014d"+
		"\5\66\34\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2"+
		"\u014e\u014f\3\2\2\2\u014f\u0155\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152"+
		"\7\66\2\2\u0152\u0154\5\66\34\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2"+
		"\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0158\u015a\7\67\2\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2"+
		"\u015a\u015b\3\2\2\2\u015b\u015c\7\t\2\2\u015c\63\3\2\2\2\u015d\u015e"+
		"\5\20\t\2\u015e\u0160\5.\30\2\u015f\u0161\7\67\2\2\u0160\u015f\3\2\2\2"+
		"\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7\13\2\2\u0163\65"+
		"\3\2\2\2\u0164\u0166\7\61\2\2\u0165\u0167\7\67\2\2\u0166\u0165\3\2\2\2"+
		"\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\7\n\2\2\u0169\u016b"+
		"\7\67\2\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2"+
		"\u016c\u016d\5.\30\2\u016d\67\3\2\2\2\u016e\u0170\5\20\t\2\u016f\u016e"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7 \2\2\u0172"+
		"\u0175\7\67\2\2\u0173\u0176\7-\2\2\u0174\u0176\5\24\13\2\u0175\u0173\3"+
		"\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7\13\2\2\u0178"+
		"9\3\2\2\2\u0179\u017a\7\37\2\2\u017a\u017d\7\67\2\2\u017b\u017e\7,\2\2"+
		"\u017c\u017e\5\24\13\2\u017d\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017e\u0180"+
		"\3\2\2\2\u017f\u0181\7\67\2\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0183\7\13\2\2\u0183;\3\2\2\2\u0184\u0185\7"+
		"\35\2\2\u0185\u0186\7\67\2\2\u0186\u0187\5*\26\2\u0187\u0188\7\67\2\2"+
		"\u0188\u018a\7&\2\2\u0189\u018b\7\67\2\2\u018a\u0189\3\2\2\2\u018a\u018b"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\78\2\2\u018d\u018f\5> \2\u018e"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u0192\3\2\2\2\u0192\u0194\79\2\2\u0193\u0195\5H%\2\u0194\u0193"+
		"\3\2\2\2\u0194\u0195\3\2\2\2\u0195=\3\2\2\2\u0196\u0198\5*\26\2\u0197"+
		"\u0199\7\67\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3"+
		"\2\2\2\u019a\u019c\78\2\2\u019b\u019d\5\16\b\2\u019c\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u01a1\79\2\2\u01a1?\3\2\2\2\u01a2\u01a3\5B\"\2\u01a3\u01a5"+
		"\78\2\2\u01a4\u01a6\5\16\b\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\79"+
		"\2\2\u01aa\u01ac\5H%\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acA"+
		"\3\2\2\2\u01ad\u01ae\7\31\2\2\u01ae\u01af\7\67\2\2\u01af\u01b3\5F$\2\u01b0"+
		"\u01b2\5D#\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4C\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b8"+
		"\7\13\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2"+
		"\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01be"+
		"\t\4\2\2\u01bd\u01bf\7\67\2\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2"+
		"\u01bf\u01c3\3\2\2\2\u01c0\u01c2\7\13\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c7\5F$\2\u01c7E\3\2\2\2\u01c8\u01c9\5*\26\2\u01c9"+
		"\u01ca\7\67\2\2\u01ca\u01cb\7!\2\2\u01cb\u01ce\7\67\2\2\u01cc\u01cd\7"+
		"\"\2\2\u01cd\u01cf\7\67\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d2\5*\26\2\u01d1\u01d3\7\67\2\2\u01d2\u01d1\3"+
		"\2\2\2\u01d2\u01d3\3\2\2\2\u01d3G\3\2\2\2\u01d4\u01d6\7\32\2\2\u01d5\u01d7"+
		"\7\67\2\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2"+
		"\u01d8\u01da\78\2\2\u01d9\u01db\5\16\b\2\u01da\u01d9\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\u01df\79\2\2\u01dfI\3\2\2\2\u01e0\u01e2\5\20\t\2\u01e1\u01e0\3\2\2\2"+
		"\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\7\34\2\2\u01e4\u01e5"+
		"\7\67\2\2\u01e5\u01e6\5\24\13\2\u01e6\u01e7\7\67\2\2\u01e7\u01e8\7(\2"+
		"\2\u01e8\u01e9\7\67\2\2\u01e9\u01ea\5\f\7\2\u01ea\u01ec\78\2\2\u01eb\u01ed"+
		"\5\16\b\2\u01ec\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2"+
		"\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01f2\5N(\2\u01f1\u01f0"+
		"\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\79\2\2\u01f4"+
		"K\3\2\2\2\u01f5\u01f7\5\20\t\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8\u01f9\7\33\2\2\u01f9\u01fc\7\67\2\2\u01fa\u01fd"+
		"\5\24\13\2\u01fb\u01fd\7.\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb\3\2\2\2"+
		"\u01fd\u01fe\3\2\2\2\u01fe\u01ff\7\67\2\2\u01ff\u0201\7\'\2\2\u0200\u0202"+
		"\7\67\2\2\u0201\u0200\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203\3\2\2\2"+
		"\u0203\u0205\78\2\2\u0204\u0206\5\16\b\2\u0205\u0204\3\2\2\2\u0206\u0207"+
		"\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209"+
		"\u020b\5N(\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2"+
		"\2\u020c\u020d\79\2\2\u020dM\3\2\2\2\u020e\u020f\7\36\2\2\u020f\u0210"+
		"\7\67\2\2\u0210\u0211\5B\"\2\u0211\u0215\7\13\2\2\u0212\u0214\5\16\b\2"+
		"\u0213\u0212\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216"+
		"\3\2\2\2\u0216O\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u0219\78\2\2\u0219\u021b"+
		"\7\24\2\2\u021a\u021c\7\67\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2"+
		"\u021c\u021d\3\2\2\2\u021d\u021e\78\2\2\u021e\u021f\5R*\2\u021f\u0220"+
		"\5T+\2\u0220\u0221\5V,\2\u0221\u0222\79\2\2\u0222\u0223\79\2\2\u0223Q"+
		"\3\2\2\2\u0224\u0225\7\25\2\2\u0225\u0228\7\67\2\2\u0226\u0229\5\24\13"+
		"\2\u0227\u0229\7.\2\2\u0228\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229\u022a"+
		"\3\2\2\2\u022a\u022b\7\67\2\2\u022b\u022d\7%\2\2\u022c\u022e\7\67\2\2"+
		"\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230"+
		"\7\13\2\2\u0230S\3\2\2\2\u0231\u0232\7\26\2\2\u0232\u0235\7\67\2\2\u0233"+
		"\u0236\5\"\22\2\u0234\u0236\5 \21\2\u0235\u0233\3\2\2\2\u0235\u0234\3"+
		"\2\2\2\u0236\u0238\3\2\2\2\u0237\u0239\7\67\2\2\u0238\u0237\3\2\2\2\u0238"+
		"\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\7\13\2\2\u023bU\3\2\2\2"+
		"\u023c\u023d\7\27\2\2\u023d\u023e\7\67\2\2\u023e\u0240\5F$\2\u023f\u0241"+
		"\7\67\2\2\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2\2\2"+
		"\u0242\u0243\7\13\2\2\u0243W\3\2\2\2S\\bgmv\177\u0082\u0093\u0097\u009b"+
		"\u009e\u00a1\u00a5\u00a9\u00ad\u00b3\u00b6\u00bd\u00c2\u00c6\u00ca\u00d4"+
		"\u00d8\u00df\u00e6\u00e9\u00ee\u00f5\u00f9\u00fc\u0100\u0106\u0109\u011e"+
		"\u0128\u012f\u0133\u0138\u013f\u0143\u0149\u014e\u0155\u0159\u0160\u0166"+
		"\u016a\u016f\u0175\u017d\u0180\u018a\u0190\u0194\u0198\u019e\u01a7\u01ab"+
		"\u01b3\u01b9\u01be\u01c3\u01ce\u01d2\u01d6\u01dc\u01e1\u01ee\u01f1\u01f6"+
		"\u01fc\u0201\u0207\u020a\u0215\u021b\u0228\u022d\u0235\u0238\u0240";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}