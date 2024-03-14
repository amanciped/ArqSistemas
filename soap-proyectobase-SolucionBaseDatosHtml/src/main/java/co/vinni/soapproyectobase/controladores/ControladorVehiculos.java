package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.servicios.ServicioVehiculos;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller

public class ControladorVehiculos {
    private static final Logger logger = LogManager.getLogger(ControladorVehiculos.class);

    @Autowired
    ServicioVehiculos servicioVehiculos;

    @PostMapping("vehiculos")
    public String registrarVehiculo(@ModelAttribute("vehiculo") VehiculoDto vehiculo) {
        servicioVehiculos.registrarVehiculo(vehiculo);
        return "redirect:/vehiculos";
    }

    @PostMapping("/vehiculos/{serial}")
    public String modificarVehiculo(@PathVariable long serial,@ModelAttribute( "vehiculo") VehiculoDto vehiculoDto, Model model){
        model.addAttribute("vehiculo", servicioVehiculos.actualizarVehiculo(vehiculoDto));
        return "redirect:/vehiculos";
    }

    @GetMapping("/vehiculos/{serial}")
    public String eliminarVehiculo(@PathVariable long serial){
        servicioVehiculos.eliminarVehiculo(serial);
        return "redirect:/vehiculos";
    }

    @GetMapping({  "/vehiculos"})
    public String listarVehiculos(Model model){
        logger.info("Verificando ");
        model.addAttribute("vehiculos",servicioVehiculos.obtenerVehiculos());
        return "vehiculos";
    }

    @GetMapping({  "/vehiculos/nuevo"})
    public String mostrarForm(Model model){
        VehiculoDto vehiculoDto = new VehiculoDto();
        model.addAttribute("vehiculo", vehiculoDto);
        return "registrar_vehiculo";
    }

    @GetMapping("/vehiculos/modificar/{serial}")
    public String mostrarFormEditar(@PathVariable long serial, Model model){
        VehiculoDto vehiculoDto = new VehiculoDto();
        model.addAttribute("vehiculo", servicioVehiculos.obtenerVehiculo(serial));
        return "editar_vehiculo";
    }

}
