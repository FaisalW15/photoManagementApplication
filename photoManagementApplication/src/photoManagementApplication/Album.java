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
		
		
		//two linkedLists. The first one is "photoManagerPhotos" which is basically all the photos we have
		//and the "photos" list will be filled with the photos that satisfy the condition.
		LinkedList<Photo> photos = new LinkedList<Photo>();
		LinkedList<Photo> photoManagerPhotos = photoManager.getPhotos();
		
		
		
		//split condition and place each tag in between the word "AND" in an array called conditionArray.
		String[] conditionArray = condition.split("AND");
		for(int i = 0; i<conditionArray.length; i++) {
			
			//get rid of whitespaces before and after conditionArray[i].
			conditionArray[i] = conditionArray[i].trim();
		}
		
		//go through all photos and check if the conditionArray is a part of the photo we stopped at in photoManagerPhotos.
		//if it is, add it to "photos" list.
		photoManagerPhotos.FindFirst();
		while(!(photoManagerPhotos.last())) {
			
			if(isAPartOf(conditionArray, photoManagerPhotos.retrieve().getTags())) {
				photos.insert(photoManagerPhotos.retrieve());
			}
		}
		
		return photos;
		
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
		list.FindFirst();
		
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
    		
    		//if there are no falses returned, then array1 is a part of list1
    		if(!(isTagInPhoto(list1, array1[i]))) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
	}
