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
    private NinjaMapper ninjaMapper;

    public NinjaService(MissoesRepository missoesRepository, NinjaRepository repository, NinjaMapper ninjaMapper) {
        this.missoesRepository = missoesRepository;
        this.repository = repository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

    public NinjaModel listarNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorID = repository.findById(id); //Utiliza-se Optional pra tratamento de Nullexceptionpointer
        return ninjaPorID.orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){

        if (ninjaDTO.getMissao() != null && ninjaDTO.getMissao().getId() != null){ //Tipos primitivos não podem ser comparado com null
            Long missaoId = ninjaDTO.getMissao().getId();

            MissoesModel missaoDoBanco = missoesRepository.findById(missaoId)
                    .orElseThrow(() -> new IllegalArgumentException("Erro: A missão com o ID " + missaoId + " não existe no banco de dados!"));

            ninjaDTO.setMissao(missaoDoBanco);
        }else{
            ninjaDTO.setMissao(null);
        }

        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = repository.save(ninja);
        return ninjaMapper.map(ninja);
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
