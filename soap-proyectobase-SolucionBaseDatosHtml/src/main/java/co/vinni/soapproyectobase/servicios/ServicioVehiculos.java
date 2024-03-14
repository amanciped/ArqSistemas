package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.entidades.Vehiculo;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioVehiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicioVehiculos implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioVehiculo repoVehiculo;

    public VehiculoDto actualizarVehiculo(VehiculoDto vehiculoDto) {
        repoVehiculo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
        return vehiculoDto;
    }

    public void eliminarVehiculo(long serial) {
        repoVehiculo.deleteById(serial);
    }

    public VehiculoDto registrarVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = repoVehiculo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
        return modelMapper.map(vehiculo, VehiculoDto.class);
    }

    public List<VehiculoDto> obtenerVehiculos() {
        TypeToken<List<VehiculoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoVehiculo.findAll(), typeToken.getType());
    }

    public VehiculoDto obtenerVehiculo(long id) {
        Vehiculo vehiculo = repoVehiculo.findById(id).orElseThrow(ResourceNotFoundException::new);
        return modelMapper.map(vehiculo, VehiculoDto.class);
    }

}
