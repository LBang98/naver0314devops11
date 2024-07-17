package bit.controller.board;

import bit.data.board.BoardDto;
import bit.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/board")
public class BoardController {

    final private BoardService boardService;
    final private NcpObjectStorageService storageService;

    String bucketName = "bitcamp-bh-98";
    String folderName = "reactboard";

    @PostMapping("/upload")
    public String photoUpload(@RequestParam("upload") MultipartFile upload) {

        String photoName = storageService.uploadFile(bucketName, folderName, upload);
        return photoName;
    }


    @PostMapping("/insert")
    public void boardInsert(@RequestBody BoardDto dto){

        boardService.insertBoard(dto);
    }

    @GetMapping("/list")
    public List<BoardDto> list(){

        return boardService.getAllDatas();
    }

    @GetMapping("/detail")
    public BoardDto detail(@RequestParam("boardnum") Long boardnum){

        //조회수 증가 후 dto 반환
        boardService.updateReadCount(boardnum);

        return boardService.getData(boardnum);
    }

    @GetMapping("/checkpass")
    public Map<String, Object> checkPass(@RequestParam Long boardnum, @RequestParam String pass){

        Map<String, Object> map = new HashMap<>();
        boolean flag = boardService.isEqualPass(boardnum, pass);

        if(flag){
            BoardDto dto = boardService.getData(boardnum);
            map.put("dto", dto);
            map.put("result", "success");
        }else{
            map.put("result", "fail");
        }

        return map;
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardDto dto){

        boardService.updateBoard(dto);
    }

    @GetMapping("/deletecheckpass")
    public Map<String, Object> delcheckPass(@RequestParam Long boardnum, @RequestParam String pass){

        Map<String, Object> map = new HashMap<>();
        boolean flag = boardService.isEqualPass(boardnum, pass);

        if(flag){
            //비번이 맞으면 사진과 db데이타 삭제
            String oldPhotoName = boardService.getData(boardnum).getPhoto();

            storageService.deleteFile(bucketName, folderName, oldPhotoName);
            boardService.deleteBoard(boardnum);

            map.put("result", "success");
        }else{
            map.put("result", "fail");
        }

        return map;
    }




}
