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
 * Proveedor: persona o empresa a la que se le compra mercadería.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedores", uniqueConstraints = @UniqueConstraint(name = "uk_proveedores_numero_documento", columnNames = "numero_documento"), indexes = @Index(name = "idx_proveedores_tipo_documento", columnList = "tipo_documento_id"))
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ProveedorEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "tipo_documento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_proveedores_tipo_documento"))
        private TipoDocumentoEntity tipoDocumento;

        @Column(name = "nombre", nullable = false, length = 255)
        private String nombre;

        @Column(name = "estado", nullable = false)
        private boolean estado;

        @Column(name = "numero_documento", nullable = false, length = 20)
        private String numeroDocumento;
}
