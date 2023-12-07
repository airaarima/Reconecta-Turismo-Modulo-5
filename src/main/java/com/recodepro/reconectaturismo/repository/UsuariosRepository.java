package com.recodepro.reconectaturismo.repository;

import com.recodepro.reconectaturismo.model.Usuarios;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SELECT * FROM PASSAGENS WHERE usuario = :id_usuario ")
    List<Object[]> getAllPassagensUsuario(@Param("id_usuario") Long id_usuario);
}
