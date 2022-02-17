package co.edu.eam;

import co.edu.eam.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Controller
@Slf4j
public class ControladorInicial {

    @Value("${index.despedida}")
    private String despedida;

    @GetMapping("/")
    public String inicio(Model model){
        var saludo = "Hola de nuevo";
        model.addAttribute("saludo", saludo);
        model.addAttribute("despedida", despedida);

        var persona1 = new Persona();
        persona1.setNombres("Carlos");
        persona1.setApellidos("Tovar");
        persona1.setProfesion("Ing. de Sistemas");
        persona1.setEmail("carlos@eam.edu.co");

        var persona2 = new Persona();
        persona2.setNombres("Juan");
        persona2.setApellidos("Pérez");
        persona2.setProfesion("Desarrollador");
        persona2.setEmail("mauricio@eam.edu.co");

        var personas = Arrays.asList(persona1, persona2);

        model.addAttribute("personas", personas);

        return "index";
    }

}
