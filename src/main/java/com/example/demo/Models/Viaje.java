package com.example.demo.Models;

import jakarta.persistence.*;

public class Viaje {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private String nombreDeCliente; 
    @Column
    private String lugarDepartida; 
    @Column
    private String lugarDestino;

 //constructorVacio
 public Viaje()  { }
 //constructoresParametros
public Viaje (Integer Id,String nombreDeCliente,String lugarDepartida, String lugarDestino) {
    this.Id = Id;
    this.nombreDeCliente = nombreDeCliente;
    this.lugarDepartida= lugarDepartida;
    this.lugarDestino = lugarDestino;
}
 //getters.setters
public Integer getId(){
    return Id;}
public void setId(Integer Id){
this.Id = Id; }


public String getNombreDeCliente(){
    return nombreDeCliente;}
public void setNombreDeCliente(String nombreDeCliente){
this.nombreDeCliente = nombreDeCliente; }


public String getLugarDepartida(){
    return lugarDepartida;}
public void setLugarDepartida(String lugarDepartida){
this.lugarDepartida = lugarDepartida; }


public String getLugarDestino(){
    return lugarDestino;}
public void setId(String lugarDestino){
this.lugarDestino = lugarDestino; }


}
