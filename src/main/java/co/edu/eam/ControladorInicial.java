package co.edu.eam;

import co.edu.eam.dao.PersonaDao;
import co.edu.eam.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicial {

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaDao.findAll();
        log.info("Ejecutando método inicio desde MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

}
