package com.example.NavApp.services;

import java.util.List;
import java.util.Optional;
import com.example.NavApp.models.Contact;
import com.example.NavApp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	//Get All Contacts
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}

	//Get Contact By Id
	public Contact findById(int id) {
		return contactRepository.findById(id).orElse(null);
	}

	//Delete Contact
	public void delete(int id) {
		contactRepository.deleteById(id);
	}

	//Update Contact
	public void save( Contact contact) {
		contactRepository.save(contact);
	}

}