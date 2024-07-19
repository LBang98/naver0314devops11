package bit.service.board;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.data.board.BoardCommentDto;
import bit.repository.board.BoardCommentDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardCommentService {
    private BoardCommentDao commentDao;

    //추가
    public void insertComment(BoardCommentDto dto)
    {
        commentDao.insertComment(dto);
    }

    //목록
    public List<BoardCommentDto> getCommentList(Long boardnum)
    {
        return commentDao.getCommentList(boardnum);
    }

    //수정
    public void updateComment(Long idx,String comment)
    {
        commentDao.updateComment(idx, comment);
    }

    //삭제
    public void deleteComment(Long idx)
    {
        commentDao.deleteComment(idx);
    }
}