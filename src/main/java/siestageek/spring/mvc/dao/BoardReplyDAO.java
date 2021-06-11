package siestageek.spring.mvc.dao;

import siestageek.spring.mvc.vo.Reply;

import java.util.List;

public interface BoardReplyDAO {

    List<Reply> selectReply(String bdno);

    int insertComment(Reply r);
    int insertReply(Reply r);

}
