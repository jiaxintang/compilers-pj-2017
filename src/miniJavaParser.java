// Generated from miniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, BOOLEAN=23, ID=24, INT=25, 
		FLOAT=26, STRING=27, MUL=28, ADD=29, SUB=30, EQ=31, ASSIGN=32, LT=33, 
		AND=34, LPR=35, RPR=36, SEMI=37, EXP=38, DOT=39, COMMA=40, LINE_COMMENT=41, 
		COMMENT=42, WS=43;
	public static final int
		RULE_goal = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_varDecs = 4, RULE_methodDeclaration = 5, RULE_body = 6, RULE_parameters = 7, 
		RULE_returnExpr = 8, RULE_type = 9, RULE_statement = 10, RULE_condition = 11, 
		RULE_expression = 12;
	public static final String[] ruleNames = {
		"goal", "mainClass", "classDeclaration", "varDeclaration", "varDecs", 
		"methodDeclaration", "body", "parameters", "returnExpr", "type", "statement", 
		"condition", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'String'", 
		"'['", "']'", "'}'", "'extends'", "'return'", "'int'", "'boolean'", "'if'", 
		"'else'", "'while'", "'System.out.println'", "'length'", "'this'", "'new'", 
		"'!'", null, null, null, null, null, "'*'", "'+'", "'-'", "'=='", "'='", 
		"'<'", "'&&'", "'('", "')'", "';'", "'^'", "'.'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "BOOLEAN", 
		"ID", "INT", "FLOAT", "STRING", "MUL", "ADD", "SUB", "EQ", "ASSIGN", "LT", 
		"AND", "LPR", "RPR", "SEMI", "EXP", "DOT", "COMMA", "LINE_COMMENT", "COMMENT", 
		"WS"
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

	@Override
	public String getGrammarFileName() { return "miniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GoalContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitGoal(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			mainClass();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				classDeclaration();
				}
				}
				setState(32);
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

	public static class MainClassContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(miniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniJavaParser.ID, i);
		}
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitMainClass(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(34);
			match(ID);
			setState(35);
			match(T__1);
			setState(36);
			match(T__2);
			setState(37);
			match(T__3);
			setState(38);
			match(T__4);
			setState(39);
			match(T__5);
			setState(40);
			match(LPR);
			setState(41);
			match(T__6);
			setState(42);
			match(T__7);
			setState(43);
			match(T__8);
			setState(44);
			match(ID);
			setState(45);
			match(RPR);
			setState(46);
			match(T__1);
			setState(47);
			statement();
			setState(48);
			match(T__9);
			setState(49);
			match(T__9);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(miniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniJavaParser.ID, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__0);
			setState(52);
			match(ID);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(53);
				match(T__10);
				setState(54);
				match(ID);
				}
			}

			setState(57);
			match(T__1);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) {
				{
				{
				setState(58);
				varDeclaration();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(64);
				methodDeclaration();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__9);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			type();
			setState(73);
			match(ID);
			setState(74);
			match(SEMI);
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

	public static class VarDecsContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public VarDecsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterVarDecs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitVarDecs(this);
		}
	}

	public final VarDecsContext varDecs() throws RecognitionException {
		VarDecsContext _localctx = new VarDecsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDecs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					varDeclaration();
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public VarDecsContext varDecs() {
			return getRuleContext(VarDecsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ReturnExprContext returnExpr() {
			return getRuleContext(ReturnExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__2);
			setState(83);
			type();
			setState(84);
			match(ID);
			setState(85);
			match(LPR);
			setState(86);
			parameters();
			setState(87);
			match(RPR);
			setState(88);
			match(T__1);
			setState(89);
			varDecs();
			setState(90);
			body();
			setState(91);
			match(T__11);
			setState(92);
			returnExpr();
			setState(93);
			match(SEMI);
			setState(94);
			match(T__9);
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

	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
				{
				{
				setState(96);
				statement();
				}
				}
				setState(101);
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

	public static class ParametersContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(miniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(miniJavaParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) {
				{
				setState(102);
				type();
				setState(103);
				match(ID);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(104);
					match(COMMA);
					setState(105);
					type();
					setState(106);
					match(ID);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ReturnExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterReturnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitReturnExpr(this);
		}
	}

	public final ReturnExprContext returnExpr() throws RecognitionException {
		ReturnExprContext _localctx = new ReturnExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			expression(0);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(T__12);
				setState(118);
				match(T__7);
				setState(119);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__13);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(T__12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(ID);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OutputContext extends StatementContext {
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public OutputContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitOutput(this);
		}
	}
	public static class SelectContext extends StatementContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SelectContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitSelect(this);
		}
	}
	public static class ArrayAssignContext extends StatementContext {
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public ArrayAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitArrayAssign(this);
		}
	}
	public static class BlockContext extends StatementContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitBlock(this);
		}
	}
	public static class WhileContext extends StatementContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitWhile(this);
		}
	}
	public static class AssignContext extends StatementContext {
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public AssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitAssign(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(T__1);
				setState(126);
				body();
				setState(127);
				match(T__9);
				}
				break;
			case 2:
				_localctx = new SelectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__14);
				setState(130);
				condition();
				setState(131);
				statement();
				setState(132);
				match(T__15);
				setState(133);
				statement();
				}
				break;
			case 3:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				match(T__16);
				setState(136);
				condition();
				setState(137);
				statement();
				}
				break;
			case 4:
				_localctx = new OutputContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(T__17);
				setState(140);
				match(LPR);
				setState(141);
				expression(0);
				setState(142);
				match(RPR);
				setState(143);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				match(ID);
				setState(146);
				match(ASSIGN);
				setState(147);
				expression(0);
				setState(148);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new ArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				match(ID);
				setState(151);
				match(T__7);
				setState(152);
				expression(0);
				setState(153);
				match(T__8);
				setState(154);
				match(ASSIGN);
				setState(155);
				expression(0);
				setState(156);
				match(SEMI);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(LPR);
			setState(161);
			expression(0);
			setState(162);
			match(RPR);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AccessContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitAccess(this);
		}
	}
	public static class BoolContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(miniJavaParser.BOOLEAN, 0); }
		public BoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitBool(this);
		}
	}
	public static class MethodContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(miniJavaParser.DOT, 0); }
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public MethodContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitMethod(this);
		}
	}
	public static class MulContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(miniJavaParser.MUL, 0); }
		public MulContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitMul(this);
		}
	}
	public static class NewIdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public NewIdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterNewId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitNewId(this);
		}
	}
	public static class ThisContext extends ExpressionContext {
		public ThisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitThis(this);
		}
	}
	public static class LTContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(miniJavaParser.LT, 0); }
		public LTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterLT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitLT(this);
		}
	}
	public static class LengthContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(miniJavaParser.DOT, 0); }
		public LengthContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitLength(this);
		}
	}
	public static class AddSubContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(miniJavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(miniJavaParser.SUB, 0); }
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitAddSub(this);
		}
	}
	public static class EQContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(miniJavaParser.EQ, 0); }
		public EQContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterEQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitEQ(this);
		}
	}
	public static class IntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(miniJavaParser.INT, 0); }
		public IntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitInt(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitNot(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public TerminalNode LPR() { return getToken(miniJavaParser.LPR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPR() { return getToken(miniJavaParser.RPR, 0); }
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitParen(this);
		}
	}
	public static class NewIntContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NewIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterNewInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitNewInt(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(miniJavaParser.AND, 0); }
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitAnd(this);
		}
	}
	public static class IdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(miniJavaParser.ID, 0); }
		public IdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitId(this);
		}
	}
	public static class ExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EXP() { return getToken(miniJavaParser.EXP, 0); }
		public ExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof miniJavaListener ) ((miniJavaListener)listener).exitExp(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				match(INT);
				}
				break;
			case 2:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(BOOLEAN);
				}
				break;
			case 3:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(T__19);
				}
				break;
			case 5:
				{
				_localctx = new NewIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__20);
				setState(170);
				match(T__12);
				setState(171);
				match(T__7);
				setState(172);
				expression(0);
				setState(173);
				match(T__8);
				}
				break;
			case 6:
				{
				_localctx = new NewIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(T__20);
				setState(176);
				match(ID);
				setState(177);
				match(LPR);
				setState(178);
				match(RPR);
				}
				break;
			case 7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(T__21);
				setState(180);
				expression(2);
				}
				break;
			case 8:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(LPR);
				setState(182);
				expression(0);
				setState(183);
				match(RPR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(188);
						match(EXP);
						setState(189);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new MulContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(190);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(191);
						match(MUL);
						setState(192);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(193);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(194);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new EQContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(197);
						match(EQ);
						setState(198);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new LTContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(200);
						match(LT);
						setState(201);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(203);
						match(AND);
						setState(204);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new MethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(206);
						match(DOT);
						setState(207);
						match(ID);
						setState(208);
						match(LPR);
						setState(217);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << BOOLEAN) | (1L << ID) | (1L << INT) | (1L << LPR))) != 0)) {
							{
							setState(209);
							expression(0);
							setState(214);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(210);
								match(COMMA);
								setState(211);
								expression(0);
								}
								}
								setState(216);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(219);
						match(RPR);
						}
						break;
					case 8:
						{
						_localctx = new LengthContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(221);
						match(DOT);
						setState(222);
						match(T__18);
						}
						break;
					case 9:
						{
						_localctx = new AccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(224);
						match(T__7);
						setState(225);
						expression(0);
						setState(226);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00ec\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\5\4:\n\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\4\7\4D\n\4\f\4"+
		"\16\4G\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\7\6P\n\6\f\6\16\6S\13\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\7\bd\n\b\f\b\16"+
		"\bg\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\5\tt\n\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13~\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00bc\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00d7\n\16\f\16\16\16\u00da\13"+
		"\16\5\16\u00dc\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00e7\n\16\f\16\16\16\u00ea\13\16\3\16\2\3\32\17\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\2\3\3\2\37 \2\u0100\2\34\3\2\2\2\4#\3\2\2\2\6\65\3\2\2\2"+
		"\bJ\3\2\2\2\nQ\3\2\2\2\fT\3\2\2\2\16e\3\2\2\2\20s\3\2\2\2\22u\3\2\2\2"+
		"\24}\3\2\2\2\26\u00a0\3\2\2\2\30\u00a2\3\2\2\2\32\u00bb\3\2\2\2\34 \5"+
		"\4\3\2\35\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2"+
		"!\3\3\2\2\2\" \3\2\2\2#$\7\3\2\2$%\7\32\2\2%&\7\4\2\2&\'\7\5\2\2\'(\7"+
		"\6\2\2()\7\7\2\2)*\7\b\2\2*+\7%\2\2+,\7\t\2\2,-\7\n\2\2-.\7\13\2\2./\7"+
		"\32\2\2/\60\7&\2\2\60\61\7\4\2\2\61\62\5\26\f\2\62\63\7\f\2\2\63\64\7"+
		"\f\2\2\64\5\3\2\2\2\65\66\7\3\2\2\669\7\32\2\2\678\7\r\2\28:\7\32\2\2"+
		"9\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;?\7\4\2\2<>\5\b\5\2=<\3\2\2\2>A\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@E\3\2\2\2A?\3\2\2\2BD\5\f\7\2CB\3\2\2\2DG\3\2\2"+
		"\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\f\2\2I\7\3\2\2\2JK\5\24"+
		"\13\2KL\7\32\2\2LM\7\'\2\2M\t\3\2\2\2NP\5\b\5\2ON\3\2\2\2PS\3\2\2\2QO"+
		"\3\2\2\2QR\3\2\2\2R\13\3\2\2\2SQ\3\2\2\2TU\7\5\2\2UV\5\24\13\2VW\7\32"+
		"\2\2WX\7%\2\2XY\5\20\t\2YZ\7&\2\2Z[\7\4\2\2[\\\5\n\6\2\\]\5\16\b\2]^\7"+
		"\16\2\2^_\5\22\n\2_`\7\'\2\2`a\7\f\2\2a\r\3\2\2\2bd\5\26\f\2cb\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\17\3\2\2\2ge\3\2\2\2hi\5\24\13\2ip\7\32"+
		"\2\2jk\7*\2\2kl\5\24\13\2lm\7\32\2\2mo\3\2\2\2nj\3\2\2\2or\3\2\2\2pn\3"+
		"\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2sh\3\2\2\2st\3\2\2\2t\21\3\2\2\2u"+
		"v\5\32\16\2v\23\3\2\2\2wx\7\17\2\2xy\7\n\2\2y~\7\13\2\2z~\7\20\2\2{~\7"+
		"\17\2\2|~\7\32\2\2}w\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\25\3\2\2\2"+
		"\177\u0080\7\4\2\2\u0080\u0081\5\16\b\2\u0081\u0082\7\f\2\2\u0082\u00a1"+
		"\3\2\2\2\u0083\u0084\7\21\2\2\u0084\u0085\5\30\r\2\u0085\u0086\5\26\f"+
		"\2\u0086\u0087\7\22\2\2\u0087\u0088\5\26\f\2\u0088\u00a1\3\2\2\2\u0089"+
		"\u008a\7\23\2\2\u008a\u008b\5\30\r\2\u008b\u008c\5\26\f\2\u008c\u00a1"+
		"\3\2\2\2\u008d\u008e\7\24\2\2\u008e\u008f\7%\2\2\u008f\u0090\5\32\16\2"+
		"\u0090\u0091\7&\2\2\u0091\u0092\7\'\2\2\u0092\u00a1\3\2\2\2\u0093\u0094"+
		"\7\32\2\2\u0094\u0095\7\"\2\2\u0095\u0096\5\32\16\2\u0096\u0097\7\'\2"+
		"\2\u0097\u00a1\3\2\2\2\u0098\u0099\7\32\2\2\u0099\u009a\7\n\2\2\u009a"+
		"\u009b\5\32\16\2\u009b\u009c\7\13\2\2\u009c\u009d\7\"\2\2\u009d\u009e"+
		"\5\32\16\2\u009e\u009f\7\'\2\2\u009f\u00a1\3\2\2\2\u00a0\177\3\2\2\2\u00a0"+
		"\u0083\3\2\2\2\u00a0\u0089\3\2\2\2\u00a0\u008d\3\2\2\2\u00a0\u0093\3\2"+
		"\2\2\u00a0\u0098\3\2\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\7%\2\2\u00a3\u00a4"+
		"\5\32\16\2\u00a4\u00a5\7&\2\2\u00a5\31\3\2\2\2\u00a6\u00a7\b\16\1\2\u00a7"+
		"\u00bc\7\33\2\2\u00a8\u00bc\7\31\2\2\u00a9\u00bc\7\32\2\2\u00aa\u00bc"+
		"\7\26\2\2\u00ab\u00ac\7\27\2\2\u00ac\u00ad\7\17\2\2\u00ad\u00ae\7\n\2"+
		"\2\u00ae\u00af\5\32\16\2\u00af\u00b0\7\13\2\2\u00b0\u00bc\3\2\2\2\u00b1"+
		"\u00b2\7\27\2\2\u00b2\u00b3\7\32\2\2\u00b3\u00b4\7%\2\2\u00b4\u00bc\7"+
		"&\2\2\u00b5\u00b6\7\30\2\2\u00b6\u00bc\5\32\16\4\u00b7\u00b8\7%\2\2\u00b8"+
		"\u00b9\5\32\16\2\u00b9\u00ba\7&\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00a6\3"+
		"\2\2\2\u00bb\u00a8\3\2\2\2\u00bb\u00a9\3\2\2\2\u00bb\u00aa\3\2\2\2\u00bb"+
		"\u00ab\3\2\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00b7\3\2"+
		"\2\2\u00bc\u00e8\3\2\2\2\u00bd\u00be\f\20\2\2\u00be\u00bf\7(\2\2\u00bf"+
		"\u00e7\5\32\16\21\u00c0\u00c1\f\17\2\2\u00c1\u00c2\7\36\2\2\u00c2\u00e7"+
		"\5\32\16\20\u00c3\u00c4\f\16\2\2\u00c4\u00c5\t\2\2\2\u00c5\u00e7\5\32"+
		"\16\17\u00c6\u00c7\f\r\2\2\u00c7\u00c8\7!\2\2\u00c8\u00e7\5\32\16\16\u00c9"+
		"\u00ca\f\f\2\2\u00ca\u00cb\7#\2\2\u00cb\u00e7\5\32\16\r\u00cc\u00cd\f"+
		"\13\2\2\u00cd\u00ce\7$\2\2\u00ce\u00e7\5\32\16\f\u00cf\u00d0\f\23\2\2"+
		"\u00d0\u00d1\7)\2\2\u00d1\u00d2\7\32\2\2\u00d2\u00db\7%\2\2\u00d3\u00d8"+
		"\5\32\16\2\u00d4\u00d5\7*\2\2\u00d5\u00d7\5\32\16\2\u00d6\u00d4\3\2\2"+
		"\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00d3\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00e7\7&\2\2\u00de\u00df\f\22\2\2\u00df\u00e0\7)"+
		"\2\2\u00e0\u00e7\7\25\2\2\u00e1\u00e2\f\21\2\2\u00e2\u00e3\7\n\2\2\u00e3"+
		"\u00e4\5\32\16\2\u00e4\u00e5\7\13\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00bd"+
		"\3\2\2\2\u00e6\u00c0\3\2\2\2\u00e6\u00c3\3\2\2\2\u00e6\u00c6\3\2\2\2\u00e6"+
		"\u00c9\3\2\2\2\u00e6\u00cc\3\2\2\2\u00e6\u00cf\3\2\2\2\u00e6\u00de\3\2"+
		"\2\2\u00e6\u00e1\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\33\3\2\2\2\u00ea\u00e8\3\2\2\2\21 9?EQeps}\u00a0"+
		"\u00bb\u00d8\u00db\u00e6\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}