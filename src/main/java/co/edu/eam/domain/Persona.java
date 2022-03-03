package co.edu.eam.domain;

import lombok.Data;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3)
    private String nombres;

    @NotEmpty
    @Size(min = 3)
    private String apellidos;

    @NotEmpty
    @Size(min = 3)
    private String profesion;

    @Email
    @Size(min = 3)
    private String email;
}
