package com.recodepro.reconectaturismo.repository;

import com.recodepro.reconectaturismo.model.Passagens;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassagensRepository extends JpaRepository<Passagens,Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select usuarios.nome_completo, destinos.cidade, passagens.local_partida, " +
            "passagens.data_partida, passagens.data_retorno from passagens, destinos, " +
            "usuarios where usuarios.id=passagens.usuario and destinos.id=passagens.destino;")
    List<Object[]> getAllPassagens();
}
