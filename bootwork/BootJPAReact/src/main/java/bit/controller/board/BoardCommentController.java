package bit.controller.board;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.data.board.BoardCommentDto;
import bit.data.board.BoardDto;
import bit.service.board.BoardCommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/comment")
public class BoardCommentController {
    final private BoardCommentService commentService;

//	@GetMapping("/insert")
//	public void insertComment(@RequestParam("boardnum") Long boardnum,
//			@RequestParam("nickname") String nickname,
//			@RequestParam("comment") String comment)
//	{
//		System.out.println("comment insert>>"+boardnum);
//		//commentService.insertComment(dto);
//		BoardDto boardDto=BoardDto.builder().boardnum(boardnum).build();
//
//		BoardCommentDto dto=BoardCommentDto.builder()
//				.nickname(nickname)
//				.comment(comment)
//				.boardDto(boardDto)
//				.build();
//
//		commentService.insertComment(dto);
//	}

    @PostMapping("/insert")
    public void insertComment(@RequestBody BoardCommentDto dto)
    {
        System.out.println(dto);
        BoardDto boardDto=BoardDto.builder().boardnum(dto.getBoardnum()).build();
        System.out.println(boardDto);
        dto.setBoardDto(boardDto);
        commentService.insertComment(dto);
    }

    @GetMapping("/list")
    public List<BoardCommentDto> list(@RequestParam("boardnum") Long boardnum)
    {
        return commentService.getCommentList(boardnum);
    }

    @PostMapping("delete")
    public void deleteComment(@RequestParam("idx") Long idx){

        commentService.deleteComment(idx);
    }
}