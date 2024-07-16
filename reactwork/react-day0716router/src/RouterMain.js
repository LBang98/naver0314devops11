import React from 'react';
import Menu from "./components/Menu";
import {Route, Routes} from "react-router-dom";
import {About, Food, Home} from "./pages";
import photo1 from './image/s5.JPG';
import photo2 from './image/s10.JPG';
import Member from "./pages/Member";
import MyCar from "./pages/MyCar";

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path={'/'} element={<Home/>}/>
{/*
                <Route path={'/food'} element={<Food/>}/>
*/}
                <Route path={'/food'} element={<Food/>}>
                    <Route path={':food1'} element={<Food/>}/>
                    <Route path={':food1/:food2'} element={<Food/>}/>
                </Route>

                <Route path={'/about'} element={<About/>}/>

                <Route path={'/member/*'} element={<Member/>}/>

                <Route path={'/mycar/*'} element={<MyCar/>}/>

                {/*직접 태그를 이용해서 페이지를 구현해도 된다*/}
                <Route path={'/login/*'} element={
                    <div>
                        <h2>로그인 메뉴입니다</h2>
                        <img src={photo1} alt=""/>
                        <About/>
                    </div>
                }/>

                {/*이외의 모든 매핑주소에 대한 처리*/}
                {/*<Route path={'*'} element={
                    <div>
                        <h2>잘못된 페이지입니다</h2>
                        <img src={photo2} alt=""/>
                    </div>
                }/>*/}

            </Routes>
        </div>
    );
};

export default RouterMain;