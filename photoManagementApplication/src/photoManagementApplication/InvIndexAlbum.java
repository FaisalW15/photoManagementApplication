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

}
