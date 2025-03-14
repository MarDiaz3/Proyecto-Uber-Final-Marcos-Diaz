package com.example.demo.Service;

import com.example.demo.Models.Conductor;
import com.example.demo.Repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

      //obtiene tddos los Conductores verdaderos (est=true)
    public List<Conductor> traeConductores() { //trae todos los pruduct de la BD
    return conductorRepository.findByEstadoTrue();
    }

    //trae Conductores Por ID(busca el id)
    public Conductor traeConductorPorId (Integer Id) {
        if (Id == null) {
            throw new IllegalArgumentException("El Id no puede ser nulo");
        }
        return conductorRepository.findById(Id).orElse(null);
    }

     //crea un nuevo coductor uno por id
     public void crearConductor (Conductor conductor){
        if (conductor == null) {
            throw new IllegalArgumentException ("El producto no puede ser nulo, no puede estar vacio");
        }
        conductorRepository.save (conductor);
        }

         //eliminar conductor(actualizar el estado a false o esconder)
    public Conductor eliminarConductor (Integer Id) {
        if(Id == null) {
            throw new IllegalArgumentException("El id no puede ser null");
        }
        Conductor conductor = conductorRepository.findById(Id).orElse(null);
        if (conductor != null) {
            conductor.setEstado(false);
            return conductorRepository.save(conductor);
        }
        return null;

    }

    
}
