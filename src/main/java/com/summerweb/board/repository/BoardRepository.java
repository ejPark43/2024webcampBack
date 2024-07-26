package com.summerweb.board.repository;

import com.summerweb.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

// update board_table_jpa_new set board_hits = board_hits + 1 where id = ? << 해당 게시글에 대해서만 조회수를 하나 올려야 하기 때문에,,,
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);



}
