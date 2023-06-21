package fr.eval.entity;

public enum Profil {

	CLIENT("CLIENT"),
	MAGASINIER("MAGASINIER"),
	ADMIN("ADMIN");

	private final String profil;

	private Profil(String profil) {
		this.profil = profil;
	}

	public final String getProfil() {
		return profil;
	}
	
	
}
