/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.demo.API;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.entity.Usuario;
import spring.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository repository;
    
    
    @GetMapping("/usuarios")
    public List<Usuario> buscartodos(){
        return repository.findAll();
    }
    
    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
    
    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> buscarId(@PathVariable(value="id") Long id){
        return repository.findById(id);
    }
    
    @PutMapping("/usuarios/{id}")
    Usuario updateUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id){
        return repository.findById(id).map(usuario -> {
            usuario.setNombre(newUsuario.getNombre());
            usuario.setApellidos(newUsuario.getApellidos());
            usuario.setTipo(newUsuario.getTipo());
            usuario.setCorreo(newUsuario.getCorreo());
            usuario.setPassword(newUsuario.getPassword());
            return repository.save(usuario);
        }).orElseGet(() -> {
            newUsuario.setUser_id(id);
            return repository.save(newUsuario);
        });
    }
            
    @DeleteMapping("/usuarios/{id}")
    void eliminar(@PathVariable Long id){
                repository.deleteById(id);
    }
    
}
