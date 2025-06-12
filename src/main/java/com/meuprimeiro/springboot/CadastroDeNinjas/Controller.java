package com.meuprimeiro.springboot.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas") // mapeia a rota raiz
    public String boasVindas() {
        return "Opa, essa é minha primeira mensagem nessa rota";
    }

}
