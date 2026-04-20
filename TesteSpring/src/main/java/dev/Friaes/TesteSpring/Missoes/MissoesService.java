package dev.Friaes.TesteSpring.Missoes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
    private MissoesRepository repository;

    public MissoesService(MissoesRepository repository) {
        this.repository = repository;
    }

    public List<MissoesModel> listarMissoes(){
        return repository.findAll();
    }
}
