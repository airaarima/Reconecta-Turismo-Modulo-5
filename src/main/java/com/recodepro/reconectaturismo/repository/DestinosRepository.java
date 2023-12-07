package com.recodepro.reconectaturismo.repository;

import com.recodepro.reconectaturismo.model.Destinos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinosRepository extends JpaRepository<Destinos,Long> {
}
