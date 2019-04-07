
//package Lab3;


public class StackNoArray {

	public StackNoArray() {
		//Constructor
	}
	
	private class StackElem {
		private double value = 0;
		private StackElem prev = null;
	
		StackElem(double d) {
			value = d;
		}
	}


	public int size = 0;
	private StackElem top = null;
		

	public double push(double d) {
		StackElem newTop = new StackElem(d);
		newTop.prev = this.top;
		this.size++;
		this.top = newTop;
		System.out.println(this.top.value + " was pushed to position " + this.size);
		return this.top.value;
	}
	
	
	
	public boolean isEmpty() {
		if (this.size == 0){
			return true;
		}else{
			return false;
		}
	}

	
	public double pop() {
		if( isEmpty()==true ) {
			System.err.println("You cannot pop an empty stack!");
			return 0;
		}
		
		double pop = this.top.value;
		this.top = this.top.prev;
		this.size--;
		System.out.println(pop + " was popped from position " + (this.size +1));
		return pop;
	}
}