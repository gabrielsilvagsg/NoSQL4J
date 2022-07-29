package com.br.gabrielsilva.nosql4j.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.br.gabrielsilva.nosql4j.NoSQL4J;
import com.br.gabrielsilva.nosql4j.document.Document;
import com.br.gabrielsilva.nosql4j.exceptions.DocumentLoadException;
import com.br.gabrielsilva.nosql4j.utility.MachineController;

public class DocumentManager {

	public static Document getDocument(String documentName, String tableName) throws DocumentLoadException {
		if (!TableManager.existTable(tableName)) {
			throw new DocumentLoadException("Non-existent table");
		}

		File file = getFile(tableName, documentName);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				throw new DocumentLoadException("An error occurred on create Document -> " + ex.getLocalizedMessage());
			}
		}
		
		Document document = new Document(documentName, tableName);

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			while (bufferedReader.ready()) {
				String line = bufferedReader.readLine();
				
				if (line.contains(":")) {
					String key = line.split(":")[0], 
							value = line.split(":")[1];
					
					document.getHash().put(key, value);
				}
			}
			
			bufferedReader.close();
			bufferedReader = null;
		} catch (IOException ex) {
			document = null;
			throw new DocumentLoadException("An error occurred on load Document -> " + ex.getLocalizedMessage());
		}

		return document;
	}
	
	public static void save(Document document) {
		if (!TableManager.existTable(document.getTableName())) {
			return;
		}
		
		File file = getFile(document.getTableName(), document.getDocumentName());
		
		try {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException ex) {
					return;
				}
			} else {
				if (!file.delete()) {
					return;
				}
				try {
					file.createNewFile();
				} catch (IOException ex) {
					return;
				}
			}
			
	        FileWriter fileWriter = new FileWriter(file, true);
	        PrintWriter printWriter = new PrintWriter(fileWriter);
	           
	        for (String key : document.getHash().keySet()) {
	        	printWriter.println(key + ":" + document.getHash().get(key));
	        }
	        
	        printWriter.flush();
	        printWriter.close();
	        
	        fileWriter.close();
	        
	        printWriter = null;
	        fileWriter = null;
		} catch (IOException ex) {
			NoSQL4J.console("An error occurred on save Document -> " + ex.getLocalizedMessage());
		}
	}
	
	public static File getFile(final String tableName, final String documentName) {
		File file = new File(MachineController.getDatabaseDirectory() + MachineController.getSplitter() + tableName.toLowerCase(),
				documentName.toLowerCase() + ".nosql4j");
		return file;
	}
}