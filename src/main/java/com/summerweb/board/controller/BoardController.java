//package com.summerweb.board.controller;
//
//import com.summerweb.board.dto.BoardDTO;
//import com.summerweb.board.service.BoardService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////@Controller
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/board") // board로 시작하는 주소를 아래 맵핑되는 애들 전부 기본으로 들어갈수있도록 함.
//public class BoardController {
//
//    private final BoardService boardService;
//    @GetMapping("/save") // get으로 받는 save주소
//    public String saveForm(){
//        return "save";
//    }
//
//    @PostMapping("/save") // post로 받는 save
//        public String save(@ModelAttribute BoardDTO boardDTO){
//        System.out.println("boardDTO = "+boardDTO);
//        boardService.save(boardDTO);
//return "index";
//    }
//
//
//    @GetMapping("/")
//    public String findAll(Model model){
//        //DB에서 전체 게시글 데이트를 가져와서 list.html에 보여준다.
//        List<BoardDTO> boardDTOList = boardService.findAll();
//        model.addAttribute("boardList",boardDTOList);
//        return "list";
//
//    }
//
//    @GetMapping("/{id}")
//    public String findById(@PathVariable Long id, Model model){
//
//        /*
//        해당 게시글의 조회수를 하나 올리고 게시글 데이터 가져와서 detail.html에 출력
//        * */
//
//        boardService.updateHits(id);
//        BoardDTO boardDTO = boardService.findById(id);
//        model.addAttribute("board", boardDTO);
//        return "detail";
//    }
//
//
//
//    @GetMapping("/update/{id}")
//    public String updateForm(@PathVariable Long id, Model model){
//        BoardDTO boardDTO = boardService.findById(id);
//        model.addAttribute("boardUpdate", boardDTO);
//        return "update";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
//        BoardDTO board = boardService.update(boardDTO);
//        model.addAttribute("board",board);
//        return "detail"; // 수정하고 나서 해당 상세 페이지로 이동.
//
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id){
//        boardService.delete(id);
//        return "redirect:/board/";
//    }
//}

package com.summerweb.board.controller;

import com.summerweb.board.dto.BoardDTO;
import com.summerweb.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
//@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private final BoardService boardService;

    // 게시글 저장 (POST)
    @PostMapping("/save")
    @CrossOrigin(origins = "https://bungae-clone-coding.netlify.app/")
    public BoardDTO save(@RequestBody BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        return boardService.save(boardDTO);
    }

    // 전체 게시글 조회 (GET)
    @GetMapping("/")
    public List<BoardDTO> findAll() {
        return boardService.findAll();
    }

    // 특정 게시글 조회 (GET)

    @GetMapping("/{id}")
    @CrossOrigin(origins = "https://bungae-clone-coding.netlify.app/")
    public BoardDTO findById(@PathVariable Long id) {
        boardService.updateHits(id);
        return boardService.findById(id);
    }

    // 게시글 수정 폼 요청 (GET)
    @GetMapping("/update/{id}")
    @CrossOrigin(origins = "https://bungae-clone-coding.netlify.app/")
    public BoardDTO updateForm(@PathVariable Long id) {
        return boardService.findById(id);
    }

    // 게시글 수정 (POST)
    @PostMapping("/update")
    @CrossOrigin(origins = "https://bungae-clone-coding.netlify.app/")
    public BoardDTO update(@RequestBody BoardDTO boardDTO) {
        return boardService.update(boardDTO);
    }

    // 게시글 삭제 (DELETE)
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "https://bungae-clone-coding.netlify.app/")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}

