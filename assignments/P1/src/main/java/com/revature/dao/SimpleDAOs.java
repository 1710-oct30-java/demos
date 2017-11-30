package com.revature.dao;

import java.util.List;

import com.revature.beans.Simple;

public interface SimpleDAOs {
	boolean add(int id, String name);

	boolean alter(int oldId, String oldName, int newId, String newName);

	boolean alterById(int oldId, int newId, String newName);

	boolean alterByName(String oldName, int newId, String newName);

	boolean alterNameById(int oldid, String newName);

	boolean alterNamebyName(String oldName, String newName);

	boolean remove(int id, String name);

	boolean removeById(int id);

	boolean removeByName(String name);

	String getNameById(int id);

	int getIdByName(String name);
	
	List<Simple> getAll();
}