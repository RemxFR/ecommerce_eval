package fr.eval.main;

import java.util.HashSet;
import java.util.Set;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.DAO.connexion.ConnexionBdd;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("Salut Sala !");
		
		ConnexionBdd.getSession();
		
	}

}
