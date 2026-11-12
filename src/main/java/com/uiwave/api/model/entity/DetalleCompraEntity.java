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
 * Línea de una compra: producto, cantidad y precio del momento de la compra.
 *
 * <p>
 * El precio queda congelado aquí (histórico); el precio vigente vive en
 * {@link ProductoEntity}. Un producto solo puede aparecer una vez por compra
 * ({@code uk_detalles_compra_compra_producto}).
 * </p>
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalles_compra", uniqueConstraints = @UniqueConstraint(name = "uk_detalles_compra_compra_producto", columnNames = {
                "compra_id",
                "producto_id" }), indexes = @Index(name = "idx_detalles_compra_producto", columnList = "producto_id"))
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class DetalleCompraEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_detalles_compra_producto"))
        private ProductoEntity producto;

        @Column(name = "precio_compra", nullable = false, precision = 12, scale = 2)
        private BigDecimal precioCompra;

        @Column(name = "cantidad", nullable = false, precision = 14, scale = 3)
        private BigDecimal cantidad;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "compra_id", nullable = false, foreignKey = @ForeignKey(name = "fk_detalles_compra_compra"))
        private CompraEntity compra;
}
