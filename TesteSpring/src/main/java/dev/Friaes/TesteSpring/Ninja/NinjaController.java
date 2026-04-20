package dev.Friaes.TesteSpring.Ninja;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVinda(){
        return "Seja bem vindo(a) à minha primeira aplicação utilizando SpringBoot";
    }

    //Adicionar Ninja (Create)
    @PostMapping("/adicionarNinja")
    public String adicionarNinja(){
        return "Aqui você adiciona um ninja";
    }

    //Mostrar Ninja Por ID (Read)
    @GetMapping("/todosID")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterarID")
    public String atualizarDados(){
        return "Aqui se atualizam os dados do Ninja";
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Aqui se deletam os Ninjas por ID";
    }

}
