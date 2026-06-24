package com.example.primeiroAppSpring.repository;

import com.example.primeiroAppSpring.model.Usuario;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail ( String email);

    boolean existsByEmail ( String email);

}
