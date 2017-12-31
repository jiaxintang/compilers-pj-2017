// Generated from miniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, LINE_COMMENT=23, COMMENT=24, 
		WS=25, BOOLEAN=26, ID=27, INT=28, FLOAT=29, STRING=30, MUL=31, ADD=32, 
		SUB=33, EQ=34, ASSIGN=35, LT=36, AND=37, LPR=38, RPR=39, SEMI=40, EXP=41, 
		DOT=42, COMMA=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "LINE_COMMENT", "COMMENT", 
		"WS", "BOOLEAN", "ID", "INT", "FLOAT", "STRING", "DIGIT", "ESC", "MUL", 
		"ADD", "SUB", "EQ", "ASSIGN", "LT", "AND", "LPR", "RPR", "SEMI", "EXP", 
		"DOT", "COMMA"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'String'", 
		"'['", "']'", "'}'", "'extends'", "'return'", "'int'", "'boolean'", "'if'", 
		"'else'", "'while'", "'System.out.println'", "'length'", "'this'", "'new'", 
		"'!'", null, null, null, null, null, null, null, null, "'*'", "'+'", "'-'", 
		"'=='", "'='", "'<'", "'&&'", "'('", "')'", "';'", "'^'", "'.'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "LINE_COMMENT", 
		"COMMENT", "WS", "BOOLEAN", "ID", "INT", "FLOAT", "STRING", "MUL", "ADD", 
		"SUB", "EQ", "ASSIGN", "LT", "AND", "LPR", "RPR", "SEMI", "EXP", "DOT", 
		"COMMA"
	};
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


	public miniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "miniJava.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0156\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00dd\n\30\f\30\16\30\u00e0\13"+
		"\30\3\30\5\30\u00e3\n\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31"+
		"\u00ed\n\31\f\31\16\31\u00f0\13\31\3\31\3\31\3\31\3\31\3\31\3\32\6\32"+
		"\u00f8\n\32\r\32\16\32\u00f9\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u0107\n\33\3\34\3\34\7\34\u010b\n\34\f\34\16\34\u010e"+
		"\13\34\3\35\6\35\u0111\n\35\r\35\16\35\u0112\3\36\6\36\u0116\n\36\r\36"+
		"\16\36\u0117\3\36\3\36\7\36\u011c\n\36\f\36\16\36\u011f\13\36\3\36\3\36"+
		"\6\36\u0123\n\36\r\36\16\36\u0124\5\36\u0127\n\36\3\37\3\37\3\37\7\37"+
		"\u012c\n\37\f\37\16\37\u012f\13\37\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0139"+
		"\n!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\5\u00de\u00ee\u012d\2/\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?\2A\2C!E\"G#I$K%M&O\'Q"+
		"(S)U*W+Y,[-\3\2\6\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\2"+
		"\u0161\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5c\3\2\2\2\7e\3\2\2\2\tl\3\2\2"+
		"\2\13s\3\2\2\2\rx\3\2\2\2\17}\3\2\2\2\21\u0084\3\2\2\2\23\u0086\3\2\2"+
		"\2\25\u0088\3\2\2\2\27\u008a\3\2\2\2\31\u0092\3\2\2\2\33\u0099\3\2\2\2"+
		"\35\u009d\3\2\2\2\37\u00a5\3\2\2\2!\u00a8\3\2\2\2#\u00ad\3\2\2\2%\u00b3"+
		"\3\2\2\2\'\u00c6\3\2\2\2)\u00cd\3\2\2\2+\u00d2\3\2\2\2-\u00d6\3\2\2\2"+
		"/\u00d8\3\2\2\2\61\u00e8\3\2\2\2\63\u00f7\3\2\2\2\65\u0106\3\2\2\2\67"+
		"\u0108\3\2\2\29\u0110\3\2\2\2;\u0126\3\2\2\2=\u0128\3\2\2\2?\u0132\3\2"+
		"\2\2A\u0138\3\2\2\2C\u013a\3\2\2\2E\u013c\3\2\2\2G\u013e\3\2\2\2I\u0140"+
		"\3\2\2\2K\u0143\3\2\2\2M\u0145\3\2\2\2O\u0147\3\2\2\2Q\u014a\3\2\2\2S"+
		"\u014c\3\2\2\2U\u014e\3\2\2\2W\u0150\3\2\2\2Y\u0152\3\2\2\2[\u0154\3\2"+
		"\2\2]^\7e\2\2^_\7n\2\2_`\7c\2\2`a\7u\2\2ab\7u\2\2b\4\3\2\2\2cd\7}\2\2"+
		"d\6\3\2\2\2ef\7r\2\2fg\7w\2\2gh\7d\2\2hi\7n\2\2ij\7k\2\2jk\7e\2\2k\b\3"+
		"\2\2\2lm\7u\2\2mn\7v\2\2no\7c\2\2op\7v\2\2pq\7k\2\2qr\7e\2\2r\n\3\2\2"+
		"\2st\7x\2\2tu\7q\2\2uv\7k\2\2vw\7f\2\2w\f\3\2\2\2xy\7o\2\2yz\7c\2\2z{"+
		"\7k\2\2{|\7p\2\2|\16\3\2\2\2}~\7U\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7i\2\2\u0083\20\3\2\2\2\u0084"+
		"\u0085\7]\2\2\u0085\22\3\2\2\2\u0086\u0087\7_\2\2\u0087\24\3\2\2\2\u0088"+
		"\u0089\7\177\2\2\u0089\26\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7z\2"+
		"\2\u008c\u008d\7v\2\2\u008d\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f\u0090"+
		"\7f\2\2\u0090\u0091\7u\2\2\u0091\30\3\2\2\2\u0092\u0093\7t\2\2\u0093\u0094"+
		"\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097\7t\2\2\u0097"+
		"\u0098\7p\2\2\u0098\32\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b"+
		"\u009c\7v\2\2\u009c\34\3\2\2\2\u009d\u009e\7d\2\2\u009e\u009f\7q\2\2\u009f"+
		"\u00a0\7q\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7c\2\2"+
		"\u00a3\u00a4\7p\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7"+
		"h\2\2\u00a7 \3\2\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab"+
		"\7u\2\2\u00ab\u00ac\7g\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7y\2\2\u00ae\u00af"+
		"\7j\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"$\3\2\2\2\u00b3\u00b4\7U\2\2\u00b4\u00b5\7{\2\2\u00b5\u00b6\7u\2\2\u00b6"+
		"\u00b7\7v\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7o\2\2\u00b9\u00ba\7\60\2"+
		"\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be"+
		"\7\60\2\2\u00be\u00bf\7r\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7p\2\2"+
		"\u00c5&\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7p\2"+
		"\2\u00c9\u00ca\7i\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7j\2\2\u00cc(\3\2"+
		"\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1"+
		"\7u\2\2\u00d1*\3\2\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5"+
		"\7y\2\2\u00d5,\3\2\2\2\u00d6\u00d7\7#\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7"+
		"\61\2\2\u00d9\u00da\7\61\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\13\2\2\2"+
		"\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00df\3\2\2\2\u00de\u00dc"+
		"\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\7\17\2\2"+
		"\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\7\f\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\30\2\2\u00e7\60\3\2\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9\u00ea\7,\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\13"+
		"\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7,"+
		"\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\31\2\2\u00f5"+
		"\62\3\2\2\2\u00f6\u00f8\t\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2"+
		"\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc"+
		"\b\32\2\2\u00fc\64\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7t\2\2\u00ff"+
		"\u0100\7w\2\2\u0100\u0107\7g\2\2\u0101\u0102\7h\2\2\u0102\u0103\7c\2\2"+
		"\u0103\u0104\7n\2\2\u0104\u0105\7u\2\2\u0105\u0107\7g\2\2\u0106\u00fd"+
		"\3\2\2\2\u0106\u0101\3\2\2\2\u0107\66\3\2\2\2\u0108\u010c\t\3\2\2\u0109"+
		"\u010b\t\4\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d8\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111"+
		"\t\5\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113:\3\2\2\2\u0114\u0116\5? \2\u0115\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011d\5Y-\2\u011a\u011c\5? \2\u011b\u011a\3\2\2\2\u011c\u011f"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0127\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0122\5Y-\2\u0121\u0123\5? \2\u0122\u0121\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127"+
		"\3\2\2\2\u0126\u0115\3\2\2\2\u0126\u0120\3\2\2\2\u0127<\3\2\2\2\u0128"+
		"\u012d\7$\2\2\u0129\u012c\5A!\2\u012a\u012c\13\2\2\2\u012b\u0129\3\2\2"+
		"\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012e\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7$\2\2\u0131"+
		">\3\2\2\2\u0132\u0133\t\5\2\2\u0133@\3\2\2\2\u0134\u0135\7^\2\2\u0135"+
		"\u0139\7$\2\2\u0136\u0137\7^\2\2\u0137\u0139\7^\2\2\u0138\u0134\3\2\2"+
		"\2\u0138\u0136\3\2\2\2\u0139B\3\2\2\2\u013a\u013b\7,\2\2\u013bD\3\2\2"+
		"\2\u013c\u013d\7-\2\2\u013dF\3\2\2\2\u013e\u013f\7/\2\2\u013fH\3\2\2\2"+
		"\u0140\u0141\7?\2\2\u0141\u0142\7?\2\2\u0142J\3\2\2\2\u0143\u0144\7?\2"+
		"\2\u0144L\3\2\2\2\u0145\u0146\7>\2\2\u0146N\3\2\2\2\u0147\u0148\7(\2\2"+
		"\u0148\u0149\7(\2\2\u0149P\3\2\2\2\u014a\u014b\7*\2\2\u014bR\3\2\2\2\u014c"+
		"\u014d\7+\2\2\u014dT\3\2\2\2\u014e\u014f\7=\2\2\u014fV\3\2\2\2\u0150\u0151"+
		"\7`\2\2\u0151X\3\2\2\2\u0152\u0153\7\60\2\2\u0153Z\3\2\2\2\u0154\u0155"+
		"\7.\2\2\u0155\\\3\2\2\2\21\2\u00de\u00e2\u00ee\u00f9\u0106\u010c\u0112"+
		"\u0117\u011d\u0124\u0126\u012b\u012d\u0138\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}