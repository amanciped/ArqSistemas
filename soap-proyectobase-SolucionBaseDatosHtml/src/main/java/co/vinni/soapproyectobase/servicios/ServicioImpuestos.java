package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.ImpuestoDto;
import co.vinni.soapproyectobase.entidades.Impuesto;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioImpuesto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicioImpuestos implements Serializable {

    private ModelMapper modelMapper;

    private RepositorioImpuesto repoImpuesto;

    public ImpuestoDto actualizarImpuesto(ImpuestoDto impuestoDto) {
        repoImpuesto.save(modelMapper.map(impuestoDto, Impuesto.class));
        return impuestoDto;
    }
    
    public void eliminarImpuesto(long serial) {
        repoImpuesto.deleteById(serial);
    }

    public ImpuestoDto registrarImpuesto(ImpuestoDto impuestoDto) {
        Impuesto impuesto = repoImpuesto.save(modelMapper.map(impuestoDto, Impuesto.class));
        return modelMapper.map(impuesto, ImpuestoDto.class);
    }

    public List<ImpuestoDto> obtenerImpuestos() {
        TypeToken<List<ImpuestoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoImpuesto.findAll(), typeToken.getType());
    }

    public ImpuestoDto obtenerImpuesto(long id) {
        Impuesto impuesto = repoImpuesto.findById(id).orElseThrow(ResourceNotFoundException::new);
        return modelMapper.map(impuesto, ImpuestoDto.class);
    }

}
