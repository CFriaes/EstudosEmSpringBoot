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
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar Todos os Ninjas (Read)
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarPorID(@PathVariable Long id){
        return ninjaService.listarNinjasPorID(id);
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterarID")
    public String atualizarDados(){
        return "Aqui se atualizam os dados do Ninja";
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletar/{id}") //Método precisa ser void, adinal de contas não irá retornar nada ao usuário
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }



}
