package com.example.annuairepersonnes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idActivite;
	String genre;
	int prix;

	@ManyToMany // Jointure avec la table personne
	 @JoinTable(name="activite_personne",
     joinColumns = @JoinColumn(name = "id_activite",referencedColumnName = "idActivite"),
     inverseJoinColumns = @JoinColumn(name = "id_personne",referencedColumnName = "idPersonne"))
	private Set<Personne> personnes = new HashSet<>();

	public Activite() {
		super();
	}

	public Long getId() {
		return idActivite;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Set<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public void addPersonne(Personne personne) {
		this.personnes.add(personne);
	}

	@Override
	public String toString() {
		return "Activite [idActivite=" + idActivite + ", genre=" + genre + ", prix=" + prix + ", personnes=" + personnes + "]";
	}

}
