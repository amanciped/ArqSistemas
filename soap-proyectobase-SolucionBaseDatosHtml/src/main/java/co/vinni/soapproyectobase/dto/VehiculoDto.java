package co.vinni.soapproyectobase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehiculoDto implements Serializable{
    private long id;
    private String placa;
    private long cilindradaje;
    private String marca;
    private long modelo;
    private long precio;
    private String propietario;
    private long identificacion;
}
