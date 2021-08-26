package com.fleta.purchasingservice.port;

import com.fleta.purchasingservice.domain.model.PtVoBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPtVoBuyRepository extends CrudRepository<PtVoBuy, Long> {
    // just to avoid having unambigous methods
    @Override
    List<PtVoBuy> findAll();

    @Override
    Optional<PtVoBuy> findById(Long id);

    @Override
    <S extends PtVoBuy> S save(S entity);
}
