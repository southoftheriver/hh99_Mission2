package com.jy.mission2.repository;

import com.jy.mission2.model.Board;
import com.jy.mission2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findAllByUserId(Long userId);
    Optional<Board> findByIdAndUserId(Long boardId, Long userId);
}
