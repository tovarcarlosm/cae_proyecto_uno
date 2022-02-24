package co.edu.eam;

import co.edu.eam.domain.Persona;
import co.edu.eam.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorInicial {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listar();
        log.info("Ejecutando método inicio desde MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Persona persona){
        return "registrar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

}
