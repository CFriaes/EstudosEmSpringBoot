package dev.Friaes.TesteSpring.Ninja;

import dev.Friaes.TesteSpring.Missoes.MissoesModel;
import dev.Friaes.TesteSpring.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private MissoesRepository missoesRepository;

    private NinjaRepository repository;

    public NinjaService(NinjaRepository repository, MissoesRepository missoesRepository) {
        this.repository = repository;
        this.missoesRepository = missoesRepository;
    }


    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

    public NinjaModel listarNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorID = repository.findById(id); //Utiliza-se Optional pra tratamento de Nullexceptionpointer
        return ninjaPorID.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){

        if (ninja.getMissao() != null && ninja.getMissao().getId() != null){ //Tipos primitivos não podem ser comparado com null
            Long missaoId = ninja.getMissao().getId();

            MissoesModel missaoDoBanco = missoesRepository.findById(missaoId)
                    .orElseThrow(() -> new IllegalArgumentException("Erro: A missão com o ID " + missaoId + " não existe no banco de dados!"));

            ninja.setMissao(missaoDoBanco);
        }else{
            ninja.setMissao(null);
        }
        return repository.save(ninja);
    }

    public void deletarNinjaPorID(Long id){
        repository.deleteById(id);
    }

    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado){
        if(repository.existsById(id)){
            ninjaAtualizado.setId(id);
            return repository.save(ninjaAtualizado);
        }
        return null;
    }
}
