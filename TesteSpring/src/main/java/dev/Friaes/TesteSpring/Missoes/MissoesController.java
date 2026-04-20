package dev.Friaes.TesteSpring.Missoes;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com Sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão Alterada com Sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

    //Manda uma requisição para o banco de Dados para mostrar todas as missoes cadastradas
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }
}
