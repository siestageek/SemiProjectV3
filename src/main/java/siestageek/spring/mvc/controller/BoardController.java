package siestageek.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public String list() {
        return "board/list.tiles";
    }

    @GetMapping("/board/view")
    public String view() {
        return "board/view.tiles";
    }

    @GetMapping("/board/write")
    public String write() {
        return "board/write.tiles";
    }

}
