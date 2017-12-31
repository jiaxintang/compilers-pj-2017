import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.InputStream;
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
		System.out.println(loader.props);
	}


}

