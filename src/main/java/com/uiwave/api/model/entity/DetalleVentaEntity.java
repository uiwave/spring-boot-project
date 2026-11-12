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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Línea de una venta: producto, cantidad y precio del momento de la venta.
 *
 * <p>
 * El precio queda congelado aquí (histórico); el precio vigente vive en
 * {@link ProductoEntity}. Un producto solo puede aparecer una vez por venta
 * ({@code uk_detalles_venta_venta_producto}).
 * </p>
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalles_venta", uniqueConstraints = @UniqueConstraint(name = "uk_detalles_venta_venta_producto", columnNames = {
                "venta_id",
                "producto_id" }), indexes = @Index(name = "idx_detalles_venta_producto", columnList = "producto_id"))
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class DetalleVentaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_detalles_venta_producto"))
        private ProductoEntity producto;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "venta_id", nullable = false, foreignKey = @ForeignKey(name = "fk_detalles_venta_venta"))
        private VentaEntity venta;

        @Column(name = "cantidad", nullable = false, precision = 14, scale = 3)
        private BigDecimal cantidad;

        @Column(name = "precio_venta", nullable = false, precision = 12, scale = 2)
        private BigDecimal precioVenta;
}
