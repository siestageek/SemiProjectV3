package siestageek.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import siestageek.spring.mvc.service.PdsService;
import siestageek.spring.mvc.utils.FileUpDownUtil;
import siestageek.spring.mvc.vo.Pds;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class PdsController {

    @Autowired private PdsService psrv;

    @GetMapping("/pds/list")
    public ModelAndView list(ModelAndView mv, String cp) {
        if (cp == null) cp = "1";
        mv.setViewName("pds/list.tiles");
        mv.addObject("pds", psrv.readPds(cp));
        mv.addObject("pcnt", psrv.countPds());

        return mv;
    }

    @GetMapping("/pds/view")  // 본문글 출력
    public ModelAndView view(ModelAndView mv, String pno) {
        mv.setViewName("pds/view.tiles");
        mv.addObject("p", psrv.readOnePds(pno));

        return mv;
    }

    @GetMapping("/pds/write")
    public String write() {
        return "pds/write.tiles";
    }

    // commons file upload로 구현한 자료실
//    @PostMapping("/pds/write")
//    public String writeok(Pds p, HttpServletRequest req) {
//
//        // commons file upload로 업로드 처리 및 폼데이터 가져오기
//        FileUpDownUtil fud = new FileUpDownUtil();
//        Map<String, String> frmdata = fud.procUpload(req);
//
//        System.out.println(frmdata.get("title"));
//        System.out.println(frmdata.get("contents"));
//        System.out.println(frmdata.get("file1"));
//        System.out.println(frmdata.get("filesize"));
//        System.out.println(frmdata.get("filetype"));
//
//        // Pds 객체를 이용하는 경우 폼 데이터가 자동으로 주입되지 않음
//        System.out.println(p.getTitle());
//        System.out.println(p.getContents());
//
//        return "redirect:/pds/list";
//    }

    // MultiPartFile로 구현한 자료실
    @PostMapping("/pds/write")
    public String writeok(Pds p, MultipartFile[] file) {

        psrv.newPds(p, file);

        return "redirect:/pds/list?cp=1";
    }



}
