package dev.Friaes.TesteSpring.Ninja;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.Friaes.TesteSpring.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

        private Long id;
        private String nome;
        private String email;
        private Integer idade;
        private MissoesModel missao;
        private String rank;

    }
