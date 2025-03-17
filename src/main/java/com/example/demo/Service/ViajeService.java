package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Viaje;
import com.example.demo.Repository.ViajeRepository;
@Service
public class ViajeService {
    @Autowired
    private ViajeRepository viajeRepository;

    //guardar en BD un viaje
    public Viaje guardarViaje(Viaje viaje){
        return viajeRepository.save(viaje);}
    
    //buscar un viaje por un ID
 public Viaje buscarViajeConId(Integer Id) {
    return viajeRepository.findById(Id).orElse(null);  }
 
}
