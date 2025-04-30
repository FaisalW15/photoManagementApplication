package photoManagementApplication;

public class Album {
	
	int numberOfComparisons = 0;
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
		return numberOfComparisons;
	}
	
	
	
	//additional methods
	
	//checks if a tag is in a photo
    public boolean isTagInPhoto(LinkedList<String> list, String tag) { //type must be resolved, use String instead of generic T.
	
    	
    	//check if list is empty.
		if(list.empty()) {
			return false;
		}
		
		//go to start of list
		list.findFirst();
		
		//go through list until the end, if the nodes data equals the tag then return true.
		while(!(list.last())) {
			
		//keep track of numberOfComparisons
			numberOfComparisons++;
			if(list.retrieve().equals(tag)) {
				return true;
			}
			
			list.findNext();
		}
		
		//check last node in list
		numberOfComparisons++;
		if(list.retrieve().equals(tag)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
    
    //checks if array1's tags are all present in list1
    public boolean isAPartOf(String[] array1, LinkedList<String> list1) {
    	
    	if(list1.empty()) {
    		return false;
    	}
    	
    	for(int i = 0; i<array1.length; i++) {
    		
    		if(!(isTagInPhoto(list1, array1[i]))) {
    			return false;
    		}
    	}
    	return true;
    }
    
	}
