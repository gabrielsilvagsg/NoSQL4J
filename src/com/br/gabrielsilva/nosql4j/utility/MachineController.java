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
		File dir = new File(getDirectory());
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
	
	static {
		initialize();
	}

	public static String getDirectory() {
		if (!WINDOWS) {
			return "/root/" + NoSQL4J.DIRECTORY_FOLDER_NAME; //N�o testado, at� o momento com suporte apenas ao usuario root.
		}
		return "C:\\" + NoSQL4J.DIRECTORY_FOLDER_NAME;
	}
}