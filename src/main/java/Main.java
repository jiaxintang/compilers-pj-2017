import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputcode = "class Factorial{\n" +
                "    public static void main(String[] a){\n" +
                "        System.out.println(new Fac().ComputeFac(10));\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class Fac {\n" +
                "\n" +
                "    public int ComputeFac(int num){\n" +
                "        int num_aux ;\n" +
                "        if (num < 1)\n" +
                "            num_aux = 1 ;\n" +
                "        else\n" +
                "            num_aux = num * (this.ComputeFac(num-1)) ;\n" +
                "        return num_aux ;\n" +
                "    }\n" +
                "\n" +
                "}" ;
        ANTLRInputStream in = new ANTLRInputStream(inputcode);
        MiniJavaLexer lexer = new MiniJavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        ParseTree tree = parser.goal();
        System.out.println(tree.toStringTree(parser));
    }
}
