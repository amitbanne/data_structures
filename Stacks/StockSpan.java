package stack;

public class StockSpan {
	
	// keeps track of the top element of the stack
	StackNode top;

	/* push() adds a new element to the stack and
	 * the new element becomes the top of the stack */
	public void push(int data) {
		StackNode newNode = new StackNode(data);

		if (top == null)
			top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}

	}

	/* pop() removes the element at the top of the stack */
	public int pop() {

		if (top == null) {
			System.out.println("No elements present in stack");
			return -1;
		}

		StackNode popped = top;
		top = top.next;
		return popped.data;
	}

	/* isStackEmpty() determines if the stack is empty.
	 * If top of the stack points to null, then stack is empty.
	 * Otherwise, stack is not empty. */
	public boolean isStackEmpty() {
		return (top == null);
	}

	
	/* stockSpan() method determines the stock span of each element. 
	 * The stock span of each element is count of number previous of elements
	 * that are less than the current element until an element 
	 * greater than current element is encountered. 
	 * 
	 * The count includes the current element as well.
	 * 
	 * Eg:
	 * {2, 5, 4, 9}
	 * 
	 *  For 2, span is 1.
	 *  For 5, span is 2.
	 *  FOr 4, span is 1.
	 *  For 9, span is 4. */	
	public int[] stockSpan(int[] input){

		int[] output = new int[input.length]; 
		output[0] = 1;
		this.push(0);

		for(int i =1; i< input.length;i++){

			while(!this.isStackEmpty() && input[this.top.data] <= input[i])
				this.pop();
			
			output[i] = (this.isStackEmpty() ? (i+1):(i-this.top.data));
			
			this.push(i);

		}
				
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StockSpan sp = new StockSpan();
		int[] input = {10, 4, 5, 90, 120, 80};
		int[] output =  sp.stockSpan(input);
		
		for(int i: output)
			System.out.print(i+" ");
		
		
	}

}
