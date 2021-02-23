package expressionTreeConverter;


import java.util.Scanner;



public class ExpressionTreeConverter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("type​ ​your​ ​infix​ ​expression or q to quit: ");
			
			if(input.hasNext("q")) {
				break;
			}
			
			String s = input.next();
			
			ExpressionTree one = new ExpressionTree(s);
		
			one.convert();
			
			
			System.out.print("Prefix: ");
			ExpressionTree.prefix(one.output);
			System.out.println();
			System.out.print("Infix: ");
			ExpressionTree.infix(one.output);
			System.out.println();
			System.out.print("Postfix: ");
			ExpressionTree.postfix(one.output);
			System.out.println();
			System.out.println();
		}
	}
}


