import java.util.HashMap;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class miniJavaLoader extends miniJavaBaseListener {
	HashMap<String, String> props = new HashMap<String, String>();

	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {
		System.out.println("hahaha");
	}

	@Override public void visitErrorNode(ErrorNode node) {
		System.out.println(node);
	}

	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) { }

	@Override public void exitAccess(miniJavaParser.AccessContext ctx) { }

	@Override public void exitBool(miniJavaParser.BoolContext ctx) { }

	@Override public void exitMethod(miniJavaParser.MethodContext ctx) { }

	@Override public void exitMul(miniJavaParser.MulContext ctx) { }

	@Override public void exitNewId(miniJavaParser.NewIdContext ctx) { }

	@Override public void enterThis(miniJavaParser.ThisContext ctx) { }

	@Override public void exitLT(miniJavaParser.LTContext ctx) { }

}
