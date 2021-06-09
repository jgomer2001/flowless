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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NL=6, COMMENT=7, FLOWSTART=8, 
		FLOWINPUTS=9, LOG=10, FLOWCALL=11, TASKCALL=12, WHEN=13, IS=14, OTHERWISE=15, 
		MATCH=16, TO=17, TRY=18, TRYTIMES=19, QUIT=20, ACCEPT=21, REJECT=22, EQ=23, 
		BOOL=24, DECIMAL=25, STRING=26, ALPHANUM=27, DOTEXPR=28, IDXEXPR=29, DOTIDXEXPR=30, 
		SPCOMMA=31, WS=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "NL", "DIGIT", "CH", "ALNUM", 
			"UINT", "SPACES", "COMMA", "COMMENT", "FLOWSTART", "FLOWINPUTS", "LOG", 
			"FLOWCALL", "TASKCALL", "WHEN", "IS", "OTHERWISE", "MATCH", "TO", "TRY", 
			"TRYTIMES", "QUIT", "ACCEPT", "REJECT", "EQ", "BOOL", "DECIMAL", "STRING", 
			"ALPHANUM", "DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'{'", "'}'", "':'", null, null, "'Flow'", "'Inputs:'", 
			"'Log'", "'Trigger'", "'Call'", "'When'", "'is'", "'Otherwise'", "'Match'", 
			"'to'", "'Try'", "'times'", "'Quit'", "'Accept'", "'Reject'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NL", "COMMENT", "FLOWSTART", "FLOWINPUTS", 
			"LOG", "FLOWCALL", "TASKCALL", "WHEN", "IS", "OTHERWISE", "MATCH", "TO", 
			"TRY", "TRYTIMES", "QUIT", "ACCEPT", "REJECT", "EQ", "BOOL", "DECIMAL", 
			"STRING", "ALPHANUM", "DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0124\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\5\7[\n\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\n\7\nk\n\n\f\n\16\nn\13\n\3\13\6\13q\n\13\r\13\16\13"+
		"r\3\f\6\fv\n\f\r\f\16\fw\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u0080\n\16\f"+
		"\16\16\16\u0083\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u00e8\n\37\3 \5 \u00eb\n \3 \3 \3 \5 \u00f0"+
		"\n \3!\3!\7!\u00f4\n!\f!\16!\u00f7\13!\3!\3!\3\"\3\"\3#\3#\3#\6#\u0100"+
		"\n#\r#\16#\u0101\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\5%\u010e\n%\3%\3%\3%\3"+
		"%\3%\3%\5%\u0116\n%\6%\u0118\n%\r%\16%\u0119\3&\5&\u011d\n&\3&\3&\5&\u0121"+
		"\n&\3\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2\25\2\27\2\31"+
		"\2\33\t\35\n\37\13!\f#\r%\16\'\17)\20+\21-\22/\23\61\24\63\25\65\26\67"+
		"\279\30;\31=\32?\33A\34C\35E\36G\37I K!M\"\3\2\7\3\2\62;\5\2C\\aac|\4"+
		"\2\13\13\"\"\4\2\f\f\17\17\6\2\13\13\"\u0080\u0082\u008e\u00a2\1\2\u012e"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7S\3\2\2\2\tU\3\2\2"+
		"\2\13W\3\2\2\2\rZ\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23g\3\2\2\2\25p\3\2"+
		"\2\2\27u\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35\u0086\3\2\2\2\37\u008b\3\2"+
		"\2\2!\u0093\3\2\2\2#\u0097\3\2\2\2%\u009f\3\2\2\2\'\u00a4\3\2\2\2)\u00a9"+
		"\3\2\2\2+\u00ac\3\2\2\2-\u00b6\3\2\2\2/\u00bc\3\2\2\2\61\u00bf\3\2\2\2"+
		"\63\u00c3\3\2\2\2\65\u00c9\3\2\2\2\67\u00ce\3\2\2\29\u00d5\3\2\2\2;\u00dc"+
		"\3\2\2\2=\u00e7\3\2\2\2?\u00ea\3\2\2\2A\u00f1\3\2\2\2C\u00fa\3\2\2\2E"+
		"\u00fc\3\2\2\2G\u0103\3\2\2\2I\u0108\3\2\2\2K\u011c\3\2\2\2M\u0122\3\2"+
		"\2\2OP\7]\2\2P\4\3\2\2\2QR\7_\2\2R\6\3\2\2\2ST\7}\2\2T\b\3\2\2\2UV\7\177"+
		"\2\2V\n\3\2\2\2WX\7<\2\2X\f\3\2\2\2Y[\7\17\2\2ZY\3\2\2\2Z[\3\2\2\2[\\"+
		"\3\2\2\2\\`\7\f\2\2]_\7\"\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2"+
		"a\16\3\2\2\2b`\3\2\2\2cd\t\2\2\2d\20\3\2\2\2ef\t\3\2\2f\22\3\2\2\2gl\5"+
		"\21\t\2hk\5\21\t\2ik\5\17\b\2jh\3\2\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2"+
		"lm\3\2\2\2m\24\3\2\2\2nl\3\2\2\2oq\5\17\b\2po\3\2\2\2qr\3\2\2\2rp\3\2"+
		"\2\2rs\3\2\2\2s\26\3\2\2\2tv\t\4\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3"+
		"\2\2\2x\30\3\2\2\2yz\7.\2\2z\32\3\2\2\2{|\7\61\2\2|}\7\61\2\2}\u0081\3"+
		"\2\2\2~\u0080\n\5\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\b\16\2\2\u0085\34\3\2\2\2\u0086\u0087\7H\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7q\2\2\u0089\u008a\7y\2\2\u008a\36\3\2\2\2\u008b\u008c\7K\2\2\u008c"+
		"\u008d\7p\2\2\u008d\u008e\7r\2\2\u008e\u008f\7w\2\2\u008f\u0090\7v\2\2"+
		"\u0090\u0091\7u\2\2\u0091\u0092\7<\2\2\u0092 \3\2\2\2\u0093\u0094\7N\2"+
		"\2\u0094\u0095\7q\2\2\u0095\u0096\7i\2\2\u0096\"\3\2\2\2\u0097\u0098\7"+
		"V\2\2\u0098\u0099\7t\2\2\u0099\u009a\7k\2\2\u009a\u009b\7i\2\2\u009b\u009c"+
		"\7i\2\2\u009c\u009d\7g\2\2\u009d\u009e\7t\2\2\u009e$\3\2\2\2\u009f\u00a0"+
		"\7E\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"&\3\2\2\2\u00a4\u00a5\7Y\2\2\u00a5\u00a6\7j\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7u\2\2\u00ab"+
		"*\3\2\2\2\u00ac\u00ad\7Q\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7j\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7y\2\2\u00b2\u00b3\7k\2\2"+
		"\u00b3\u00b4\7u\2\2\u00b4\u00b5\7g\2\2\u00b5,\3\2\2\2\u00b6\u00b7\7O\2"+
		"\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb"+
		"\7j\2\2\u00bb.\3\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7q\2\2\u00be\60"+
		"\3\2\2\2\u00bf\u00c0\7V\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7{\2\2\u00c2"+
		"\62\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7o\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7\u00c8\7u\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7S\2\2\u00ca"+
		"\u00cb\7w\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7v\2\2\u00cd\66\3\2\2\2\u00ce"+
		"\u00cf\7C\2\2\u00cf\u00d0\7e\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2\7g\2\2"+
		"\u00d2\u00d3\7r\2\2\u00d3\u00d4\7v\2\2\u00d48\3\2\2\2\u00d5\u00d6\7T\2"+
		"\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7l\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da"+
		"\7e\2\2\u00da\u00db\7v\2\2\u00db:\3\2\2\2\u00dc\u00dd\7?\2\2\u00dd<\3"+
		"\2\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2\u00e1"+
		"\u00e2\7u\2\2\u00e2\u00e8\7g\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7t\2\2"+
		"\u00e5\u00e6\7w\2\2\u00e6\u00e8\7g\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e3"+
		"\3\2\2\2\u00e8>\3\2\2\2\u00e9\u00eb\7/\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ef\5\25\13\2\u00ed\u00ee\7\60\2"+
		"\2\u00ee\u00f0\5\25\13\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"@\3\2\2\2\u00f1\u00f5\7$\2\2\u00f2\u00f4\t\6\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2"+
		"\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7$\2\2\u00f9B\3\2\2\2\u00fa\u00fb"+
		"\5\23\n\2\u00fbD\3\2\2\2\u00fc\u00ff\5\23\n\2\u00fd\u00fe\7\60\2\2\u00fe"+
		"\u0100\5\23\n\2\u00ff\u00fd\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3"+
		"\2\2\2\u0101\u0102\3\2\2\2\u0102F\3\2\2\2\u0103\u0104\5\23\n\2\u0104\u0105"+
		"\7]\2\2\u0105\u0106\5\25\13\2\u0106\u0107\7_\2\2\u0107H\3\2\2\2\u0108"+
		"\u010d\5\23\n\2\u0109\u010a\7]\2\2\u010a\u010b\5\25\13\2\u010b\u010c\7"+
		"_\2\2\u010c\u010e\3\2\2\2\u010d\u0109\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0117\3\2\2\2\u010f\u0110\7\60\2\2\u0110\u0115\5\23\n\2\u0111\u0112\7"+
		"]\2\2\u0112\u0113\5\25\13\2\u0113\u0114\7_\2\2\u0114\u0116\3\2\2\2\u0115"+
		"\u0111\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u010f\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"J\3\2\2\2\u011b\u011d\5\27\f\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\u0120\5\31\r\2\u011f\u0121\5\27\f\2\u0120\u011f"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121L\3\2\2\2\u0122\u0123\5\27\f\2\u0123"+
		"N\3\2\2\2\24\2Z`jlrw\u0081\u00e7\u00ea\u00ef\u00f5\u0101\u010d\u0115\u0119"+
		"\u011c\u0120\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}