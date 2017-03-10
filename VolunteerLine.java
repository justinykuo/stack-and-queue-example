import java.util.NoSuchElementException;

public class VolunteerLine implements VolunteerLineInterface{

	public MyQueue<Volunteer> line = new MyQueue<Volunteer>();
	
	@Override
	public boolean addNewVoluneer(Volunteer v) {
		return line.enqueue(v);
	}

	@Override
	public Volunteer volunteerTurn() throws NoSuchElementException {
		if(line.isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return line.dequeue();
		}
	}

	@Override
	public boolean volunteerLineEmpty() {
		return line.isEmpty();
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		Object[] objectArray = new Object[5];
		Volunteer[] volunteerArray = new Volunteer[5];
		objectArray = line.toArray();
		for(int i = 0; i < objectArray.length; i++){
			volunteerArray[i] = (Volunteer)objectArray[i];
		}
		return volunteerArray;
	}

	public int size(){
		return line.size();
	}
}
