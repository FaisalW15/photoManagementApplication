package photoManagementApplication;

public class Photo {
	String path;
	LinkedList<String> tags;
	
	// Constructor
	public Photo(String path, LinkedList<String > tags) {
		this.path=path; 
		this.tags=tags;
	}
	
	public String getPath(){
	return path;
	}
	
	public LinkedList<String> getTags(){
	return tags;}
	
	//added helpping methods
	public void display() {
		System.out.println("path="+path);
		System.out.print("tags is: ");
			tags.display();
	
	}
}
