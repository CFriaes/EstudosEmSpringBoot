package dev.Friaes.TesteSpring.Missoes;
import java.util.List;
import dev.Friaes.TesteSpring.Ninja.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // id não precisa de métodos getter e setter, já que será administrado pela notation "@Generated Value"
    private String nomeMissao;
    private RankMissao rankMissao;

    @OneToMany
    private List<NinjaModel> ninjas;

    public MissoesModel() {}

    public MissoesModel(long id, String nome_missao, RankMissao rankMissao) {
        this.id = id;
        this.nomeMissao = nome_missao;
        this.rankMissao = rankMissao;
    }

    public String getNome_missao() {
        return nomeMissao;
    }

    public void setNome_missao(String nome_missao) {
        this.nomeMissao = nome_missao;
    }

    public RankMissao getRankMissao() {
        return rankMissao;
    }

    public void setRankMissao(RankMissao rankMissao) {
        this.rankMissao = rankMissao;
    }
}
