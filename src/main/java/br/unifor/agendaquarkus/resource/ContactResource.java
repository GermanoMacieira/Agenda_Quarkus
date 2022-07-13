package br.unifor.agendaquarkus.resource;

import br.unifor.agendaquarkus.dto.ContactDto;
import br.unifor.agendaquarkus.model.Contact;
import br.unifor.agendaquarkus.service.ContactService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    @Inject
    private ContactService contactService;

    @POST
    @Transactional  // É Preciso para alteração de escrita no banco.
    public Contact createContact(Contact contact) {

        return this.contactService.createContact(contact);
    }

    @GET
    public List<Contact> listAllContacts() {

        return this.contactService.listAllContacts();
    }

    @DELETE
    @Path("{id}")
    @Transactional  // É Preciso para alteração de escrita no banco.
    public void deleteContact(@PathParam("id") Long id) {

        this.contactService.deleteContact(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void updateContact(@PathParam("id") Long id, Contact contact) {

        this.contactService.updateContact(id, contact);

    }

}
