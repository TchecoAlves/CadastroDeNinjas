package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import com.meuprimeiro.springboot.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private MissoesModel missoes;
    private String rank;
}
