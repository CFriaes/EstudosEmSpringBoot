package dev.Friaes.TesteSpring;

import jakarta.persistence.*;

//a partir do momento que eu utilizo a notaation @Entity em uma classe, a mesma se torna em uma entidade do DB
//JPA = Java Pesistance API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id //A variável abaixo do ID, nesse caso, long id, será utilizada como id na aplicação
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Notation que irá controlar a incrementação do id
    private long id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel(String nome) {
        this.nome = nome;
    }

    public NinjaModel(String nome, String email, int idade) {
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
