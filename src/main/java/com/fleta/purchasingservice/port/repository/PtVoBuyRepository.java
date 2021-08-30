package com.fleta.purchasingservice.port.repository;

import com.fleta.purchasingservice.domain.model.PtVoBuy;

import java.util.List;
import java.util.Optional;

public interface PtVoBuyRepository {
    List<PtVoBuy> findAll();

    Optional<PtVoBuy> findById(Long id);

    <S extends PtVoBuy> S save(S entity);

}
