package siestageek.spring.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import siestageek.spring.mvc.vo.Pds;

import java.util.List;
import java.util.Map;

@Repository("pdao")
public class PdsDAOImpl implements PdsDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public int insertPds(Pds p) {
        return sqlSession.insert("pds.insertPds", p);
    }

    @Override
    public List<Pds> selectPds(int snum) {
        return sqlSession.selectList("pds.selectPds", snum);
    }

    @Override
    public int selectCountPds() {
        return sqlSession.selectOne("pds.countPds");
    }

    @Override
    public Pds selectOnePds(String pno) {
        return sqlSession.selectOne("pds.selectOnePds", pno);
    }

    @Override
    public Pds selectOneFname(String pno, String order) {
        return null;
    }

    @Override
    public int downCountPds(Map<String, String> param) {
        return 0;
    }
}
