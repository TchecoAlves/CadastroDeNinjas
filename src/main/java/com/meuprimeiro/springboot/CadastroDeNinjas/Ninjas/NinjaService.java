package com.meuprimeiro.springboot.CadastroDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    // Listar todos meus ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar todos os ninjas por id
    public NinjaDTO listarNinjaId(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar Ninja, tem que ser um metodo VOID
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id);
        if (ninjaExiste.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return  null;
    }

}
