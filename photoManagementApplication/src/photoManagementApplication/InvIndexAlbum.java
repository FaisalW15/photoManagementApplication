package photoManagementApplication;

public class InvIndexAlbum {
	
	String name;
	String condition;
	InvIndexPhotoManager invIndexPhotoManager;
	
	
	public InvIndexAlbum(String name, String condition, InvIndexPhotoManager invINdexPhotoManager) {
		
		this.name = name;
		this.condition = condition;
		this.invIndexPhotoManager = invIndexPhotoManager;
		
	}
	
	//return name of album
	public String getname() {
		return name;
	}
	
	//return condition associated with the album
	public String getCondition() {
		return condition;
	}

    //return the manager
	public InvIndexPhotoManager getManager() {
		return invIndexPhotoManager;
	}
	
	
	
	//nearly same as LinkedList version
	public LinkedList<Photo> getPhotos(){
		
		
		//two linkedLists. The first one is "photoManagerPhotos" which is basically all the photos we have
		//and the "photos" list will be filled with the photos that satisfy the condition.
		//if no condition then return an empty linkedlist
		LinkedList<Photo> empty = new LinkedList<Photo>();	
		if(condition==null || condition.equals("")) {
			return empty;
		}
		
		
		//split condition and place each tag in between the word "AND" in an array called conditionArray.
		String[] conditionArray = condition.split("AND");
		for(int i = 0; i<conditionArray.length; i++) {
			
			//get rid of whitespaces before and after conditionArray[i].
			conditionArray[i] = conditionArray[i].trim();
		}
		
		//get all photos from the first tag
		LinkedList<Photo> photos = getTagPhotos(conditionArray[0]);
		
		//iterate through the conditionArray, and find the commonPhotos between the list photos and the list LL
		for (int i = 1; i<conditionArray.length; i++) {
			
			LinkedList<Photo> LL = getTagPhotos(conditionArray[i]);
			photos = commonPhotos(photos, LL);
		}

		return photos;
		
	}
	
	
	// Return all photos with this tag
	public LinkedList<Photo> getTagPhotos(String tag){

		//empty linkedList
		LinkedList<Photo> LL = new LinkedList<Photo>();
		
		//if we find a the tag entered, return the LinkedList in it (LL)
		if(invIndexPhotoManager.getPhotos().findKey1(tag)) {
			LL = invIndexPhotoManager.getPhotos().retrieve();
		}
		return LL;
	}
	
	
	//checks if a given photo is in the given linkedList
	public boolean isPhotoInList(LinkedList<Photo> LL, Photo photo) {
		
		if(LL.empty()) {
			return false;
		}
		
		LL.FindFirst();
		while(!(LL.last())) {
			if(LL.retrieve().path.equals(photo.path)) {
				return true;
			}
		LL.findNext();
		}
		
		//check last node
		if(LL.retrieve().path.equals(photo.path)) {
			return true;
		}
		return false;
	}
	
	
	//takes a linkedlist LL1 and a linkedlist LL2, and returns the nodes with the common photos present in both lists.
	public LinkedList<Photo> commonPhotos(LinkedList<Photo> LL1, LinkedList<Photo> LL2){
		
		LinkedList<Photo> commonPhotos = new LinkedList<Photo>();
		
		//check if either lists are empty.
		if (LL1.empty()){
			return commonPhotos;
		}
		if (LL2.empty()) {
			return commonPhotos;
		}
		
		LL1.FindFirst();
		boolean notFinished1 = true;
		
		
		//first while loop compares current node of LL1 with each and every node in LL2.
		//if comparison retruns true, add it to commonPhotos list, and let LL1 move to the next node and do the same thing.
		//break out of either while loops if we went through the whole list and found nothing
		while(notFinished1) {
			
			LL2.FindFirst();
			boolean notFinished2 = true;
			
			while(notFinished2) {
				if(isPhotoInList(LL2, LL1.retrieve())) {

					commonPhotos.insert(LL1.retrieve());
					break;
				}

				if(!LL2.last()) {
					LL2.findNext();	
				}
				else{
					break;
				}
			}
			
			if(!LL1.last()) {
				LL1.findNext();
			}
			else {
				break;
			}
		}
		return commonPhotos;
	}
	
	
	

}
