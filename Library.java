public class Library{
	private String name;
	private String address;
	private Book[] books = null;

	
	// setter
	public void setName(String name){
		// Name length must be between 3 - 20 char
		if(name.length() >= 3 && name.length() <= 20){
			this.name = name;
		}
	}
	public void setAddress(String address){
		// Adress length must be between 10 - 25 char
		if(address.length() >= 10 && address.length() <= 25){
			this.address = address;
		}
	}
				//Books[] books: haven't Validation Rules !!!
				
	
	// getter
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	
	// constructor
	public Library(String name, String address){
		if(name.length() >= 3 && name.length() <= 20){
			this.name = name;
		}
		if(address.length() >= 10 && address.length() <= 25){
			this.address = address;
		}
	}
	// methods
	public Book[] getAvailableBooks(){
		if(books == null){
			books = new Book[0];
		}
		// Count how many archived book is in the library
		int count = 0;
		for (int i = 0; i < books.length; ++i){
			if(books[i].getStatus().equals("Archived")){
				count += 1;
			}
		}
		// List all the available books into a list and return it
		Book[] temp = new Book[books.length-count];
		int tempIndex =0;
		for (int i = 0; i < books.length; ++i){
			if(books[i].getStatus().equals("Available")){
				temp[tempIndex] = books[i];
				tempIndex += 1;
			}
			else{
				tempIndex += 0;
			}
		}
		return temp;
	}
	public boolean addBook(Book book){
		// Check if the book is already in there
		if(books == null){
			books = new Book[0];
		}
		for (int i = 0; i < books.length; ++i){
			if(books[i] == book){
				return false;
			}
		}
		// If status equals available add a book into the books array
		if (book.getStatus().equals("Available")){
			Book[] temp = new Book[books.length + 1];
			for (int i = 0; i < books.length; ++i){
				temp[i] = books[i];
			}
			books = temp;
			books[books.length-1] = book;
		}
		return true;
	}
	public boolean removeBook(Book book){
		if(books == null){
			books = new Book[0];
		}
		
		for(int i = 0; i < books.length; ++i){
			// Check if the status of the book equals archived
			if(books[i] == book && books[i].getStatus().equals("Archived")){
				// Create a same new array without the archived book and assign the original books array into it
				Book[] temp = new Book[books.length - 1];
				int indexTemp = 0;
				for(int j =0; j < books.length; ++j){
					if (books[j] != book){
						temp[indexTemp] = books[j];
						indexTemp += 1;
					}
					else if (books[j] == book){
						indexTemp += 0;
						continue;
					}
				}
				books = temp;
			}
		}
		// returning boolean 
		for(int i = 0; i < books.length; ++i){
			if(books[i] == book && books[i].getStatus().equals("Archived")){
				return true;
			}
		}
		return false;
	}
	public boolean rentBook(int i, Reader reader){
		if(books == null){
			books = new Book[0];
		}
		boolean bool = false;
		for (int j = 0; j < books.length; ++j) {
			// Letting the reader rent the i'th book in the array if the book status is available
			if (j+1 == i) {
				if (books[j].getStatus().equals("Available")){
					books[j].rent(reader);
					bool = true;
				}
				else{
					bool = false;
				}
			}
		}
		return bool;
	}
	public boolean returnBook(Book book, int rating){
		//Rating cant go past 5 so anything pass it will be 0
		if (rating > 5 || rating < 1){
			rating = 0;
		}
		//Reset the book status and add the rating to the rating history of the reader
		if (book.getStatus().equals("Rented")) {
			book.setStatus("Available");
			book.addRating(book.getLastReader(), rating);
			return true;
		}
		return false;
	}
	
	// Return a report about the library books
	public String toString(){
		if(books == null){
			books = new Book[0];
		}
		String str; 
		if(books.length <= 1){
			str = "Library "+ name +" has "+ books.length +" book available";
		}
		else{
			str = "Library "+ name +" has "+ books.length +" books available";
		}
		return str;
	} 
	public String displayBooks(){
		if(books == null){
			books = new Book[0];
		}
		//Display everybooks in the library to the fullest
		String str = "List of books:\n";
		for (int i = 0; i < books.length; ++i){
			str += "	";
			str += "\"" + books[i].getTitle() + "\"" + " by " + books[i].getAuthor() + " (" + books[i].getPublicationYear() +") " + "-- Rating:" + books[i].getRating()+ " -- " + books[i].getStatus() +"\n";
		}
		return str;
	}
}
