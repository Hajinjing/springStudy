package com.mega.board.controller;

import com.mega.board.dto.BoardDto;
import com.mega.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController // 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어줌, @Controller + @ResponseBody view페이지가 없는 경우
@Controller // 컨트롤러임을 명시하는 어노테이션, 메서드들은 반환 값으로 템플릿 경로를 작성하거나 redirect해줘야 함
@AllArgsConstructor // Bean주입 방식과 관련이 있으며, 생성자로 Bean객체를 받는 방식을 해결해주는 어노테이션, BoardService에서 객체를 주입받을 때 @Autowired를 부여하지 않음
public class BoardController {

    private BoardService boardService;


//    @GetMapping("/test") // HTTP 메소드인 Get의 요청을 받을 수 있는 API
//    public String test() {
//        return "Hello World!";
//    }

    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    // 게시글 상세조회 페이지
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    // 게시글 수정 페이지
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }

}
