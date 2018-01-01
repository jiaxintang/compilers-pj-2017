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
		System.out.println(tab + name);
		deep += 1;
	}
	void lv() {
		deep -= 1;
		System.out.println("lv" + deep);
	}

	public static final int
		WRONG_TYPE=0, VOID=1, INT=2, FLOAT=3, BOOL=4, STRING=5;
	boolean check(int left, int right, int exp_left, int exp_right)
	{
		if (left != exp_left || right != exp_right)
			return false;
		return true;
	}

	public void print(String out)
	{

	}

	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {
		common("goal");
	}
	@Override public void exitGoal(miniJavaParser.GoalContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.mainClass()));
		for (miniJavaParser.ClassDeclarationContext i: ctx.classDeclaration())
			node.addChild(vast.get(i));
		node.invokingState = 0;
		ast = node;
	}
	@Override public void enterMainClass(miniJavaParser.MainClassContext ctx) { common("mainClass");}
	@Override public void exitMainClass(miniJavaParser.MainClassContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.statement()));
		node.invokingState = 1;
		vast.put(ctx, node);
	}
	@Override public void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { common("classDeclaration");}

	@Override public void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration())
			node.addChild(vast.get(i));
		for (miniJavaParser.MethodDeclarationContext i : ctx.methodDeclaration())
			node.addChild(vast.get(i));
		node.invokingState = 2;
		vast.put(ctx, node);
	}

	@Override public void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx) { common("varDeclaration");}

	@Override public void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.invokingState = 3;
		vast.put(ctx, node);
	}

	@Override public void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) { common("methodDeclaration");}

	@Override public void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		int len = ctx.type().size();
		for (int i = 1;i < len;++ i)
			node.addChild(vast.get(ctx.type().get(i)));
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration())
			node.addChild(vast.get(i));
		for (miniJavaParser.StatementContext i : ctx.statement())
			node.addChild(vast.get(i));
		node.addChild(vast.get(ctx.expression()));
		node.invokingState = 4;
		vast.put(ctx, node);
	}
	@Override public void enterType(miniJavaParser.TypeContext ctx) { common("type");}
	@Override public void exitType(miniJavaParser.TypeContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.invokingState = 5;
		vast.put(ctx, node);
	}
	@Override public void enterBlock(miniJavaParser.BlockContext ctx) { common("block");}
	@Override public void exitBlock(miniJavaParser.BlockContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.StatementContext i : ctx.statement())
			node.addChild(vast.get(i));
		node.invokingState = 6;
		vast.put(ctx, node);
	}
	@Override public void enterSelect(miniJavaParser.SelectContext ctx) { common("select");}
	@Override public void exitSelect(miniJavaParser.SelectContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		for (miniJavaParser.StatementContext i : ctx.statement())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterWhile(miniJavaParser.WhileContext ctx) { common("while");}
	@Override public void exitWhile(miniJavaParser.WhileContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		node.addChild(vast.get(ctx.statement()));
		vast.put(ctx, node);
	}
	@Override public void enterOutput(miniJavaParser.OutputContext ctx) { common("output");}
	@Override public void exitOutput(miniJavaParser.OutputContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterAssign(miniJavaParser.AssignContext ctx) { common("assign");}
	@Override public void exitAssign(miniJavaParser.AssignContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx) { common("arrayAssign");}
	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterAccess(miniJavaParser.AccessContext ctx) {common("access");}
	@Override public void exitAccess(miniJavaParser.AccessContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterBool(miniJavaParser.BoolContext ctx) {common("bool");}
	@Override public void exitBool(miniJavaParser.BoolContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		vast.put(ctx, node);
	}
	@Override public void enterMethod(miniJavaParser.MethodContext ctx) {common("method");}
	@Override public void exitMethod(miniJavaParser.MethodContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterMul(miniJavaParser.MulContext ctx) {common("mul");}
	@Override public void exitMul(miniJavaParser.MulContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterNewId(miniJavaParser.NewIdContext ctx) {common("newId");}
	@Override public void exitNewId(miniJavaParser.NewIdContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		vast.put(ctx, node);
	}
	@Override public void enterThis(miniJavaParser.ThisContext ctx) {common("this");}
	@Override public void exitThis(miniJavaParser.ThisContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		vast.put(ctx, node);
	}
	@Override public void enterLT(miniJavaParser.LTContext ctx) {common("<");}
	@Override public void exitLT(miniJavaParser.LTContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterLength(miniJavaParser.LengthContext ctx) {common("length");}
	@Override public void exitLength(miniJavaParser.LengthContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterAddSub(miniJavaParser.AddSubContext ctx) {common("+-");}
	@Override public void exitAddSub(miniJavaParser.AddSubContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterEQ(miniJavaParser.EQContext ctx) {common("==");}
	@Override public void exitEQ(miniJavaParser.EQContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}
	@Override public void enterInt(miniJavaParser.IntContext ctx) {common("int");}
	@Override public void exitInt(miniJavaParser.IntContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		vast.put(ctx, node);
	}
	@Override public void enterNot(miniJavaParser.NotContext ctx) {common("!");}
	@Override public void exitNot(miniJavaParser.NotContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterParen(miniJavaParser.ParenContext ctx) {common("paran");}
	@Override public void exitParen(miniJavaParser.ParenContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterNewInt(miniJavaParser.NewIntContext ctx) {common("newInt");}
	@Override public void exitNewInt(miniJavaParser.NewIntContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		node.addChild(vast.get(ctx.expression()));
		vast.put(ctx, node);
	}
	@Override public void enterAnd(miniJavaParser.AndContext ctx) {common("&&");}
	@Override public void exitAnd(miniJavaParser.AndContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
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
	@Override public void enterId(miniJavaParser.IdContext ctx) {common("ID");}
	@Override public void exitId(miniJavaParser.IdContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
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
	@Override public void enterExp(miniJavaParser.ExpContext ctx) {common("^");}
	@Override public void exitExp(miniJavaParser.ExpContext ctx) {
		ParserRuleContext node = new ParserRuleContext();
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			node.addChild(vast.get(i));
		vast.put(ctx, node);
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) {}
	@Override public void exitEveryRule(ParserRuleContext ctx) {lv();}
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
