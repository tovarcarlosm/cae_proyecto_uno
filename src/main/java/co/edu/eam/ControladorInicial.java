package co.edu.eam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class ControladorInicial {

    @GetMapping("/")
    public String inicio(){
        log.info("ejecutando el método inicio de la clase Controlador Inicial");
        log.debug("Haciendo debug desde el método inicio de la clase Controlador Inicial");
        return "index";
    }

}
