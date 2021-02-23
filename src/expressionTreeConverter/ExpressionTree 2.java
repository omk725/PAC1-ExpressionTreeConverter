package expressionTreeConverter;

import java.util.List;

public class ExpressionTree {

	private String postfix;
	Node output;
	
	ExpressionTree(String input){
		//creating a tree object with a postfix string
		PostFixConverter one = new PostFixConverter(input);
		postfix = one.toPostFix();
	}

	public void convert() {
		
		char[] arrayInput = postfix.toCharArray();
		List<String> workingInput = ParserHelper.parse(arrayInput);
		
		LinkedStack<Node> stack = new LinkedStack<>();
		
		String e = "";
		Node Parent;
		Node number;
		
		
		for(int i = 0; i < workingInput.size(); i++) {
			
			e = workingInput.get(i);
			//if e is a number then create a node and push
			if(order(e) < 0) {
				
				number = new Node(e);
				stack.push(number);
				
			} 
			//if not then pop two off and make children
			else {

				Parent = new Node(e);
				Parent.rightChild = stack.pop();
				Parent.leftChild = stack.pop();
				stack.push(Parent);

			}	
		}
		output = stack.pop();
	}
	//method to see if operator
	private static int order(String e) {
		switch(e){
		case "-":
			return 1;
		case "+":
			return 2;
		case "/":
			return 3;
		case "*":
			return 4;
		case "^":
			return 5;
		}
		return -1;
	}
	
	public static void infix(Node t) {
		if(t != null) {
			if(t.leftChild != null) {
				System.out.print("(");
			}
			infix(t.leftChild);
			
			System.out.print(t);
			
			infix(t.rightChild);
			
			if(t.rightChild != null) {
				System.out.print(")");
			}
			
		}
	}
	
	public static void prefix(Node t) {
		if(t != null) {
			System.out.print(t);
			
			prefix(t.leftChild);
			
			prefix(t.rightChild);
		}
	}
	
	public static void postfix(Node t) {
		if(t != null) {
			postfix(t.leftChild);
			
			postfix(t.rightChild);
			
			System.out.print(t);
		}
	}
}
