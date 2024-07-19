package bit.repository.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import bit.data.board.BoardCommentDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BoardCommentDao {

    private BoardCommentDaoInter commentDaoInter;

    //추가
    public void insertComment(BoardCommentDto dto)
    {
        commentDaoInter.save(dto);
    }

    //목록
    public List<BoardCommentDto> getCommentList(Long boardnum)
    {
        return commentDaoInter.getCommentList(boardnum);
    }

    //수정
    public void updateComment(Long idx,String comment)
    {
        commentDaoInter.updateComment(idx, comment);
    }

    //삭제
    public void deleteComment(Long idx)
    {
        commentDaoInter.deleteById(idx);
    }


}