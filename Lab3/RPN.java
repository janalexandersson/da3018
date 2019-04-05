
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
					stack.push(stack.pop() / stack.pop());
					break;
				case "=":
					System.out.println("Result: " + stack.pop());
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
		
		System.out.println("Write \"q\" to quit");
		
		while(true){
			System.out.println("Write an RPN expression: ");
			evaluateRPN(keyboard.nextLine());
		}
    }

}