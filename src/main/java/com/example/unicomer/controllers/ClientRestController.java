package com.example.unicomer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.unicomer.models.entities.Client;
import com.example.unicomer.models.services.IClientService;


@RestController
@RequestMapping("/application")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/client/all")
	public List<Client> index(){
		return clientService.findAll();
	}

	@PostMapping("/client")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		if (clientService.findById(client.getClientId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
		return clientService.save(client);	
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/client/{id}")
	public Client update(@RequestBody Client obj, @PathVariable Long id) {
		Client client= clientService.findById(id);
		client.setFirstName(obj.getFirstName());
		client.setLastName(obj.getLastName());
		client.setBirthday(obj.getBirthday());
		client.setGender(obj.getGender());
		client.setCellphone(obj.getCellphone());
		client.setHomephone(obj.getHomephone());
		client.setAddressHome(obj.getAddressHome());
		client.setProfession(obj.getProfession());
		client.setClientIncome(obj.getClientIncome());
		return clientService.save(client);
	}
}
