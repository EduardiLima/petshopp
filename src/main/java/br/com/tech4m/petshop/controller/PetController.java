package br.com.tech4m.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.tech4m.petshop.service.PetService;
import br.com.tech4m.petshop.model.Pet;
import br.com.tech4m.petshop.Shared.PetCompletoDto;
import br.com.tech4m.petshop.Shared.PetDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService servico;

    @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<PetDto>> obterPets() {
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetCompletoDto> obterPetPorId(@PathVariable String id) {
        Optional<PetCompletoDto> pet = servico.obterPorId(id);

        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PetCompletoDto> cadastrarPet(@RequestBody @Valid PetCompletoDto pet) {
        return new ResponseEntity<>(servico.cadastrar(pet), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPetPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PetCompletoDto> atualizarPet(@PathVariable String id, @RequestBody @Valid PetCompletoDto pet) {
        PetCompletoDto petAtualizado = servico.atualizarPorId(id, pet);

        if (petAtualizado != null) {
            return new ResponseEntity<>(petAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
