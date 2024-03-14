package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Impuesto")
@Table(name = "IMPUESTOS")
public class Impuesto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMPUESTOS")
    @SequenceGenerator(name = "SEQ_IMPUESTOS", sequenceName = "SEQ_IMPUESTOS", allocationSize = 1)

    @Column(name = "REFERENCIA", nullable = false)
    private long referencia;

    @Column(name = "ANIO_LIQUIDADO", nullable = false)
    private long anioLiquidado;

    @Column(name = "VALOR", nullable = false)
    private double valor;

    @Column(name = "PLACA", nullable = false)
    private String placa;

    @Column(name = "MODELO", nullable = false)
    private long modelo;

    @Column(name = "FECHA_PAGO", nullable = false)
    private String fechaPago;

    @Column(name = "ESTADO", nullable = false)
    private String estado;


}
