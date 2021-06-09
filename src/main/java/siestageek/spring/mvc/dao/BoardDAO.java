package siestageek.spring.mvc.dao;

import siestageek.spring.mvc.vo.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

    boolean insertBoard(Board b);
    boolean updateBoard(Board b);
    boolean deleteBoard(String bdno);

    List<Board> selectBoard(int snum);
    List<Board> findSelectBoard(Map<String, Object> param);
    Board selectOneBoard(String bdno);

    int selectCountBoard();
    int selectCountBoard(Map<String, Object> param);
    boolean viewCountBoard(String bdno);

}
