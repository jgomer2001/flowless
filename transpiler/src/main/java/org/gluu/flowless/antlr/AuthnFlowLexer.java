// Generated from AuthnFlow.g4 by ANTLR 4.9.2
package org.gluu.flowless.antlr;

  import com.yuvalshavit.antlr4.DenterHelper;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AuthnFlowLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NL=9, 
		COMMENT=10, FLOWSTART=11, BASE=12, FLOWINPUTS=13, LOG=14, FLOWCALL=15, 
		ACTIONCALL=16, RRFCALL=17, STATUS_REQ=18, ALLOW=19, REPLY=20, UNTIL=21, 
		OVERRIDE=22, WHEN=23, OTHERWISE=24, REPEAT=25, MATCH=26, QUIT=27, FINISH=28, 
		RFAC=29, IS=30, NOT=31, AND=32, OR=33, SECS=34, TO=35, MAXTIMES=36, EQ=37, 
		MINUS=38, NUL=39, BOOL=40, STRING=41, UINT=42, SINT=43, DECIMAL=44, ALPHANUM=45, 
		DOTEXPR=46, IDXEXPR=47, DOTIDXEXPR=48, SPCOMMA=49, WS=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NL", 
			"DIGIT", "CH", "ALNUM", "SPACES", "COMMA", "COMMENT", "FLOWSTART", "BASE", 
			"FLOWINPUTS", "LOG", "FLOWCALL", "ACTIONCALL", "RRFCALL", "STATUS_REQ", 
			"ALLOW", "REPLY", "UNTIL", "OVERRIDE", "WHEN", "OTHERWISE", "REPEAT", 
			"MATCH", "QUIT", "FINISH", "RFAC", "IS", "NOT", "AND", "OR", "SECS", 
			"TO", "MAXTIMES", "EQ", "MINUS", "NUL", "BOOL", "STRING", "UINT", "SINT", 
			"DECIMAL", "ALPHANUM", "DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'$'", "'#'", "'['", "']'", "'{'", "'}'", "':'", null, null, 
			"'Flow'", "'Basepath'", "'Inputs'", "'Log'", "'Trigger'", "'Call'", "'RRF'", 
			"'Status requests'", "'Allow for'", "'Reply'", "'Until'", "'Override templates'", 
			"'When'", "'Otherwise'", "'Repeat'", "'Match'", "'Quit'", "'Finish'", 
			"'RFAC'", "'is'", "'not'", "'and'", "'or'", "'seconds'", "'to'", "'times max'", 
			"'='", "'-'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NL", "COMMENT", 
			"FLOWSTART", "BASE", "FLOWINPUTS", "LOG", "FLOWCALL", "ACTIONCALL", "RRFCALL", 
			"STATUS_REQ", "ALLOW", "REPLY", "UNTIL", "OVERRIDE", "WHEN", "OTHERWISE", 
			"REPEAT", "MATCH", "QUIT", "FINISH", "RFAC", "IS", "NOT", "AND", "OR", 
			"SECS", "TO", "MAXTIMES", "EQ", "MINUS", "NUL", "BOOL", "STRING", "UINT", 
			"SINT", "DECIMAL", "ALPHANUM", "DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", 
			"WS"
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


	  private final DenterHelper denter = DenterHelper.builder()
	    .nl(NL)
	    .indent(AuthnFlowParser.INDENT)
	    .dedent(AuthnFlowParser.DEDENT)
	    .pullToken(AuthnFlowLexer.super::nextToken);

	  @Override
	  public Token nextToken() {
	    return denter.nextToken();
	  }


	public AuthnFlowLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AuthnFlow.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01bf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\5\n\u0083\n\n\3\n\3\n\7\n\u0087"+
		"\n\n\f\n\16\n\u008a\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0094\n"+
		"\r\f\r\16\r\u0097\13\r\3\16\6\16\u009a\n\16\r\16\16\16\u009b\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\7\20\u00a4\n\20\f\20\16\20\u00a7\13\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\5.\u0170\n.\3/\3/\7/\u0174\n/\f/\16/\u0177\13/\3/\3/\3\60\6\60"+
		"\u017c\n\60\r\60\16\60\u017d\3\61\3\61\3\61\3\62\3\62\5\62\u0185\n\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\6\64\u018f\n\64\r\64\16\64\u0190"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\5\66\u019d\n\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\5\66\u01a5\n\66\6\66\u01a7\n\66\r\66\16\66\u01a8"+
		"\3\67\5\67\u01ac\n\67\3\67\7\67\u01af\n\67\f\67\16\67\u01b2\13\67\3\67"+
		"\3\67\5\67\u01b6\n\67\3\67\7\67\u01b9\n\67\f\67\16\67\u01bc\13\67\38\3"+
		"8\2\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33\2\35"+
		"\2\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27\67\309\31;\32"+
		"=\33?\34A\35C\36E\37G I!K\"M#O$Q%S&U\'W(Y)[*]+_,a-c.e/g\60i\61k\62m\63"+
		"o\64\3\2\7\4\2\13\13\"\"\3\2\62;\4\2C\\c|\4\2\f\f\17\17\7\2\13\13\"#%"+
		"\u0080\u0082\u008e\u00a2\1\2\u01cc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3q\3\2\2\2\5s\3\2\2"+
		"\2\7u\3\2\2\2\tw\3\2\2\2\13y\3\2\2\2\r{\3\2\2\2\17}\3\2\2\2\21\177\3\2"+
		"\2\2\23\u0082\3\2\2\2\25\u008b\3\2\2\2\27\u008d\3\2\2\2\31\u008f\3\2\2"+
		"\2\33\u0099\3\2\2\2\35\u009d\3\2\2\2\37\u009f\3\2\2\2!\u00aa\3\2\2\2#"+
		"\u00af\3\2\2\2%\u00b8\3\2\2\2\'\u00bf\3\2\2\2)\u00c3\3\2\2\2+\u00cb\3"+
		"\2\2\2-\u00d0\3\2\2\2/\u00d4\3\2\2\2\61\u00e4\3\2\2\2\63\u00ee\3\2\2\2"+
		"\65\u00f4\3\2\2\2\67\u00fa\3\2\2\29\u010d\3\2\2\2;\u0112\3\2\2\2=\u011c"+
		"\3\2\2\2?\u0123\3\2\2\2A\u0129\3\2\2\2C\u012e\3\2\2\2E\u0135\3\2\2\2G"+
		"\u013a\3\2\2\2I\u013d\3\2\2\2K\u0141\3\2\2\2M\u0145\3\2\2\2O\u0148\3\2"+
		"\2\2Q\u0150\3\2\2\2S\u0153\3\2\2\2U\u015d\3\2\2\2W\u015f\3\2\2\2Y\u0161"+
		"\3\2\2\2[\u016f\3\2\2\2]\u0171\3\2\2\2_\u017b\3\2\2\2a\u017f\3\2\2\2c"+
		"\u0184\3\2\2\2e\u0189\3\2\2\2g\u018b\3\2\2\2i\u0192\3\2\2\2k\u0197\3\2"+
		"\2\2m\u01ab\3\2\2\2o\u01bd\3\2\2\2qr\7~\2\2r\4\3\2\2\2st\7&\2\2t\6\3\2"+
		"\2\2uv\7%\2\2v\b\3\2\2\2wx\7]\2\2x\n\3\2\2\2yz\7_\2\2z\f\3\2\2\2{|\7}"+
		"\2\2|\16\3\2\2\2}~\7\177\2\2~\20\3\2\2\2\177\u0080\7<\2\2\u0080\22\3\2"+
		"\2\2\u0081\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0088\7\f\2\2\u0085\u0087\t\2\2\2\u0086\u0085\3\2"+
		"\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\24\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\t\3\2\2\u008c\26\3\2\2\2\u008d"+
		"\u008e\t\4\2\2\u008e\30\3\2\2\2\u008f\u0095\5\27\f\2\u0090\u0094\7a\2"+
		"\2\u0091\u0094\5\27\f\2\u0092\u0094\5\25\13\2\u0093\u0090\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\32\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a"+
		"\t\2\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\34\3\2\2\2\u009d\u009e\7.\2\2\u009e\36\3\2\2\2\u009f"+
		"\u00a0\7\61\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a4\n"+
		"\5\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\b\20"+
		"\2\2\u00a9 \3\2\2\2\u00aa\u00ab\7H\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad"+
		"\7q\2\2\u00ad\u00ae\7y\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7D\2\2\u00b0\u00b1"+
		"\7c\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7r\2\2\u00b4"+
		"\u00b5\7c\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7j\2\2\u00b7$\3\2\2\2\u00b8"+
		"\u00b9\7K\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7r\2\2\u00bb\u00bc\7w\2\2"+
		"\u00bc\u00bd\7v\2\2\u00bd\u00be\7u\2\2\u00be&\3\2\2\2\u00bf\u00c0\7N\2"+
		"\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7i\2\2\u00c2(\3\2\2\2\u00c3\u00c4\7"+
		"V\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7i\2\2\u00c7\u00c8"+
		"\7i\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7t\2\2\u00ca*\3\2\2\2\u00cb\u00cc"+
		"\7E\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7n\2\2\u00cf"+
		",\3\2\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7T\2\2\u00d2\u00d3\7H\2\2\u00d3"+
		".\3\2\2\2\u00d4\u00d5\7U\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7c\2\2\u00d7"+
		"\u00d8\7v\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7\"\2"+
		"\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7s\2\2\u00de\u00df"+
		"\7w\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7v\2\2\u00e2"+
		"\u00e3\7u\2\2\u00e3\60\3\2\2\2\u00e4\u00e5\7C\2\2\u00e5\u00e6\7n\2\2\u00e6"+
		"\u00e7\7n\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7y\2\2\u00e9\u00ea\7\"\2"+
		"\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7t\2\2\u00ed\62\3"+
		"\2\2\2\u00ee\u00ef\7T\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7r\2\2\u00f1"+
		"\u00f2\7n\2\2\u00f2\u00f3\7{\2\2\u00f3\64\3\2\2\2\u00f4\u00f5\7W\2\2\u00f5"+
		"\u00f6\7p\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7n\2\2"+
		"\u00f9\66\3\2\2\2\u00fa\u00fb\7Q\2\2\u00fb\u00fc\7x\2\2\u00fc\u00fd\7"+
		"g\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7k\2\2\u0100\u0101"+
		"\7f\2\2\u0101\u0102\7g\2\2\u0102\u0103\7\"\2\2\u0103\u0104\7v\2\2\u0104"+
		"\u0105\7g\2\2\u0105\u0106\7o\2\2\u0106\u0107\7r\2\2\u0107\u0108\7n\2\2"+
		"\u0108\u0109\7c\2\2\u0109\u010a\7v\2\2\u010a\u010b\7g\2\2\u010b\u010c"+
		"\7u\2\2\u010c8\3\2\2\2\u010d\u010e\7Y\2\2\u010e\u010f\7j\2\2\u010f\u0110"+
		"\7g\2\2\u0110\u0111\7p\2\2\u0111:\3\2\2\2\u0112\u0113\7Q\2\2\u0113\u0114"+
		"\7v\2\2\u0114\u0115\7j\2\2\u0115\u0116\7g\2\2\u0116\u0117\7t\2\2\u0117"+
		"\u0118\7y\2\2\u0118\u0119\7k\2\2\u0119\u011a\7u\2\2\u011a\u011b\7g\2\2"+
		"\u011b<\3\2\2\2\u011c\u011d\7T\2\2\u011d\u011e\7g\2\2\u011e\u011f\7r\2"+
		"\2\u011f\u0120\7g\2\2\u0120\u0121\7c\2\2\u0121\u0122\7v\2\2\u0122>\3\2"+
		"\2\2\u0123\u0124\7O\2\2\u0124\u0125\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127"+
		"\7e\2\2\u0127\u0128\7j\2\2\u0128@\3\2\2\2\u0129\u012a\7S\2\2\u012a\u012b"+
		"\7w\2\2\u012b\u012c\7k\2\2\u012c\u012d\7v\2\2\u012dB\3\2\2\2\u012e\u012f"+
		"\7H\2\2\u012f\u0130\7k\2\2\u0130\u0131\7p\2\2\u0131\u0132\7k\2\2\u0132"+
		"\u0133\7u\2\2\u0133\u0134\7j\2\2\u0134D\3\2\2\2\u0135\u0136\7T\2\2\u0136"+
		"\u0137\7H\2\2\u0137\u0138\7C\2\2\u0138\u0139\7E\2\2\u0139F\3\2\2\2\u013a"+
		"\u013b\7k\2\2\u013b\u013c\7u\2\2\u013cH\3\2\2\2\u013d\u013e\7p\2\2\u013e"+
		"\u013f\7q\2\2\u013f\u0140\7v\2\2\u0140J\3\2\2\2\u0141\u0142\7c\2\2\u0142"+
		"\u0143\7p\2\2\u0143\u0144\7f\2\2\u0144L\3\2\2\2\u0145\u0146\7q\2\2\u0146"+
		"\u0147\7t\2\2\u0147N\3\2\2\2\u0148\u0149\7u\2\2\u0149\u014a\7g\2\2\u014a"+
		"\u014b\7e\2\2\u014b\u014c\7q\2\2\u014c\u014d\7p\2\2\u014d\u014e\7f\2\2"+
		"\u014e\u014f\7u\2\2\u014fP\3\2\2\2\u0150\u0151\7v\2\2\u0151\u0152\7q\2"+
		"\2\u0152R\3\2\2\2\u0153\u0154\7v\2\2\u0154\u0155\7k\2\2\u0155\u0156\7"+
		"o\2\2\u0156\u0157\7g\2\2\u0157\u0158\7u\2\2\u0158\u0159\7\"\2\2\u0159"+
		"\u015a\7o\2\2\u015a\u015b\7c\2\2\u015b\u015c\7z\2\2\u015cT\3\2\2\2\u015d"+
		"\u015e\7?\2\2\u015eV\3\2\2\2\u015f\u0160\7/\2\2\u0160X\3\2\2\2\u0161\u0162"+
		"\7p\2\2\u0162\u0163\7w\2\2\u0163\u0164\7n\2\2\u0164\u0165\7n\2\2\u0165"+
		"Z\3\2\2\2\u0166\u0167\7h\2\2\u0167\u0168\7c\2\2\u0168\u0169\7n\2\2\u0169"+
		"\u016a\7u\2\2\u016a\u0170\7g\2\2\u016b\u016c\7v\2\2\u016c\u016d\7t\2\2"+
		"\u016d\u016e\7w\2\2\u016e\u0170\7g\2\2\u016f\u0166\3\2\2\2\u016f\u016b"+
		"\3\2\2\2\u0170\\\3\2\2\2\u0171\u0175\7$\2\2\u0172\u0174\t\6\2\2\u0173"+
		"\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2"+
		"\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7$\2\2\u0179"+
		"^\3\2\2\2\u017a\u017c\5\25\13\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2"+
		"\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e`\3\2\2\2\u017f\u0180"+
		"\5W,\2\u0180\u0181\5_\60\2\u0181b\3\2\2\2\u0182\u0185\5a\61\2\u0183\u0185"+
		"\5_\60\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0187\7\60\2\2\u0187\u0188\5_\60\2\u0188d\3\2\2\2\u0189\u018a\5\31\r"+
		"\2\u018af\3\2\2\2\u018b\u018e\5\31\r\2\u018c\u018d\7\60\2\2\u018d\u018f"+
		"\5\31\r\2\u018e\u018c\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2"+
		"\u0190\u0191\3\2\2\2\u0191h\3\2\2\2\u0192\u0193\5\31\r\2\u0193\u0194\7"+
		"]\2\2\u0194\u0195\5_\60\2\u0195\u0196\7_\2\2\u0196j\3\2\2\2\u0197\u019c"+
		"\5\31\r\2\u0198\u0199\7]\2\2\u0199\u019a\5_\60\2\u019a\u019b\7_\2\2\u019b"+
		"\u019d\3\2\2\2\u019c\u0198\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a6\3\2"+
		"\2\2\u019e\u019f\7\60\2\2\u019f\u01a4\5\31\r\2\u01a0\u01a1\7]\2\2\u01a1"+
		"\u01a2\5_\60\2\u01a2\u01a3\7_\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a0\3\2"+
		"\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u019e\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9l\3\2\2\2"+
		"\u01aa\u01ac\5\33\16\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b0"+
		"\3\2\2\2\u01ad\u01af\5\23\n\2\u01ae\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2"+
		"\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0"+
		"\3\2\2\2\u01b3\u01b5\5\35\17\2\u01b4\u01b6\5\33\16\2\u01b5\u01b4\3\2\2"+
		"\2\u01b5\u01b6\3\2\2\2\u01b6\u01ba\3\2\2\2\u01b7\u01b9\5\23\n\2\u01b8"+
		"\u01b7\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bbn\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\5\33\16\2\u01bep\3"+
		"\2\2\2\25\2\u0082\u0088\u0093\u0095\u009b\u00a5\u016f\u0175\u017d\u0184"+
		"\u0190\u019c\u01a4\u01a8\u01ab\u01b0\u01b5\u01ba\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}