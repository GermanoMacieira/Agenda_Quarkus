package br.unifor.agendaquarkus.service;

import br.unifor.agendaquarkus.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> listAllContacts();
    Contact createContact(Contact contact);
    void deleteContact(long id);
    void updateContact(long id, Contact contact);

}
