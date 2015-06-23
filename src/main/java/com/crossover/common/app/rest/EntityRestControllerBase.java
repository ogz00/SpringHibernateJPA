package com.crossover.common.app.rest;

import com.crossover.common.domain.DomainService;
import com.crossover.common.domain.EntityBase;

public class EntityRestControllerBase<TEntity extends EntityBase,
        TService extends DomainService<TEntity>>
        extends RestControllerBase<TEntity, TEntity, TService> {

    protected EntityRestControllerBase(TService service) {
        super(service);
    }
}
