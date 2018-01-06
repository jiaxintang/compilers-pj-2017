import java.util.HashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.misc.Interval;
import java.util.ArrayList;
import java.util.List;

public class miniJavaLoader extends miniJavaBaseListener {
	ParseTreeProperty<String> values = new ParseTreeProperty<String>();
	ParseTreeProperty<ParserRuleContext> vast = new ParseTreeProperty<ParserRuleContext>();

	String classPrefix;
	HashMap<String, Integer> classType = new HashMap<String, Integer>();
	HashMap<String, HashMap<String, ArrayList<String> > > methods = new HashMap<String, HashMap<String, ArrayList<String> > >();

	HashMap<String, String> classVar = new HashMap<String, String>();
	HashMap<String, String> methodVar = new HashMap<String, String>();


	public static ParserRuleContext ast;

	int deep = 0;

	void common(String name) {
		String tab=new String();
		for (int i = 0;i < deep;++ i)
			tab+=' ';
		deep += 1;
		//System.out.println(tab + name);
	}
	void lv(ParseTree node) {
		deep -= 1;
		String tab = new String();
		for (int i = 0;i < deep;++ i)
			tab+=' ';
		//System.out.println(tab + "lv" + node.getText());
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
		_BODY=34, _CONDITION=35, _FLOAT=36,
		_EXPR=37, _STRING=38;


	boolean check(int left, int right, int exp_left, int exp_right)
	{
		if (left != exp_left || right != exp_right)
			return false;
		return true;
	}

	public void print(String out)
	{
		System.out.print(out);
	}

	public void printColor(String output, int color)
	{
		System.out.print("\033[" + Integer.toString(color) + ";1m");
		System.out.print(output);
		System.out.print("\033[0m");
	}

	public void err(TerminalNode node, String output)
	{
		int line = node.getSymbol().getLine();
		int lineStart = node.getSymbol().getStartIndex()- node.getSymbol().getCharPositionInLine();
		int start = node.getSymbol().getCharPositionInLine();
		int stop = node.getSymbol().getStopIndex() - lineStart;

		int sourceEnd = node.getSymbol().getInputStream().size();
		String standardOutput = "line " + Integer.toString(line) + ":" + Integer.toString(start) + " \033[31;1merror\033[0m";
		System.out.println(standardOutput + " : " + output);

		String lineString = node.getSymbol().getInputStream().getText(new Interval(lineStart, sourceEnd-1)).split("\n|\r",2)[0];
		lineString = lineString.replaceAll("\t", " ");
		int len = lineString.length();
		System.out.print(lineString.substring(0, start));
		printColor(lineString.substring(start, stop+1), 31);
		System.out.println(lineString.substring(stop+1, len));
		for (int i = 0;i < start;++ i)
			System.out.print(" ");
		System.out.print("\033[31;1m");
		for (int i = start;i <= stop;++ i)
			System.out.print("^");
		System.out.println("\033[0m");
	}

	public void warn(TerminalNode node, String output)
	{
		int line = node.getSymbol().getLine();
		int lineStart = node.getSymbol().getStartIndex()- node.getSymbol().getCharPositionInLine();
		int start = node.getSymbol().getCharPositionInLine();
		int stop = node.getSymbol().getStopIndex() - lineStart;

		int sourceEnd = node.getSymbol().getInputStream().size();
		String standardOutput = "line " + Integer.toString(line) + ":" + Integer.toString(start) + " \033[34;1mwarning\033[0m";
		System.out.println(standardOutput + " : " + output);

		String lineString = node.getSymbol().getInputStream().getText(new Interval(lineStart, sourceEnd-1)).split("\n|\r",2)[0];
		lineString = lineString.replaceAll("\t", " ");
		int len = lineString.length();
		System.out.print(lineString.substring(0, start));
		printColor(lineString.substring(start, stop+1), 34);
		System.out.println(lineString.substring(stop+1, len));
		for (int i = 0;i < start;++ i)
			System.out.print(" ");
		System.out.print("\033[34;1m");
		for (int i = start;i <= stop;++ i)
			System.out.print("^");
		System.out.println("\033[0m");
	}

	public String combineMethod(String name, ArrayList<String> param) {
		String s = name;
		for (int i = 0;i < param.size(); ++i)
			s = s + "|" + param.get(i);
		return s;
	}

	public static class GoalContext2 extends miniJavaParser.GoalContext {
		@Override public int getRuleIndex() {return _GOAL;}
		public GoalContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterGoal(miniJavaParser.GoalContext ctx) {
		// record all class
		classType.put("void", 0);
		classType.put("int", 1);
		classType.put("float", 2);
		classType.put("String", 3);
		classType.put("boolean", 4);
		classType.put("int[]", 5);

		int po = 10;
		HashMap<String, String> Edge = new HashMap<String, String>();
		for (miniJavaParser.ClassDeclarationContext i: ctx.classDeclaration()) {
			String s = i.ID(0).getSymbol().getText();
			Edge.put(s, "null");
			if (classType.containsKey(s)) {
				if (classType.get(s) < 10)
					err(i.ID(0), "Class name illegal, '" + s + "' is reserved word");
				else
					err(i.ID(0), "Class '" + s + "' already exists");
			}
			else
				classType.put(s, po++);

		}

		// extends
		for (miniJavaParser.ClassDeclarationContext i: ctx.classDeclaration()) {
			if (i.ID().size() == 2) {
				String start = i.ID(0).getSymbol().getText();
				String s = i.ID(1).getSymbol().getText();
				if (!Edge.containsKey((s))) {
					err(i.ID(1), "Unknown class '" + s + "' found when extends");
				}
				else {
					while (!s.equals("null") && !s.equals(start))
						s = Edge.get(s);
					if (start.equals(s))
						err(i.ID(1), "Loop inheritance occurred when extends '" + s + "'");
					else
						Edge.put(start, i.ID(1).getSymbol().getText());
				}
			}
		}

		// methods
		boolean ok = true;
		while (ok) {
			ok = false;
			for (String i: Edge.keySet()) {
				String s = Edge.get(i);
				if (s.equals("true"))
					continue;
				HashMap<String, ArrayList<String> > now;
				if (s.equals("null") || Edge.get(s).equals("true")) {
					if (s.equals("null")) {
						// original methods
						now = new HashMap<String, ArrayList<String> >();
					}
					else {
						// extends
						HashMap<String, ArrayList<String> > iter = methods.get(s);
						now = (HashMap<String, ArrayList<String> >)iter.clone();
					}
					for (miniJavaParser.ClassDeclarationContext classIter: ctx.classDeclaration()) {
						String className = classIter.ID(0).getSymbol().getText();
						if (className.equals(i)) {
							for (miniJavaParser.MethodDeclarationContext methodIter: classIter.methodDeclaration()) {
								String methodName = methodIter.ID().getSymbol().getText();
								ArrayList<String> lis = new ArrayList<String>();
								lis.add(methodIter.type().getText());
								miniJavaParser.ParametersContext param = methodIter.parameters();
								for (miniJavaParser.TypeContext typeIter: param.type())
									lis.add(typeIter.getText());

								// add method
								if (now.containsKey(methodName)) {
									err(methodIter.ID(), "Function name '" + methodName + "' already declared");
									continue;
								}
								now.put(methodName, lis);
							}
							break;
						}
					}
					methods.put(i, now);
					Edge.put(i, "true");
				}
				ok = true;
			}
		}

		common("goal");
	}
	@Override public void exitGoal(miniJavaParser.GoalContext ctx) {
		ParserRuleContext node = new GoalContext2(ctx, 0);
		node.copyFrom(ctx);
		try{vast.get(ctx.mainClass()).getText();node.addChild(vast.get(ctx.mainClass()));}catch (NullPointerException e) {}
		for (miniJavaParser.ClassDeclarationContext i: ctx.classDeclaration())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
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
		try{vast.get(ctx.statement()).getText();node.addChild(vast.get(ctx.statement()));}catch (NullPointerException e) {}
		node.invokingState = _MAINCLASS;
		vast.put(ctx, node);
	}
	
	public static class ClassDeclarationContext2 extends miniJavaParser.ClassDeclarationContext {
		@Override public int getRuleIndex() {return _CLASSDECLARATION;}
		public ClassDeclarationContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) { 
		classPrefix = ctx.ID(0).getSymbol().getText();
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration()) {
			String type = i.type().getText();
			String name = i.ID().getSymbol().getText();
			if (classVar.containsKey(name)) {
				err(i.ID(), "redefinition of '" + type + " " + name + "'");
			}
			else if (!classType.containsKey(type)) {
				err(i.ID(), "'" + type + "' was not declare in the scope");
			}
			else
				classVar.put(name, type);
		}
		common("classDeclaration");
	}
	@Override public void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx) {
		classVar.clear();
		classPrefix = "";

		ParserRuleContext node = new ClassDeclarationContext2(ctx, 0);
		node.copyFrom(ctx);
		for (miniJavaParser.VarDeclarationContext i : ctx.varDeclaration())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		for (miniJavaParser.MethodDeclarationContext i : ctx.methodDeclaration())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
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
		try{vast.get(ctx.type()).getText();node.addChild(vast.get(ctx.type()));}catch (NullPointerException e) {}
		node.invokingState = _VARDECLARATION;
		vast.put(ctx, node);
	}

	public static class MethodDeclarationContext2 extends miniJavaParser.MethodDeclarationContext {
		@Override public int getRuleIndex() {return _METHODDECLARATION;}
		public MethodDeclarationContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) {
		
		miniJavaParser.ParametersContext params = ctx.parameters();
		int paramN = params.ID().size();
		for (int i = 0;i < paramN;++ i) {
			String type = params.type(i).getText();
			String name = params.ID(i).getSymbol().getText();
			if (methodVar.containsKey(name)) {
				err(params.ID(i), "redefinition of '" + type + " " + name + "'");
			}
			else if (!classType.containsKey(type)) {
				err(params.ID(i), "'" + type + "' was not declare in the scope");
			}
			else
				methodVar.put(name, type);
		}

		for (miniJavaParser.VarDeclarationContext i : ctx.varDecs().varDeclaration()) {
			String type = i.type().getText();
			String name = i.ID().getSymbol().getText();
			if (methodVar.containsKey(name)) {
				err(i.ID(), "redefinition of '" + type + " " + name + "'");
			}
			else if (!classType.containsKey(type)) {
				err(i.ID(), "'" + type + "' was not declare in the scope");
			}
			else
				methodVar.put(name, type);
		}
		common("methodDeclaration");
	}
	@Override public void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx) {
		methodVar.clear();

		ParserRuleContext node = new MethodDeclarationContext2(ctx, 0);
		node.copyFrom(ctx);
		try{vast.get(ctx.parameters()).getText();node.addChild(vast.get(ctx.parameters()));}catch (NullPointerException e) {}
		try{vast.get(ctx.varDecs()).getText();node.addChild(vast.get(ctx.varDecs()));}catch (NullPointerException e) {}
		try{vast.get(ctx.body()).getText();node.addChild(vast.get(ctx.body()));}catch (NullPointerException e) {}
		try{vast.get(ctx.returnExpr()).getText();node.addChild(vast.get(ctx.returnExpr()));}catch (NullPointerException e) {}

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
		try{vast.get(ctx.expr()).getText();node.addChild(vast.get(ctx.expr()));}catch (NullPointerException e) {}
		node.invokingState = _CONDITION;
		vast.put(ctx, node);

		String type = values.get(ctx.expr());
		if (type.equals("boolean"))
			values.put(ctx, "boolean");
		else if (type.equals("int") || type.equals("float")) {
			warn(ctx.LPR(), "Implicit conversion from '" + type + "' to 'boolean'");
			values.put(ctx, type);
		}
		else if (!type.equals("wrong")){
			err(ctx.LPR(), "Condition expression needs 'boolean' expression");
			values.put(ctx, "wrong");
		}
		else 
			values.put(ctx, "wrong");

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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _BODY;
		vast.put(ctx, node);

		values.put(ctx, "void");
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _PARAMETERS;
		vast.put(ctx, node);

	}

	public static class ExprContext2 extends miniJavaParser.ReturnExprContext {
		@Override public int getRuleIndex() {return _EXPR;}
		public ExprContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterExpr(miniJavaParser.ExprContext ctx) { common("parameters");}
	@Override public void exitExpr(miniJavaParser.ExprContext ctx) {
		vast.put(ctx, vast.get(ctx.expression()));

		values.put(ctx, values.get(ctx.expression()));
	}

	public static class ReturnExprContext2 extends miniJavaParser.ReturnExprContext {
		@Override public int getRuleIndex() {return _RETURNEXPR;}
		public ReturnExprContext2(ParserRuleContext ctx, int invokingState) {super(ctx, invokingState);}
	}
	@Override public void enterReturnExpr(miniJavaParser.ReturnExprContext ctx) { common("returnExpr");}
	@Override public void exitReturnExpr(miniJavaParser.ReturnExprContext ctx) {
		ParserRuleContext node = new ReturnExprContext2(ctx, 0);
		node.copyFrom(ctx);
		try{vast.get(ctx.expr()).getText();node.addChild(vast.get(ctx.expr()));}catch (NullPointerException e) {}
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

		values.put(ctx, "variableDefine");
	}

	public static class BlockContext2 extends miniJavaParser.BlockContext {
		@Override public int getRuleIndex() {return _BLOCK;}
		public BlockContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterBlock(miniJavaParser.BlockContext ctx) { common("block");}
	@Override public void exitBlock(miniJavaParser.BlockContext ctx) {
		ParserRuleContext node = new BlockContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.body()).getText();node.addChild(vast.get(ctx.body()));}catch (NullPointerException e) {}
		node.invokingState = _BLOCK;
		vast.put(ctx, node);

		values.put(ctx, values.get(ctx.body()));
	}

	public static class SelectContext2 extends miniJavaParser.SelectContext {
		@Override public int getRuleIndex() {return _SELECT;}
		public SelectContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterSelect(miniJavaParser.SelectContext ctx) { common("select");}
	@Override public void exitSelect(miniJavaParser.SelectContext ctx) {
		ParserRuleContext node = new SelectContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.condition()).getText();node.addChild(vast.get(ctx.condition()));}catch (NullPointerException e) {}
		for (miniJavaParser.StatementContext i : ctx.statement())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _SELECT;
		vast.put(ctx, node);

		values.put(ctx, "void");
	}

	public static class WhileContext2 extends miniJavaParser.WhileContext {
		@Override public int getRuleIndex() {return _WHILE;}
		public WhileContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterWhile(miniJavaParser.WhileContext ctx) { common("while");}
	@Override public void exitWhile(miniJavaParser.WhileContext ctx) {
		ParserRuleContext node = new WhileContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.condition()).getText();node.addChild(vast.get(ctx.condition()));}catch (NullPointerException e) {}
		try{vast.get(ctx.statement()).getText();node.addChild(vast.get(ctx.statement()));}catch (NullPointerException e) {}
		node.invokingState = _WHILE;
		vast.put(ctx, node);

		values.put(ctx, "void");
	}

	public static class OutputContext2 extends miniJavaParser.OutputContext {
		@Override public int getRuleIndex() {return _OUTPUT;}
		public OutputContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterOutput(miniJavaParser.OutputContext ctx) { common("output");}
	@Override public void exitOutput(miniJavaParser.OutputContext ctx) {
		ParserRuleContext node = new OutputContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expr()).getText();node.addChild(vast.get(ctx.expr()));}catch (NullPointerException e) {}
		node.invokingState = _OUTPUT;
		vast.put(ctx, node);

		values.put(ctx, "void");
	}

	public static class AssignContext2 extends miniJavaParser.AssignContext {
		@Override public int getRuleIndex() {return _ASSIGN;}
		public AssignContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterAssign(miniJavaParser.AssignContext ctx) { common("assign");}
	@Override public void exitAssign(miniJavaParser.AssignContext ctx) {
		ParserRuleContext node = new AssignContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expr()).getText();node.addChild(vast.get(ctx.expr()));}catch (NullPointerException e) {}
		node.invokingState = _ASSIGN;
		vast.put(ctx, node);

		String name = ctx.ID().getSymbol().getText();
		String typeL;
		if (methodVar.containsKey(name)) {
			typeL = methodVar.get(name);
		}
		else if (classVar.containsKey(name)) {
			typeL = classVar.get(name);
		}
		else if (classType.containsKey(name))
		{
			err(ctx.ID(), "class '" + name + "' can't be a identifier");
			values.put(ctx, "wrong");
			return;
		}
		else
		{
			err(ctx.ID(), "'" + name + "' was not declared in this scope");
			values.put(ctx, "wrong");
			return;
		}

		String typeR = values.get(ctx.expr());

		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if (typeL.equals(typeR)) {
			values.put(ctx, typeL);
		}
		else if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			values.put(ctx, typeL);
			if (!typeL.equals(typeR))
				warn(ctx.ASSIGN(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.ASSIGN(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary '='");
			values.put(ctx, "wrong");
		}
	}

	public static class ArrayAssignContext2 extends miniJavaParser.ArrayAssignContext {
		@Override public int getRuleIndex() {return _ARRAYASSIGN;}
		public ArrayAssignContext2(miniJavaParser.StatementContext ctx) {super(ctx);}
	}
	@Override public void enterArrayAssign(miniJavaParser.ArrayAssignContext ctx) { common("arrayAssign");}
	@Override public void exitArrayAssign(miniJavaParser.ArrayAssignContext ctx) {
		ParserRuleContext node = new ArrayAssignContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExprContext i : ctx.expr())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _ARRAYASSIGN;
		vast.put(ctx, node);

		String name = ctx.ID().getSymbol().getText();
		String typeL;
		if (methodVar.containsKey(name)) {
			typeL = methodVar.get(name);
			if (!typeL.equals("int[]"))
			{
				err(ctx.ID(), "'" + name + "' is not an array");
				values.put(ctx, "wrong");
				return;
			}
		}
		else if (classVar.containsKey(name)) {
			typeL = classVar.get(name);
			if (!typeL.equals("int[]"))
			{
				err(ctx.ID(), "'" + name + "' is not an array");
				values.put(ctx, "wrong");
				return;
			}
		}
		else if (classType.containsKey(name))
		{
			err(ctx.ID(), "class '" + name + "' can't be a identifier");
			values.put(ctx, "wrong");
			return;
		}
		else
		{
			err(ctx.ID(), "'" + name + "' was not declared in this scope");
			values.put(ctx, "wrong");
			return;
		}
		String index = values.get(ctx.expr(0));
		if (!index.equals("int")) {
			err(ctx.ID(), "index of array should be 'int', not '" + index + "'");
			values.put(ctx, "wrong");
			return;
		}
		typeL = typeL.substring(0, typeL.length()-2);

		String typeR = values.get(ctx.expr(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if (typeL.equals(typeR)) {
			values.put(ctx, typeL);
		}
		else if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			values.put(ctx, typeL);
			if (!typeL.equals(typeR))
				warn(ctx.ASSIGN(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.ASSIGN(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary '='");
			values.put(ctx, "wrong");
		}
	
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _ACCESS;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if (typeL.substring(typeL.length()-1, typeL.length()).equals("]") && typeR.equals("int")) {
			values.put(ctx, typeL.substring(0,typeL.length()-2));
		}
		else if (!typeR.equals("int")) {
			err(ctx.SLP(), "Invalid types '" + typeL + typeR + "' for array subscript");
			values.put(ctx, "wrong");
		}
		else if (typeL.substring(typeL.length()-1, typeL.length()).equals("]")) {
			err(ctx.SLP(), "Invalid array access for type '" + typeL + "'");
			values.put(ctx, "wrong");
		}
		else {
			err(ctx.SLP(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + ctx.SLP().getSymbol().getText());
			values.put(ctx, "wrong");
		}
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

		values.put(ctx, "boolean");
	}

	public static class MethodContext2 extends miniJavaParser.MethodContext {
		@Override public int getRuleIndex() {return _METHOD;}
		public MethodContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterMethod(miniJavaParser.MethodContext ctx) {

		common("method");
	}
	@Override public void exitMethod(miniJavaParser.MethodContext ctx) {
		ParserRuleContext node = new MethodContext2(ctx);
		node.copyFrom(ctx);
		for (miniJavaParser.ExpressionContext i : ctx.expression())
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _METHOD;
		vast.put(ctx, node);

		String type;
		for (miniJavaParser.ExpressionContext i: ctx.expression()) {
			type = values.get(i);
			if (type.equals("wrong")) {
				values.put(ctx, "wrong");
				return;
			}
		}

		String name = values.get(ctx.expression(0));
		String funcName = ctx.ID().getSymbol().getText();

		HashMap<String, ArrayList<String> > funcs = methods.get(name);
		if (!funcs.containsKey(funcName))
		{
			err(ctx.ID(), "class '" + name + "' has no member named '" + funcName + "'");
			values.put(ctx, "wrong");
			return;
		}
		ArrayList<String> func = funcs.get(funcName);
		ArrayList<String> params = new ArrayList<String>();

		int expN = ctx.expression().size();
		int paramN = func.size();
		for (int i = 1;i < expN;++ i)
		{
			String paramType = values.get(ctx.expression(i));
			params.add(paramType);
		}

		if (expN != paramN)
		{
			String myParam = "";
			String expParam = "";
			for (int j = 1;j < expN;++ j)
				myParam += "'" + params.get(j-1) + "'";
			for (int j = 1;j < paramN;++ j)
				expParam += "'" + func.get(j) + "'";
			err(ctx.ID(), "function '" + funcName + "' expect " + expParam + ". but " + myParam + " got");
			values.put(ctx, "wrong");
			return;
		}



		for (int i = 1;i < expN;++ i)
			if (!func.get(i).equals(params.get(i-1)))
			{
				String myParam = "";
				String expParam = "";
				for (int j = 1;j < expN;++ j)
					myParam += "'" + params.get(j-1) + "'";
				for (int j = 1;j < paramN;++ j)
					expParam += "'" + func.get(j) + "'";
				err(ctx.ID(), "function '" + funcName + "' expect " + expParam + ". but " + myParam + " got");
				values.put(ctx, "wrong");
				return;
			}

		values.put(ctx, func.get(0));
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _MUL;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			if (typeL.equals("float") || typeR.equals("float"))
				values.put(ctx, "float");
			else
				values.put(ctx, "int");
			if (!typeL.equals(typeR))
				warn(ctx.MUL(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.MUL(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + ctx.MUL().getSymbol().getText());
			values.put(ctx, "wrong");
		}
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

		String type = ctx.ID().getSymbol().getText();
		if (classType.containsKey(type))
			values.put(ctx, type);
		else {
			err(ctx.ID(), "'" + type + "' is not declare in this scope");
			values.put(ctx, "wrong");
		}
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

		if (classType.containsKey(classPrefix))
			values.put(ctx, classPrefix);
		else {
			err(ctx.THIS(), classPrefix);
			err(ctx.THIS(), "Invalid use of 'this'");
			values.put(ctx, "wrong");
		}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _LT;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			values.put(ctx, "boolean");
			if (!typeL.equals(typeR))
				warn(ctx.LT(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.LT(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + "<");
			values.put(ctx, "wrong");
		}
	}

	public static class LengthContext2 extends miniJavaParser.LengthContext {
		@Override public int getRuleIndex() {return _LENGTH;}
		public LengthContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterLength(miniJavaParser.LengthContext ctx) {common("length");}
	@Override public void exitLength(miniJavaParser.LengthContext ctx) {
		ParserRuleContext node = new LengthContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expression()).getText();node.addChild(vast.get(ctx.expression()));}catch (NullPointerException e) {}
		node.invokingState = _LENGTH;
		vast.put(ctx, node);

		String type = values.get(ctx.expression());
		if (type.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if (type.substring(type.length()-1, type.length()).equals("]")) {
			values.put(ctx, "int");
		}
		else {
			err(ctx.DOT(), "Type '" + type + "' has no member 'length'");
			values.put(ctx, "wrong");
		}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _ADDSUB;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		TerminalNode op = ctx.OP.getText().equals("+")?ctx.ADD():ctx.SUB();
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			if (typeL.equals("float") || typeR.equals("float"))
				values.put(ctx, "float");
			else
				values.put(ctx, "int");
			if (!typeL.equals(typeR))
				warn(op, "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(op, "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + ctx.OP.getText());
			values.put(ctx, "wrong");
		}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _EQ;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("int")||typeL.equals("float") ) && (typeR.equals("int")||typeR.equals("float"))) {
			values.put(ctx, "boolean");
			if (!typeL.equals(typeR))
				warn(ctx.EQ(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.EQ(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + "==");
			values.put(ctx, "wrong");
		}
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

		values.put(ctx, "int");
	}

	public static class FloatContext2 extends miniJavaParser.FloatContext {
		@Override public int getRuleIndex() {return _FLOAT;}
		public FloatContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterFloat(miniJavaParser.FloatContext ctx) {common("float");}
	@Override public void exitFloat(miniJavaParser.FloatContext ctx) {
		ParserRuleContext node = new FloatContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _FLOAT;
		vast.put(ctx, node);

		values.put(ctx, "float");
	}

	public static class StringContext2 extends miniJavaParser.StringContext {
		@Override public int getRuleIndex() {return _STRING;}
		public StringContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterString(miniJavaParser.StringContext ctx) {common("string");}
	@Override public void exitString(miniJavaParser.StringContext ctx) {
		ParserRuleContext node = new StringContext2(ctx);
		node.copyFrom(ctx);
		node.invokingState = _STRING;
		vast.put(ctx, node);

		values.put(ctx, "String");
	}

	public static class NotContext2 extends miniJavaParser.NotContext {
		@Override public int getRuleIndex() {return _NOT;}
		public NotContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterNot(miniJavaParser.NotContext ctx) {common("!");}
	@Override public void exitNot(miniJavaParser.NotContext ctx) {
		ParserRuleContext node = new NotContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expression()).getText();node.addChild(vast.get(ctx.expression()));}catch (NullPointerException e) {}
		node.invokingState = _NOT;
		vast.put(ctx, node);

		String type = values.get(ctx.expression());
		if (type.equals("boolean")) {
			values.put(ctx, "boolean");
		}
		else {
			err(ctx.NOT(), "Expression must be 'boolean'");
			values.put(ctx, "wrong");
		}
	}

	public static class ParenContext2 extends miniJavaParser.ParenContext {
		@Override public int getRuleIndex() {return _PAREN;}
		public ParenContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterParen(miniJavaParser.ParenContext ctx) {common("paran");}
	@Override public void exitParen(miniJavaParser.ParenContext ctx) {
		ParserRuleContext node = new ParenContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expression()).getText();node.addChild(vast.get(ctx.expression()));}catch (NullPointerException e) {}
		node.invokingState = _PAREN;
		vast.put(ctx, node);

		values.put(ctx, values.get(ctx.expression()));
	}

	public static class NewIntContext2 extends miniJavaParser.NewIntContext {
		@Override public int getRuleIndex() {return _NEWINT;}
		public NewIntContext2(miniJavaParser.ExpressionContext ctx) {super(ctx);}
	}
	@Override public void enterNewInt(miniJavaParser.NewIntContext ctx) {common("newInt");}
	@Override public void exitNewInt(miniJavaParser.NewIntContext ctx) {
		ParserRuleContext node = new NewIntContext2(ctx);
		node.copyFrom(ctx);
		try{vast.get(ctx.expression()).getText();node.addChild(vast.get(ctx.expression()));}catch (NullPointerException e) {}
		node.invokingState = _NEWINT;
		vast.put(ctx, node);

		String type = values.get(ctx.expression());
		if (type.equals("int")) {
			values.put(ctx, "int[]");
		}
		else {
			err(ctx.SLP(), "Expression in '[]' should be int");
			values.put(ctx, "wrong");
		}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _AND;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("boolean") ) && (typeR.equals("boolean"))) {
			values.put(ctx, "boolean");
		}
		else {
			err(ctx.AND(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + "&&");
			values.put(ctx, "wrong");
		}
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

		String name = ctx.getText();
		if (methodVar.containsKey(name))
			values.put(ctx, methodVar.get(name));
		else if (classVar.containsKey(name))
			values.put(ctx, classVar.get(name));
		else if (classType.containsKey(name))
		{
			err(ctx.ID(), "class '" + name + "' can't be a identifier");
			values.put(ctx, "wrong");
		}
		else
		{
			err(ctx.ID(), "'" + name + "' was not declared in this scope");
			values.put(ctx, "wrong");
		}
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
			try{vast.get(i).getText();node.addChild(vast.get(i));}catch (NullPointerException e) {}
		node.invokingState = _EXP;
		vast.put(ctx, node);

		String typeL = values.get(ctx.expression(0));
		String typeR = values.get(ctx.expression(1));
		if (typeL.equals("wrong") || typeR.equals("wrong")) {
			values.put(ctx, "wrong");
			return;
		}
		if ((typeL.equals("int") || typeL.equals("float")) && (typeR.equals("int") || typeR.equals("float"))) {
			if (typeL.equals("float") || typeR.equals("float"))
				values.put(ctx, "float");
			else
				values.put(ctx, "int");
			if (!typeL.equals(typeR))
				warn(ctx.EXP(), "Implicit conversion between 'int' and 'float'");
		}
		else {
			err(ctx.EXP(), "Invalid operands of type '" + typeL + "' and '" + typeR + "' to binary " + "^");
			values.put(ctx, "wrong");
		}
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) {}
	@Override public void exitEveryRule(ParserRuleContext ctx) {lv(ctx);}
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
