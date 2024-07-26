package com.summerweb.board.entity;

import com.summerweb.board.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//entity: DB의 테이블 역할을 하는 클래스 (db와 직접적인 연관을 갖고 있다. 서비스와 리포지토리 에서만 사용을 한다)

@Entity
@Getter
@Setter
@Table(name = "board_table_jpa_new")
public class BoardEntity extends BaseEntity{ // boardentity가 baseentity를 상속받아서 시간 스탬프 사용가능
    @Id // pk 컬럼 지정, 필수임.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 30)
    private String boardWriter;

    @Column
    private String boardPass;

    @Column // 이렇게 굳이 지정 안해두면 크기 = 255, null 가능으로 설정됨.
    private String boardTitle;

    @Column (length=500)
    private String boardContents;

    @Column
    private int boardHits;

    @Column int boardPrice;

    @Column String boardImg;



    // builder로 만들수도 있지만 이렇게  메서드 만들수도있음 (DTO -> Entity로 변환, 옮겨담는 내용 )
    public static BoardEntity toSaveEntity(BoardDTO boardDTO){

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        boardEntity.setBoardPrice(boardDTO.getBoardPrice());
        boardEntity.setBoardImg(boardDTO.getBoardImg());

        return boardEntity; // 옮겨담은 내용을 리턴함
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(boardDTO.getBoardHits());
        boardEntity.setBoardPrice(boardDTO.getBoardPrice());
        boardEntity.setBoardPrice(boardDTO.getBoardPrice());
        boardEntity.setBoardImg(boardDTO.getBoardImg());
        return boardEntity; // 옮겨담은 내용을 리턴함

    }
}
