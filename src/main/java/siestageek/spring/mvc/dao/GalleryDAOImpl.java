package siestageek.spring.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import siestageek.spring.mvc.vo.Gallery;

import java.util.List;

@Repository("gdao")
public class GalleryDAOImpl implements GalleryDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public int insertGallery(Gallery g) {
        sqlSession.insert("gallery.insertGallery", g);
        return sqlSession.selectOne("gallery.lastGalID");
    }

    @Override
    public List<Gallery> selectGallery(int snum) {
        return sqlSession.selectList("gallery.selectGallery", snum);
    }

    @Override
    public Gallery selectOneGallery(String gno) {
        return sqlSession.selectOne("gallery.selectOneGallery", gno);
    }

    @Override
    public int updateGallery(Gallery g) {
        return sqlSession.update("gallery.updateGallery", g);
    }

    @Override
    public String readFnames(String gno) {
        return sqlSession.selectOne("gallery.readFnames", gno);
    }

    @Override
    public String readFsizes(String gno) {
        return sqlSession.selectOne("gallery.readFsizes", gno);
    }
}
