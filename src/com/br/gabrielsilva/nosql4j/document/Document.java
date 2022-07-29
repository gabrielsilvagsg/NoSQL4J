package com.br.gabrielsilva.nosql4j.document;

import java.util.HashMap;

public class Document {

	private String documentName;
	private String tableName;
	private HashMap<String, String> hash;
	
	public Document(String documentName, String tableName) {
		this.documentName = documentName;
		this.tableName = tableName;
		this.hash = new HashMap<>();
	}
	
	public void save() {
		
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getTableName() {
		return tableName;
	}
	
	public String getValue(String key) {
		return hash.getOrDefault(key.toLowerCase(), "Unknown");
	}

	public HashMap<String, String> getHash() {
		return hash;
	}
}