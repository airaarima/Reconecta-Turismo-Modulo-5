package com.recodepro.reconectaturismo.repository;

import com.recodepro.reconectaturismo.model.Passagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassagensRepository extends JpaRepository<Passagens,Long> {
}
