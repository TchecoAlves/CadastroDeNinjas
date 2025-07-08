package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar todos os ninjas por id
    public NinjaModel listarNinjaId(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja (NinjaModel ninja){
        return ninjaRepository.save(ninja);

    }

}
