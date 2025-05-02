package photoManagementApplication;

public class PhotoManager 
{  
	
    private LinkedList<Photo> photos;  
    
    
    
    public PhotoManager() 
    {  
        photos = new LinkedList<Photo>();  
    }  
    
     
    public void addPhoto(Photo p) 
    {  
    	
        if (!photos.empty()) 
        {  
            photos.FindFirst(); 
            
            while (true) 
            {  
                if (photos.retrieve().getPath().equals(p.getPath())) 
                {  
                    return; // Photo already exists  
                }  
                
                if (photos.last()) 
                {  
                    break;  
                }  
                
                photos.findNext();  
            }  
        }  
        
        photos.insert(p);  
    }  
    
    
    
      
    public void deletePhoto(String path) 
    { 
    	
        if (photos.empty()) 
        {  
            return;  
        }  
        
        photos.FindFirst(); 
        
        while (true) 
        {  
            if (photos.retrieve().getPath().equals(path)) 
            {  
                photos.remove();  
                return;  
            }  
            
            if (photos.last())
            {  
                break;  
            }  
            
            photos.findNext();  
        }  
        
        
    }  
    
    
    
     
    public Photo findPhoto(String path) 
    {  
        if (photos.empty()) 
        {  
            return null;  
        }  
        
        photos.FindFirst(); 
        
        while (true) 
        {  
            Photo currentPhoto = photos.retrieve();
            
            if (currentPhoto.getPath().equals(path)) 
            {  
                return currentPhoto;  
            }  
            
            if (photos.last()) 
            {  
                break;  
            }  
            
            photos.findNext();  
        }  
        
        return null;  
    }  
    
    
    
    public LinkedList<Photo> getPhotos() 
    {  
        return photos;  
    }  
    
    
    
      
    public LinkedList<Photo> getPhotos(String[] tags) // Get photos that satisfy all the conditions (tags).
    {  
        LinkedList<Photo> result = new LinkedList<Photo>();  
        
        if (photos.empty() || tags.length == 0) 
        {  
            return result;  
        }  
        
        photos.FindFirst();  
        
        do 
        {  
        	
            Photo currentPhoto = photos.retrieve();  
            
            boolean allTagsPresent = true;  
            
            for (String tag : tags) 
            {  
            	
                boolean hasTag = false; 
                
                LinkedList<String> photoTags = currentPhoto.getTags();  
                
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
                    allTagsPresent = false;  
                    break;  
                }  
            }  
            
            if (allTagsPresent) 
            {  
                result.insert(currentPhoto);  
            }  
            
            if (photos.last())
            {  
                break;  
            }  
            
            photos.findNext(); 
            
        } while (true); 
        
        
        return result;  
        
    }  
    
}  
