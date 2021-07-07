package com.example.annuairepersonnes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnuairePersonnesService {

	@Autowired
	AdresseRepository adresseRepository;
	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	ActiviteRepository activiteRepository;

	public void addPersonne(Personne nouvellePersonne) {
		personneRepository.save(nouvellePersonne);
	}

	public void addAdresse(Adresse nouvelleAdresse) {

		Personne personneDto = nouvelleAdresse.getPersonne();
		Optional<Personne> personne = personneRepository.findById(personneDto.getIdPersonne());
		if (personne.isPresent()) {
			nouvelleAdresse.setPersonne(personne.get());
			adresseRepository.save(nouvelleAdresse);
		} else {
			Personne personne1 = personneRepository.save(personneDto);
			nouvelleAdresse.setPersonne(personne1);
			adresseRepository.save(nouvelleAdresse);

		}

	}
	
	public void adresseFromForm(Adresse nouvelleAdresse) {
		adresseRepository.save(nouvelleAdresse);
	}
	
	public List <Adresse> recupAdresse(){
		return adresseRepository.findAll();
	}

	public void deletePersonne(Long id) {
		Optional<Personne> oPersonne = personneRepository.findById(id);
		if (oPersonne.isPresent())
			personneRepository.deleteById(id);

	}

	public void addActivite(Activite nouvelleActivite, Long id) {

		Optional<Personne> oPersonne = personneRepository.findById(id);
		if (oPersonne.isPresent()) {
			nouvelleActivite.addPersonne(oPersonne.get());
			activiteRepository.save(nouvelleActivite);

		}

	}

}
