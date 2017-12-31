import java.util.HashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class miniJavaLoader extends miniJavaBaseListener {
	HashMap<String, String> props = new HashMap<String, String>();
	int deep = 0;

	void common(String name)
	{
		String tab=new String();
		for (int i = 0;i < deep;++ i)
			tab+='\t';
		System.out.println(tab + name);
		deep += 1;
	}
	void lv() {deep -= 1;}
	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {common("goal");}
	@Override public void exitGoal(miniJavaParser.GoalContext ctx) {lv();}
	@Override public void enterMainClass(miniJavaParser.MainClassContext ctx) { }
	@Override public void exitMainClass(miniJavaParser.MainClassContext ctx) { }
	@Override public void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { }
	@Override public void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { }
	@Override public void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx) { }
	@Override public void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx) { }
	@Override public void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) { }
	@Override public void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) { }
	@Override public void enterType(miniJavaParser.TypeContext ctx) { }
	@Override public void exitType(miniJavaParser.TypeContext ctx) { }
	@Override public void enterBlock(miniJavaParser.BlockContext ctx) { }
	@Override public void exitBlock(miniJavaParser.BlockContext ctx) { }
	@Override public void enterSelect(miniJavaParser.SelectContext ctx) { }
	@Override public void exitSelect(miniJavaParser.SelectContext ctx) { }
	@Override public void enterWhile(miniJavaParser.WhileContext ctx) { }
	@Override public void exitWhile(miniJavaParser.WhileContext ctx) { }
	@Override public void enterOutput(miniJavaParser.OutputContext ctx) { }
	@Override public void exitOutput(miniJavaParser.OutputContext ctx) { }
	@Override public void enterAssign(miniJavaParser.AssignContext ctx) { }
	@Override public void exitAssign(miniJavaParser.AssignContext ctx) { }
	@Override public void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx) { }
	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) { }
	@Override public void enterAccess(miniJavaParser.AccessContext ctx) { }
	@Override public void exitAccess(miniJavaParser.AccessContext ctx) { }
	@Override public void enterBool(miniJavaParser.BoolContext ctx) { }
	@Override public void exitBool(miniJavaParser.BoolContext ctx) { }
	@Override public void enterMethod(miniJavaParser.MethodContext ctx) { }
	@Override public void exitMethod(miniJavaParser.MethodContext ctx) { }
	@Override public void enterMul(miniJavaParser.MulContext ctx) { }
	@Override public void exitMul(miniJavaParser.MulContext ctx) { }
	@Override public void enterNewId(miniJavaParser.NewIdContext ctx) { }
	@Override public void exitNewId(miniJavaParser.NewIdContext ctx) { }
	@Override public void enterThis(miniJavaParser.ThisContext ctx) { }
	@Override public void exitThis(miniJavaParser.ThisContext ctx) { }
	@Override public void enterLT(miniJavaParser.LTContext ctx) { }
	@Override public void exitLT(miniJavaParser.LTContext ctx) { }
	@Override public void enterLength(miniJavaParser.LengthContext ctx) { }
	@Override public void exitLength(miniJavaParser.LengthContext ctx) { }
	@Override public void enterAddSub(miniJavaParser.AddSubContext ctx) { }
	@Override public void exitAddSub(miniJavaParser.AddSubContext ctx) { }
	@Override public void enterInt(miniJavaParser.IntContext ctx) { }
	@Override public void exitInt(miniJavaParser.IntContext ctx) { }
	@Override public void enterNot(miniJavaParser.NotContext ctx) { }
	@Override public void exitNot(miniJavaParser.NotContext ctx) { }
	@Override public void enterParen(miniJavaParser.ParenContext ctx) { }
	@Override public void exitParen(miniJavaParser.ParenContext ctx) { }
	@Override public void enterNewInt(miniJavaParser.NewIntContext ctx) { }
	@Override public void exitNewInt(miniJavaParser.NewIntContext ctx) { }
	@Override public void enterAnd(miniJavaParser.AndContext ctx) { }
	@Override public void exitAnd(miniJavaParser.AndContext ctx) { }
	@Override public void enterId(miniJavaParser.IdContext ctx) { }
	@Override public void exitId(miniJavaParser.IdContext ctx) { }
	@Override public void enterExp(miniJavaParser.ExpContext ctx) { }
	@Override public void exitExp(miniJavaParser.ExpContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
