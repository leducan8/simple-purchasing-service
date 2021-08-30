package com.fleta.purchasingservice.adapter.persistence;

import com.fleta.purchasingservice.domain.model.PtVoBuy;
import com.fleta.purchasingservice.port.repository.JpaPtVoBuyRepository;
import com.fleta.purchasingservice.port.repository.PtVoBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PtVoBuyRepositoryImpl implements PtVoBuyRepository {
    @Autowired
    private JpaPtVoBuyRepository repository;

    @Override
    public List<PtVoBuy> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PtVoBuy> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public <S extends PtVoBuy> S save(S entity) {
        return repository.save(entity);
    }
}
