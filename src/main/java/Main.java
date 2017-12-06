import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        String sentence = "{213,23}";
        ANTLRInputStream in = new ANTLRInputStream(sentence);
        MiniJavaLexer lexer = new MiniJavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        ParseTree tree = parser.goal();
        System.out.println(tree.toStringTree(parser));
    }
}
