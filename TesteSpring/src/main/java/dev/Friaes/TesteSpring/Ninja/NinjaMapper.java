package dev.Friaes.TesteSpring.Ninja;

import org.springframework.stereotype.Component;

@Component //Diz ao Spring que essa classe pode ser injetada em outras
public class NinjaMapper {

    public NinjaModel map(NinjaDTO NinjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(NinjaDTO.getId());
        ninjaModel.setNome(NinjaDTO.getNome());
        ninjaModel.setEmail(NinjaDTO.getEmail());
        ninjaModel.setIdade(NinjaDTO.getIdade());
        ninjaModel.setMissao(NinjaDTO.getMissao());
        ninjaModel.setRank(NinjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissao(ninjaModel.getMissao());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;

    }
}
