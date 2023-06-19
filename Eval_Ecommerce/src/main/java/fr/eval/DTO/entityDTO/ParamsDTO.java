package fr.eval.DTO.entityDTO;

public class ParamsDTO {

	private long id;

	private String cle_cryptage_mdp;

	private String cle_cryptage_cp;

	public ParamsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParamsDTO(String cle_cryptage_mdp, String cle_cryptage_cp) {
		super();
		this.cle_cryptage_mdp = cle_cryptage_mdp;
		this.cle_cryptage_cp = cle_cryptage_cp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCle_cryptage_mdp() {
		return cle_cryptage_mdp;
	}

	public void setCle_cryptage_mdp(String cle_cryptage_mdp) {
		this.cle_cryptage_mdp = cle_cryptage_mdp;
	}

	public String getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}

	public void setCle_cryptage_cp(String cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
}
