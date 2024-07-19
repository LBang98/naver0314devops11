package bit.repository.board;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.data.board.BoardDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BoardDao {

    private BoardDaoInter boardDaoInter;

    public void insertBoard(BoardDto dto)
    {
        boardDaoInter.save(dto);
    }

    public List<BoardDto> getAllDatas()
    {
        return boardDaoInter.findAll(Sort.by(Sort.Direction.DESC,"boardnum"));
    }

    public void updateReadCount(Long boardnum)
    {
        boardDaoInter.updateReadCount(boardnum);
    }

    public BoardDto getData(Long boardnum)
    {
        return boardDaoInter.findById(boardnum).get();
    }

    public boolean isEqualPass(Long boardnum,String pass)
    {
        return boardDaoInter.isEqualPass(boardnum, pass)==1?true:false;
    }

    public void deleteBoard(Long boardnum)
    {
        boardDaoInter.deleteById(boardnum);
    }

    public void updateBoard(BoardDto dto)
    {
        if(dto.getPhoto().equals("no"))
            boardDaoInter.updateBoardNoPhoto(dto);
        else
            boardDaoInter.save(dto);
    }

}