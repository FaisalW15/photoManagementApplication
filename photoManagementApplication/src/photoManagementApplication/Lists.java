package photoManagementApplication;

public interface Lists<T> {
	public void findfirst();
	public void findNext();
	public void findPrevious();
	public void insert(T e);
	public void update(T e);
	public void remove();
	public boolean full();
	public boolean last();
	public boolean empty();
	public boolean first();
	public T retrieve();

}
