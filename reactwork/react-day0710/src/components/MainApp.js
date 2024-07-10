import React, {useState} from 'react';
import {brown} from "@mui/material/colors";
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';

const MainApp = () => {

    const [idx, setIdx] = useState(1);

    const changeApp = (e) => {
        setIdx(Number(e.target.value));
    }

    return (
        <div>
            <h2>2024-07-10 리액트 수업</h2>
            <div style={{fontSize: '20px'}}>
                <label>
                    <input type="radio" name={'app'} defaultValue={1}
                           onClick={changeApp}/>OneApp - 배열추가, 삭제
                </label>
                <br/>
                <label>
                    <input type="radio" name={'app'} defaultValue={2}
                           onClick={changeApp}/>TwoApp - 배열추가, 삭제 문제
                </label>
                <br/>
                <label>
                    <input type="radio" name={'app'} defaultValue={3}
                           onClick={changeApp}/>ThreeApp
                </label>
                <br/>
                <label>
                    <input type="radio" name={'app'} defaultValue={4}
                           onClick={changeApp}/>FourApp
                </label>
                <br/>
                <label>
                    <input type="radio" name={'app'} defaultValue={5}
                           onClick={changeApp}/>FiveApp
                </label>
                <br/>
                <label>
                    <input type="radio" name={'app'} defaultValue={6}
                           onClick={changeApp}/>SixApp
                </label>
                <br/>
                <div>
                    <hr/>
                    {
                        idx === 1 ? <OneApp/> : idx === 2 ? <TwoApp/> :
                            idx === 3 ? <ThreeApp/> : idx === 4 ? <FourApp/> :
                                idx === 5 ? <FiveApp/> : <SixApp/>
                    }
                </div>
            </div>
        </div>
    );
};

export default MainApp;