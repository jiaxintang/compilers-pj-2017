import java.util.HashMap;
public class miniJavaLoader extends miniJavaBaseListener {
	HashMap<String, String> props = new HashMap<String, String>();

	public void enterGoal(miniJavaParser.GoalContext ctx) 
	{
		System.out.println("hahaha");
	}
}
