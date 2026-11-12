package com.uiwave.api.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Producto del inventario.
 *
 * <p>
 * {@code stock} es {@code NUMERIC(14,3)} para admitir unidades
 * fraccionarias (kg, litros, metros) y stock negativo.
 * </p>
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos", indexes = {
                @Index(name = "idx_productos_categoria", columnList = "categoria_id"),
                @Index(name = "idx_productos_nombre", columnList = "nombre")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ProductoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @Column(name = "nombre", nullable = false, length = 255)
        private String nombre;

        @Column(name = "descripcion", length = 500)
        private String descripcion;

        @Column(name = "stock", nullable = false, precision = 14, scale = 3)
        private BigDecimal stock;

        @Column(name = "precio_compra", nullable = false, precision = 12, scale = 2)
        private BigDecimal precioCompra;

        @Column(name = "precio_venta", nullable = false, precision = 12, scale = 2)
        private BigDecimal precioVenta;

        @Column(name = "estado", nullable = false)
        private boolean estado;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "categoria_id", nullable = false, foreignKey = @ForeignKey(name = "fk_productos_categoria"))
        private CategoriaEntity categoria;
}
