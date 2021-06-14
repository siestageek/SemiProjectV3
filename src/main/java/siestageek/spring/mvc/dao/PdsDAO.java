package siestageek.spring.mvc.dao;

import siestageek.spring.mvc.vo.Pds;

import java.util.List;
import java.util.Map;

public interface PdsDAO {

    int insertPds(Pds p);
    List<Pds> selectPds(int snum);
    int selectCountPds();

    Pds selectOnePds(String pno);
    Pds selectOneFname(String pno, String order);
    int downCountPds(Map<String, String> param);

}
