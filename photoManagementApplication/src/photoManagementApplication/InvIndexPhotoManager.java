public class InvIndexPhotoManager 
{  
	
    private BST<LinkedList<Photo>> tagIndex; // this is where we maps tags to photos that have that tag.  
    
    private LinkedList<Photo> allPhotos; // this is to track all photos in the system. 
    
    
    
    public InvIndexPhotoManager() 
    
    {  
        tagIndex = new BST<LinkedList<Photo>>();  
        allPhotos = new LinkedList<Photo>();  
    }  
    
    
    
      
    public void addPhoto(Photo p) 
    {  
        // firsrt we check if the photo (p) already exists.
    	
        if (!allPhotos.empty()) 
        {  
        	
            allPhotos.FindFirst();  
            
            while (true) 
            {  
                if (allPhotos.retrieve().getPath().equals(p.getPath())) 
                {  
                    return; // The photo already exists.  
                }  
                
                if (allPhotos.last()) 
                {  
                    break;  
                }  
                
                allPhotos.findNext();  
                
            }  
            
        }  
        
        // Now we add (p) to the main list (allPhotos).  
        allPhotos.insert(p);  
        
        
        // Now we add (p) to the inverted index for each tag the photo contains.
        
        LinkedList<String> tags = p.getTags();  // We extract the tags from the photo.
        
        if (!tags.empty()) 
        {  
            tags.FindFirst(); 
            
            do 
            {  
                String tag = tags.retrieve();  
                
                addPhotoToTagIndex(tag, p);  // This is a few methods down and it's the heart of the add process.
                
                if (tags.last()) 
                {  
                    break;  
                }  
                
                tags.findNext(); 
                
            } while (true); 
            
        }  
        
    }  
    
    
    
    
    public void deletePhoto(String path) 
    {  
        // First we find the photo in the main list(allPhotos). 
    	
        Photo photoToDelete = null;  // A temporary container for the targeted photo's info.
        
        if (!allPhotos.empty()) 
        {  
            allPhotos.FindFirst();  
            
            while (true) 
            {  
                Photo current = allPhotos.retrieve();
                
                if (current.getPath().equals(path)) 
                {  
                    photoToDelete = current;  // to save the tags in the photo to use them later in the BST deletion.
                    allPhotos.remove();  
                    break;  
                }  
                
                if (allPhotos.last())
                {  
                    break;  
                }  
                
                allPhotos.findNext();  
                
            }  
            
        }  
        
        if (photoToDelete == null) 
        {  
            return; // The photo is not found.  
        }  
        
        // Now we remove from the inverted index.
        
        LinkedList<String> tags = photoToDelete.getTags();  
        
        if (!tags.empty()) 
        {  
            tags.FindFirst();
            
            do 
            {  
                String tag = tags.retrieve();  
                
                removePhotoFromTagIndex(tag, photoToDelete);  //The last method in the code. 
                
                if (tags.last()) 
                {  
                    break;  
                }  
                
                tags.findNext();  
                
            } while (true);  
            
        }  
        
    }  
    
    
     
    public Photo findPhoto(String path) // A straight forward search method.
    {  
        if (allPhotos.empty()) 
        {  
            return null;  
        }  
        
        allPhotos.FindFirst();
        
        while (true) 
        {  
            Photo currentPhoto = allPhotos.retrieve();
            
            if (currentPhoto.getPath().equals(path)) 
            {  
                return currentPhoto;  
            }  
            
            if (allPhotos.last()) 
            {  
                break;  
            }  
            
            allPhotos.findNext(); 
            
        }  
        
        return null;  
        
    }  
    
    
   
    public LinkedList<Photo> getAllPhotos() 
    {  
        return allPhotos;  
    }  
    
    
    
      
    public BST<LinkedList<Photo>> getPhotos() // Returns the whole inverted index.
    {  
        return tagIndex;  
    }  
    
    
   /* After scouring the internet looking for an optimal solution, I found a technique 
    * Used in query optimization (the enhancement of information retrieval processes)
    * which says if you have a photo album that contains 1000 photos, and you're asked to fetch all 
    * the photos that contain a sky AND bodies of water, and all the photos that contain grass AND bodies of water.
    * Now, if you're given this information:
    * 
    * The number of photos that have sky in them is 380. 
    * The number of photos that have grass in them is 490.
    * The number of photos that have bodies of water in them is 130.
    * 
    * The worst thing you can do is to go through every photo in the album and check it for these conditions. Instead
    * you should start with the smallest group of photos that satisfy a condition 
    * (in this example: photos that contain bodies of water) then cross-reference them 
    * with the other condition (AND grass, AND sky).
   */
    public LinkedList<Photo> getPhotos(String[] tags) // Returns the photos that satisfy all the conditions (tags).
    {  
        LinkedList<Photo> result = new LinkedList<Photo>();  
        
        
        if (tags.length == 0) 
        {  
            return result;  
        }  
        
        // Find the tag with the smallest photo list.
        
        String smallestTag = findSmallestTagList(tags); 
        
        
        /* 
           If any tag doesn't exist in our index (findSmallestTagList returned null),  
           return the empty result immediately.
        */
        if (smallestTag == null) 
        {  
            return result; 
        }  
        
        
          
        tagIndex.findKey(smallestTag);  
        
        LinkedList<Photo> startList = tagIndex.retrieve();  
        
        if (!startList.empty()) 
        {  
            startList.FindFirst(); 
            
            do 
            {  
                Photo p = startList.retrieve();
                // Set the flag to "true" as a base case.
                boolean hasAllTags = true;  
                
                // Check if the current photo has all the other required tags. 
                for (String tag : tags) 
                {  
                	// Skip checking the smallest tag (because we already know the photo has it).
                    if (!tag.equals(smallestTag)) 
                    {  
                        LinkedList<String> photoTags = p.getTags(); 
                        
                        // We assume the photo doesn't have this tag until we find it.
                        boolean hasTag = false;  
                        
                        if (!photoTags.empty()) 
                        {  
                            photoTags.FindFirst();  
                            
                            do 
                            {  
                                if (photoTags.retrieve().equals(tag)) 
                                {  
                                    hasTag = true;  
                                    break;  
                                }  
                                
                                if (photoTags.last())
                                {  
                                    break;  
                                }  
                                
                                photoTags.findNext(); 
                                
                            } while (true);  
                            
                        }  
                        
                        
                        if (!hasTag) 
                        {  
                            hasAllTags = false;  
                            break;  
                        }  
                        
                    }  
                    
                }  
                
                if (hasAllTags) 
                {  
                    result.insert(p);  
                }  
                
                if (startList.last()) 
                {  
                    break;  
                }  
                
                startList.findNext();
                
            } while (true);  
            
        }  
        
        return result;  
    }  
    
  
    
    private String findSmallestTagList(String[] tags) 
    {  
    	
        String smallestTag = null;
        
        // We start with maximum possible value to ensure first tag is smaller.
        int smallestSize = Integer.MAX_VALUE;  
        
        // We check each tag to find the one with the least number of photos. 
        for (String tag : tags) 
        {  
            if (!tagIndex.findKey(tag)) 
            {  
                return null; // This tag doesn't exist  
            }  
            
            LinkedList<Photo> photoList = tagIndex.retrieve(); 
            
            int size = countPhotos(photoList);  
            
            if (size < smallestSize)
            {  
                smallestSize = size;  
                smallestTag = tag;  
            }  
            
        }  
        
        // Return the tag with the least number of associated photos.
        return smallestTag;  
        
    }  
    
    
     // A common counting method.
    private int countPhotos(LinkedList<Photo> photoList) 
    {  
        if (photoList.empty()) 
        {  
            return 0;  
        }  
        
        int count = 0;  
        photoList.FindFirst();  
        do 
        {  
            count++;
            
            if (photoList.last()) 
            {  
                break;  
            }  
            
            photoList.findNext();  
            
        } while (true);  
        
        return count;  
        
    }  
    
      
    private void addPhotoToTagIndex(String tag, Photo p) // The heart of inverted index addition. 
    {  
        LinkedList<Photo> photoList;  
        
        if (tagIndex.findKey(tag)) 
        {  
            photoList = tagIndex.retrieve();  
        } 
        
        else 
        {  
            photoList = new LinkedList<Photo>();  
            tagIndex.insert(tag, photoList);  
        }  
        
        // Now we check if the photo already exists in this list.  
        boolean exists = false;  
        
        if (!photoList.empty()) 
        {  
            photoList.FindFirst();  
            do 
            {  
                if (photoList.retrieve().getPath().equals(p.getPath()))
                {  
                    exists = true;  
                    break;  
                }  
                
                if (photoList.last()) 
                {  
                    break;  
                }  
                
                photoList.findNext(); 
                
            } while (true);  
            
        }  
        
        if (!exists) 
        {  
            photoList.insert(p);  
        }  
        
        
    }  
    
    
      
    private void removePhotoFromTagIndex(String tag, Photo p) // A helper method to remove a photo from a tag's index.
    {  
    	// We check if the tag exists in our index, if it does, then the next step is retrieval.
        if (!tagIndex.findKey(tag)) 
        {  
            return;  
        }  
        
     
        LinkedList<Photo> photoList = tagIndex.retrieve();  
        
        if (photoList.empty()) 
        {  
            return;  
        }  
        
        photoList.FindFirst(); 
        
        do 
        {  
            if (photoList.retrieve().getPath().equals(p.getPath())) 
            {  
                photoList.remove();  
                
                  
                if (photoList.empty()) 
                {  
                	// If removing this photo made the tag's list empty, remove the tag entirely from the index.
                    tagIndex.removeKey(tag);  
                }  
                
                return;  
            }  
            
            if (photoList.last()) 
            {  
                break;  
            }  
            
            photoList.findNext(); 
            
        } while (true);  
        
        
    }  
    
    
    
  
}
