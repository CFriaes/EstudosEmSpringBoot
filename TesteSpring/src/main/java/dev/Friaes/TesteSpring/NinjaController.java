package dev.Friaes.TesteSpring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVinda(){
        return "Seja bem vindo(a) à minha primeira aplicação utilizando SpringBoot";
    }

}
