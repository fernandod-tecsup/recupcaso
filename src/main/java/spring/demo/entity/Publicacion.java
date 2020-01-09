/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "publicacion")
public class Publicacion implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pub_id;
    private String pub_contenido;
    private String titulo;
    private Long user_id;

    public Publicacion() {
    }

    public Long getPub_id() {
        return pub_id;
    }

    public void setPub_id(Long pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_contenido() {
        return pub_contenido;
    }

    public void setPub_contenido(String pub_contenido) {
        this.pub_contenido = pub_contenido;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "pub_id=" + pub_id + ", pub_contenido=" + pub_contenido + ", titulo=" + titulo + ", user_id=" + user_id + '}';
    }
    
    
    
    
    
    
}
