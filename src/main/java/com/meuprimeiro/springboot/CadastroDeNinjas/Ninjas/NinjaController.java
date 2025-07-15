package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaNovo = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaNovo.getNome());
    }

    // Listar Todos Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Listar Ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        if(ninja !=null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao existe na base");
        }
    }

    //Deletar ninja por id (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID " + id + "deletado com sucesso...");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado");
        }


    }

    // Atualizar ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja =  ninjaService.atualizarNinja(id, ninjaAtualizado);
      if (ninja !=null){
          return ResponseEntity.ok(ninja);
      }else{
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("O ninja com o id " + id + " não encontrado");
      }

    }




}
