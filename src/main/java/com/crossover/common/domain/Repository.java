package com.crossover.common.domain;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface Repository<T extends EntityBase> extends PagingAndSortingRepository<T, Integer> {
}
