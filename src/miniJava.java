import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.InputStream;
import java.util.Arrays;

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

		//show AST in console
		System.out.println(tree.toStringTree(parser));

		//show AST in GUI
		JFrame frame  = new JFrame("Antlr AST");
		JPanel panel = new JPanel();
		TreeViewer viewer = new TreeViewer(Arrays.asList(
					parser.getRuleNames()), tree);
		viewer.setScale(1.5);
		panel.add(viewer);
		frame.add(viewer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.setVisible(true);

	
		// create a standard ANTLR parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();
		// create listener then feed to walker
		miniJavaLoader loader = new miniJavaLoader();
		walker.walk(loader, tree);
	}


}

