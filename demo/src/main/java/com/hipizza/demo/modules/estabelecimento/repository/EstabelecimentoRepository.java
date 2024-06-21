package com.hipizza.demo.modules.estabelecimento.repository;

import com.hipizza.demo.modules.estabelecimento.domain.Estabelecimento;
import com.hipizza.demo.projection.EstabelecimentoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    List<EstabelecimentoProjection> findAllBy();

    Optional<Estabelecimento> findByEmail(String email);
}
