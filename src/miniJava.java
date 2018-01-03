import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;

import java.io.FileInputStream;

class miniJava {
	public static void main(String[] args) throws Exception {
		InputStream is = args.length > 0 ? new FileInputStream(args[0]) : System.in;

		ANTLRInputStream input = new ANTLRInputStream(is);
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		miniJavaParser parser = new miniJavaParser(tokens);
		ParseTree tree = parser.goal();

		//System.out.println("ASDASASD");
	
		// create a standard ANTLR parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();
		// create listener then feed to walker
		miniJavaLoader loader = new miniJavaLoader();
		walker.walk(loader, tree);

		boolean useGUI = false;
		if (args.length > 1) {
			if (args[1].equals("gui"))
				useGUI = true;
		}
		if (!useGUI)
			return;

		ParseTree ast = loader.ast;

		//show AST in console
		//System.out.println("AST : ");
		//System.out.println(tree.toStringTree(parser));

		List<String> l = new ArrayList<>();
		l.add("goal"); // 0
		l.add("main"); // 1
		l.add("classDec"); // 2
		l.add("Dec"); // 3
		l.add("methodDec"); // 4
		l.add("type"); // 5
		l.add("state"); // 6
		l.add("expr"); // 7
		l.add("body"); // 8
		l.add("if"); // 9
		l.add("while"); // 10
		l.add("print"); // 11
		l.add(":="); // 12
		l.add("ID[expr]=expr"); // 13
		l.add("expr.func(expr*)"); // 14
		l.add("expr.length"); // 15
		l.add("expr[expr]"); // 16
		l.add("^"); // 17
		l.add("*"); // 18
		l.add("+/-"); // 19
		l.add("=="); // 20
		l.add("<"); // 21
		l.add("&&"); // 22
		l.add("int"); // 23
		l.add("bool"); // 24
		l.add("ID"); // 25
		l.add("this"); // 26
		l.add("new int[expr]"); // 27
		l.add("new ID()"); // 28
		l.add("!"); // 29
		l.add("()"); // 30
		l.add("return"); //31
		l.add("param"); //32
		l.add("vars"); //33
		l.add("body"); //34
		l.add("condition"); //35
		l.add("float"); //36
		l.add("expr(WRONG!)"); //37
		l.add("string"); //37


		//show AST in GUI
		JFrame frame  = new JFrame("Antlr AST");
		JPanel panel = new JPanel();
		//TreeViewer viewer = new TreeViewer(Arrays.asList(
		//			parser.getRuleNames()), ast);
		TreeViewer viewer;
		if (true)
			viewer = new TreeViewer(l, ast);
		else
			viewer =new TreeViewer(Arrays.asList(
					parser.getRuleNames()), tree);
		viewer.setScale(1.5);
		panel.add(viewer);
		frame.add(viewer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setVisible(true);

	}


}

