import java.util.HashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class miniJavaLoader extends miniJavaBaseListener {
	ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();
	ParseTreeProperty<ParserRuleContext> vast = new ParseTreeProperty<ParserRuleContext>();
	HashMap<String, Integer> classList= new HashMap<String, Integer>();
	HashMap<String, Integer> idList = new HashMap<String, Integer>();

	public static ParserRuleContext ast;

	public void setValue(ParseTree node, int value) { values.put(node, value);}
	public int getValue(ParseTree node) { return values.get(node);}
	int deep = 0;

	void common(String name) {
		String tab=new String();
		for (int i = 0;i < deep;++ i)
			tab+=' ';
		//System.out.println(tab + name);
		deep += 1;
	}
	void lv() {
		deep -= 1;
	}

	public static final int
		WRONG_TYPE=0, VOID=1, INT=2, FLOAT=3, BOOL=4, STRING=5;

	public static final int
		_GOAL=0, _MAINCLASS=1, _CLASSDECLARATION=2, _VARDECLARATION=3,
		_METHODDECLARATION=4, _TYPE=5, _STATEMENT=6, _EXPRESSION=7,
		_BLOCK=8, _SELECT=9, _WHILE=10, _OUTPUT=11, _ASSIGN=12,
		_ARRAYASSIGN=13, _METHOD=14, _LENGTH=15, _ACCESS=16,
		_EXP=17, _MUL=18, _ADDSUB=19, _EQ=20, _LT=21,
		_AND=22, _INT=23, _BOOL=24, _ID=25, _THIS=26,
		_NEWINT=27, _NEWID=28, _NOT=29, _PAREN=30,
		_RETURNEXPR=31, _PARAMETERS=32, _VARDECS=33,
		_BODY=34, _CONDITION=35;


	boolean check(int left, int right, int exp_left, int exp_right)
	{
		if (left != exp_left || right != exp_right)
			return false;
		return true;
	}

	public void print(String out)
	{

	}

	public static class GoalContext2 extends miniJavaParser.GoalContext {
		@Override public int getRuleIndex() {return _GOAL;}
		public GoalContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {
		common("goal");
	}
	@Override public void exitGoal(miniJavaParser.GoalContext ctx) {
		ParserRuleContext node = new GoalContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.mainClass()));
		for (miniJavaParser.ClassDeclarationContext i: ctx.classDeclaration())
			node.addChild(vast.get(i));
		node.invokingState = _GOAL;
		ast = node;
	}

	public static class MainClassContext2 extends miniJavaParser.MainClassContext {
		@Override public int getRuleIndex() {return _MAINCLASS;}
		public MainClassContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterMainClass(miniJavaParser.MainClassContext ctx) { common("mainClass");}
	@Override public void exitMainClass(miniJavaParser.MainClassContext ctx) {
		ParserRuleContext node = new MainClassContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.statement()));
		node.invokingState = _MAINCLASS;
		vast.put(ctx, node);
	}
	
	public static class ClassDeclarationContext2 extends miniJavaParser.ClassDeclarationContext {
		@Override public int getRuleIndex() {return _CLASSDECLARATION;}
		public ClassDeclarationContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { common("classDeclaration");}
	@Override public void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) {
		ParserRuleContext node = new ClassDeclarationContext2(ctx, 0);
		node.copyFrom(ctx);
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration())
			node.addChild(vast.get(i));
		for (miniJavaParser.MethodDeclarationContext i : ctx.methodDeclaration())
			node.addChild(vast.get(i));
		node.invokingState = _CLASSDECLARATION;
		vast.put(ctx, node);
	}

	public static class VarDeclarationContext2 extends miniJavaParser.VarDeclarationContext {
		@Override public int getRuleIndex() {return _VARDECLARATION;}
		public VarDeclarationContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx) { common("varDeclaration");}
	@Override public void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx) {
		ParserRuleContext node = new VarDeclarationContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.type()));
		node.invokingState = _VARDECLARATION;
		vast.put(ctx, node);
	}

	public static class MethodDeclarationContext2 extends miniJavaParser.MethodDeclarationContext {
		@Override public int getRuleIndex() {return _METHODDECLARATION;}
		public MethodDeclarationContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) { common("methodDeclaration");}
	@Override public void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) {
		ParserRuleContext node = new MethodDeclarationContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.parameters()));
		node.addChild(vast.get(ctx.varDecs()));
		node.addChild(vast.get(ctx.body()));
		node.addChild(vast.get(ctx.returnExpr()));
		node.invokingState = _METHODDECLARATION;
		vast.put(ctx, node);
	}

	public static class ConditionContext2 extends miniJavaParser.ConditionContext {
		@Override public int getRuleIndex() {return _CONDITION;}
		public ConditionContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterCondition(miniJavaParser.ConditionContext ctx) { common("condition");}
	@Override public void exitCondition(miniJavaParser.ConditionContext ctx) {
		ParserRuleContext node = new ConditionContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _CONDITION;
		vast.put(ctx, node);
	}

	public static class BodyContext2 extends miniJavaParser.BodyContext {
		@Override public int getRuleIndex() {return _BODY;}
		public BodyContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterBody(miniJavaParser.BodyContext ctx) { common("body");}
	@Override public void exitBody(miniJavaParser.BodyContext ctx) {
		ParserRuleContext node = new BodyContext2(ctx, 0);
		node.copyFrom(ctx);
		for (miniJavaParser.StatementContext i : ctx.statement())
			node.addChild(vast.get(i));
		node.invokingState = _BODY;
		vast.put(ctx, node);
	}

	public static class VarDecsContext2 extends miniJavaParser.VarDecsContext {
		@Override public int getRuleIndex() {return _VARDECS;}
		public VarDecsContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterVarDecs(miniJavaParser.VarDecsContext ctx) { common("vardecs");}
	@Override public void exitVarDecs(miniJavaParser.VarDecsContext ctx) {
		ParserRuleContext node = new VarDecsContext2(ctx, 0);
		node.copyFrom(ctx);
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration())
			node.addChild(vast.get(i));
		node.invokingState = _VARDECS;
		vast.put(ctx, node);
	}

	public static class ParametersContext2 extends miniJavaParser.ReturnExprContext {
		@Override public int getRuleIndex() {return _PARAMETERS;}
		public ParametersContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterParameters(miniJavaParser.ParametersContext ctx) { common("parameters");}
	@Override public void exitParameters(miniJavaParser.ParametersContext ctx) {
		ParserRuleContext node = new ParametersContext2(ctx, 0);
		node.copyFrom(ctx);
		for (miniJavaParser.TypeContext i : ctx.type())
			node.addChild(vast.get(i));
		node.invokingState = _PARAMETERS;
		vast.put(ctx, node);
	}

	public static class ReturnExprContext2 extends miniJavaParser.ReturnExprContext {
		@Override public int getRuleIndex() {return _RETURNEXPR;}
		public ReturnExprContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterReturnExpr(miniJavaParser.ReturnExprContext ctx) { common("returnExpr");}
	@Override public void exitReturnExpr(miniJavaParser.ReturnExprContext ctx) {
		ParserRuleContext node = new ReturnExprContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _RETURNEXPR;
		vast.put(ctx, node);
	}

	public static class TypeContext2 extends miniJavaParser.TypeContext {
		@Override public int getRuleIndex() {return _TYPE;}
		public TypeContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterType(miniJavaParser.TypeContext ctx) { common("type");}
	@Override public void exitType(miniJavaParser.TypeContext ctx) {
		ParserRuleContext node = new TypeContext2(ctx, 0);
		node.copyFrom(ctx);
		node.addAnyChild(ctx.getChild(0));
		node.invokingState = _TYPE;
		vast.put(ctx, node);
	}

	public static class BlockContext2 extends miniJavaParser.BlockContext {
		@Override public int getRuleIndex() {return _BLOCK;}
		public BlockContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterBlock(miniJavaParser.BlockContext ctx) { common("block");}
	@Override public void exitBlock(miniJavaParser.BlockContext ctx) {
		ParserRuleContext node = new BlockContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.body()));
		node.invokingState = _BLOCK;
		vast.put(ctx, node);
	}

	public static class SelectContext2 extends miniJavaParser.SelectContext {
		@Override public int getRuleIndex() {return _SELECT;}
		public SelectContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterSelect(miniJavaParser.SelectContext ctx) { common("select");}
	@Override public void exitSelect(miniJavaParser.SelectContext ctx) {
		ParserRuleContext node = new SelectContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.condition()));
		for (miniJavaParser.StatementContext i : ctx.statement())
			node.addChild(vast.get(i));
		node.invokingState = _SELECT;
		vast.put(ctx, node);
	}

	public static class WhileContext2 extends miniJavaParser.WhileContext {
		@Override public int getRuleIndex() {return _WHILE;}
		public WhileContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterWhile(miniJavaParser.WhileContext ctx) { common("while");}
	@Override public void exitWhile(miniJavaParser.WhileContext ctx) {
		ParserRuleContext node = new WhileContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.condition()));
		node.addChild(vast.get(ctx.statement()));
		node.invokingState = _WHILE;
		vast.put(ctx, node);
	}

	public static class OutputContext2 extends miniJavaParser.OutputContext {
		@Override public int getRuleIndex() {return _OUTPUT;}
		public OutputContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterOutput(miniJavaParser.OutputContext ctx) { common("output");}
	@Override public void exitOutput(miniJavaParser.OutputContext ctx) {
		ParserRuleContext node = new OutputContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _OUTPUT;
		vast.put(ctx, node);
	}

	public static class AssignContext2 extends miniJavaParser.AssignContext {
		@Override public int getRuleIndex() {return _ASSIGN;}
		public AssignContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterAssign(miniJavaParser.AssignContext ctx) { common("assign");}
	@Override public void exitAssign(miniJavaParser.AssignContext ctx) {
		ParserRuleContext node = new AssignContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _ASSIGN;
		vast.put(ctx, node);
	}

	public static class ArrayAssignContext2 extends miniJavaParser.ArrayAssignContext {
		@Override public int getRuleIndex() {return _ARRAYASSIGN;}
		public ArrayAssignContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx) { common("arrayAssign");}
	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) {
		ParserRuleContext node = new ArrayAssignContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _ARRAYASSIGN;
		vast.put(ctx, node);
	}

	public static class AccessContext2 extends miniJavaParser.AccessContext {
		@Override public int getRuleIndex() {return _ACCESS;}
		public AccessContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterAccess(miniJavaParser.AccessContext ctx) {common("access");}
	@Override public void exitAccess(miniJavaParser.AccessContext ctx) {
		ParserRuleContext node = new AccessContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _ACCESS;
		vast.put(ctx, node);
	}

	public static class BoolContext2 extends miniJavaParser.BoolContext {
		@Override public int getRuleIndex() {return _BOOL;}
		public BoolContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterBool(miniJavaParser.BoolContext ctx) {common("bool");}
	@Override public void exitBool(miniJavaParser.BoolContext ctx) {
		ParserRuleContext node = new BoolContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _BOOL;
		vast.put(ctx, node);
	}

	public static class MethodContext2 extends miniJavaParser.MethodContext {
		@Override public int getRuleIndex() {return _METHOD;}
		public MethodContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterMethod(miniJavaParser.MethodContext ctx) {common("method");}
	@Override public void exitMethod(miniJavaParser.MethodContext ctx) {
		ParserRuleContext node = new MethodContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _METHOD;
		vast.put(ctx, node);
	}

	public static class MulContext2 extends miniJavaParser.MulContext {
		@Override public int getRuleIndex() {return _MUL;}
		public MulContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterMul(miniJavaParser.MulContext ctx) {common("mul");}
	@Override public void exitMul(miniJavaParser.MulContext ctx) {
		ParserRuleContext node = new MulContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _MUL;
		vast.put(ctx, node);
	}

	public static class NewIdContext2 extends miniJavaParser.NewIdContext {
		@Override public int getRuleIndex() {return _NEWID;}
		public NewIdContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterNewId(miniJavaParser.NewIdContext ctx) {common("newId");}
	@Override public void exitNewId(miniJavaParser.NewIdContext ctx) {
		ParserRuleContext node = new NewIdContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _NEWID;
		vast.put(ctx, node);
	}

	public static class ThisContext2 extends miniJavaParser.ThisContext {
		@Override public int getRuleIndex() {return _THIS;}
		public ThisContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterThis(miniJavaParser.ThisContext ctx) {common("this");}
	@Override public void exitThis(miniJavaParser.ThisContext ctx) {
		ParserRuleContext node = new ThisContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _THIS;
		vast.put(ctx, node);
	}

	public static class LTContext2 extends miniJavaParser.LTContext {
		@Override public int getRuleIndex() {return _LT;}
		public LTContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterLT(miniJavaParser.LTContext ctx) {common("<");}
	@Override public void exitLT(miniJavaParser.LTContext ctx) {
		ParserRuleContext node = new LTContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _LT;
		vast.put(ctx, node);
	}

	public static class LengthContext2 extends miniJavaParser.LengthContext {
		@Override public int getRuleIndex() {return _LENGTH;}
		public LengthContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterLength(miniJavaParser.LengthContext ctx) {common("length");}
	@Override public void exitLength(miniJavaParser.LengthContext ctx) {
		ParserRuleContext node = new LengthContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _LENGTH;
		vast.put(ctx, node);
	}

	public static class AddSubContext2 extends miniJavaParser.AddSubContext {
		@Override public int getRuleIndex() {return _ADDSUB;}
		public AddSubContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterAddSub(miniJavaParser.AddSubContext ctx) {common("+-");}
	@Override public void exitAddSub(miniJavaParser.AddSubContext ctx) {
		ParserRuleContext node = new AddSubContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _ADDSUB;
		vast.put(ctx, node);
	}

	public static class EQContext2 extends miniJavaParser.EQContext {
		@Override public int getRuleIndex() {return _EQ;}
		public EQContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterEQ(miniJavaParser.EQContext ctx) {common("==");}
	@Override public void exitEQ(miniJavaParser.EQContext ctx) {
		ParserRuleContext node = new EQContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _EQ;
		vast.put(ctx, node);
	}

	public static class IntContext2 extends miniJavaParser.IntContext {
		@Override public int getRuleIndex() {return _INT;}
		public IntContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterInt(miniJavaParser.IntContext ctx) {common("int");}
	@Override public void exitInt(miniJavaParser.IntContext ctx) {
		ParserRuleContext node = new IntContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _INT;
		vast.put(ctx, node);
	}

	public static class NotContext2 extends miniJavaParser.NotContext {
		@Override public int getRuleIndex() {return _NOT;}
		public NotContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterNot(miniJavaParser.NotContext ctx) {common("!");}
	@Override public void exitNot(miniJavaParser.NotContext ctx) {
		ParserRuleContext node = new NotContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _NOT;
		vast.put(ctx, node);
	}

	public static class ParenContext2 extends miniJavaParser.ParenContext {
		@Override public int getRuleIndex() {return _PAREN;}
		public ParenContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterParen(miniJavaParser.ParenContext ctx) {common("paran");}
	@Override public void exitParen(miniJavaParser.ParenContext ctx) {
		ParserRuleContext node = new ParenContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _PAREN;
		vast.put(ctx, node);
	}

	public static class NewIntContext2 extends miniJavaParser.NewIntContext {
		@Override public int getRuleIndex() {return _NEWINT;}
		public NewIntContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterNewInt(miniJavaParser.NewIntContext ctx) {common("newInt");}
	@Override public void exitNewInt(miniJavaParser.NewIntContext ctx) {
		ParserRuleContext node = new NewIntContext2(ctx);
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = _NEWINT;
		vast.put(ctx, node);
	}

	public static class AndContext2 extends miniJavaParser.AndContext {
		@Override public int getRuleIndex() {return _AND;}
		public AndContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterAnd(miniJavaParser.AndContext ctx) {common("&&");}
	@Override public void exitAnd(miniJavaParser.AndContext ctx) {
		ParserRuleContext node = new AndContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _AND;
		vast.put(ctx, node);
		// context
		System.out.println("AND : " + ctx.expression(0) + " && " + ctx.expression(1));
		int lt = getValue(ctx.expression(0));
		int rt = getValue(ctx.expression(1));

		if (lt == WRONG_TYPE || rt == WRONG_TYPE)
			setValue(ctx, WRONG_TYPE);
		else if (!check(lt, rt, BOOL, BOOL)) {
			System.out.println("&& must be boolean");
			setValue(ctx, WRONG_TYPE);
		}
		else
			setValue(ctx, BOOL);
		
	}

	public static class IdContext2 extends miniJavaParser.IdContext {
		@Override public int getRuleIndex() {return _ID;}
		public IdContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterId(miniJavaParser.IdContext ctx) {common("ID");}
	@Override public void exitId(miniJavaParser.IdContext ctx) {
		ParserRuleContext node = new IdContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _ID;
		vast.put(ctx, node);
		// context
		System.out.print("ID : ");
		System.out.println(ctx.ID());
		if (!idList.containsKey(ctx.ID())) {
			System.out.println(ctx.ID() + " didn't declare");
			setValue(ctx, WRONG_TYPE);
		}
		else
			setValue(ctx, idList.get(ctx.ID()));
	}

	public static class ExpContext2 extends miniJavaParser.ExpContext {
		@Override public int getRuleIndex() {return _EXP;}
		public ExpContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterExp(miniJavaParser.ExpContext ctx) {common("^");}
	@Override public void exitExp(miniJavaParser.ExpContext ctx) {
		ParserRuleContext node = new ExpContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		node.invokingState = _EXP;
		vast.put(ctx, node);
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) {}
	@Override public void exitEveryRule(ParserRuleContext ctx) {lv();}
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
