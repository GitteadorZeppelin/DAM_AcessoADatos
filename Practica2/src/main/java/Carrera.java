/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gyro
 */
public class Carrera {
    
    private String id;
    private String nombre;
    private String escuderia;
    private String modelo;
    private String circuito;
    private String ano;
    private String velocidad;

    public Carrera(String id, String nombre, String escuderia, String modelo, String circuito, String ano, String velocidad) {
        this.setId(id);
        this.setNombre(nombre);
        this.setEscuderia(escuderia);
        this.setModelo(modelo);
        this.setCircuito(circuito);
        this.setAno(ano);
        this.setVelocidad(velocidad);
    }
////////////////////////////////////////////////////////////////////////////////
    
   
    
////////////////////////////////////////////////////////////////////////////////    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String año) {
        this.ano = año;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    
    
}
