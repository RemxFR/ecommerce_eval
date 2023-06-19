package fr.eval.DAO.Interface;

import org.hibernate.Session;

public interface ICrud<T> {

	void add(T t) throws Exception;
	T getById(long id) throws Exception;
	void update(T t) throws Exception;
	void deleteById(long id) throws Exception;
	void closeSession(Session session) throws Exception;
} 
