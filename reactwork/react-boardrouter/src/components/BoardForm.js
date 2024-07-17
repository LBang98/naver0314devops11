import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";
import {CameraAltRounded} from "@mui/icons-material";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const BoardForm = () => {

    const [writer, setWriter] = useState('');
    const [pass, setPass] = useState('');
    const [subject, setSubject] = useState('');
    const [photo, setPhoto] = useState('no');

    const navi = useNavigate();

    const fileRef = useRef(null);
    const contentRef = useRef(null);

    //.env의 변수를 가져오는방법
    const storage = process.env.REACT_APP_STORAGE;
    console.log(storage);

    //파일 업로드 이벤트
    const uploadPhoto = (e)=>{
        const uploadFile = e.target.files[0];
        const uploadForm = new FormData;
        uploadForm.append("upload", uploadFile);

        axios({
            type:'post',
            url:'/boot/board/upload',
            data:uploadForm,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            //스토리지에 저장된 파일명을 Photo에 넣기
            setPhoto(res.data);
        })
    }

    //저장 버튼 이벤트
    const dataSaveEvent = ()=>{
        const content = contentRef.current.value;
        if(writer === ''){
            alert("작성자를 입력해주세요");
            return;
        }
        if(pass === ''){
            alert("비밀번호를 입력해주세요");
            return;
        }
        if(subject === ''){
            alert("제목을 입력 후 엔터를 눌러주세요");
            return;
        }
        if (content === ''){
            alert("내용을 입력해주세요")
            return;
        }

        axios.post("/boot/board/insert", {writer, pass, photo, subject, content})
            .then(res=>{
                //추가 성공 후 값 초기화 후 목록으로 이동
                setPhoto('no');
                setWriter('');
                setSubject('');
                setPass('');
                contentRef.current.value='';

                //목록으로 이동
                navi("/board/list")
            })
    }

    return (
        <div>
            <Alert>게시판 글쓰기</Alert>
            <table className={'table table-bordered'} style={{width:'400px'}}>
                <tbody>
                <tr>
                    <th className={'table-info'}>작성자</th>
                    <td>
                        <input type="text" className={'form-control'}
                               value={writer} onChange={(e)=>setWriter(e.target.value)}/>
                    </td>
                </tr>
                <tr>
                    <th className={'table-info'}>비밀번호</th>
                    <td>
                        <input type="password" className={'form-control'}
                               value={pass} onChange={(e)=>setPass(e.target.value)}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        {/*<InputEmojiWithRef
                            placeholder={'제목을 입력해주세요'}
                            onEnter={(text)=>{
                                console.log(text);
                            }}/>*/}
                        <input type="text" className={'form-control'}
                        value={subject} onChange={(e)=>setSubject(e.target.value)}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        <input type="file" style={{display:'hidden'}}
                        ref={fileRef} onChange={uploadPhoto}/>
                        <CameraAltRounded onClick={()=>fileRef.current.click()}
                            style={{cursor:'pointer', fontSize:'30px'}}/>

                        {/* 스토리지에 저장된 이미지를 보여준다 */}
                        <img src={`${storage}/${photo}`} alt=""
                        style={{width:'60px', marginLeft:'30px'}}/>
                        <br/>
                        <textarea style={{width:'100%', height:'150px'}}
                                  ref={contentRef}
                                  placeholder={'내용을 입력해주세요'} required/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align={'center'}>
                        <Button variant={'contained'} color={'success'}
                                style={{width:'100px'}}
                        onClick={dataSaveEvent}>DB저장</Button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default BoardForm;