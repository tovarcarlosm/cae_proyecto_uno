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

    @NotEmpty(message = "El campo NOMBRE no puede estar libre")
    @Size(min = 3, max = 40, message = "Longitud min 3 y max 40")
    private String nombres;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String apellidos;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 30)
    private String profesion;

    @Email
    @Size(min = 3)
    private String email;
}
