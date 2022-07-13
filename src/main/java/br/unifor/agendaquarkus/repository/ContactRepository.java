package br.unifor.agendaquarkus.repository;

import br.unifor.agendaquarkus.model.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped  // Cria uma instância da classe (repositório) para ser utilizada onde quiser.
public class ContactRepository implements PanacheRepository<Contact> {

}
