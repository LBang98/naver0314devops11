import { Alert } from '@mui/material';
import React from 'react';

const EightApp = () => {
    const personArray=[
        {pname:"전지현",photo:"8.jpg",addr:"제주도애월읍",age:45},
        {pname:"설현",photo:"15.jpg",addr:"부산 해운대구",age:26},
        {pname:"신민아",photo:"17.jpg",addr:"서울시 강남구",age:31},
        {pname:"수지",photo:"19.jpg",addr:"서울시 여의도",age:29},
        {pname:"강동원",photo:"9.jpg",addr:"경기도 용인시",age:41}
    ];
    return (
        <div>
            <Alert>EightApp-table 을 이용해서 출력</Alert>
            {/* 번호 ,사진(class smallphoto 적용),이름,나이,주소 순으로 출력 */}

            <table className={"table table-bordered"} style={{width:'400px'}}>
                <thead>
                <tr className={'table-danger'}>
                    <th style={{width:'50px'}}>번호</th>
                    <th style={{width:'70'}}>사진</th>
                    <th style={{width:'100px'}}>이름</th>
                    <th style={{width:'80px'}}>나이</th>
                    <th style={{width:'60px'}}>주소</th>
                </tr>
                </thead>
                <tbody>
                {
                    personArray.map((person, idx)=>
                    <tr key={idx}>
                        <td align={'center'}>{idx+1}</td>
                        <td align={'center'}>
                            <img src={require(`../image/${person.photo}`)} alt="" className={'smallphoto'}/>
                        </td>
                        <td>{person.pname}</td>
                        <td>{person.age}세</td>
                        <td>{person.addr}</td>
                    </tr>
                    )
                }
                </tbody>
            </table>

        </div>
    );
};

export default EightApp;