package dev.Friaes.TesteSpring.Ninja;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo Ninja Criado Com Sucesso");
    }

    //Mostrar Todos os Ninjas (Read)
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorID(@PathVariable Long id){
        NinjaDTO ninjaID = ninjaService.listarNinjasPorID(id);

        if (ninjaID == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja inexistente");
        }
        return ResponseEntity.ok(ninjaID);

    }

    //Alterar dados dos Ninjas (Update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarDados(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        boolean ninjaExistente = ninjaService.ninjaExiste(id);
        if (!ninjaExistente){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja Inexistente");
        }
        NinjaDTO ninjaAlterado = ninjaService.alterarNinja(id, ninjaAtualizado);
        return ResponseEntity.ok("Ninja Alterado com sucesso");
    }

    //Deletar Ninja (Delete)
    @DeleteMapping("/deletar/{id}") //Método precisa ser void, afinal de contas não irá retornar nada ao usuário
    public ResponseEntity<?> deletarNinjaPorID(@PathVariable Long id){
        boolean ninjaExistente = ninjaService.ninjaExiste(id);
        if (ninjaExistente){
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja Deletado com Sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja Inexistente");
    }


}
