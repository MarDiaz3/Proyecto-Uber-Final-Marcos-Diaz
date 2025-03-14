package com.example.demo.Repository;

import com.example.demo.Models.Viaje; //llama hace el crud del model Viaje
import org.springframework.data.jpa.repository.JpaRepository; //llama a la librari para hacer la conexion de java y mysql
import java.util.List;

//integer por el ID
public interface ViajeRepository extends JpaRepository <Viaje, Long> {
//busca Viajes activos
List<Viaje> findByEstadoTrue(); 
    
}     
