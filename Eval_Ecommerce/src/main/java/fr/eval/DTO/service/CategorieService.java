package fr.eval.DTO.service;

import fr.eval.DAO.EntityDAO.CategorieDAO;
import fr.eval.entity.Article;
import fr.eval.entity.Categorie;

public class CategorieService {

	private CategorieDAO categorieDAO = new CategorieDAO();

	
	public void addCategorie(Categorie categorie) throws Exception {

		this.categorieDAO.add(categorie);

	}

	public void updateCategorie(Categorie categorie) throws Exception {

		this.categorieDAO.update(categorie);

	}

	public Categorie getCategorieById(long id) throws Exception {

		Categorie categorie = this.categorieDAO.getById(id);

		return categorie;
	}

	public void removeCategorieById(long id) throws Exception {

		this.categorieDAO.deleteById(id);

	}

}
