package com.crossover.common.domain;

import com.google.common.base.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DomainServiceBase<TEntity extends EntityBase> implements DomainService<TEntity> {

    private Class<?> entityClass;
    private Repository<TEntity> repository;

    public DomainServiceBase(Class<?> entityClass, Repository<TEntity> repository) {
        this.entityClass = entityClass;
        this.repository = repository;
    }

    @Override
    public TEntity create() {
        try {
            return newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected TEntity newInstance() throws IllegalAccessException, InstantiationException {
        return (TEntity) entityClass.newInstance();
    }

    @Override
    public Optional<TEntity> getById(int id) {
        return Optional.fromNullable(repository.findOne(id));
    }

    @Override
    public Page<TEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public TEntity save(TEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
