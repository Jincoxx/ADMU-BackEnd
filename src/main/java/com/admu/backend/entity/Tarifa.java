package com.admu.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tarifas")
public class Tarifa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_compania", nullable = false)
    private String nombreCompania;
    
    @Column(name = "ruta", nullable = false)
    private String ruta;
    
    @Column(name = "tarifa", nullable = false)
    private String tarifa;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "condicion")
    private String condicion;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    // Constructores
    public Tarifa() {}
    
    public Tarifa(String nombreCompania, String ruta, String tarifa, String tipo) {
        this.nombreCompania = nombreCompania;
        this.ruta = ruta;
        this.tarifa = tarifa;
        this.tipo = tipo;
    }
    
    public Tarifa(String nombreCompania, String ruta, String tarifa, String tipo, String condicion, String descripcion) {
        this.nombreCompania = nombreCompania;
        this.ruta = ruta;
        this.tarifa = tarifa;
        this.tipo = tipo;
        this.condicion = condicion;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreCompania() {
        return nombreCompania;
    }
    
    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }
    
    public String getRuta() {
        return ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public String getTarifa() {
        return tarifa;
    }
    
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getCondicion() {
        return condicion;
    }
    
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

