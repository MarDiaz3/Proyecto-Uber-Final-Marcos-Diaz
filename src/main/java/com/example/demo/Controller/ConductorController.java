package com.example.demo.Controller;

import com.example.demo.Models.Conductor;
import com.example.demo.Service.ConductorService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;



@Controller
@RequestMapping("/conductores")
public class ConductorController {
private final ConductorService conductorService;

public ConductorController (ConductorService conductorService){
    this.conductorService = conductorService;}

    //indexPrimer HTML
    @GetMapping ("/")
    public String index(){
        return "index"; 
    }


    //Ver Lista de conductores activos=true
    @GetMapping("/conductores")
    public String traeListaConductores(Model model) {
        List<Conductor> conductores = conductorService.traeListaConductores();
        model.addAttribute("conductores", conductores);
        return "cardConductores";//htmlm
    }

    //Mostrar form. donde se registra nuevos conductores
    @GetMapping("/nuevoConductor")
    public String FormRegistroConductor( Model model){
       model.addAttribute("condutor", new Conductor());
        return "formConductores"; //html registra nuevo conductores
    }

    //guardar nuevos conductores(id)
    @PostMapping("/guardarNuevoConductor")
    public String RegistrarNuevoConductores(@ModelAttribute Conductor conductor){
        conductorService.crearConductor(conductor);
        return "redirect:/conductores/conductores";//vuelve a la lisa de nuevos conductores
    }

    //eliminar conductor(ocultar de true a false)
    @PostMapping("/eliminarConductor/{Id}")
    public String eliminarConductor (@PathVariable Integer Id){
        conductorService.eliminarOcultarConductor(Id);
        return "redirect:/conductores/conductores";
    }


    //Ver todos los detalles de conductor
    @GetMapping("/detallesDeCondutor/{Id}")
    public String verDetallesDeConductor(@PathVariable Integer Id, Model model) {
        Conductor conductor = conductorService.traeConductorPorId(Id);//llama al service para obtener el conduct
      
        if (conductor == null) {
        return "redirect:/coductores/conductores"; //si es nulo vuelve a la lista
    }

    Integer edad = Period.between(conductor.getFechaDeNacimiento(), LocalDate.now()).getYears();
    model.addAttribute("edad", edad); //agrega edad calculada(fechaNac - ahora = edad)

    model.addAttribute("conductor", conductor);
    return "detalleConductor"; //vist de todos los detalles de conductor


    }

    
}
