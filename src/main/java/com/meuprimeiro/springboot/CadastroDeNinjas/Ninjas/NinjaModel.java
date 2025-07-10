package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;
import com.meuprimeiro.springboot.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.SpringVersion;

import java.util.List;

@Entity // Anotação @Entity indica que essa classe é uma entidade JPA do BD
@Table(name = "tb_cadastro") // Anotação @Table define o nome da tabela no banco de dados
@NoArgsConstructor // Lombok gera um construtor sem argumentos automaticamente
@AllArgsConstructor // Lombok gera um construtor com todos os argumentos automaticamente
@Data // Lombok gera os métodos getters e setters automaticamente
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String rank;

    @Column(unique = true) // Anotação @Column define que o email deve ser único
    private String email;

    // Anotação @ManyToOne indica que um ninja tem apenas uma missao, mas uma missão pode ter vários ninjas
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
