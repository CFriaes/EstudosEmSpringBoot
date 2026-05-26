package dev.Friaes.TesteSpring.Ninja;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.List;
import dev.Friaes.TesteSpring.Missoes.*; //tive que importar a classe de outro package para que pudesse funcionar aqui
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

//a partir do momento que eu utilizo a notaation @Entity em uma classe, a mesma se torna em uma entidade do DB
//JPA = Java Pesistance API
@Table(name = "tb_ninja")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class NinjaModel {

    @Id //A variável abaixo do ID, nesse caso, long id, será utilizada como id na aplicação
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Notation que irá controlar a incrementação do id
    private Long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "idade", nullable = true)
    private Integer idade;

    @ManyToOne//Um ninja só pode ter 1 missão
    @JoinColumn(name = "missoes_id")
    @JsonManagedReference
    private MissoesModel missao;

}