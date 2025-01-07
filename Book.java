public class Book{
	// field
	private String title;
	private String author;
	private int publicationYear;
	private float rating;
	private long isbn;
	private String status;
	private Reader[] readersHistory = null;
	private int[] ratingsHistory = null;
	
	// setter
	public void setTitle(String title){
		if(title != null && title.length() >= 2){
			this.title = title;
		}
	}
	public void setAuthor(String author){
		if((author != null) && author.length()>= 5){
			this.author = author;
		}
	}
	public void setPublicationYear(int publicationYear){
		if (publicationYear >= 1700 && publicationYear <= 2023) {
			this.publicationYear = publicationYear;
		}
	}
	public void setIsbn(long isbn){
		if(publicationYear < 2007 && (isbn >= 1000000000L && isbn <= 9999999999L)){
			this.isbn = isbn;
		}
		else if(publicationYear >= 2007 && (isbn >= 1000000000000L && isbn <= 9999999999999L)){
			this.isbn = isbn;
		}
	}
	public void setStatus(String status){
		if (status.equals("Available") || status.equals("Rented") || status.equals("Archived")) {
			if(this.status.equals("Archived") == false){
				this.status = status;
			}
		}
	}
	
					//private Reader[] readersHistory; haven't Validation rule!!!
					//private int[] ratingsHistory; haven't Validation rule !!!
					
	
	// getter
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public int getPublicationYear(){
		return publicationYear;
	}
	public float getRating(){
		rating = 0;
		float count = 0;
		if(ratingsHistory == null){
				ratingsHistory = new int[0];
			}
		if(ratingsHistory.length == 0){
			return 0;
		}
		//Get the average rating of the books that was rated by the reader in the rating history
		for(int i = 0; i < ratingsHistory.length;++i){
			if(ratingsHistory[i] != 0){
				rating += ratingsHistory[i];
				count += 1;
			}
		}
		rating = rating/count;
		return rating;
	}
	public long getIsbn(){
		return isbn;
	}
	public String getStatus(){
		return status;
	}

	// constructor
	
	public Book(String title, String author, int publicationYear, long isbn){
		//Title must have more than 2 character
		if(title != null && title.length() >= 2){
			this.title = title;
		}
		//Author name must have more than 4 character and it is not null
		if((author != null) && author.length()>= 5){
			this.author = author;
		}
		
		//PublicationYear must be between 1700 and 2023
		if (publicationYear >= 1700 && publicationYear <= 2023) {
			this.publicationYear = publicationYear;
		}
		
		//isbn correspoding to year of publishing
		if(publicationYear < 2007 && (isbn >= 1000000000L && isbn <= 9999999999L)){
			this.isbn = isbn;
		}
		else if(publicationYear >= 2007 && (isbn >= 1000000000000L && isbn <= 9999999999999L)){
			this.isbn = isbn;
		}
		//Set status to available
		status = "Available";
	}

	// methods
	public boolean archive(){
		//Set the book status to archived
		if(status.equals("Rented")){
			return false;
		}
		status = "Archived";
		if (status.equals("Archived")){
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean rent(Reader reader){
		//If the list is null make it an empty list
		if(readersHistory == null){
			readersHistory = new Reader[0];
		}
		//Create a new array with the new reader added on top of the reader history of the book
		if(status.equals("Available")){
			Reader[] temp = new Reader[readersHistory.length + 1];
			for (int i = 0; i < readersHistory.length; ++i){
				temp[i] = readersHistory[i];
			}
			readersHistory = temp;
			readersHistory[readersHistory.length-1] = reader;
			//Change book status to rent
			status = "Rented";
			//Make sure ratingsHistory have the same length as readersHistory
			if(ratingsHistory == null){
				ratingsHistory = new int[0];
			}
			int[] temp2 = new int[ratingsHistory.length + 1];
			for(int i = 0;i < ratingsHistory.length; ++i){
				temp2[i] = ratingsHistory[i];
			}
			ratingsHistory = temp2;
			return true;
		}
		else{
			return false;
		}
	}
	public Reader getLastReader(){
		// Return the last reader of the book
		if(readersHistory.length>=1){
			return readersHistory[readersHistory.length-1];
		}
		else{
		// If no one read it return null
			return null;
		}
	}
	
	public boolean addRating(Reader reader, int rating){
		// Add the rating of the book corresponse the the reader
		boolean bool = false;
		if (rating > 5 || rating < 1){
			rating = 0;
		}
		for(int i = (readersHistory.length-1); i >= 0 ; --i){
			if(readersHistory[i] == reader){
				ratingsHistory[i] = rating;
				return true;
			}
		}
		return bool;
	}
	
	public String toString(){
		// Return a string with information about the book
		String str = "\"" + title + "\"" + " by " + author + " (" + publicationYear +") " + "- Rating:" + rating + " - " + status;
		return str;
	}
	
	//Testinsnfngowbsf sajkd jfeadsnjkas fbas dfjha dshjlf 
	/*public void test(){
		for (int i = 0; i < readersHistory.length; ++i){
			System.out.println(readersHistory[i].getFullName());
		}
		for (int i = 0; i < ratingsHistory.length; ++i){
			System.out.println(ratingsHistory[i]);
		}
	}*/
	
}
