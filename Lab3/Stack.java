


public class Stack{
	
	int upperLimit = 5;
	int lastPosition;
	double arr[] = new double[upperLimit];
	
	//constructor
	public Stack(){
		//begin with empty stack
		lastPosition = -1;
	}

	
	public boolean isEmpty(){
		if(lastPosition < 0){
			System.out.println("Empty");
			return true;
		}else{
			System.out.println("Not empty");
			return false;
		}
	}
	
	
	public boolean push(Double x){
		if(lastPosition >= (upperLimit-1)){
			System.out.println("To many elements in stack");
			return false;
		}else{
			arr[lastPosition+1] = x;
			lastPosition++;
			System.out.println(x + " was pushed to stack at position " + lastPosition);
			return true;
		}
	
	}
	
	public Double pop(){
		if(lastPosition < 0){
			System.out.println("The stack is empty");
			return null;
		}else{
			double x = arr[lastPosition];
			lastPosition--;
			System.out.println(x + " was popped from position " + (lastPosition+1));
			return x;
		}
	}
	
}