package com.uiwave.api.model.entity;

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
 * Cabecera de una venta (comprobante de venta).
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventas", uniqueConstraints = @UniqueConstraint(name = "uk_ventas_numero_comprobante", columnNames = "numero_comprobante"), indexes = {
                @Index(name = "idx_ventas_cliente", columnList = "cliente_id"),
                @Index(name = "idx_ventas_usuario", columnList = "usuario_id"),
                @Index(name = "idx_ventas_tipo_comprobante", columnList = "tipo_comprobante_id")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class VentaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "tipo_comprobante_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ventas_tipo_comprobante"))
        private TipoComprobanteEntity tipoComprobante;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ventas_usuario"))
        private UsuarioEntity usuario;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ventas_cliente"))
        private ClienteEntity cliente;

        @Column(name = "numero_comprobante", nullable = false, length = 20)
        private String numeroComprobante;
}
