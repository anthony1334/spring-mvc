package com.example.annuairepersonnes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class HelloController {
	
	
	
	@Autowired
	AnnuairePersonnesService annuairePersonnesService;
	
	   @GetMapping("/hello")
	    public String hello(Model model) {
		   List<Adresse> listePersonne = annuairePersonnesService.recupAdresse();
		 
	        model.addAttribute("personne", listePersonne);
	        model.addAttribute("newPersonne", new AdressePersonne());
	        return "hello";
	    }
	   
	   @PostMapping("/personne")
	   public String savePersonne(@ModelAttribute AdressePersonne personne) {
		   annuairePersonnesService.adresseFromForm(personne.getAdresse());
		 
		  
	       return "redirect:/hello";
	   }
	   
		


}
