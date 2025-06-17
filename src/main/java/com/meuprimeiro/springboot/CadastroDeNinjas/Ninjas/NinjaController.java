package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotação @RestController indica que essa classe é um controlador REST
@RequestMapping // Anotação @RequestMapping define a rota base para os métodos desse controlador
public class NinjaController {

    @GetMapping("/boasvindas") // mapeia a rota raiz
    public String boasVindas() {
        return "Opa, essa é minha primeira mensagem nessa rota";
    }

}
