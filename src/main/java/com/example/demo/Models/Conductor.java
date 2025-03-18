package com.example.demo.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDate fechaDeNacimiento; //año,mes,dia //fecha actual=edad de la persona
    @Column
    private String automovil;
   
 
    @Enumerated(EnumType.STRING)
    private TipoAutomovil tipoAutomovil; 
    //relacion uno a muchos se ve distinto de los dos modelos
    @OneToMany (mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<Viaje> viajes = new ArrayList<>();
    
    @Column
    private boolean estado = true; 

    //constructorVacio
public Conductor()  {
}

//constructoresParametros
public Conductor (String nombre,String apellido,LocalDate fechaDeNacimiento,String automovil, TipoAutomovil tipoAutomovil,boolean estado){

    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.automovil = automovil;
    this.tipoAutomovil = tipoAutomovil;
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


public LocalDate getFechaDeNacimiento() {
    return fechaDeNacimiento;
}

public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
} 


public String getAutomovil(){
    return automovil;
}
public void setAutomovil(String automovil){
this.automovil = automovil; 
}


public TipoAutomovil getTipoAutomovil() {
    return tipoAutomovil;
}

public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
    this.tipoAutomovil = tipoAutomovil;
} 


public List<Viaje> getViaje(){
    return viajes;
}
public void setViaje(List<Viaje> viajes){
this.viajes = viajes; 
}


public boolean getEstado(){
    return estado;
}
public void setEstado(boolean estado){
this.estado = estado;
}

    
}
