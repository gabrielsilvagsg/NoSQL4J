package com.br.gabrielsilva.nosql4j.manager;

import java.io.File;

import com.br.gabrielsilva.nosql4j.utility.MachineController;

public class TableManager {

	public static boolean createTable(String table) {
		File db = new File(MachineController.getDatabaseDirectory(), table.toLowerCase());
		if (db.exists()) {
			return false;
		} else {
			db.mkdirs();
			return true;
		}
	}

	public static boolean existTable(String table) {
		File db = new File(MachineController.getDatabaseDirectory(), table.toLowerCase());
		return db != null && db.exists();
	}

	public static boolean existDocument(String documentName, String tableName) {
		return DocumentManager.getFile(tableName, documentName).exists();
	}
}