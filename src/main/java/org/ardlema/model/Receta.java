package org.ardlema.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="RECETA")
public class Receta implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;

    @Column(name="NOMBRE")
    private String nombreReceta;

    @Column(name="DIFICULTAD")
    private Integer dificultad;

    @Column(name="ELABORACION")
    private String elaboracion;

    public Receta() {
    }

    public Receta(String nombreReceta, Integer dificultad, String elaboracion) {
        this.nombreReceta = nombreReceta;
        this.dificultad = dificultad;
        this.elaboracion = elaboracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }
}
