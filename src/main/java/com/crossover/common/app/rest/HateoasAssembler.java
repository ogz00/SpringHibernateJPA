package com.crossover.common.app.rest;

import com.crossover.common.domain.Identifiable;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

public class HateoasAssembler<TEntity extends Identifiable> extends ResourceAssemblerSupport<TEntity, Resource> {

    private Class<?> controllerClass;

    public HateoasAssembler(Class<?> controllerClass) {
        super(controllerClass, Resource.class);
        this.controllerClass = controllerClass;
    }

    public List<Resource> toResources(Iterable<? extends TEntity> entities) {
        return FluentIterable.from(entities).transform(new Function<TEntity, Resource>() {
            public Resource apply(TEntity e) { return new Resource(e, createResourceWithId(e.getId(), e).getLink("self")); }
        }).toList();
    }

    @Override
    public Resource toResource(TEntity entity) {
        return new Resource(entity, ControllerLinkBuilder.linkTo(controllerClass)
                .slash(Integer.valueOf(entity.getId())).withSelfRel());
    }
}
