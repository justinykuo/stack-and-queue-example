import java.util.LinkedList;

public class MyStack<T> implements StackInterface<T>{
	
	private LinkedList<T> stack = new LinkedList<T>();

	private int MAX_SIZE = 5;
	
	@Override
	public boolean isEmpty() {
		//Similar to queue in all aspects except stacks are LIFO
		return (stack.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (stack.size() == MAX_SIZE);
	}

	@Override
	public T pop() {
		// Because it is a stack we remove the last from the list
		return stack.removeLast();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean push(T e) {
		if(stack.size() >= MAX_SIZE){
			return false;
		}
		else 
			// Add at end because stacks are LIFO
			stack.addLast(e);
			return true;
		
	}

	@Override
	public T[] toArray() {
		T[] results =  (T[]) new Object[MAX_SIZE];
		if(stack.isEmpty()){
			return null;
		}
		else{
		for(int i = 0; i < stack.size(); i++){
			results[i] = stack.get(i);
		}
		return results;
	}
	}

}
