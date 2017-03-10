import java.util.LinkedList;

public class MyQueue<T> implements QueueInterface<T>{

	//Using a linked list for a generic queue
	
	private LinkedList<T> queue = new LinkedList<T>();
	private int MAX_SIZE = 5;
	
	
	@Override
	public boolean isEmpty() {
		return (queue.isEmpty());
	}

	// Because queues are first in first out then we just remove the first item to dequeue
	@Override
	public T dequeue() {
		return queue.remove();
	}

	@Override
	public int size() {
		return queue.size();
	}

	// Because the queue cannot be bigger than 5 we return false if it is trying to add a sixth
	@Override
	public boolean enqueue(T e) {
		if(queue.size() >= MAX_SIZE){
			return false;
		}
		else{
			queue.add(e);
			return true;
		}
	}
	

	@Override
	public T[] toArray() {
		T[] results = (T[]) new Object[5];
		if(queue.isEmpty()){
			return null;
		}
		else{
			for(int i = 0; i < queue.size(); i++){
				results[i] = queue.get(i);
		}
		return results;
		}
	}


}
