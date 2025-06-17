package com.meuprimeiro.springboot.CadastroDeNinjas.Missoes;


import com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes") // Anotação @Table define o nome da tabela no banco de dados
@NoArgsConstructor // Lombok gera um construtor sem argumentos automaticamente
@AllArgsConstructor // Lombok gera um construtor com todos os argumentos automaticamente
@Data // Lombok gera os métodos getters e setters automaticamente
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dificuldade;

    // Anotação @ManyToOne indica que uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


}
