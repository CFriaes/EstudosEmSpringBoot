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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar Todos os Ninjas (Read)
    @GetMapping("/todos")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarPorID(@PathVariable Long id){
        return ninjaService.listarNinjasPorID(id);
    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarDados(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.alterarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletar/{id}") //Método precisa ser void, adinal de contas não irá retornar nada ao usuário
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }


}
