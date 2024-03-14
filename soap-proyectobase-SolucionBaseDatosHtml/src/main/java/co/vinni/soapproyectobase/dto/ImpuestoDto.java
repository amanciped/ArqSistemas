package co.vinni.soapproyectobase.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImpuestoDto implements Serializable{
    private long referencia;
    private long anioLiquidado;
    private double valor;
    private String placa;
    private long modelo;
    private String fechaPago;
    private String estado;
}
