package fr.eval.DTO.controller;

import javax.ws.rs.core.Response;

public interface IControllerRest<T> {

	String getInfos() throws Exception;
	T getById(long id) throws Exception;
	Response addT(T t) throws Exception;
	Response updateT(T t) throws Exception;
	Response removeTById(long id) throws Exception;
}
