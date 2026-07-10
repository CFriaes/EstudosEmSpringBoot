package dev.Friaes.TesteSpring.Ninja;

import dev.Friaes.TesteSpring.Missoes.MissoesModel;
import dev.Friaes.TesteSpring.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private NinjaRepository repository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository repository, NinjaMapper ninjaMapper) {
        this.repository = repository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = repository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .toList(); //Java 16
    }

    public NinjaDTO listarNinjasPorID(Long id){
        return repository.findById(id)
                .map(ninjaMapper::map)
                .orElse(null);



    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = repository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorID(Long id){
        repository.deleteById(id);
    }

    public boolean ninjaExiste(Long id){
        return repository.existsById(id);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaAtualizado) {
        Optional<NinjaModel> verificarID = repository.findById(id);
        if(verificarID.isPresent()){
            NinjaModel ninja = ninjaMapper.map(ninjaAtualizado);
            ninja.setId(id);
            NinjaModel ninjaSalvo = repository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        } else {
            return null;
        }
    }
}