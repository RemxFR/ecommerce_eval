package fr.eval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "t_params")
public class Params {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name = "cle_mdp", 
			columnDefinition = "TINYBLOB", 
			nullable = false, updatable = false)
	private byte [] cle_cryptage_mdp;

	@Lob
	@Column(name = "cle_cp",
			columnDefinition = "TINYBLOB",
			nullable = false, updatable = false)
	private byte[] cle_cryptage_cp;

	public Params() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Params(byte[] cle_cryptage_mdp, byte[] cle_cryptage_cp) {
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

	public byte[] getCle_cryptage_mdp() {
		return cle_cryptage_mdp;
	}

	public void setCle_cryptage_mdp(byte[] cle_cryptage_mdp) {
		this.cle_cryptage_mdp = cle_cryptage_mdp;
	}

	public byte[] getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}

	public void setCle_cryptage_cp(byte[] cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
}
