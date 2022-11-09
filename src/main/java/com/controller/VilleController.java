package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	// fonction pour récupérer le contenu de la BDD
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		System.out.println("get");
		// TODO : mon code vers la BDD
		
		ArrayList<Ville> listeVille = villeBLOService.getInfoVilles(codePostal);

		return listeVille;
	}
	
	// TODO : 
	// fonction pour enregistrer un element dans la BDD
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Ville ville, Model model) {
	//public String insert(@RequestBody String num) {
	    //System.out.println(num);
		System.out.println("Appel POST");
		System.out.println("ville Post : " + ville.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(ville);
			System.out.println("ville Json : " + jsonInString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //villeService.insertVille(ville);
		return "index";
	}

}