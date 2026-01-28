package dev.Friaes.TesteSpring.Ninja;

import jakarta.persistence.*;
import java.util.List;
import dev.Friaes.TesteSpring.Missoes.*; //tive que importar a classe de outro package para que pudesse funcionar aqui

//a partir do momento que eu utilizo a notaation @Entity em uma classe, a mesma se torna em uma entidade do DB
//JPA = Java Pesistance API
@Entity
@Table(name = "tb_ninja")
public class NinjaModel {

    @Id //A variável abaixo do ID, nesse caso, long id, será utilizada como id na aplicação
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Notation que irá controlar a incrementação do id
    private long id;
    private String nome;
    private String email;
    private int idade;

    @ManyToOne//Um ninja só pode ter 1 missão
    private MissoesModel missao;

    public NinjaModel() {} //construtor NO ARGS

    public NinjaModel(String nome, String email, int idade) { //sobrecarga de construtor
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }
}
