package com.example.NavApp.services;

import java.util.List;
import java.util.Optional;
import com.example.NavApp.models.Invoice;
import com.example.NavApp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Get All Invoices
	public List<Invoice> findAll(){
		return invoiceRepository.findAll();
	}	
	
	//Get Invoice By Id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}	
	
	//Delete Invoice
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//Update Invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

}
