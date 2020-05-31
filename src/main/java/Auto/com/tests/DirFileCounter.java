package Auto.com.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirFileCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*File directory=new File("C:\\Users\\mdonagapura\\Desktop\\spring-tool-suite-3.9.6.RELEASE-e4.9.0-win32-x86_64\\sts-bundle\\sts-3.9.6.RELEASE\\Automation1\\CMS\\Report");
	    int fileCount=directory.list().length;
	    System.out.println("File Count:"+fileCount);
	    
	    
	    
	    
	    for(int i=1;i<fileCount;i++) {
	    	
	    	String fileName=(String) directory.getName();
	    	System.out.println(fileName);
	    	*/
		
		List<String> fileNames = new ArrayList();
		System.out.println(fileNames);
	    try {
	      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:\\Users\\mdonagapura\\Desktop\\spring-tool-suite-3.9.6.RELEASE-e4.9.0-win32-x86_64\\sts-bundle\\sts-3.9.6.RELEASE\\Automation1\\CMS\\Report"));
	      for (Path path : directoryStream) {
	        fileNames.add(path.toString());
	      }
	    } catch (IOException ex) {
	    }
	    System.out.println("File Count:"+fileNames.size());
	    
	    	
	    }

	}


