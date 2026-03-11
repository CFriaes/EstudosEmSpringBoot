package dev.Friaes.TesteSpring.Ninja;

import jakarta.persistence.*;
import java.util.List;
import dev.Friaes.TesteSpring.Missoes.*; //tive que importar a classe de outro package para que pudesse funcionar aqui
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//a partir do momento que eu utilizo a notaation @Entity em uma classe, a mesma se torna em uma entidade do DB
//JPA = Java Pesistance API
@Entity
@Table(name = "tb_ninja")
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id //A variável abaixo do ID, nesse caso, long id, será utilizada como id na aplicação
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Notation que irá controlar a incrementação do id
    private long id;


    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne//Um ninja só pode ter 1 missão
    @JoinColumn(name = "missoes_id")
    private MissoesModel missao;

}