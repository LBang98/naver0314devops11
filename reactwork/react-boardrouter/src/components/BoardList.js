import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import axios from "axios";
import {NavLink} from "react-router-dom";

const BoardList = () => {

    const [boardlist, setBoardList] = useState([]);
    const getDataList=()=>{
        axios.get("/boot/board/list")
            .then(res=>{
                setBoardList(res.data);
            });
    }

    const storage = process.env.REACT_APP_STORAGE;


    //처음 딱 한번 목록 가져오기
    useEffect(() => {
        getDataList();
    }, []);

    return (
        <div style={{width:'600px'}}>
            <Alert>
                <b>총 {boardlist.length}개의 게시글이 있습니다</b>
            </Alert>
            <table className={'table table-striped'}>
                <thead>
                <tr className={'table-danger'}>
                    <th style={{width: '50px'}}>번호</th>
                    <th style={{width: '350px'}}>제목</th>
                    <th style={{width: '70px'}}>작성자</th>
                    <th style={{width: '100px'}}>작성일</th>
                    <th style={{width: '50px'}}>조회</th>
                </tr>
                </thead>
                <tbody>
                {
                    boardlist &&
                    boardlist.map((row,idx) =>
                        <tr key={idx}>
                            <td align={"center"}>{boardlist.length-idx}</td>
                            <td>
                                <NavLink to={`/board/detail${row.boardnum}`}
                                         style={{textDecoration:'none', color:'black'}}>
                                    <img src="`${storage}/${row.photo}`" alt=""
                                         style={{width:'40px', height:'40px', marginRight:'5px'}}/>
                                    {row.subject}
                                </NavLink>
                            </td>
                            <td align={'center'}>{row.writer}</td>
                            <td align={'center'}>
                                <span style={{fontSize:'14px'}}>{row.writeday.substring(0,10)}</span>
                            </td>
                            <td align={'center'}>{row.readcount}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>


        </div>
    );
};

export default BoardList;