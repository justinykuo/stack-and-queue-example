import java.util.NoSuchElementException;


// Recipient line is a queue
public class RecipientLine implements RecipientLineInterface{

	public MyQueue<Recipient> line = new MyQueue<Recipient>();
	
	@Override
	public boolean addNewRecepient(Recipient rc) {
		return line.enqueue(rc);
	}

	@Override
	public Recipient recipientTurn() throws NoSuchElementException {
		if(line.isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return line.dequeue();
		}
	}

	@Override
	public boolean recipientLineEmpty() {
		return line.isEmpty();
	}

	// Cannot cast object to donation package, this is the workaround
	@Override
	public Recipient[] toArrayRecipient() {
		Object[] objectArray = new Object[5];
		Recipient[] recipientArray = new Recipient[5];
		objectArray = line.toArray();
		for(int i = 0; i < objectArray.length; i++){
			recipientArray[i] = (Recipient)objectArray[i];
		}
		return recipientArray;
	}
	
	public int size(){
		return line.size();
	}

}
