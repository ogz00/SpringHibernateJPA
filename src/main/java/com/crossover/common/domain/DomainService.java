package com.crossover.common.domain;

import com.google.common.base.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomainService<TEntity> {
    TEntity create();
    Optional<TEntity> getById(int id);
    Page<TEntity> getAll(Pageable page);

    TEntity save(TEntity entity);
    void delete(int id);
}
