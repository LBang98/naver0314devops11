import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { EditNote, HighlightOff, UpdateOutlined, UpdateTwoTone } from '@mui/icons-material';

const BoardDetail = () => {
    const {boardnum}=useParams();
    const [selectData,setSelectData]=useState({});
    const [nickname,setNickname]=useState('');
    const [comment,setComment]=useState('');
    const [commentList,setCommentList]=useState([]);

    //댓글 입력후 엔터 이벤트
    const addCommentEvent=()=>{
        //alert("comment");
        if(nickname===''){
            alert("닉네임을 입력해주세요");
            return;
        }

        if(comment===''){
            alert("코멘트를 입력해주세요");
            return;
        }

        // let url=`/boot/comment/insert?boardnum=${boardnum}&nickname=${nickname}&comment=${comment}`;
        // axios.get(url)
        // .then(res=>{
        //   commentListEvent();//댓글 다시 출력
        //   //입력값 초기화
        //   setNickname('');
        //   setComment('');
        // });

        axios.post("/boot/comment/insert",{boardnum,nickname,comment})
            .then(res=>{
                commentListEvent();//댓글 다시 출력
                //입력값 초기화
                setNickname('');
                setComment('');
            });

    }

    //댓글 출력 함수
    const commentListEvent=()=>{
        axios.get(`/boot/comment/list?boardnum=${boardnum}`)
            .then(res=>{
                setCommentList(res.data);
            })
    }

    //댓글 삭제 함수
    const deleteComment=(idx)=>{
        let url=`/boot/comment/delete?idx=${idx}`;
        axios.delete(url)
            .then(res=>{
                //댓글 삭제후 댓글 목록 다시 출력
                commentListEvent();
            })
    }

    const storage=process.env.REACT_APP_STORAGE;
    const navi=useNavigate();

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const [pass,setPass]=useState('');

    const getData=()=>{
        let url="/boot/board/detail?boardnum="+boardnum;
        axios.get(url)
            .then(res=>{
                setSelectData(res.data);
            })
    }

    useEffect(()=>{
        getData();
        commentListEvent();//처음 시작시 댓글 출력
    },[]);

    return (
        <div style={{width:'500px',marginLeft:'30px'}}>
            {
                selectData &&
                <table className='table'>
                    <caption align='top'><h3><b>게시글 상세보기</b></h3></caption>
                    <tbody>
                    <tr>
                        <td>
                            <h3><b>{selectData.subject}</b></h3>
                            <b>{selectData.writer}</b>
                            <span style={{float:'right',color:'gray',fontSize:'14px'}}>
                                조회&nbsp;{selectData.readcount}
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                {selectData.writeday}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {
                                selectData.photo!=='no'?
                                    <div>
                                        <h3><b>대표 사진</b></h3>
                                        <img alt='' src={`${storage}/${selectData.photo}`}
                                             style={{width:'200px'}}/>
                                        <hr/>
                                    </div>:""

                            }
                            {/* dangerouslySetInnerHTML은 DOM에서 innerHTML을 사용하기 위한 리액트의 대체 방법이다.
                        innerHTML을 사용하면 DOM의 변경을 인식하지 못한다.
                        대신 dangerouslySetInnerHTML를 사용하게 되면 가상 DOM과 실제 DOM을 비교해 변경된 곳을 리렌더링 해준다. */}
                            <pre dangerouslySetInnerHTML={{__html: selectData.content}}></pre>

                        </td>
                    </tr>
                    <tr>
                        <td align='right'>
                            <Button variant='outlined' color='success'
                                    size="small" style={{width:'80px'}}
                                    onClick={()=>navi("/board/list")}>목록</Button>
                            &nbsp;
                            <Button variant='outlined' color='success'
                                    size="small" style={{width:'80px'}}
                                    onClick={()=>navi("/board/form")}>글쓰기</Button>
                            &nbsp;
                            <Button variant='outlined' color='success'
                                    size="small" style={{width:'80px'}}
                                    onClick={()=>navi(`/board/updatepass/${boardnum}`)}>수정</Button>

                            &nbsp;
                            <Button variant='outlined' color='success'
                                    size="small" style={{width:'80px'}}
                                    onClick={handleClickOpen}>삭제</Button>

                            {/* 삭제 비번 입력 다이얼로그 */}
                            <Dialog
                                open={open}
                                onClose={handleClose}
                                PaperProps={{
                                    component: 'form',
                                    onSubmit: (event) => {
                                        event.preventDefault();
                                        //alert(pass);
                                        let url=`/boot/board/deletecheckpass?boardnum=${boardnum}&pass=${pass}`;
                                        axios.get(url)
                                            .then(res=>{
                                                // alert(res.data.result);
                                                if(res.data.result==='success'){
                                                    window.alert("삭제되었습니다");
                                                    navi("/board/list");

                                                }else
                                                    window.alert("비밀번호가 맞지 않습니다");
                                            });
                                        handleClose();
                                    },
                                }}
                            >
                                <DialogTitle>삭제확인</DialogTitle>
                                <DialogContent>
                                    <DialogContentText>
                                        비밀번호를 입력해주세요
                                    </DialogContentText>
                                    <TextField
                                        autoFocus
                                        required
                                        margin="dense"
                                        id="standard-password-input"
                                        label="Password"
                                        type="password"
                                        autoComplete="current-password"
                                        variant="standard"
                                        onChange={(e)=>setPass(e.target.value)}
                                    />
                                </DialogContent>
                                <DialogActions>
                                    <Button onClick={handleClose}>취소</Button>
                                    <Button type="submit">글삭제</Button>
                                </DialogActions>
                            </Dialog>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                {
                                    commentList &&
                                    commentList.map((item,idx)=>
                                        <div key={idx}>
                                            {item.nickname} : {item.comment}
                                            <span style={{fontSize:'13px',color:'gray',marginLeft:'30px'}}>
                                {item.writeday}</span>
                                            &nbsp;&nbsp;
                                            <EditNote style={{cursor:'pointer',color:'gray'}}
                                                      onClick={()=>{
                                                          let comment=window.prompt("댓글수정",item.comment);
                                                          //alert(comment);

                                                          let url=`/boot/comment/update?idx=${item.idx}&comment=${comment}`;
                                                          axios.get(url)
                                                              .then(res=>{
                                                                  //수정후 목록 다시 호출
                                                                  commentListEvent();
                                                              });

                                                      }}/>
                                            &nbsp;&nbsp;
                                            <HighlightOff style={{cursor:'pointer',color:'gray'}}
                                                          onClick={()=>{
                                                              let a=window.confirm("해당 댓글을 삭제하시겠습니까?");
                                                              if(a){
                                                                  deleteComment(item.idx);
                                                              }
                                                          }}/>
                                        </div>)
                                }
                            </div>
                            <hr/>
                            <div className='input-group' style={{width:'500px'}}>
                                {/* 댓글 입력 */}
                                <input type='text' className='form-control'
                                       style={{width:'120px'}} placeholder='닉네임입력'
                                       value={nickname} onChange={(e)=>setNickname(e.target.value)}/>
                                &nbsp;&nbsp;
                                <input type='text' className='form-control'
                                       placeholder='댓글을 입력하세요'
                                       value={comment} onChange={(e)=>setComment(e.target.value)}
                                       style={{width:'250px'}}/>
                                &nbsp;&nbsp;
                                <Button variant='contained' size="small" color='error'
                                        onClick={addCommentEvent}>저장</Button>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            }

        </div>
    );
};

export default BoardDetail;