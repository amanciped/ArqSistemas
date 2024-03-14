package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Vehiculo")
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEHICULOS")
    @SequenceGenerator(name = "SEQ_VEHICULOS", sequenceName = "SEQ_VEHICULOS", allocationSize = 1)

    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "PLACA", nullable = false)
    private String placa;

    @Column(name = "CILINDRADAJE", nullable = false)
    private long cilindradaje;

    @Column(name = "MARCA", nullable = false)
    private String marca;

    @Column(name = "MODELO", nullable = false)
    private long modelo;

    @Column(name = "PRECIO", nullable = false)
    private long precio;

    @Column(name = "PROPIETARIO", nullable = false)
    private String propietario;

    @Column(name = "IDENTIFICACION", nullable = false)
    private long identificacion;
}
