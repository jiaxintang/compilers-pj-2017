// Generated from miniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(miniJavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(miniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(miniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code select}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(miniJavaParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(miniJavaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code output}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(miniJavaParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(miniJavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(miniJavaParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code access}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(miniJavaParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(miniJavaParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(miniJavaParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newId}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewId(miniJavaParser.NewIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis(miniJavaParser.ThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LT}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLT(miniJavaParser.LTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code length}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(miniJavaParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(miniJavaParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(miniJavaParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(miniJavaParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(miniJavaParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newInt}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInt(miniJavaParser.NewIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(miniJavaParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(miniJavaParser.IdContext ctx);
}