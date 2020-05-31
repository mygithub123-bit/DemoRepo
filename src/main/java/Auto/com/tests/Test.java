package Auto.com.tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class Test 
	
	{ 
	    public static void main(String[] args) throws IOException
	    { 
	        Path temp = Files.move 
	        (Paths.get("C:\\Users\\mdonagapura\\Desktop\\spring-tool-suite-3.9.6.RELEASE-e4.9.0-win32-x86_64\\sts-bundle\\sts-3.9.6.RELEASE\\Automation1\\CMS\\Wifispark1570680182034.html"),  
	        Paths.get("C:\\Users\\mdonagapura\\Desktop\\Wifispark1570680182034.html")); 
	  
	        if(temp != null) 
	        { 
	            System.out.println("File renamed and moved successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to move the file"); 
	        } 
	    } 
	} 



