package fr.eval.DAO.Interface;


public interface ICrud<T> {

	void add(T t) throws Exception;
	T getById(long id) throws Exception;
	void update(T t) throws Exception;
	void deleteById(long id) throws Exception;
	
}
