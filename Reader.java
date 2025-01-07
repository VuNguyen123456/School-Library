public class Reader {
	private String fullName;
	private int yearOfBirth;
	private int zipCode;
	
	
	// setter
	public void setFullName(String fullName){
		//Name must be between 3 - 20 character
		if(fullName.length() >= 3 && fullName.length()<= 20){
			this.fullName = fullName;
		}
	}
	public void setYearOfBirth(int yearOfBirth){
		//Must be born between 1923 and 2013
		if(yearOfBirth >= 1923 && yearOfBirth <= 2013){
			this.yearOfBirth = yearOfBirth;
		}
	}
	public void setZipCode(int zipCode){
		//Must have valid zipCode
		if(zipCode >= 10000 && zipCode <= 99999){
			this.zipCode = zipCode;
		}
	}
	
	// getter
	public String getFullName(){
		return fullName;
	}
	public int getYearOfBirth(){
		return yearOfBirth;
	}
	public int getZipCode(){
		return zipCode;
	}
	
	// constructor
	public Reader(String fullName, int yearOfBirth, int zipCode){
		if(fullName.length() >= 3 && fullName.length()<= 20){
			this.fullName = fullName;
		}
		if(yearOfBirth >= 1923 && yearOfBirth <= 2013){
			this.yearOfBirth = yearOfBirth;
		}
		if(zipCode >= 10000 && zipCode <= 99999){
			this.zipCode = zipCode;
		}
	}
	
}
