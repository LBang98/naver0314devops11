import React from 'react';
import {Alert, Button} from "@mui/material";
import nofood from "../image/s10.JPG";
import {useNavigate, useParams} from "react-router-dom";

const Food = () => {

    //path의 파라미터값 읽기
    const {food1, food2} = useParams();
    console.log({food1}, {food2});

    const navi = useNavigate();

    return (
        <div>
            <Alert severity={'error'}>Food</Alert>
            <div style={{marginTop: '20px'}}>
                {
                    food1 == null && food2 == null ?
                        <div>
                            <h3>오늘은 점심을 안먹고 공부를 하겠습니다</h3>
                            <img src={nofood} alt=""/>
                        </div> :
                        food1 != null && food2 == null ?
                            <div>
                                <h2>오늘 저의 후식 메뉴는 한가지입니다</h2>
                                <img src={require(`../image/${food1}.jpg`)} alt=""
                                     style={{width: '200px'}}/>
                            </div> :
                            <div>
                                <h2>오늘 저의 점심 메뉴입니다</h2>
                                <img src={require(`../image/${food1}.jpg`)} alt=""
                                     style={{width: '200px'}}/>
                                &nbsp;&nbsp;
                                <img src={require(`../image/${food2}.jpg`)} alt=""
                                     style={{width: '200px'}}/>
                            </div>
                }
            </div>
            <h3>페이지 이동 연습</h3>
            <Button variant={'contained'} size={'small'} color={'error'}
                    onClick={() => navi('/about')}>About 페이지로 이동</Button>
            <br/>
            <Button variant={'contained'} size={'small'} color={'success'}
                    onClick={() => navi('/mycar/list')}>MyCar 페이지로 이동</Button>
            <br/>
            <Button variant={'contained'} size={'small'} color={'info'}
                    onClick={() => navi('/member/moim1')}>Member 페이지로 이동</Button>

        </div>
    );
};

export default Food;