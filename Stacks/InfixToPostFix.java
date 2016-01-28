package stack;

public class InfixToPostFix {

	// keeps track of the top element of the stack
	StackNodeExp top;
	
	/* push() adds a new element to the stack and
	 * the new element becomes the top of the stack */
	public void push(char data){
		StackNodeExp newNode =  new StackNodeExp(data);
		
		if(top==null)
			top = newNode;
		else{
			newNode.next =  top;
			top = newNode;
		}
		
	}
	
	/* pop() removes the element at the top of the stack */
	public char pop(){
		
		if(top == null){
			System.out.println("No elements present in stack");
			return '\0';
		}
		
		StackNodeExp popped = top;
		top = top.next;
		return popped.data;
	}
	
	/* peek() returns the data of the top
	 * element of the stack */
	public char peek(){
		if(top == null){
			System.out.println("No elements present");
			return '\0';		
		}else{
			return top.data;
		}
			
	}
	
	/* isStackEmpty() determines if the stack is empty.
	 * If top of the stack points to null, then stack is empty.
	 * Otherwise, stack is not empty. */
	public boolean isStackEmpty(){
		return (top == null);
	}
	
	/* precedence() determines the precedence of the operator */
	public int precedence(char ch){
		switch(ch){
		case '+':
		case '-': return 1;
		
		case '*':
		case '/': return 2;
		
		case '^': return 3; 
		}
		return -1;
	}
	
	/* isOperand() determines if given character is an operand or not */
	public boolean isOperand(char ch){
		return ((ch >='a' && ch<='z')|| (ch >='A' && ch<='Z'));
	}
	
	/* infixToPostfix() converts the Infix expression to PostFix expression */
	public String infixToPostfix(String input){
		int k=-1;
		
		char[] temp =input.toCharArray();
		int count = 0;
		for(int i=0;i<temp.length;i++){
			if(temp[i] == '(')
				count++;
			else if(temp[i] == ')')
				count--;
		}
		
		if(count != 0)
			return "Paranthesis Mismatch";
		
		input = "";
		for(int i=0;i<temp.length;i++){
			
			if(isOperand(temp[i]))
				input+= temp[i];
			
			else if(temp[i] == '(')
				push(temp[i]);
			
			else if(temp[i] == ')'){
				
				while(!isStackEmpty() && peek() != '(')
					input+= pop();
				
				if(!isStackEmpty() && peek() != '(')
					return "Invalid Expression";
				
				pop();
				
			}else{
			
				while(!isStackEmpty() && precedence(temp[i]) <= precedence(peek()))
					input+= pop();
				
				push(temp[i]);
			}
		}
		
		while(!isStackEmpty())
			input+=pop();
		
		return input;
	}
	
	
	/* paranthesisBalance() checks if the paranthesis in the expression
	 * are balanced i.e. opening-closing pairs */
	public String paranthesisBalance(String input){
		
		for(int i=0; i< input.length(); i++){
			if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{')
				push(input.charAt(i));
			else if(input.charAt(i) == ')'){
				if(pop() != '(')
					return ") Mismatch";
			}else if(input.charAt(i) == '}'){
				if(pop() != '{')
					return "} Mismatch";
			}else if(input.charAt(i) == ']'){
				if(pop() != '[')
					return "] Mismatch";
			}
			
		}
		return input+" has matching paranthesis..";
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfixToPostFix exp = new InfixToPostFix();
		String input= "a/b+c/";
		System.out.println("Input: "+input);
		System.out.println("Output: "+exp.infixToPostfix(input));
		
		
		String input1 = "(a+b))";
		System.out.println(exp.paranthesisBalance(input1));
		
	}

}
