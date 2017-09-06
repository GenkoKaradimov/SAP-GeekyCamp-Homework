package inmemory.file.system;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileSystem {
	private Folder folder;
	private File file;
	private String pathFolder;
	
	public FileSystem() {
		folder = new Folder("root", null, null, null);
		pathFolder = "root";
	}
	
	public String getPath() {
		return this.pathFolder;
	}
	
	// navigation
	public void enterFolder(String name) {
		this.folder = folder.getSubfolder(name);
		this.pathFolder = this.pathFolder + "\\" + name; 
	}
	
	public void backFolder() {
		this.folder = this.folder.parent;
		String[] path = this.pathFolder.split("\\");
		String[] newPath = new String[path.length - 1];
		for(int i = 0; i < path.length; i++) {
			newPath[i] = path[i];
		}
	}
	
	public void setFile(String name) {
		this.file = this.folder.getFile(name);
	}
}
