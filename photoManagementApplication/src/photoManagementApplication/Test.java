package photoManagementApplication;

public class Test {
	
	
	public static void main(String[] args) {
	

		PhotoManager manager = new PhotoManager();
		
		//photo1
		LinkedList<String> photo1tags = new LinkedList<String>();
		photo1tags.insert("animal");
		photo1tags.insert("hedgehog");
		photo1tags.insert("apple");
		photo1tags.insert("grass");
		photo1tags.insert("green");
		Photo photo1 = new Photo("hedgehog.jpg", photo1tags);
		manager.addPhoto(photo1);
		
		//photo2
		LinkedList<String> photo2tags = new LinkedList<String>();
		photo2tags.insert("animal");
		photo2tags.insert("bear");
		photo2tags.insert("cab");
		photo2tags.insert("grass");
		photo2tags.insert("wind");
		Photo photo2 = new Photo("bear.jpg",photo2tags);
		manager.addPhoto(photo2);
		
		//photo3
		LinkedList<String> photo3tags = new LinkedList<String>();
		photo3tags.insert("insect");
		photo3tags.insert("butterfly");
		photo3tags.insert("flower");
		photo3tags.insert("color");
		Photo photo3 = new Photo("orange-butterfly.jpg",photo3tags);
	    manager.addPhoto(photo3);
	    
	    //photo4
	    LinkedList<String> photo4tags = new LinkedList<String>();
		photo4tags.insert("insect");
		photo4tags.insert("butterfly");
		photo4tags.insert("flower");
		photo4tags.insert("black");
		Photo photo4 = new Photo("black butterfly.jpg", photo4tags);
		manager.addPhoto(photo4);
		
		//photo5
		LinkedList<String> photo5tags = new LinkedList<String>();
		photo5tags.insert("animal");
		photo5tags.insert("fox");
		photo5tags.insert("tree");
		photo5tags.insert("forest");
		photo5tags.insert("grass");
		Photo photo5 = new Photo("fox.jpg", photo5tags);
		manager.addPhoto(photo5);
		
		//photo6
		LinkedList<String> photo6tags = new LinkedList<String>();
		photo6tags.insert("animal");
		photo6tags.insert("bear");
		photo6tags.insert("panda");
		photo6tags.insert("grass");
		Photo photo6 = new Photo("panda.jpg", photo6tags);
		manager.addPhoto(photo6);
		
		//photo7
		LinkedList<String> photo7tags = new LinkedList<String>();
		photo7tags.insert("animal");
		photo7tags.insert("wolf");
		photo7tags.insert("snow");
		photo7tags.insert("cloud");
		Photo photo7 = new Photo("wolf.jpg", photo7tags);
		manager.addPhoto(photo7);
		
		//photo8
		LinkedList<String> photo8tags = new LinkedList<String>();
		photo7tags.insert("animal");
		photo7tags.insert("raccoon");
		photo7tags.insert("log");
		photo7tags.insert("snow");
		Photo photo8 = new Photo("racoon.jpg", photo8tags);
		manager.addPhoto(photo8);
		
		
		Album album1 = new Album("Album1", "bear", manager);
		Album album2 = new Album("Album2", "animal AND grass", manager);
		System.out.println("Get photo1 path and tags:");
		System.out.println("photo1 path: " + photo1.getPath());
		System.out.println("photo1 tags: ");
		photo1.printTags();

		//You can write a method that prints the list of tags of photo1.

		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("album2 name: " + album2.getName());
		System.out.println("album2 condition: " + album2.getCondition());
		System.out.print("album2 photos: ");
		album2.printPhotos();
		
		
		
		//You can get the list of photos in album2 by calling album2.getPhotos().
		//You can write a method that prints the list of photos in album2.
		System.out.println("Delete the photo ’bear.jpg’:");
	    manager.deletePhoto("bear.jpg");

	}
	
private static LinkedList<String> toTagsLinkedList(String tags) {
	
	LinkedList<String> result = new LinkedList<String>();
	String[] tagsArray = tags.split("\\s*,\\s*");
	for (int i = 0; i < tagsArray.length; i++) {
		result.insert(tagsArray[i]);
	}
return result;
}




}
