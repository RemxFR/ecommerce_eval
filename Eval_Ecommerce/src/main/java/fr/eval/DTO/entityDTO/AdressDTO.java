package fr.eval.DTO.entityDTO;

public class AdressDTO {

	private long id;
	
	private int numero;
	
	private String rue;
	
	private String ville;
	
	private String codePostal;
	
	private UtilisateurDTO utilisateur;

	public AdressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdressDTO(int numero, String rue, String ville, String codePostal, UtilisateurDTO utilisateur) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

}
