package inmemory.file.system;

public class File extends BaseObject {
	protected String content;
	protected String type;
	
	// create
	public File(String name,Folder parent,  String content, String type) {
		super(name, parent);
		this.content = content;
		this.type = type;
	}	
	
	// read
	public String more() {
		StringBuilder str = new StringBuilder();
		str.append(this.name);
		str.append(" ");
		str.append(this.created.toString());
		str.append(" ");
		str.append(this.content);
		str.append(" ");
		str.append(this.type);
		str.append(" ");
		return str.toString();
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getType() {
		return this.content;
	}
	
	// update
	
	public void setContent(String newContent) {
		this.content = newContent;
	}
	
	public void setType(String newType) {
		this.type = newType;
	}
}
