package com.example.annuairepersonnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AnnuairePersonnesController {
	
	@Autowired
	AnnuairePersonnesService annuairePersonnesService;
	
	@PostMapping("/adresse")
	public void ajouterAdresse(@RequestBody Adresse nouvelleAdresse) {
		annuairePersonnesService.addAdresse(nouvelleAdresse);
	}
	
	
	@DeleteMapping("/personne/{id}")  	
	public String deletePersonne(@PathVariable("id") Long id) {
		annuairePersonnesService.deletePersonne(id);
	     return"supression ok";
	}

	
	@PostMapping("/activite/{id}")
	public void ajouterActivite(@RequestBody Activite nouvelleActivite, @PathVariable("id") Long id) {
		annuairePersonnesService.addActivite(nouvelleActivite,id);
	}


}
