package fr.eval.DTO.service;

import fr.eval.DAO.EntityDAO.AdressDAO;
import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.DTO.entityDTO.AdressDTO;
import fr.eval.DTO.service.conversions.AdressConverter;
import fr.eval.entity.Adress;
import fr.eval.entity.Utilisateur;

public class AdresseService {

	private AdressDAO adressDAO = new AdressDAO();
	private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
	
	public AdresseService() {
		super();
	}

	public void addAdresse(AdressDTO adressDTO, long id) {
		
			Adress adress = null;
			Utilisateur utilisateur = null;
			
		try {
			
			utilisateur = this.utilisateurDAO.getById(id);
			
			if(utilisateur == null) {
				System.out.println("Id utilisateur inexistant...");
				return;
			}
			
			if(adressDTO == null) {
				System.out.println("L'adresse renseignée ne peut pas être null...");
				return;
			}
			
			adress = AdressConverter.convertAdressDtoEnAdress(adressDTO);
			adress.setUtilisateur(utilisateur);
			
			this.adressDAO.add(adress);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Adress getAdresse(long id) {
		
		Adress adress = null;
		
		try {
			
			adress = this.adressDAO.getById(id);
			
			if(adress == null) {
				System.out.println("Adresse inexistante...");
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return adress;
	}
	
	public void updateAdresse(AdressDTO adressDTO, long id) {
		
		try {
		Adress adress = adressDAO.getById(id);
		
		if(adress == null) {
			System.out.println("Adresse inexistante");
		}
		
		adress = AdressConverter.updateAdressInfoFromDto(adress, adressDTO);
		this.adressDAO.update(adress);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAdresse(long id) {
		
		try {
			
			if(id > 0 && (Long) id != null) {
			this.adressDAO.deleteById(id);
			} else {
				System.out.println("Adresse inexistante...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
