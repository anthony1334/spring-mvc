package com.example.annuairepersonnes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "personnes")
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idPersonne;
	String nom;
	String prenom;

	@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
	private List<Adresse> listAdresse;

	  
	  @ManyToMany // Jointure avec la table personne
		 @JoinTable(name="activite_personne",
	     joinColumns = @JoinColumn(name = "id_personne",referencedColumnName = "idPersonne"),
	     inverseJoinColumns = @JoinColumn(name = "id_activite",referencedColumnName = "idActivite"))
	    private Set<Activite> activites = new HashSet<>();

	public Personne() {
		super();
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public List<Adresse> getListAdresse() {
		return listAdresse;
	}

	public void setListAdresse(List<Adresse> listAdresse) {
		this.listAdresse = listAdresse;
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

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
