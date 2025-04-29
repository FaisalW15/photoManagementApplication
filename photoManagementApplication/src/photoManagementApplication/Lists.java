package photoManagementApplication;

public interface Lists<T> {
	public void findfirst();
	public void findNext();
	public void insert(T e);
	public void update(T e);
	public void remove();
	public boolean full();
	public boolean last();
	public boolean empty();
	public T retrieve();

}
