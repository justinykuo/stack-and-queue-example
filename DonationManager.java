
public class DonationManager implements DonationManageInterface{
	
	public Container container = new Container();
	public VolunteerLine vLine = new VolunteerLine();
	public RecipientLine rLine = new RecipientLine();

	@Override
	public boolean ManagerLoadcontainer(DonationPackage dPackage) throws ContainerException {
		if(container.isFull()){
			throw new ContainerException("Container is full");
		}
		else{
			return container.loadContainer(dPackage);
		}
	}

	@Override
	public boolean ManagerQueueVolunteer(Volunteer v) throws VolunteerException {
		if(vLine.size() == 5){
			throw new VolunteerException("Volunteer line is full");
		}
		else{
			return vLine.addNewVoluneer(v);
		}
	}

	@Override
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException {
		if(rLine.size() == 5){
			throw new RecipientException("Recipient line is full");
		}
		else{
			return rLine.addNewRecepient(r);
		}
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @returns 1, if there are no volunteer, 2 if there are no recipients, 3 if container is empty, and 0 if the operation is successful
	 * 
	 */
	@Override
	public int donatePackage() {
		if(vLine.volunteerLineEmpty()){
			return 1;
		}
		if(rLine.recipientLineEmpty()){
			return 2;
		}
		if(container.isEmpty()){
			return 3;
		}
		else{
			// volunteer gets dequeued and then queued back
			Volunteer volAddBack = new Volunteer();
			volAddBack = vLine.volunteerTurn();
			container.removePackageFromContainer();
			rLine.recipientTurn();
			vLine.addNewVoluneer(volAddBack);
			return 0;
		}
	}
	
	/**
	 * To return the list of volunteers in array form
	 * @return an array of volunteers
	 */
	public Volunteer[] vLineToArr(){
		return vLine.toArrayVolunteer();
	}
	/**
	 * To return the list of recipients in array form
	 * @return an array of Recipients
	 */
	public Recipient[] rLineToArr(){
		return rLine.toArrayRecipient();
	}
	
	/**
	 * To return the list of packages in array form
	 * @return an array of DonationPackages
	 */
	public DonationPackage[] contToArr(){
		return container.toArrayPackage();
	}

}
