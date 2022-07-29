package com.br.gabrielsilva.nosql4j.utility;

import java.io.File;

import com.br.gabrielsilva.nosql4j.NoSQL4J;

public class MachineController {
	
	public static final String OS = System.getProperty("os.name").toLowerCase();
	public static boolean WINDOWS = OS.indexOf("win") >= 0;
	
	static {
		File dir = new File(getDirectory());
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
	
	public static String getDirectory() {
		if (!WINDOWS) {
			return "/root/" + NoSQL4J.DIRECTORY_FOLDER_NAME;
		}
		return "C:\\" + NoSQL4J.DIRECTORY_FOLDER_NAME;
	}
}