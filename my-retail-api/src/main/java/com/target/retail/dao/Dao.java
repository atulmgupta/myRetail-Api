package com.target.retail.dao;

import java.util.List;
/**
 * 
 * @author atulgupta
 *
 */
public interface Dao<T> {
	T get(String id);

	List<T> getAll();

	void save(T t);

	void update(T t, String[] params);

	void delete(T t);
}
