package dev.Friaes.TesteSpring.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository repository;
    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

}
