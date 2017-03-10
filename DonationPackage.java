
public class DonationPackage {
	
	public String description;
	public double weight;
	
	public DonationPackage(){
		
	}
	
	public DonationPackage(String description, double weight){
		this.description = description;
		this.weight = weight;
	}
	
	public String toString(){
		return description;
	}

}
