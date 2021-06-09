package siestageek.spring.mvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siestageek.spring.mvc.dao.MemberDAO;
import siestageek.spring.mvc.vo.Member;

import javax.servlet.http.HttpSession;

@Service("msrv")
public class MemberServiceImpl implements MemberService {

    @Autowired private MemberDAO mdao;

    @Override
    public String newMember(Member m) {
        String result = "회원정보 저장 실패!";

        int cnt = mdao.insertMember(m);
        if (cnt > 0) result = "회원정보 저장 성공!";

        return result;
    }

    @Override
    public String findZipcode(String dong) {
        // 조회결과 출력방법 1 : csv (쉼표로 구분)
        // sido, gugun, dong, bunji
        // 서울, 강남구, 논현동, 123번지

        // 조회결과 출력방법 2 : xml
        // <zip><sido>서울</sido> <gugun>강남구</gugun>
        //      <dong>논현동</dong> <bunji>123번지</bunji></zip>

        // 조회결과 출력방법 3 : json (추천)
        // {'sido':'서울', 'gugun':'강남구',
        //  'dong':'논현동', 'bunji':'123번지'},
        // {'sido':'서울', 'gugun':'강남구',
        //  'dong':'논현동', 'bunji':'123번지'},
        // {'sido':'서울', 'gugun':'강남구',
        //  'dong':'논현동', 'bunji':'123번지'},

        // StringBuilder sb = new StringBuilder();
        // sb.append("{'sido':").append("'서울',")
        // .append("'gugun':").append("'강남구',")
        // .append("'dong':").append("'논현동',")
        // .append("'bunji':").append("'123번지',");
        // .append("}");

        // 코드를 json형태로 결과물을 만들려면 상당히 복잡함
        // ObjectMapper라는 라이브러리를 이용하면
        // 손쉽게 JSON형식의 데이터를 생성할 수 있음
        // writeValueAsString : List형식의 데이터를 JSON형식으로 변환해 줌
        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        dong = dong + "%";

        try {
            json = mapper.writeValueAsString(
                mdao.selectZipcode(dong)
            ); //
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public String checkUserid(String uid) {
        return mdao.selectOneUserid(uid)+"";
    }

    @Override
    public boolean checkLogin(Member m, HttpSession sess) {
        boolean isLogin = false;

        // 로그인 성공시 회원정보를 세션에 저장
        // 입력한 아이디/비밀번호가 member 테이블에 있는지 확인
        // 있으면 : 1을 반환, 없으면 : 0을 반환
        if (mdao.selectLogin(m) > 0) {
            sess.setAttribute("UID", m.getUserid());
            isLogin = true;
        }

        return isLogin;
    }
}
