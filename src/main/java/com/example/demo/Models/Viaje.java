package com.example.demo.Models;

import jakarta.persistence.*;


@Entity//tabla en mysql
public class Viaje {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Enumerated(EnumType.STRING)
    private TipoDeViaje tipo;
    
    @Column
    private  double costo;  
    @Column
    private String nombreDeCliente; 
    @Column
    private Integer DNI;
    @Column
    private String lugarDepartida; 
    @Column
    private String lugarDestino;
    @Column
    private boolean estado = true;


//relacion muchos a uno se ve distinto de los dos models
@ManyToOne
@JoinColumn (name = "conductor_id")
private Conductor conductor;


 //constructorVacio
 public Viaje()  { }
 //constructoresParametros
public Viaje (TipoDeViaje tipo,double costo,String nombreDeCliente, Integer DNI,String lugarDepartida, String lugarDestino, Conductor conductor) {
    
    this.tipo = tipo;
    this.nombreDeCliente = nombreDeCliente;
    this.DNI = DNI;
    this.lugarDepartida = lugarDepartida;
    this.lugarDestino = lugarDestino;
    this.conductor = conductor;
    this.costo = calcularCostoViaje(tipo, conductor);
}


//metod para saber cost de viaje
    private double calcularCostoViaje(TipoDeViaje tipo, Conductor conductor){
        double precioBase= switch (tipo){
            case CORTO -> 7000;
            case MEDIO -> 10000;
            case LARGO -> 20000;
        };

     double adicional = switch (conductor.getTipoAutomovil()){
        case BASE -> 0;
        case LUXE -> 0.10;
        case PREMIUM -> 0.20;
    };
    return precioBase* + adicional;
    }


 //getters.setters
public Integer getId(){
    return Id;}
public void setId(Integer Id){
this.Id = Id; }


public TipoDeViaje getTipo(){
    return tipo;}
public void setTipo(TipoDeViaje tipo){
this.tipo = tipo; }

public String getNombreDeCliente(){
    return nombreDeCliente;}
public void setNombreDeCliente(String nombreDeCliente){
this.nombreDeCliente = nombreDeCliente; }

public Integer getDNI(){
    return DNI;}
public void setDNI(Integer DNI){
this.DNI = DNI; }

public String getLugarDepartida(){
    return lugarDepartida;}
public void setLugarDepartida(String lugarDepartida){
this.lugarDepartida = lugarDepartida; }


public String getLugarDestino(){
    return lugarDestino;}
public void setId(String lugarDestino){
this.lugarDestino = lugarDestino; }


public Conductor getConductor(){
    return conductor;}
public void setConductor(Conductor conductor){
this.conductor = conductor; 
this.costo= calcularCostoViaje(this.tipo, conductor);
}

public boolean getEstado(){
    return estado;
}
public void setEstado(boolean estado){
this.estado = estado;
}



}