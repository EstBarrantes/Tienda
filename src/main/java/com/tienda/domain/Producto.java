
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data; //se generan los get y set por defecto

@Data
@Entity //esta clase va a mapear una tabla de la base de datos
@Table(name="producto")

public class Producto implements Serializable{ //Serializable para poder enviar objetos a internet
    private static final long serialVersionUID =1l;//se va a usar internamente para asignar los valores
    @Id //por medio del atributo de abajo se mapean las filas
    @GeneratedValue(strategy = GenerationType.IDENTITY)//que la base de datos sea la que se encargue de asignar el id 
    @Column(name="id_producto") //Da a notar que el valor de abajo va a representar cierta columna de la tabla
    
    private Long idProducto;
    //private Long idCategoria; no se utiliza más por el QManyToOne
    private String descripcion;
    private String detalle;
    private double precio; 
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
