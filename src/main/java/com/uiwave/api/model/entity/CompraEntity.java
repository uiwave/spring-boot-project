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
 * Cabecera de una compra a un proveedor.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compras", uniqueConstraints = @UniqueConstraint(name = "uk_compras_numero_comprobante", columnNames = "numero_comprobante"), indexes = {
                @Index(name = "idx_compras_proveedor", columnList = "proveedor_id"),
                @Index(name = "idx_compras_usuario", columnList = "usuario_id"),
                @Index(name = "idx_compras_tipo_comprobante", columnList = "tipo_comprobante_id")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class CompraEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "tipo_comprobante_id", nullable = false, foreignKey = @ForeignKey(name = "fk_compras_tipo_comprobante"))
        private TipoComprobanteEntity tipoComprobante;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_compras_usuario"))
        private UsuarioEntity usuario;

        @Column(name = "numero_comprobante", nullable = false, length = 20)
        private String numeroComprobante;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "proveedor_id", nullable = false, foreignKey = @ForeignKey(name = "fk_compras_proveedor"))
        private ProveedorEntity proveedor;
}
