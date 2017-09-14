package inmemory.file.system;

public class FileSystem {
	// current open folder
	private Folder folder;
	private String pathFolder;
	
	public FileSystem() {
		folder = new Folder("root", null);
		pathFolder = "root";
	}
	
	// read
	public String getPath() {
		return this.pathFolder;
	}
	
	public String[] listView() {		
		String[] subFoldersName = this.folder.getSubfolders();
		String[] subFilesName = this.folder.getFiles();
		
		int countFolders = subFoldersName.length;
		int countFiles = subFilesName.length;
		
		String[] str = new String[countFolders + countFiles];
		
		for(int i = 0; i < countFolders; i++) {
			str[i] = "folder -> " + subFoldersName[i];
		}
		
		for(int i = countFolders; i < countFolders + countFiles; i++) {
			str[i] = "file -> " + subFoldersName[i - countFolders];
		}
		
		return str;		
	}
	
	// write
	public void createFolder(String name) {
		// createFolder and enter it
		Folder nf = new Folder(name, this.folder);
		this.folder.addSubFolder(nf);
		enterFolder(name);
	}
	
	public void createFile(String name, String content, String type) {
		File file = new File(name, this.folder, content, type);
		this.folder.addFile(file);
	}
	
	
	// navigation 
	public void enterFolder(String name) {
		this.folder = folder.getSubfolder(name);
		this.pathFolder = this.pathFolder + "/" + name; 
	}
	
	public void backFolder() {
		// back folder
		this.folder = this.folder.parent;
		
		// change path
		String[] path = this.pathFolder.split("/");
		String[] newPath = new String[path.length - 1];

		for(int i = 0; i < path.length - 1; i++) {
			newPath[i] = path[i] + "/";
		}
		
		this.pathFolder = path.toString();
	}
}
