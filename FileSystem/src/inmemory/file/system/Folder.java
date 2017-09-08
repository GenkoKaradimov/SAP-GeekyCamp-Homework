package inmemory.file.system;

import java.util.List;

public class Folder extends BaseObject{
	protected List<Folder> subfolders;
	protected List<File> files;
	
	// create
	public Folder(String name, Folder parent,List<Folder> subfolders, List<File> files) {
		super(name, parent);
		this.subfolders = subfolders;
		this.files = files;
	}
	
	// read	
	public String more() {
		StringBuilder str = new StringBuilder();
		str.append(this.name);
		str.append(" ");
		str.append(this.created.toString());
		str.append(" subfolders:");
		str.append(subfolders.size());
		str.append(" files:");
		str.append(files.size());
		
		return str.toString();
	}
	
	public String[] getSubfolders() {
		int size = this.subfolders.size();
		String[] str = new String[size];
		
		for(int i = 0; i < size; i++) {
			str[i] = this.subfolders.get(i).toString();				
		}
		
		return str;
	}
	
	public String[] getFiles() {
		int size = this.files.size();
		String[] str = new String[size];
		
		for(int i = 0; i < size; i++) {
			str[i] = this.files.get(i).toString();				
		}
		
		return str;
	}
	
	public void addSubFolder(Folder folder) {
		this.subfolders.add(folder);
	}
	
	public void addFile(File file) {
		this.files.add(file);
	}
	
	// navigate
	
	public Folder getSubfolder(String name) {
		int size = this.subfolders.size();
		
		for(int i = 0; i < size; i++) {
			if(this.subfolders.get(i).name.equals(name)) {
				return this.subfolders.get(i);
			}				
		}
		
		return null;
	}
	
	public File getFile(String name) {
		int size = this.files.size();
		
		for(int i = 0; i < size; i++) {
			if(this.files.get(i).name.equals(name)) {
				return this.files.get(i);
			}
		}
		
		return null;
	}
}
