package co.edu.eam;

import co.edu.eam.domain.Persona;
import co.edu.eam.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@Slf4j
public class ControladorInicial {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Persona persona){
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if (errores.hasErrors()) {
            return "index";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = personaService.buscarPorId(persona);
        model.addAttribute("persona", persona);
        return "registrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
