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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NL=8, COMMENT=9, 
		FLOWSTART=10, BASE=11, FLOWINPUTS=12, LOG=13, FLOWCALL=14, ACTIONCALL=15, 
		RRFCALL=16, STATUS_REQ=17, ALLOW=18, REPLY=19, UNTIL=20, OVERRIDE=21, 
		WHEN=22, OTHERWISE=23, REPEAT=24, MATCH=25, QUIT=26, FINISH=27, REDIRECT=28, 
		IS=29, NOT=30, AND=31, OR=32, SECS=33, TO=34, MAXTIMES=35, EQ=36, MINUS=37, 
		NUL=38, BOOL=39, STRING=40, UINT=41, SINT=42, DECIMAL=43, ALPHANUM=44, 
		DOTEXPR=45, IDXEXPR=46, DOTIDXEXPR=47, SPCOMMA=48, WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NL", "DIGIT", 
			"CH", "ALNUM", "SPACES", "COMMA", "COMMENT", "FLOWSTART", "BASE", "FLOWINPUTS", 
			"LOG", "FLOWCALL", "ACTIONCALL", "RRFCALL", "STATUS_REQ", "ALLOW", "REPLY", 
			"UNTIL", "OVERRIDE", "WHEN", "OTHERWISE", "REPEAT", "MATCH", "QUIT", 
			"FINISH", "REDIRECT", "IS", "NOT", "AND", "OR", "SECS", "TO", "MAXTIMES", 
			"EQ", "MINUS", "NUL", "BOOL", "STRING", "UINT", "SINT", "DECIMAL", "ALPHANUM", 
			"DOTEXPR", "IDXEXPR", "DOTIDXEXPR", "SPCOMMA", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\5\t\177\n\t\3\t\3\t\7\t\u0083\n\t\f\t\16\t"+
		"\u0086\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f\u008f\n\f\f\f\16\f\u0092"+
		"\13\f\3\r\6\r\u0095\n\r\r\r\16\r\u0096\3\16\3\16\3\17\3\17\3\17\3\17\7"+
		"\17\u009f\n\17\f\17\16\17\u00a2\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3("+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0173\n-\3.\3.\7.\u0177\n.\f.\16.\u017a"+
		"\13.\3.\3.\3/\6/\u017f\n/\r/\16/\u0180\3\60\3\60\3\60\3\61\3\61\5\61\u0188"+
		"\n\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\6\63\u0192\n\63\r\63\16"+
		"\63\u0193\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\5\65\u01a0"+
		"\n\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u01a8\n\65\6\65\u01aa\n\65\r"+
		"\65\16\65\u01ab\3\66\5\66\u01af\n\66\3\66\7\66\u01b2\n\66\f\66\16\66\u01b5"+
		"\13\66\3\66\3\66\5\66\u01b9\n\66\3\66\7\66\u01bc\n\66\f\66\16\66\u01bf"+
		"\13\66\3\67\3\67\2\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27"+
		"\2\31\2\33\2\35\13\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65"+
		"\27\67\309\31;\32=\33?\34A\35C\36E\37G I!K\"M#O$Q%S&U\'W(Y)[*]+_,a-c."+
		"e/g\60i\61k\62m\63\3\2\7\4\2\13\13\"\"\3\2\62;\5\2C\\aac|\4\2\f\f\17\17"+
		"\7\2\13\13\"#%\u0080\u0082\u008e\u00a2\1\2\u01ce\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5q"+
		"\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21~"+
		"\3\2\2\2\23\u0087\3\2\2\2\25\u0089\3\2\2\2\27\u008b\3\2\2\2\31\u0094\3"+
		"\2\2\2\33\u0098\3\2\2\2\35\u009a\3\2\2\2\37\u00a5\3\2\2\2!\u00aa\3\2\2"+
		"\2#\u00b3\3\2\2\2%\u00ba\3\2\2\2\'\u00be\3\2\2\2)\u00c6\3\2\2\2+\u00cb"+
		"\3\2\2\2-\u00cf\3\2\2\2/\u00df\3\2\2\2\61\u00e9\3\2\2\2\63\u00ef\3\2\2"+
		"\2\65\u00f5\3\2\2\2\67\u0108\3\2\2\29\u010d\3\2\2\2;\u0117\3\2\2\2=\u011e"+
		"\3\2\2\2?\u0124\3\2\2\2A\u0129\3\2\2\2C\u0130\3\2\2\2E\u0139\3\2\2\2G"+
		"\u013c\3\2\2\2I\u0140\3\2\2\2K\u0144\3\2\2\2M\u0147\3\2\2\2O\u014f\3\2"+
		"\2\2Q\u0152\3\2\2\2S\u0160\3\2\2\2U\u0162\3\2\2\2W\u0164\3\2\2\2Y\u0172"+
		"\3\2\2\2[\u0174\3\2\2\2]\u017e\3\2\2\2_\u0182\3\2\2\2a\u0187\3\2\2\2c"+
		"\u018c\3\2\2\2e\u018e\3\2\2\2g\u0195\3\2\2\2i\u019a\3\2\2\2k\u01ae\3\2"+
		"\2\2m\u01c0\3\2\2\2op\7~\2\2p\4\3\2\2\2qr\7%\2\2r\6\3\2\2\2st\7]\2\2t"+
		"\b\3\2\2\2uv\7_\2\2v\n\3\2\2\2wx\7}\2\2x\f\3\2\2\2yz\7\177\2\2z\16\3\2"+
		"\2\2{|\7<\2\2|\20\3\2\2\2}\177\7\17\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0084\7\f\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\22\3\2\2"+
		"\2\u0086\u0084\3\2\2\2\u0087\u0088\t\3\2\2\u0088\24\3\2\2\2\u0089\u008a"+
		"\t\4\2\2\u008a\26\3\2\2\2\u008b\u0090\5\25\13\2\u008c\u008f\5\25\13\2"+
		"\u008d\u008f\5\23\n\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\30\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0095\t\2\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\32\3\2\2\2\u0098\u0099"+
		"\7.\2\2\u0099\34\3\2\2\2\u009a\u009b\7\61\2\2\u009b\u009c\7\61\2\2\u009c"+
		"\u00a0\3\2\2\2\u009d\u009f\n\5\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a4\b\17\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7H\2"+
		"\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7y\2\2\u00a9 \3\2"+
		"\2\2\u00aa\u00ab\7D\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae"+
		"\7g\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7v\2\2\u00b1"+
		"\u00b2\7j\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\u00b6\7r\2\2\u00b6\u00b7\7w\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7u\2\2"+
		"\u00b9$\3\2\2\2\u00ba\u00bb\7N\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7i\2"+
		"\2\u00bd&\3\2\2\2\u00be\u00bf\7V\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7"+
		"k\2\2\u00c1\u00c2\7i\2\2\u00c2\u00c3\7i\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5(\3\2\2\2\u00c6\u00c7\7E\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9"+
		"\7n\2\2\u00c9\u00ca\7n\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7T\2\2\u00cc\u00cd"+
		"\7T\2\2\u00cd\u00ce\7H\2\2\u00ce,\3\2\2\2\u00cf\u00d0\7U\2\2\u00d0\u00d1"+
		"\7v\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7w\2\2\u00d4"+
		"\u00d5\7u\2\2\u00d5\u00d6\7\"\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7g\2"+
		"\2\u00d8\u00d9\7s\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7g\2\2\u00db\u00dc"+
		"\7u\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7u\2\2\u00de.\3\2\2\2\u00df\u00e0"+
		"\7C\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\u00e4\7y\2\2\u00e4\u00e5\7\"\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7q\2"+
		"\2\u00e7\u00e8\7t\2\2\u00e8\60\3\2\2\2\u00e9\u00ea\7T\2\2\u00ea\u00eb"+
		"\7g\2\2\u00eb\u00ec\7r\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7{\2\2\u00ee"+
		"\62\3\2\2\2\u00ef\u00f0\7W\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7v\2\2\u00f2"+
		"\u00f3\7k\2\2\u00f3\u00f4\7n\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7Q\2\2\u00f6"+
		"\u00f7\7x\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7t\2\2"+
		"\u00fa\u00fb\7k\2\2\u00fb\u00fc\7f\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe"+
		"\7\"\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7o\2\2\u0101"+
		"\u0102\7r\2\2\u0102\u0103\7n\2\2\u0103\u0104\7c\2\2\u0104\u0105\7v\2\2"+
		"\u0105\u0106\7g\2\2\u0106\u0107\7u\2\2\u0107\66\3\2\2\2\u0108\u0109\7"+
		"Y\2\2\u0109\u010a\7j\2\2\u010a\u010b\7g\2\2\u010b\u010c\7p\2\2\u010c8"+
		"\3\2\2\2\u010d\u010e\7Q\2\2\u010e\u010f\7v\2\2\u010f\u0110\7j\2\2\u0110"+
		"\u0111\7g\2\2\u0111\u0112\7t\2\2\u0112\u0113\7y\2\2\u0113\u0114\7k\2\2"+
		"\u0114\u0115\7u\2\2\u0115\u0116\7g\2\2\u0116:\3\2\2\2\u0117\u0118\7T\2"+
		"\2\u0118\u0119\7g\2\2\u0119\u011a\7r\2\2\u011a\u011b\7g\2\2\u011b\u011c"+
		"\7c\2\2\u011c\u011d\7v\2\2\u011d<\3\2\2\2\u011e\u011f\7O\2\2\u011f\u0120"+
		"\7c\2\2\u0120\u0121\7v\2\2\u0121\u0122\7e\2\2\u0122\u0123\7j\2\2\u0123"+
		">\3\2\2\2\u0124\u0125\7S\2\2\u0125\u0126\7w\2\2\u0126\u0127\7k\2\2\u0127"+
		"\u0128\7v\2\2\u0128@\3\2\2\2\u0129\u012a\7H\2\2\u012a\u012b\7k\2\2\u012b"+
		"\u012c\7p\2\2\u012c\u012d\7k\2\2\u012d\u012e\7u\2\2\u012e\u012f\7j\2\2"+
		"\u012fB\3\2\2\2\u0130\u0131\7T\2\2\u0131\u0132\7g\2\2\u0132\u0133\7f\2"+
		"\2\u0133\u0134\7k\2\2\u0134\u0135\7t\2\2\u0135\u0136\7g\2\2\u0136\u0137"+
		"\7e\2\2\u0137\u0138\7v\2\2\u0138D\3\2\2\2\u0139\u013a\7k\2\2\u013a\u013b"+
		"\7u\2\2\u013bF\3\2\2\2\u013c\u013d\7p\2\2\u013d\u013e\7q\2\2\u013e\u013f"+
		"\7v\2\2\u013fH\3\2\2\2\u0140\u0141\7c\2\2\u0141\u0142\7p\2\2\u0142\u0143"+
		"\7f\2\2\u0143J\3\2\2\2\u0144\u0145\7q\2\2\u0145\u0146\7t\2\2\u0146L\3"+
		"\2\2\2\u0147\u0148\7u\2\2\u0148\u0149\7g\2\2\u0149\u014a\7e\2\2\u014a"+
		"\u014b\7q\2\2\u014b\u014c\7p\2\2\u014c\u014d\7f\2\2\u014d\u014e\7u\2\2"+
		"\u014eN\3\2\2\2\u014f\u0150\7v\2\2\u0150\u0151\7q\2\2\u0151P\3\2\2\2\u0152"+
		"\u0153\7v\2\2\u0153\u0154\7k\2\2\u0154\u0155\7o\2\2\u0155\u0156\7g\2\2"+
		"\u0156\u0157\7u\2\2\u0157\u0158\7\"\2\2\u0158\u0159\7c\2\2\u0159\u015a"+
		"\7v\2\2\u015a\u015b\7\"\2\2\u015b\u015c\7o\2\2\u015c\u015d\7q\2\2\u015d"+
		"\u015e\7u\2\2\u015e\u015f\7v\2\2\u015fR\3\2\2\2\u0160\u0161\7?\2\2\u0161"+
		"T\3\2\2\2\u0162\u0163\7/\2\2\u0163V\3\2\2\2\u0164\u0165\7p\2\2\u0165\u0166"+
		"\7w\2\2\u0166\u0167\7n\2\2\u0167\u0168\7n\2\2\u0168X\3\2\2\2\u0169\u016a"+
		"\7h\2\2\u016a\u016b\7c\2\2\u016b\u016c\7n\2\2\u016c\u016d\7u\2\2\u016d"+
		"\u0173\7g\2\2\u016e\u016f\7v\2\2\u016f\u0170\7t\2\2\u0170\u0171\7w\2\2"+
		"\u0171\u0173\7g\2\2\u0172\u0169\3\2\2\2\u0172\u016e\3\2\2\2\u0173Z\3\2"+
		"\2\2\u0174\u0178\7$\2\2\u0175\u0177\t\6\2\2\u0176\u0175\3\2\2\2\u0177"+
		"\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2"+
		"\2\2\u017a\u0178\3\2\2\2\u017b\u017c\7$\2\2\u017c\\\3\2\2\2\u017d\u017f"+
		"\5\23\n\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2"+
		"\u0180\u0181\3\2\2\2\u0181^\3\2\2\2\u0182\u0183\5U+\2\u0183\u0184\5]/"+
		"\2\u0184`\3\2\2\2\u0185\u0188\5_\60\2\u0186\u0188\5]/\2\u0187\u0185\3"+
		"\2\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\7\60\2\2\u018a"+
		"\u018b\5]/\2\u018bb\3\2\2\2\u018c\u018d\5\27\f\2\u018dd\3\2\2\2\u018e"+
		"\u0191\5\27\f\2\u018f\u0190\7\60\2\2\u0190\u0192\5\27\f\2\u0191\u018f"+
		"\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"f\3\2\2\2\u0195\u0196\5\27\f\2\u0196\u0197\7]\2\2\u0197\u0198\5]/\2\u0198"+
		"\u0199\7_\2\2\u0199h\3\2\2\2\u019a\u019f\5\27\f\2\u019b\u019c\7]\2\2\u019c"+
		"\u019d\5]/\2\u019d\u019e\7_\2\2\u019e\u01a0\3\2\2\2\u019f\u019b\3\2\2"+
		"\2\u019f\u01a0\3\2\2\2\u01a0\u01a9\3\2\2\2\u01a1\u01a2\7\60\2\2\u01a2"+
		"\u01a7\5\27\f\2\u01a3\u01a4\7]\2\2\u01a4\u01a5\5]/\2\u01a5\u01a6\7_\2"+
		"\2\u01a6\u01a8\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa"+
		"\3\2\2\2\u01a9\u01a1\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01acj\3\2\2\2\u01ad\u01af\5\31\r\2\u01ae\u01ad\3\2\2\2"+
		"\u01ae\u01af\3\2\2\2\u01af\u01b3\3\2\2\2\u01b0\u01b2\5\21\t\2\u01b1\u01b0"+
		"\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b8\5\33\16\2\u01b7\u01b9\5"+
		"\31\r\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bd\3\2\2\2\u01ba"+
		"\u01bc\5\21\t\2\u01bb\u01ba\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3"+
		"\2\2\2\u01bd\u01be\3\2\2\2\u01bel\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c1"+
		"\5\31\r\2\u01c1n\3\2\2\2\25\2~\u0084\u008e\u0090\u0096\u00a0\u0172\u0178"+
		"\u0180\u0187\u0193\u019f\u01a7\u01ab\u01ae\u01b3\u01b8\u01bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}