package com.example.NavApp.repositories;

import com.example.NavApp.models.Contact;
import com.example.NavApp.models.InvoiceStatus;
import com.example.NavApp.services.ContactService;
import com.example.NavApp.services.CountryService;
import com.example.NavApp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Repository
public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {

    @Controller
    class ContactController {

        @Autowired
        private StateService stateService;
        @Autowired private CountryService countryService;
        @Autowired private ContactService contactService;

        //Get All Contacts
        @GetMapping("/contacts")
        public String findAll(Model model){
            model.addAttribute("countries", countryService.findAll());
            model.addAttribute("states", stateService.findAll());
            model.addAttribute("contacts", contactService.findAll());
            return "contact";
        }

        @RequestMapping("contacts/findById")
        @ResponseBody
        public Optional<Contact> findById(Integer id)
        {
            return Optional.ofNullable(contactService.findById(id));
        }

        //Add Contact
        @PostMapping(value="contacts/addNew")
        public String addNew(Contact contact) {
            contactService.save(contact);
            return "redirect:/contacts";
        }

        @RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(Contact contact) {
            contactService.save(contact);
            return "redirect:/contacts";
        }

        @RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String delete(Integer id) {
            contactService.delete(id);
            return "redirect:/contacts";
        }

    }
}
