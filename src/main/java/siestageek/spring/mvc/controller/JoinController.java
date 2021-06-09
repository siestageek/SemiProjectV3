package siestageek.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import siestageek.spring.mvc.service.MemberService;
import siestageek.spring.mvc.vo.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class JoinController {

    @Autowired private MemberService msrv;

    @GetMapping("/join/agree")
    public String agree() {
        return "join/agree.tiles";
    }

    @GetMapping("/join/checkme")
    public String checkme() {
        return "join/checkme.tiles";
    }

    @PostMapping("/join/joinme")
    public String joinme() {
        return "join/joinme.tiles";
    }

    @PostMapping("/join/joinok")
    public String joinok(Member m, HttpServletRequest req) {

        msrv.newMember(m);

        return "join/joinok.tiles";
    }

    // 우편번호 검색
    // /join/zipcode?dong=동이름
    // 검색된 결과를 뷰페이지 없이 바로 응답으로 출력 : RESTful 방식 (마이크로서비스)
    // 서블릿에서 제공하는 HttpServletResponse를 이용하면
    // 스프링의 뷰리졸버 없이 바로 응답을 출력할 수 있음
    // 결과는 자바스크립트의 ajax를 이용해서 적절히 가공해서 폼에 출력
    @ResponseBody
    @GetMapping("/join/zipcode")
    public void zipcode(String dong, HttpServletResponse res) {

        try {
            // 응답결과의 유형은 JSON형식으로 설정
            res.setContentType("application/json; charset=UTF-8");
            // 응답결과를 뷰없이 브라우져로 바로 출력
            res.getWriter().print( msrv.findZipcode(dong) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 아이디 중복검사
    // /join/checkuid?uid=아이디
    // 사용가능 아이디 : 결과 0
    // 사용불가능 아이디 : 결과 1
    @ResponseBody
    @GetMapping("/join/checkuid")
    public void checkuid(String uid, HttpServletResponse res) {
        try {
            res.getWriter().println( msrv.checkUserid(uid) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 로그인 처리
    // 입력한 아이디/비밀번호로 로그인 가능여부 확인
    // 로그인 성공시 로그인 여부를 시스템에 저장하기 위해
    // HttpSession 객체를 이용함
    // 즉, 서버가 생성한 정보를 일정기간 동안
    // WAS에 저장해두고 필요할 때마다 이것을 활용함으로써
    // 로그인한 사용자를 식별할 수 있음
    @PostMapping("/join/login")
    public String login(Member m, HttpSession sess) {
        String returnPage = "redirect:/join/loginfail";

        if (msrv.checkLogin(m, sess)) // 로그인 성공시
            returnPage = "redirect:/";

        return returnPage;
    }

    // 로그인 성공시 로그인여부를 세션객체로 만들어 두었음
    // 로그아웃시에는 이 세션객체를 지워버리면 됨
    @GetMapping("/join/logout")
    public String logout(HttpSession sess) {
        sess.invalidate();  // 세션객체 제거

        return "redirect:/";
    }

}
