/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.demo.API;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.entity.Publicacion;
import spring.demo.repository.PublicacionRepository;

@RestController
@RequestMapping("/api")
public class PublicacionController {
    @Autowired
    PublicacionRepository repositoy;
    
    @GetMapping("/publicaciones")
    public List<Publicacion> buscartodos(){
        return repositoy.findAll();
    }
    
    @PostMapping("/publicaciones")
    public Publicacion guardar(@RequestBody Publicacion publicacion){
        return repositoy.save(publicacion);
    }
    
    @PostMapping("/publicaciones/{id}")
    public Optional<Publicacion> buscarId(@PathVariable(value="id") Long id){
        return repositoy.findById(id);
    }
    
    @DeleteMapping("/publicaciones/{id}")
    void eliminar(@PathVariable Long id){
        repositoy.deleteById(id);
    }
}
