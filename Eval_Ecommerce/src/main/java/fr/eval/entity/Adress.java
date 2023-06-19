package fr.eval.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "t_adresse")
@NamedQueries ({
	@NamedQuery(name = "Adress::FindAdressById", query = "FROM Adress a WHERE id= :id"),
	@NamedQuery(name = "Adress::FindAll", query = "FROM Adress a")
})
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@NotEmpty
	@Column(name = "rue", length = 45, nullable = false)
	private String rue;
	
	@NotEmpty
	@Column(name = "ville", length = 45, nullable = false)
	private String ville;
	
	@NotEmpty
	@Column(name = "codePostal", length = 6, nullable = false)
	private String codePostal;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "adresse")
	private Utilisateur utilisateur;

	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adress(@NotEmpty int numero, @NotEmpty String rue, @NotEmpty String ville, @NotEmpty String codePostal,
			Utilisateur utilisateur) {
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
