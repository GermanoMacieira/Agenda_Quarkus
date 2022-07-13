package br.unifor.agendaquarkus.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Contatos")
public class Contact {

    // ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // (message = "Name is required")
    private String firstName;

    private String lastName;

    @NotBlank // (message = "Telephone is required")
    private String telephone;

    private String address;
    private String email;

}
