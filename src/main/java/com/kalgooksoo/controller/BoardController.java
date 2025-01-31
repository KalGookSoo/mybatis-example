package com.kalgooksoo.controller;

import com.kalgooksoo.command.BoardCommand;
import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.BoardCriteria;
import com.kalgooksoo.mapstruct.BoardMapper;
import com.kalgooksoo.model.Board;
import com.kalgooksoo.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/boards")
public class BoardController {

    /**
     * 게시글 관리 서비스 객체
     */
    private final BoardService boardService;

    /**
     * 게시글 데이터 변환 매퍼
     */
    private final BoardMapper boardMapper = BoardMapper.INSTANCE;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시글 초기 페이지
     *
     * @param model    모델
     * @param criteria 검색 및 페이징 조건
     * @return 뷰
     */
    @GetMapping
    public String index(Model model, BoardCriteria criteria) {
        Page<Board> page = this.boardService.findByCategoryId(criteria);
        model.addAttribute("page", page);
        return "board/index";
    }

    /**
     * 게시글 저장 페이지
     *
     * @param model      모델
     * @param categoryId 카테고리 식별자
     * @return 뷰
     */
    @GetMapping("/save")
    public String save(Model model, @RequestParam Long categoryId) {

        model.addAttribute("command", new BoardCommand(categoryId));
        return "board/save";
    }

    /**
     * 게시글 수정 페이지
     *
     * @param model 모델
     * @param id    게시글 식별자
     * @return 뷰
     */
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable Long id) {

        // TODO 스프링 시큐리티 추가 후 ACL 및 권한 및 그룹 설정에 따라 수정 권한 유무를 파악해 라우팅하도록 한다.

        Board board = this.boardService.view(id);
        BoardCommand command = this.boardMapper.convert(board);
        model.addAttribute("command", command);
        return "board/update";
    }

    /**
     * 게시글 생성
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PostMapping
    public String insert(
            @ModelAttribute("command") @Valid BoardCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "board/save";
        }

        //TODO 스프링 시큐리티 추가된 이후에 익명 또는 UserPrincipal 구현체에서 username 꺼내와 주입시켜야 함
        Board board = this.boardMapper.convert(command);
        this.boardService.insert(board);

        return "redirect:/boards";

    }

    /**
     * 게시글 수정
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PutMapping("/{id}")
    public String update(
            @ModelAttribute("command") @Valid BoardCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "board/update";
        }

        Board board = this.boardMapper.convert(command);
        this.boardService.update(board);

        return "redirect:/board";

    }

}
