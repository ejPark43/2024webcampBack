package com.summerweb.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.summerweb.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

//DTO : Data Transfer Object 데이터 전송할때 쓰는 객체 (VO, Bean 등과 비슷) / Entity는 좀 다른 목적을 가진 클래스
@Getter // lombok 이 제공하는거, 게터와 세터를 알아서 다 만들어줌. (나중에 변수명같은거 수정할때 여기 아래 DTO 부분만 수정하면 다른 게터, 세터 수정할 필요 없다! )
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private int boardPrice;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;
    private String boardImg;


    //entity를 DTO에 옮겨담는 부분
    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardPrice(boardEntity.getBoardPrice());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
        boardDTO.setBoardImg(boardEntity.getBoardImg());

        return boardDTO;
    }



}
