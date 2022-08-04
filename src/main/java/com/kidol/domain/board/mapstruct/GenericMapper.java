package com.kidol.domain.board.mapstruct;

import java.util.List;

public interface GenericMapper<Q, S, E>{ //Q: request, S: response, E: entity
    S toResponse(E e);
    E toEntity(Q q);
    List<S> toResponse(List<E> e);
    List<E> toEntity(List<Q> q);
}
