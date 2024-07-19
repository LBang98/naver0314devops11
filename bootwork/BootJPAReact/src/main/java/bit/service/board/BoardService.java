package bit.service.board;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.data.board.BoardDto;
import bit.repository.board.BoardDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardDao boardDao;

    public void insertBoard(BoardDto dto)
    {
        boardDao.insertBoard(dto);
    }

    public List<BoardDto> getAllDatas()
    {
        return boardDao.getAllDatas();
    }

    public void updateReadCount(Long boardnum)
    {
        boardDao.updateReadCount(boardnum);
    }

    public BoardDto getData(Long boardnum)
    {
        return boardDao.getData(boardnum);
    }

    public boolean isEqualPass(Long boardnum,String pass)
    {
        return boardDao.isEqualPass(boardnum, pass);
    }

    public void deleteBoard(Long boardnum)
    {
        boardDao.deleteBoard(boardnum);
    }

    public void updateBoard(BoardDto dto)
    {
        boardDao.updateBoard(dto);
    }
}