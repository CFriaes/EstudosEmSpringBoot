package dev.Friaes.TesteSpring.Missoes;
import java.util.List;

import dev.Friaes.TesteSpring.Ninja.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id não precisa de métodos getter e setter, já que será administrado pela notation "@Generated Value"
    private String nomeMissao;
    private String rankMissao;

    @OneToMany
    private List<NinjaModel> ninjas;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nomeMissao, String rankMissao, List<NinjaModel> ninjas) {
        this.id = id;
        this.nomeMissao = nomeMissao;
        this.rankMissao = rankMissao;
        this.ninjas = ninjas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getRankMissao() {
        return rankMissao;
    }

    public void setRankMissao(String rankMissao) {
        this.rankMissao = rankMissao;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
