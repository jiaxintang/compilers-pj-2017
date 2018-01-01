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


	
		// create a standard ANTLR parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();
		// create listener then feed to walker
		miniJavaLoader loader = new miniJavaLoader();
		walker.walk(loader, tree);
		ParseTree ast = loader.ast;

		//show AST in console
		//System.out.println("AST : ");
		//System.out.println(tree.toStringTree(parser));

		List<String> l = new ArrayList<>();
		l.add("goal"); // 0
		l.add("mainClass"); // 1
		l.add("classDec"); // 2
		l.add("varDec"); // 3
		l.add("methodDec"); // 4
		l.add("type"); // 5
		l.add("statement"); // 6
		l.add("expression"); // 7
		l.add("block"); // 8
		l.add("select"); // 9
		l.add("while"); // 10
		l.add("output"); // 11
		l.add("assign"); // 12
		l.add("arrayAssign"); // 13
		l.add("method"); // 14
		l.add("length"); // 15
		l.add("length"); // 16
		l.add("length"); // 17
		l.add("length"); // 18
		l.add("length"); // 19
		l.add("length"); // 20
		l.add("length"); // 21
		l.add("length"); // 22
		l.add("length"); // 23
		l.add("length"); // 24
		l.add("length"); // 25
		l.add("length"); // 26
		l.add("length"); // 27
		l.add("length"); // 28
		l.add("length"); // 29
		l.add("length"); // 30
		l.add("length"); // 30
		l.add("length"); // 30
		


		//show AST in GUI
		JFrame frame  = new JFrame("Antlr AST");
		JPanel panel = new JPanel();
		//TreeViewer viewer = new TreeViewer(null, tree);
		//TreeViewer viewer =new TreeViewer(Arrays.asList(
		//			parser.getRuleNames()), tree);
		//TreeViewer viewer = new TreeViewer(Arrays.asList(
		//			parser.getRuleNames()), ast);
		//TreeViewer viewer = new TreeViewer(l, ast);
		TreeViewer viewer = new TreeViewer(null, ast);
		viewer.setScale(1.5);
		panel.add(viewer);
		frame.add(viewer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setVisible(true);

	}


}

