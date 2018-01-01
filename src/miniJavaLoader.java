import java.util.HashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class miniJavaLoader extends miniJavaBaseListener {
	ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();
	HashMap<String, Integer> classList= new HashMap<String, Integer>();
	HashMap<String, Integer> idList = new HashMap<String, Integer>();

	public void setValue(ParseTree node, int value) { values.put(node, value);}
	public int getValue(ParseTree node) { return values.get(node);}
	int deep = 0;

	void common(String name)
	{
		String tab=new String();
		for (int i = 0;i < deep;++ i)
			tab+=' ';
		System.out.println(tab + name);
		deep += 1;
	}
	void lv() {deep -= 1;}

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

	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {common("goal");}
	@Override public void exitGoal(miniJavaParser.GoalContext ctx) {lv();}
	@Override public void enterMainClass(miniJavaParser.MainClassContext ctx) { common("mainClass");}
	@Override public void exitMainClass(miniJavaParser.MainClassContext ctx) {lv();}
	@Override public void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { common("classDeclaration");}
	@Override public void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) {lv();}
	@Override public void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx) { common("varDeclaration");}
	@Override public void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx) {lv();}
	@Override public void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) { common("methodDeclaration");}
	@Override public void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) {lv();}
	@Override public void enterType(miniJavaParser.TypeContext ctx) { common("type");}
	@Override public void exitType(miniJavaParser.TypeContext ctx) {lv();}
	@Override public void enterBlock(miniJavaParser.BlockContext ctx) { common("block");}
	@Override public void exitBlock(miniJavaParser.BlockContext ctx) {lv();}
	@Override public void enterSelect(miniJavaParser.SelectContext ctx) { common("select");}
	@Override public void exitSelect(miniJavaParser.SelectContext ctx) {lv();}
	@Override public void enterWhile(miniJavaParser.WhileContext ctx) { common("while");}
	@Override public void exitWhile(miniJavaParser.WhileContext ctx) {lv();}
	@Override public void enterOutput(miniJavaParser.OutputContext ctx) { common("output");}
	@Override public void exitOutput(miniJavaParser.OutputContext ctx) {lv();}
	@Override public void enterAssign(miniJavaParser.AssignContext ctx) { common("assign");}
	@Override public void exitAssign(miniJavaParser.AssignContext ctx) {lv();}
	@Override public void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx) { common("arrayAssign");}
	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) {lv();}
	@Override public void enterAccess(miniJavaParser.AccessContext ctx) {common("access");}
	@Override public void exitAccess(miniJavaParser.AccessContext ctx) {lv();}
	@Override public void enterBool(miniJavaParser.BoolContext ctx) {common("bool");}
	@Override public void exitBool(miniJavaParser.BoolContext ctx) {lv();}
	@Override public void enterMethod(miniJavaParser.MethodContext ctx) {common("method");}
	@Override public void exitMethod(miniJavaParser.MethodContext ctx) {lv();}
	@Override public void enterMul(miniJavaParser.MulContext ctx) {common("mul");}
	@Override public void exitMul(miniJavaParser.MulContext ctx) {lv();}
	@Override public void enterNewId(miniJavaParser.NewIdContext ctx) {common("newId");}
	@Override public void exitNewId(miniJavaParser.NewIdContext ctx) {lv();}
	@Override public void enterThis(miniJavaParser.ThisContext ctx) {common("this");}
	@Override public void exitThis(miniJavaParser.ThisContext ctx) {lv();}
	@Override public void enterLT(miniJavaParser.LTContext ctx) {common("<");}
	@Override public void exitLT(miniJavaParser.LTContext ctx) {lv();}
	@Override public void enterLength(miniJavaParser.LengthContext ctx) {common("length");}
	@Override public void exitLength(miniJavaParser.LengthContext ctx) {lv();}
	@Override public void enterAddSub(miniJavaParser.AddSubContext ctx) {common("+-");}
	@Override public void exitAddSub(miniJavaParser.AddSubContext ctx) {lv();}
	@Override public void enterInt(miniJavaParser.IntContext ctx) {common("int");}
	@Override public void exitInt(miniJavaParser.IntContext ctx) {lv();}
	@Override public void enterNot(miniJavaParser.NotContext ctx) {common("!");}
	@Override public void exitNot(miniJavaParser.NotContext ctx) {lv();}
	@Override public void enterParen(miniJavaParser.ParenContext ctx) {common("paran");}
	@Override public void exitParen(miniJavaParser.ParenContext ctx) {lv();}
	@Override public void enterNewInt(miniJavaParser.NewIntContext ctx) {common("newInt");}
	@Override public void exitNewInt(miniJavaParser.NewIntContext ctx) {lv();}
	@Override public void enterAnd(miniJavaParser.AndContext ctx) {common("&&");}
	@Override public void exitAnd(miniJavaParser.AndContext ctx) {
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
		lv();
	}
	@Override public void exitId(miniJavaParser.IdContext ctx) {
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
		lv();
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) {}
	@Override public void exitEveryRule(ParserRuleContext ctx) {}
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
