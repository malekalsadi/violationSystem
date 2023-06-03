package classes;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.http.Part;

public class mediaHandler {
	public String saveMedia(Part filePart) {
		try {
			String fileName = filePart.getSubmittedFileName();
			String contentType = filePart.getContentType();
			InputStream fileContent = filePart.getInputStream();
			
			String filePath = "/Users/malekalsadi/Downloads/ProjectForWeb/src/main/webapp/image/" + fileName;
			File file = new File(filePath);
			if(file.exists()) {
				filePath = "/Users/malekalsadi/Downloads/ProjectForWeb/src/main/webapp/image/" + nameGenerator(fileName) + '.' + extractExtension(fileName); 
			}
//			String currentPath = System.getProperty("user.dir");
//		    System.out.println("Current Path: " + currentPath);
	        
		    Files.copy(fileContent, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
	        
	        return filePath;
	        
		}catch(Exception E) {
			E.printStackTrace();
		}
        return "failed";
	}
	private String nameGenerator(String fileName) {
		 String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	        String randomString = UUID.randomUUID().toString().replace("-", "");       
	        return timestamp + randomString;
	}
	
	private String extractExtension(String fileName) {
		 String fileExtension = "";
	     int extensionIndex = fileName.lastIndexOf(".");
	     if (extensionIndex != -1 && extensionIndex < fileName.length() - 1) {
	    	 fileExtension = fileName.substring(extensionIndex + 1);
	     }
	     return fileExtension;     
	}
}
