
import java.util.Scanner;

public class RPN{
	
	
	public static void evaluateRPN (String input){
		Stack stack = new Stack();
		// \\s+ means that we split on whitespace
		for(String symbol : input.split("\\s+")){
			switch(symbol){
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					stack.push( -stack.pop() + stack.pop());
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					Double denom = stack.pop();
					stack.push(stack.pop() / denom);
					break;
				case "=":
					System.out.println("\nResult: " + stack.pop());
					break;
				case "q":
					System.exit(0);
				default:
					stack.push(Double.parseDouble(symbol));
					break;
			}
		}
	}


	public static void main(String[] args) {
		String input;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\nWrite \"q\" to quit");
		
		while(true){
			System.out.println("\nWrite an RPN expression: ");
			evaluateRPN(keyboard.nextLine());
		}
    }

}