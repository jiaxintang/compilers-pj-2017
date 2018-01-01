// Generated from miniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link miniJavaParser}.
 */
public interface miniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#varDecs}.
	 * @param ctx the parse tree
	 */
	void enterVarDecs(miniJavaParser.VarDecsContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#varDecs}.
	 * @param ctx the parse tree
	 */
	void exitVarDecs(miniJavaParser.VarDecsContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(miniJavaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(miniJavaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(miniJavaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(miniJavaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpr(miniJavaParser.ReturnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpr(miniJavaParser.ReturnExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(miniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(miniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock(miniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock(miniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code select}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSelect(miniJavaParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code select}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSelect(miniJavaParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(miniJavaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(miniJavaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code output}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterOutput(miniJavaParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code output}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitOutput(miniJavaParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(miniJavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(miniJavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(miniJavaParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(miniJavaParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code access}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAccess(miniJavaParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code access}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAccess(miniJavaParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool(miniJavaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool(miniJavaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMul(miniJavaParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMul(miniJavaParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newId}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewId(miniJavaParser.NewIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newId}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewId(miniJavaParser.NewIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(miniJavaParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(miniJavaParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LT}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLT(miniJavaParser.LTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LT}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLT(miniJavaParser.LTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code length}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLength(miniJavaParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code length}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLength(miniJavaParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(miniJavaParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(miniJavaParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQ}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEQ(miniJavaParser.EQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQ}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEQ(miniJavaParser.EQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInt(miniJavaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInt(miniJavaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(miniJavaParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(miniJavaParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(miniJavaParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(miniJavaParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newInt}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewInt(miniJavaParser.NewIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newInt}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewInt(miniJavaParser.NewIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(miniJavaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(miniJavaParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(miniJavaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(miniJavaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExp(miniJavaParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExp(miniJavaParser.ExpContext ctx);
}