package dev.Friaes.TesteSpring.Missoes;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Friaes.TesteSpring.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id não precisa de métodos getter e setter, já que será administrado pela notation "@Generated Value"
    private String nomeMissao;
    private String rankMissao;

    @OneToMany
    private List<NinjaModel> ninjas;

}
