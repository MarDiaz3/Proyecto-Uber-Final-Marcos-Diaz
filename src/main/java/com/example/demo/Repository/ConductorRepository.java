package com.example.demo.Repository;

import com.example.demo.Models.Conductor; //llama hace el crud del model Conductor
import org.springframework.data.jpa.repository.JpaRepository; //llama a la librari para hacer la conexion de java y mysql
import java.util.List;

//integer por el ID
public interface ConductorRepository extends JpaRepository <Conductor, Integer> {
//busca Conductores activos
List<Conductor> findByEstadoTrue();
    
}     
