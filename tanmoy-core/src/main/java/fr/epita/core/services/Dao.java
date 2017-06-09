package fr.epita.core.services;

import java.util.List;

public interface Dao<T> {
	
	public void write(T instance);
	public void delete(T instance);
	public void update(T instance);
	public List<T> search(T instance);

}
