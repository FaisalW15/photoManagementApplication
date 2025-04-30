package photoManagementApplication;

public class Album {
	
	
	String name;
	String condition;
	PhotoManager photoManager;
	
	
	
	
	// Constructor
	public Album(String name, String condition, PhotoManager photoManager) {
	 this.name = name;
	 this.condition = condition;
	 this.photoManager = photoManager;
	}
	
	
	
	
	 // Return the name of the album
	public String getName() {
		return name;
	}
	// Return the condition associated with the album
	public String getCondition() {
		return condition;
	}
	// Return the manager
	public PhotoManager getManager() {
		return photoManager;
	}
	// Return all photos that satisfy the album condition
	public LinkedList<Photo> getPhotos(){
		
	}
	// Return the number of tag comparisons used to find all photos of the album
	public int getNbComps() {
		
	}
	
	
	
	//additional methods
	
	
	}
