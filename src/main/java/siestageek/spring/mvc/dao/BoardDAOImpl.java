package siestageek.spring.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import siestageek.spring.mvc.vo.Board;

import java.util.List;
import java.util.Map;

@Repository("bdao")
public class BoardDAOImpl implements BoardDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public boolean insertBoard(Board b) {
        return false;
    }

    @Override
    public boolean updateBoard(Board b) {
        return false;
    }

    @Override
    public boolean deleteBoard(String bdno) {
        return false;
    }

    @Override
    public List<Board> selectBoard(int snum) {
        return sqlSession.selectList("board.selectBoard", snum);
    }

    @Override
    public List<Board> findSelectBoard(Map<String, Object> param) {
        return null;
    }

    @Override
    public Board selectOneBoard(String bdno) {
        return null;
    }

    @Override
    public int selectCountBoard() {
        return 0;
    }

    @Override
    public int selectCountBoard(Map<String, Object> param) {
        return 0;
    }

    @Override
    public boolean viewCountBoard(String bdno) {
        return false;
    }
}
