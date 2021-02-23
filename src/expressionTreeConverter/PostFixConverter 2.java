package expressionTreeConverter;

import java.util.List;

public class PostFixConverter {
	
	private String input;
	private String output = "";
	
	PostFixConverter(String input) {
		this.input = input;
	}
	
	//returns order of operations
	public int order(String e) {
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
	
	
	public String toPostFix() {
		
		//turning input string into char array for ParserHelper
		char[] arrayInput = this.input.toCharArray();
		List<String> workingInput = ParserHelper.parse(arrayInput);
		
		LinkedStack<String> stack = new LinkedStack<>();
		
		String e = "";
		
		
		for(int i = 0; i < workingInput.size(); ++i) {
			e = workingInput.get(i);
			
			//if ( push to stack
			if (e.equals("(")) {
				stack.push(e);
			} 
			//if ) pop from stack until empty or (
			else if (e.equals(")")) {
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					output += stack.pop();
					output += " ";
				}
				stack.pop();
			} 
			//if operator pop from stack till precedence is lower
			else if (order(e) > 0){
				while (!stack.isEmpty() && order(e) <= order(stack.top())) {
					output += stack.pop();
					output += " ";
				}
				stack.push(e);
			} 
			//add number to output
			else {
				output += e;
				output += " ";
			}
		
		}
		//pop remaining objects from stack
		while (!stack.isEmpty()) {
			output += stack.pop();
			output += " ";
		}
		
		return output;
	}
}
