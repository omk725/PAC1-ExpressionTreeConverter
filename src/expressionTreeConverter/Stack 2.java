package expressionTreeConverter;

public interface Stack<E> {
	
	//return size
	int size();
	
	//checks if stack is empty
	boolean isEmpty();
	
	//pushes an object on top of the stack
	void push(E e);
	
	//tells what is the top most object
	E top();
	
	//removes and returns the top most object
	E pop();
	
}
