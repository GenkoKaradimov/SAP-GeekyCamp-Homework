package inmemory.file.system;

import java.util.Date;

public abstract class BaseObject {
	protected String name;
	protected Date created;
	protected Folder parent;
	
	public BaseObject(String name, Folder parent) {
		this.name = name;
		this.created = new Date();
		this.parent = parent;
	}
	
	public Folder getParent() {
		return this.parent;
	}
	
	public void rename(String name) {
		this.name = name;
	}
	
	public String getDateCreated() {
		return this.created.toString();
	}
}