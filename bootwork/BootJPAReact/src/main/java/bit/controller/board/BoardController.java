package bit.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.data.board.BoardDto;
import bit.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/boot/board/")
public class BoardController {

    final private BoardService boardService;
    final private NcpObjectStorageService storageService;

    String bucketName="bitcamp-bh-98";
    String folderName="reactboard";

    @PostMapping("/upload")
    public String photoUpload(@RequestParam("upload") MultipartFile upload)
    {
        System.out.println("upload>>"+upload.getOriginalFilename());
        String photoName=storageService.uploadFile(bucketName, folderName, upload);
        return photoName;
    }

    @PostMapping("/insert")
    public void boardInsert(@RequestBody BoardDto dto)
    {
        System.out.println("insert>>"+dto);
        boardService.insertBoard(dto);
    }

    @GetMapping("/list")
    public List<BoardDto> list()
    {
        System.out.println("list>>");
        return boardService.getAllDatas();
    }

    @GetMapping("/detail")
    public BoardDto detail(@RequestParam("boardnum") Long boardnum)
    {
        System.out.println("detail>>"+boardnum);
        //조회수 증가후 dto 반환
        boardService.updateReadCount(boardnum);
        return boardService.getData(boardnum);
    }

    @GetMapping("/updatecheckpass")
    public Map<String, Object> checkPass(@RequestParam("boardnum") Long boardnum,
                                         @RequestParam("pass") String pass)
    {
        System.out.println("checkPass>>"+boardnum);
        Map<String, Object> map=new HashMap<>();

        boolean flag=boardService.isEqualPass(boardnum, pass);

        if(flag) {
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }
        return map;
    }

    @GetMapping("/updateform")
    public BoardDto select(@RequestParam("boardnum") Long boardnum)
    {
        return boardService.getData(boardnum);
    }

    @PostMapping("/update")
    public void update(@RequestBody BoardDto dto)
    {
        boardService.updateBoard(dto);
    }

    @GetMapping("/deletecheckpass")
    public Map<String, Object> delcheckPass(@RequestParam("boardnum") Long boardnum,
                                            @RequestParam("pass") String pass)
    {
        System.out.println("deletepass>>"+boardnum+","+pass);
        Map<String, Object> map=new HashMap<>();

        boolean flag=boardService.isEqualPass(boardnum, pass);

        if(flag) {
            //비번이 맞으면 사진과 db 데이타 삭제
            String oldPhotoName=boardService.getData(boardnum).getPhoto();
            storageService.deleteFile(bucketName, folderName, oldPhotoName);//사진 삭제
            boardService.deleteBoard(boardnum);

            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }
        return map;
    }
}