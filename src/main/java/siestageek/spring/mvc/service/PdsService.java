package siestageek.spring.mvc.service;

import org.springframework.web.multipart.MultipartFile;
import siestageek.spring.mvc.vo.Pds;

import java.util.List;

public interface PdsService {

    boolean newPds(Pds p, MultipartFile[] file);

    List<Pds> readPds(String cp);
    int countPds();

    Pds readOnePds(String pno);
    Pds readOneFname(String pno, String order);

    boolean downCountPds(String pno, String order);

}
