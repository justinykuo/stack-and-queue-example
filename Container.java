import java.util.EmptyStackException;


public class Container implements ContainerInterface{
	
	public MyStack<DonationPackage> container = new MyStack<DonationPackage>();

	@Override
	public boolean loadContainer(DonationPackage dPackage) {
		return (container.push(dPackage));
	}

	@Override
	public DonationPackage removePackageFromContainer() throws EmptyStackException {
		if(container.isEmpty()){
			throw new EmptyStackException();
		}
		else{
			return (container.pop());
		}
	}

	@Override
	public DonationPackage[] toArrayPackage() {
		Object[] objectArray = new Object[5];
		DonationPackage[] packageArray = new DonationPackage[5];
		objectArray = container.toArray();
		for(int i = 0; i < objectArray.length; i++){
			packageArray[i] = (DonationPackage)objectArray[i];
		}
		return packageArray;
	}
	
	
	public int size(){
		return container.size();
	}
	
	public boolean isEmpty(){
		return container.isEmpty();
	}
	
	public boolean isFull(){
		return container.isFull();
	}

}
