package br.unifor.agendaquarkus.service.impl;

import br.unifor.agendaquarkus.model.Contact;
import br.unifor.agendaquarkus.repository.ContactRepository;
import br.unifor.agendaquarkus.service.ContactService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceImpl implements ContactService {

    @Inject
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {

        contact.setFirstName(contact.getFirstName());
        contact.setLastName(contact.getLastName());
        contact.setAddress(contact.getAddress());
        contact.setTelephone(contact.getTelephone());
        contact.setEmail(contact.getEmail());

        contactRepository.persist(contact); // Salva uma entidade no banco.
        return contact;   // Retorna com os dados inseridos.
    }
    @Override
    public List<Contact> listAllContacts() {

        return this.contactRepository.listAll();
    }

    @Override
    public void deleteContact(long id) {

        this.contactRepository.deleteById(id);
    }


    public void updateContact(@PathParam("id")long id, Contact contact) {
        Optional<Contact> optionalContact = contactRepository.findByIdOptional(id);

        if (optionalContact.isPresent()) {
//            optionalContact.get().setId(id);
            optionalContact.get().setFirstName(contact.getFirstName());
            optionalContact.get().setLastName(contact.getLastName());
            optionalContact.get().setTelephone(contact.getTelephone());
            optionalContact.get().setEmail(contact.getEmail());

            contactRepository.persist(optionalContact.get());
        }
    }

}