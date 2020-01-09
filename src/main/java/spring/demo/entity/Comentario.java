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
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "comentario")
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long com_id;
    private String com_contenido;
    private Long pub_id;
    private Long user_id;

    public Comentario() {
    }
    

    public Long getCom_id() {
        return com_id;
    }

    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }

    public String getCom_contenido() {
        return com_contenido;
    }

    public void setCom_contenido(String com_contenido) {
        this.com_contenido = com_contenido;
    }

    public Long getPub_id() {
        return pub_id;
    }

    public void setPub_id(Long pub_id) {
        this.pub_id = pub_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Comentario{" + "com_id=" + com_id + ", com_contenido=" + com_contenido + ", pub_id=" + pub_id + ", user_id=" + user_id + '}';
    }
    
}
