package dao;

import java.util.List;

public interface IDao<T> {
	boolean create(T o);

	boolean delete(int o);

	boolean update(T o);

	T findById(int id);

	List<T> findAll();

}
