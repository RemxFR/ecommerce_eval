package fr.eval.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_token")
public class Token {

	private long id;
	private long idUtilisateur;
	private UUID uuidToken;
	
}
