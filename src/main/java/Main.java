import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream in = new ANTLRInputStream(args[0]);
        MiniJavaLexer lexer = new MiniJavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        ParseTree tree = parser.goal();
        System.out.println(tree.toStringTree(parser));
    }
}
