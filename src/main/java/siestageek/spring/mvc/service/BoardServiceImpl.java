package siestageek.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siestageek.spring.mvc.dao.BoardDAO;
import siestageek.spring.mvc.vo.Board;

import java.util.List;

@Service("bsrv")
public class BoardServiceImpl implements BoardService {

    @Autowired private BoardDAO bdao;

    @Override
    public boolean newBoard(Board b) {
        return false;
    }

    @Override
    public boolean modifyBoard(Board b) {
        return false;
    }

    @Override
    public boolean removeBoard(String bdno) {
        return false;
    }

    @Override
    public List<Board> readBoard(String cp) {
        int snum = (Integer.parseInt(cp) - 1) * 30;

        return bdao.selectBoard(snum);
    }

    @Override
    public List<Board> readBoard(String cp, String ftype, String fkey) {
        return null;
    }

    @Override
    public Board readOneBoard(String bdno) {
        return null;
    }

    @Override
    public int countBoard() {
        return 0;
    }

    @Override
    public int countBoard(String ftype, String fkey) {
        return 0;
    }

    @Override
    public boolean viewCountBoard(String bdno) {
        return false;
    }
}
