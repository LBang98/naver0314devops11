import React, {useState} from 'react';
import {Alert} from "@mui/material";

const OneApp = () => {

    //i번지의 메시지 삭제하는 함수
    const deleteMessage = (i) => {

        //1. slice를 이용해서 i번지만 빼고 다시 배열에 담기
        /*setMsg(
            [
                ...msg.slice(0,i),
                ...msg.slice(i+1, msg.length)
            ]
        )*/

        //2. filter를 이용해서 i번지만 제외해서 담기
        setMsg(msg.filter((m,n) => n!==i));
    }

    const [msg, setMsg] = useState(["Happy","안녕","Bitcamp"]);

    return (
        <div>
            <Alert>OneApp - 배열에 데이타 추가, 삭제하기</Alert>

            <h6>배열 데이타 출력</h6>
            {
                msg &&
                msg.map((m,i) =>
                <h4 key={i}>{m}</h4>
                )
            }
            <h3 style={{color:'red'}}>배열 데이타 출력</h3>
            <Alert severity={'info'}>총 {msg.length}개의 메시지가 있어요</Alert>
            {
                //msg값이 널 값이 아닌 경우에만 출력
                msg &&
                msg.map((m,i) =>
                    <h4 key={i}>{m}
                        &nbsp;&nbsp;
                        <span onClick={deleteMessage(i)}>

                        </span>
                    </h4>
                )
            }
        </div>
    );
};

export default OneApp;