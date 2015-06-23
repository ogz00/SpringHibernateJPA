package com.crossover.common.app.rest;

import com.crossover.common.domain.DomainService;
import com.crossover.common.domain.EntityBase;
import com.crossover.common.domain.Identifiable;
import com.google.common.base.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

public abstract class RestControllerBase<TRep extends Identifiable, TEntity extends EntityBase, TService extends DomainService<TEntity>> {
    protected final ResourceAssemblerSupport entityAssembler;
    protected final TService entityService;

    protected RestControllerBase(TService service) {
        this.entityService = service;
        this.entityAssembler = new HateoasAssembler<>(this.getClass());
    }

    @RequestMapping("/{id}")
    public ResourceSupport get(@PathVariable int id) {
        Optional<TEntity> result = entityService.getById(id);
        if (result.isPresent())
            return toResource(entityToRep(result.get()));
        throw new NotFoundException(id);
    }

    @RequestMapping("/create")
    public ResourceSupport get() {
        return toResource(entityToRep(entityService.create()));
    }

    @RequestMapping
    PagedResources<TEntity> getAll(Pageable page, PagedResourcesAssembler assembler) {
        Page entities = entityService.getAll(page);
        return assembler.toResource(entities, entityAssembler);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity save(@RequestBody TRep rep) {
        int id = rep.getId();
        TEntity saved = repToEntity(rep);
        saved = entityService.save(saved);
        rep = entityToRep(saved);
        Link link = toResource(rep).getLink("self");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(link.getHref()));
        return new ResponseEntity(httpHeaders, id == 0? HttpStatus.CREATED : HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    ResponseEntity delete(@PathVariable int id) {
        entityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    protected ResourceSupport toResource(TRep entity) {
        return entityAssembler.toResource(entity);
    }

    protected TRep entityToRep(TEntity entity) {
        return (TRep)entity;
    }

    protected TEntity repToEntity(TRep rep) {
        return (TEntity)rep;
    }
}

