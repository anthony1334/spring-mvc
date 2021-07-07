package com.example.annuairepersonnes;

public class AdressePersonne {
	String nom;
	String prenom;
	String numero, rue, codePostal, ville;

	private Personne getPersonne() {
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setPrenom(prenom);
		return personne;
	}

	
	/**
	 * 
	 * @return
	 */
	public Adresse getAdresse() {
		Adresse adresse = new Adresse();
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		adresse.setPersonne(getPersonne());
		return adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "AdressePersonne [nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", rue=" + rue
				+ ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	

}