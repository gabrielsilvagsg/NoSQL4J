package com.br.gabrielsilva.nosql4j.manager;

import java.io.File;

import com.br.gabrielsilva.nosql4j.exceptions.TableCreateExcepetion;
import com.br.gabrielsilva.nosql4j.utility.MachineController;

public class TableManager {

	public static void createTable(String table) throws TableCreateExcepetion {
		File db = new File(MachineController.getDatabaseDirectory(), table);
		if (db.exists()) {
			throw new TableCreateExcepetion("Already existing table");
		} else {
			db.mkdirs();
		}
	}
	
	public static boolean existTable(String table) {
		File db = new File(MachineController.getDatabaseDirectory(), table);
		return db != null && db.exists();
	}
}