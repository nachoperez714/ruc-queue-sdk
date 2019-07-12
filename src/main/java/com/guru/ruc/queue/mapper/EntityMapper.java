package com.guru.ruc.queue.mapper;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - Domain type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDomain(E domain);

    List <E> toEntity(List<D> dtoList);

    List <D> toDomain(List<? extends E> list);
}
