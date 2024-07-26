//package com.summerweb.board.service;
//
//import com.summerweb.board.dto.BoardDTO;
//import com.summerweb.board.entity.BoardEntity;
//import com.summerweb.board.repository.BoardRepository;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//// DTO -> Entity (Entity class에서 진행)
//// Entity -> DTO (DTO  class에서 진행)
//@Service
//@RequiredArgsConstructor
//public class BoardService {
//    private final BoardRepository boardRepository;
//    public void save(BoardDTO boardDTO) {
//
//    BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
//        boardRepository.save(boardEntity);
//    }
//
//    public List<BoardDTO> findAll() {
//        List<BoardEntity> boardEntityList = boardRepository.findAll();
//        List<BoardDTO> boardDTOList = new ArrayList<>();
//
//
//        for(BoardEntity boardEntity : boardEntityList){
//            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
//        }
//        return boardDTOList;
//    }
//
//    @Transactional // transactional 어노테이션 안쓰면 에러나온다. BoardRepository에서 Query로 따로 하나 만들고있어서, 수동? 적인 느낌이라.
//    public void updateHits(Long id) {
//    boardRepository.updateHits(id);
//
//    }
//
//    public BoardDTO findById(Long id) {
//        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
//        if(optionalBoardEntity.isPresent()){
//            BoardEntity boardEntity = optionalBoardEntity.get();
//            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
//            return boardDTO;
//
//        }else {
//            return null;
//        }
//    }
//
//    public BoardDTO update(BoardDTO boardDTO) {
//        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
//        boardRepository.save(boardEntity);
//        return findById(boardDTO.getId());
//
//
//    }
//
//    public void delete(Long id) { // 삭제
//        boardRepository.deleteById(id);
//           }
//}

package com.summerweb.board.service;

import com.summerweb.board.dto.BoardDTO;
import com.summerweb.board.entity.BoardEntity;
import com.summerweb.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDTO save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return BoardDTO.toBoardDTO(savedEntity); // 저장된 엔티티를 DTO로 변환하여 반환
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    @Transactional // transactional 어노테이션 안쓰면 에러나온다. BoardRepository에서 Query로 따로 하나 만들고있어서, 수동? 적인 느낌이라.
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity = optionalBoardEntity.get();
            return BoardDTO.toBoardDTO(boardEntity);
        } else {
            return null;
        }
    }

    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity);
        return findById(boardDTO.getId());
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
