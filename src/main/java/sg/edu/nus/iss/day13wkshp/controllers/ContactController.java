package sg.edu.nus.iss.day13wkshp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day13wkshp.models.Contact;
import sg.edu.nus.iss.day13wkshp.services.DatabaseService;

@Controller
@RequestMapping(path = "/contact")
public class ContactController {
    @Autowired
    private DatabaseService dbSvc;

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model) {
        Contact contact = new Contact();
        contact.setName(form.getFirst("name"));
        contact.setEmail(form.getFirst("email"));
        contact.setPhone(form.getFirst("phone"));

        System.out.printf("Created new %s!\n", contact);
        dbSvc.save(contact);

        model.addAttribute("contact", contact);

        // return "success";
        return "showcontact";
    }

    @GetMapping(value="/{id}", produces="text/html")
    public String getContact(@PathVariable("id") String id, Model model) {
        Contact contact = new Contact();
        contact = dbSvc.read(id);
        System.out.printf(">id: %s\n", contact);

        model.addAttribute("contact", contact);
        return "showContact";
    }
}
