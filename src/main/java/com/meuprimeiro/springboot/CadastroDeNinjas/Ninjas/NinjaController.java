package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Anotação @RestController indica que essa classe é um controlador REST
@RequestMapping("/ninjas") // Anotação @RequestMapping define a rota base para os métodos desse controlador
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Criar Ninja (Create)
    @PostMapping("/cadastrar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Listar Todos Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Listar Ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaId(id);
    }








}
