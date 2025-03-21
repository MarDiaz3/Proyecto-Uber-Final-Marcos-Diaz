package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Conductor;
import com.example.demo.Models.TipoDeViaje;
import com.example.demo.Models.Viaje;
import com.example.demo.Service.ConductorService;
import com.example.demo.Service.ViajeService;
@RequestMapping("/viaje")
@Controller
public class ViajeController {
    private final ViajeService viajeService;
    private final ConductorService conductorService;

    public ViajeController(ViajeService viajeService, ConductorService conductorService){
        this.viajeService = viajeService;
        this.conductorService = conductorService; }

    //mostrar y ver el form. con el conductor que se eligio o cargo
    @GetMapping("/formViajeReserv/{IdConductor}")
    public String VerFormulario(@PathVariable("IdConductor")Integer IdConductor, Model model){
        Conductor conductor = conductorService.traeConductorPorId(IdConductor);
        if (conductor == null) {
            return "redirect:/conductores?error=ConductorNoExiste";  }
            model.addAttribute("tiposViaje", TipoDeViaje.values());
            model.addAttribute("conductor", conductor); //un conductor
            return "formViaje";  }



    //imprimir y mostrar el resumen del viaje UBER
    @PostMapping("/AceptarElViaje")
    public String AceptarViaje (
        @RequestParam("tipoViaje") TipoDeViaje tipoViaje,
        @RequestParam("nombreDeCliente") String nombreDeCliente,
        @RequestParam("DNI") Integer DNI,
        @RequestParam("lugarDepartida") String lugarDepartida,
        @RequestParam("lugarDestino") String  lugarDestino,
        @RequestParam("conductorId") Integer conductorId,
        Model model ) {
            Conductor conductor = conductorService.traeConductorPorId(conductorId);
            if (conductor == null) {
                return "redirect:/conductores?error=ConductorNoExiste";   }
            
            Viaje nuevoViaje = new Viaje(tipoViaje,conductorId,nombreDeCliente,DNI,lugarDepartida,lugarDestino,conductor);
            viajeService.guardarViaje(nuevoViaje);

            model.addAttribute("viaje", nuevoViaje); //guarda todos los datos del Viaje UBER
            return "resumenViaje";

        }

}