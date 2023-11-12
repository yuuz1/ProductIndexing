package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Proentity;
import com.example.demo.repository.Prorepositiry;

@RestController
public class Procontroller {

	@Autowired
	private Prorepositiry repo;
	
	@PostMapping("/addpro")
	public Proentity addproduct(@RequestBody Proentity pro) {
		try {
			repo.save(pro);
			return pro;
		}catch(Exception e) {
			e.printStackTrace();	}
	return null;
}
	//GET API
	@GetMapping("/retrieveuser")
	public List <Proentity> Retrieveuser() {
		try {
		return repo.findAll();
			
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return null;
		}
	//GET API by Id
	@GetMapping("/retrieveuser/{Id}")
	public Proentity Retrievesingleuser (@PathVariable int Id) {
		try {
		return repo.findById(Id).orElse(null);
			
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		return null;
		}
	@PutMapping("/updateuser")
	public Proentity Updateuser (@RequestBody Proentity Entitydetail) {
		try {
			repo.save(Entitydetail);
			return Entitydetail;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//@SuppressWarnings("deprecation")
	@DeleteMapping("/deleteuser/{Id}")
	public String Deleteuser (@PathVariable int Id) {
		try {
			Proentity Entitydetail =  repo.getOne(Id);
			repo.delete(Entitydetail);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
