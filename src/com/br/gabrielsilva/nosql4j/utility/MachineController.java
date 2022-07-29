package com.br.gabrielsilva.nosql4j.utility;

import java.io.File;

import com.br.gabrielsilva.nosql4j.NoSQL4J;

public class MachineController {

	public static boolean WINDOWS = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
	public static boolean INITIALIZED = false;
	
	public static void initialize() {
		if (INITIALIZED)
			return;
		
		INITIALIZED = true;
		File dir = new File(getDatabaseDirectory());
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	static {
		initialize();
	}
	
	public static String getSplitter() {
		if (!WINDOWS) {
			return "/";
		}
		return "\\";
	}

	public static String getDirectory() {
		if (!WINDOWS) {
			return "/root/" + NoSQL4J.DIRECTORY_FOLDER_NAME; //Não testado, até o momento com suporte apenas ao usuario root.
		}
		return "C:\\" + NoSQL4J.DIRECTORY_FOLDER_NAME;
	}
	
	public static String getDatabaseDirectory() {
		if (!WINDOWS) {
			return "/root/" + NoSQL4J.DIRECTORY_FOLDER_NAME + "/db"; //Não testado, até o momento com suporte apenas ao usuario root.
		}
		return "C:\\" + NoSQL4J.DIRECTORY_FOLDER_NAME + "\\db";
	}
}