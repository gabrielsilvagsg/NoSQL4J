package com.br.gabrielsilva.nosql4j.document;

import java.util.HashMap;

import com.br.gabrielsilva.nosql4j.manager.DocumentManager;
import com.br.gabrielsilva.nosql4j.manager.TableManager;

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
		DocumentManager.save(this);
	}
	
	public boolean exist() {
		return TableManager.existDocument(documentName, tableName);
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getTableName() {
		return tableName;
	}
	
	public void put(String key, String value) {
		hash.put(key.toLowerCase(), value);
	}
	
	public void put(String key, int value) {
		hash.put(key.toLowerCase(), "" + value);
	}
	
	public void put(String key, long value) {
		hash.put(key.toLowerCase(), "" + value);
	}
	
	public void put(String key, double value) {
		hash.put(key.toLowerCase(), "" + value);
	}
	
	public void put(String key, boolean value) {
		hash.put(key.toLowerCase(), "" + value);
	}
	
	public String getValue(String key) {
		return hash.getOrDefault(key.toLowerCase(), "Unknown");
	}

	public HashMap<String, String> getHash() {
		return hash;
	}
}