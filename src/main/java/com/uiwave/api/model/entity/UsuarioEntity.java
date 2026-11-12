package com.uiwave.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * Usuario del sistema con sus credenciales de acceso.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios", uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuarios_correo", columnNames = "correo"),
                @UniqueConstraint(name = "uk_usuarios_numero_documento", columnNames = "numero_documento")
}, indexes = {
                @Index(name = "idx_usuarios_tipo_documento", columnList = "tipo_documento_id"),
                @Index(name = "idx_usuarios_rol", columnList = "rol_id")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @EqualsAndHashCode.Include
        @ToString.Include
        private Long id;

        @Column(name = "nombre", nullable = false, length = 150)
        private String nombre;

        @Column(name = "correo", nullable = false, length = 120)
        private String correo;

        @Column(name = "estado", nullable = false)
        private boolean estado;

        /**
         * Hash de la contraseña. Nunca se expone en respuestas JSON.
         */
        @JsonIgnore
        @Column(name = "contrasena", nullable = false, length = 255)
        private String contrasena;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "tipo_documento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarios_tipo_documento"))
        private TipoDocumentoEntity tipoDocumento;

        @Column(name = "numero_documento", nullable = false, length = 20)
        private String numeroDocumento;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "rol_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarios_rol"))
        private RolEntity rol;
}
