package fr.eval.main;

import fr.eval.DAO.ArticleDAO;
import fr.eval.DAO.connexion.ConnexionBdd;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("Salut Sala !");
		
		ConnexionBdd.getSession();
		
	}

}
