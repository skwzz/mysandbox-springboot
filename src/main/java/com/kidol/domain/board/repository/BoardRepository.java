package com.kidol.domain.board.repository;

import com.kidol.domain.board.entity.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Override
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Board> findAll();
}
