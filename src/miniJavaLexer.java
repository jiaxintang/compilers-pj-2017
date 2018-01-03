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
		T__17=18, T__18=19, T__19=20, MUL=21, ADD=22, SUB=23, EQ=24, ASSIGN=25, 
		LT=26, AND=27, LPR=28, RPR=29, SEMI=30, EXP=31, DOT=32, COMMA=33, BLP=34, 
		BRP=35, RETURN=36, BOOLEAN=37, ID=38, INT=39, FLOAT=40, STRING=41, LINE_COMMENT=42, 
		COMMENT=43, WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "MUL", "ADD", "SUB", "EQ", "ASSIGN", "LT", 
		"AND", "LPR", "RPR", "SEMI", "EXP", "DOT", "COMMA", "BLP", "BRP", "RETURN", 
		"BOOLEAN", "ID", "INT", "FLOAT", "STRING", "DIGIT", "ESC", "LINE_COMMENT", 
		"COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'public'", "'static'", "'void'", "'main'", "'String'", 
		"'['", "']'", "'extends'", "'int'", "'boolean'", "'float'", "'if'", "'else'", 
		"'while'", "'System.out.println'", "'length'", "'this'", "'new'", "'!'", 
		"'*'", "'+'", "'-'", "'=='", "'='", "'<'", "'&&'", "'('", "')'", "';'", 
		"'^'", "'.'", "','", "'{'", "'}'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "MUL", "ADD", "SUB", 
		"EQ", "ASSIGN", "LT", "AND", "LPR", "RPR", "SEMI", "EXP", "DOT", "COMMA", 
		"BLP", "BRP", "RETURN", "BOOLEAN", "ID", "INT", "FLOAT", "STRING", "LINE_COMMENT", 
		"COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u015e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0106\n&\3\'\3\'\7\'\u010a"+
		"\n\'\f\'\16\'\u010d\13\'\3(\6(\u0110\n(\r(\16(\u0111\3)\6)\u0115\n)\r"+
		")\16)\u0116\3)\3)\7)\u011b\n)\f)\16)\u011e\13)\3)\3)\6)\u0122\n)\r)\16"+
		")\u0123\5)\u0126\n)\3*\3*\3*\7*\u012b\n*\f*\16*\u012e\13*\3*\3*\3+\3+"+
		"\3,\3,\3,\3,\5,\u0138\n,\3-\3-\3-\3-\7-\u013e\n-\f-\16-\u0141\13-\3-\5"+
		"-\u0144\n-\3-\3-\3-\3-\3.\3.\3.\3.\7.\u014e\n.\f.\16.\u0151\13.\3.\3."+
		"\3.\3.\3.\3/\6/\u0159\n/\r/\16/\u015a\3/\3/\5\u012c\u013f\u014f\2\60\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y,[-].\3\2\6\4\2C\\c|\6\2\62;C\\aac|\3"+
		"\2\62;\5\2\13\f\17\17\"\"\2\u0169\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3"+
		"\2\2\2\5e\3\2\2\2\7l\3\2\2\2\ts\3\2\2\2\13x\3\2\2\2\r}\3\2\2\2\17\u0084"+
		"\3\2\2\2\21\u0086\3\2\2\2\23\u0088\3\2\2\2\25\u0090\3\2\2\2\27\u0094\3"+
		"\2\2\2\31\u009c\3\2\2\2\33\u00a2\3\2\2\2\35\u00a5\3\2\2\2\37\u00aa\3\2"+
		"\2\2!\u00b0\3\2\2\2#\u00c3\3\2\2\2%\u00ca\3\2\2\2\'\u00cf\3\2\2\2)\u00d3"+
		"\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2"+
		"\63\u00de\3\2\2\2\65\u00e0\3\2\2\2\67\u00e2\3\2\2\29\u00e5\3\2\2\2;\u00e7"+
		"\3\2\2\2=\u00e9\3\2\2\2?\u00eb\3\2\2\2A\u00ed\3\2\2\2C\u00ef\3\2\2\2E"+
		"\u00f1\3\2\2\2G\u00f3\3\2\2\2I\u00f5\3\2\2\2K\u0105\3\2\2\2M\u0107\3\2"+
		"\2\2O\u010f\3\2\2\2Q\u0125\3\2\2\2S\u0127\3\2\2\2U\u0131\3\2\2\2W\u0137"+
		"\3\2\2\2Y\u0139\3\2\2\2[\u0149\3\2\2\2]\u0158\3\2\2\2_`\7e\2\2`a\7n\2"+
		"\2ab\7c\2\2bc\7u\2\2cd\7u\2\2d\4\3\2\2\2ef\7r\2\2fg\7w\2\2gh\7d\2\2hi"+
		"\7n\2\2ij\7k\2\2jk\7e\2\2k\6\3\2\2\2lm\7u\2\2mn\7v\2\2no\7c\2\2op\7v\2"+
		"\2pq\7k\2\2qr\7e\2\2r\b\3\2\2\2st\7x\2\2tu\7q\2\2uv\7k\2\2vw\7f\2\2w\n"+
		"\3\2\2\2xy\7o\2\2yz\7c\2\2z{\7k\2\2{|\7p\2\2|\f\3\2\2\2}~\7U\2\2~\177"+
		"\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7i\2\2\u0083\16\3\2\2\2\u0084\u0085\7]\2\2\u0085\20\3\2\2\2\u0086\u0087"+
		"\7_\2\2\u0087\22\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a\7z\2\2\u008a\u008b"+
		"\7v\2\2\u008b\u008c\7g\2\2\u008c\u008d\7p\2\2\u008d\u008e\7f\2\2\u008e"+
		"\u008f\7u\2\2\u008f\24\3\2\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092"+
		"\u0093\7v\2\2\u0093\26\3\2\2\2\u0094\u0095\7d\2\2\u0095\u0096\7q\2\2\u0096"+
		"\u0097\7q\2\2\u0097\u0098\7n\2\2\u0098\u0099\7g\2\2\u0099\u009a\7c\2\2"+
		"\u009a\u009b\7p\2\2\u009b\30\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7"+
		"n\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1\32"+
		"\3\2\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7h\2\2\u00a4\34\3\2\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2"+
		"\u00a9\36\3\2\2\2\u00aa\u00ab\7y\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7"+
		"k\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7g\2\2\u00af \3\2\2\2\u00b0\u00b1"+
		"\7U\2\2\u00b1\u00b2\7{\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7v\2\2\u00b4"+
		"\u00b5\7g\2\2\u00b5\u00b6\7o\2\2\u00b6\u00b7\7\60\2\2\u00b7\u00b8\7q\2"+
		"\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7\60\2\2\u00bb\u00bc"+
		"\7r\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"\u00c0\7v\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7p\2\2\u00c2\"\3\2\2\2\u00c3"+
		"\u00c4\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7i\2\2"+
		"\u00c7\u00c8\7v\2\2\u00c8\u00c9\7j\2\2\u00c9$\3\2\2\2\u00ca\u00cb\7v\2"+
		"\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7u\2\2\u00ce&\3\2"+
		"\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7y\2\2\u00d2(\3"+
		"\2\2\2\u00d3\u00d4\7#\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6,\3\2"+
		"\2\2\u00d7\u00d8\7-\2\2\u00d8.\3\2\2\2\u00d9\u00da\7/\2\2\u00da\60\3\2"+
		"\2\2\u00db\u00dc\7?\2\2\u00dc\u00dd\7?\2\2\u00dd\62\3\2\2\2\u00de\u00df"+
		"\7?\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1\66\3\2\2\2\u00e2\u00e3"+
		"\7(\2\2\u00e3\u00e4\7(\2\2\u00e48\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6:\3"+
		"\2\2\2\u00e7\u00e8\7+\2\2\u00e8<\3\2\2\2\u00e9\u00ea\7=\2\2\u00ea>\3\2"+
		"\2\2\u00eb\u00ec\7`\2\2\u00ec@\3\2\2\2\u00ed\u00ee\7\60\2\2\u00eeB\3\2"+
		"\2\2\u00ef\u00f0\7.\2\2\u00f0D\3\2\2\2\u00f1\u00f2\7}\2\2\u00f2F\3\2\2"+
		"\2\u00f3\u00f4\7\177\2\2\u00f4H\3\2\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7w\2\2\u00f9\u00fa\7t\2\2\u00fa"+
		"\u00fb\7p\2\2\u00fbJ\3\2\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7t\2\2\u00fe"+
		"\u00ff\7w\2\2\u00ff\u0106\7g\2\2\u0100\u0101\7h\2\2\u0101\u0102\7c\2\2"+
		"\u0102\u0103\7n\2\2\u0103\u0104\7u\2\2\u0104\u0106\7g\2\2\u0105\u00fc"+
		"\3\2\2\2\u0105\u0100\3\2\2\2\u0106L\3\2\2\2\u0107\u010b\t\2\2\2\u0108"+
		"\u010a\t\3\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010cN\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110"+
		"\t\4\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112P\3\2\2\2\u0113\u0115\5U+\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011c\5A!\2\u0119\u011b\5U+\2\u011a\u0119\3\2\2\2\u011b\u011e"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0126\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0121\5A!\2\u0120\u0122\5U+\2\u0121\u0120\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126"+
		"\3\2\2\2\u0125\u0114\3\2\2\2\u0125\u011f\3\2\2\2\u0126R\3\2\2\2\u0127"+
		"\u012c\7$\2\2\u0128\u012b\5W,\2\u0129\u012b\13\2\2\2\u012a\u0128\3\2\2"+
		"\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012d\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\7$\2\2\u0130"+
		"T\3\2\2\2\u0131\u0132\t\4\2\2\u0132V\3\2\2\2\u0133\u0134\7^\2\2\u0134"+
		"\u0138\7$\2\2\u0135\u0136\7^\2\2\u0136\u0138\7^\2\2\u0137\u0133\3\2\2"+
		"\2\u0137\u0135\3\2\2\2\u0138X\3\2\2\2\u0139\u013a\7\61\2\2\u013a\u013b"+
		"\7\61\2\2\u013b\u013f\3\2\2\2\u013c\u013e\13\2\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u0141\3\2\2\2\u013f\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0143"+
		"\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0144\7\17\2\2\u0143\u0142\3\2\2\2"+
		"\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\7\f\2\2\u0146\u0147"+
		"\3\2\2\2\u0147\u0148\b-\2\2\u0148Z\3\2\2\2\u0149\u014a\7\61\2\2\u014a"+
		"\u014b\7,\2\2\u014b\u014f\3\2\2\2\u014c\u014e\13\2\2\2\u014d\u014c\3\2"+
		"\2\2\u014e\u0151\3\2\2\2\u014f\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150"+
		"\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\7,\2\2\u0153\u0154\7\61"+
		"\2\2\u0154\u0155\3\2\2\2\u0155\u0156\b.\2\2\u0156\\\3\2\2\2\u0157\u0159"+
		"\t\5\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b/\2\2\u015d^\3\2\2\2\21"+
		"\2\u0105\u010b\u0111\u0116\u011c\u0123\u0125\u012a\u012c\u0137\u013f\u0143"+
		"\u014f\u015a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}