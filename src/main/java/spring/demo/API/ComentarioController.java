/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.demo.API;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.entity.Comentario;
import spring.demo.repository.ComentarioRepository;

@RestController
@RequestMapping("/api")
public class ComentarioController {
    
    @Autowired
    ComentarioRepository repository;
    
    @GetMapping("/comentarios")
    public List<Comentario> buscartodos(){
        return repository.findAll();
    }
    
    @PostMapping("/comentarios")
    public Comentario guardar(@RequestBody Comentario comentario){
        return repository.save(comentario);
    }
    
    /*@PutMapping("/comentarios/{id}")
    Comentario updateComentario(@RequestBody Comentario newComentario, @PathVariable Long id){
        
    } */
    
    @DeleteMapping("/comentarios/{id}")
    void eliminar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
