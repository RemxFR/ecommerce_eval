package fr.eval.DTO.service.conversions;

import fr.eval.DTO.entityDTO.AdressDTO;
import fr.eval.entity.Adress;

public final class AdressConverter {

	private AdressConverter() {
		super();
	}

	public static Adress convertAdressDtoEnAdress(AdressDTO adressDTO) {

		Adress adressConvertie = new Adress();

		adressConvertie.setNumero(adressDTO.getNumero());
		adressConvertie.setRue(adressDTO.getRue());
		adressConvertie.setCodePostal(adressDTO.getCodePostal());
		adressConvertie.setVille(adressDTO.getVille());

		return adressConvertie;
	}
	
	public static Adress updateAdressInfoFromDto(Adress adress, AdressDTO adressDTO) {
		
		adress.setNumero(adressDTO.getNumero());
		adress.setRue(adressDTO.getRue());
		adress.setCodePostal(adressDTO.getCodePostal());
		adress.setVille(adressDTO.getVille());
		
		return adress;
	}
}
