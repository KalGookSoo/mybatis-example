package com.kalgooksoo.controller;

import com.kalgooksoo.command.UserCommand;
import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.UserCriteria;
import com.kalgooksoo.mapstruct.UserMapper;
import com.kalgooksoo.model.User;
import com.kalgooksoo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 사용자 컨트롤러
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * 사용자 관리 서비스
     */
    private UserService userService;

    /**
     * 사용자 데이터 변환 매퍼
     */
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 사용자 초기 페이지
     *
     * @param model    모델
     * @param criteria 검색 및 페이징 조건
     * @return 뷰
     */
    @GetMapping
    public String index(Model model, UserCriteria criteria) {
        Page<User> page = this.userService.find(criteria);
        model.addAttribute("page", page);
        return "user/index";
    }

    /**
     * 사용자 저장 페이지
     * 
     * @param model 모델
     * @return 뷰
     */
    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("command", new UserCommand());
        return "user/save";
    }
    
    /**
     * 사용자 수정 페이지
     *
     * @param model 모델
     * @param id    사용자 식별자
     * @return 뷰
     */
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable Long id) {

        // TODO 스프링 시큐리티 추가 후 ACL 및 권한 및 그룹 설정에 따라 수정 권한 유무를 파악해 라우팅하도록 한다.

        User user = this.userService.findById(id);
        UserCommand command = this.userMapper.convert(user);
        model.addAttribute("command", command);
        return "user/update";
    }

    /**
     * 사용자 생성
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PostMapping
    public String insert(
            @ModelAttribute("command") @Valid UserCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "user/save";
        }

        User user = this.userMapper.convert(command);
        this.userService.insert(user);

        return "redirect:/users";

    }

    /**
     * 사용자 수정
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PutMapping("/{id}")
    public String update(
            @ModelAttribute("command") @Valid UserCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "user/update";
        }

        User user = this.userMapper.convert(command);
        this.userService.update(user);

        return "redirect:/user";

    }

}
