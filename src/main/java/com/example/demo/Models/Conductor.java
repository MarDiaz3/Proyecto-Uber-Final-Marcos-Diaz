package com.example.demo.Models;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity

public class Conductor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Integer Id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fechaDeNacimient;
    @Column
    private String automovil;

    @Enumerated (EnumType.STRING)
    private TipoDeAutomovil tipoDeAutomovil;
    //relacion uno a uno 
    @OneToOne (mappedBy = "conductor", cascade = CascadeType.ALL)
    private Viaje viaje;
    private boolean estado = true; 

    //constructorVacio
public Conductor()  {
}

//constructoresParametros
public Conductor (String nombre,String apellido,LocalDate fechaDeNacimient,String automovil, TipoDeAutomovil tipoDeAutomovil,boolean estado){

    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimient = fechaDeNacimient;
    this.automovil = automovil;
    this.tipoDeAutomovil = tipoDeAutomovil;
    this.estado = estado;
    
}

    //getters.setters
public Integer getId(){
    return Id;
}
public void setId(Integer Id){
this.Id = Id; 
}


public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
this.nombre = nombre;
}


public String getApellido(){
    return apellido;
}
public void setApellido(String apellido){
this.apellido = apellido; 
}


public LocalDate getFechaDeNacimient(){
    return fechaDeNacimient;
}
public void setNechaDeNacimient(LocalDate fechaDeNacimient){
this.fechaDeNacimient = fechaDeNacimient; 
}


public String getAutomovil(){
    return automovil;
}
public void setAutomovil(String automovil){
this.automovil = automovil; 
}


public TipoDeAutomovil getTipoAutomovil(){
    return tipoDeAutomovil;
}
public void setTipoAutomovil(TipoDeAutomovil tipoDeAutomovil){
this.tipoDeAutomovil = tipoDeAutomovil; 
}


public boolean getEstado(){
    return estado;
}
public void setEstado(boolean estado){
this.estado = estado;
}

    
}
