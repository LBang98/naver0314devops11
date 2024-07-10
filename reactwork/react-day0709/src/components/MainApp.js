import React, {useState} from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from "./SevenApp";
import EightApp from "./EightApp";

const MainApp = () => {

    const [idx, setIdx] = useState(1);

    return (
        <div>
            <h3>2024-07-09 리액트 수업</h3>
            <br/>
            <select className={"form-select"} style={{width: "300px", marginLeft: "30px"}}
                    onChange={(e) => setIdx(Number(e.target.value))}>
                <option value={1} selected>OneApp-styled-components</option>
                <option value={2}>TwoApp - 이미지 불러오기</option>
                <option value={3}>ThreeApp show/hide</option>
                <option value={4}>FourApp</option>
                <option value={5}>FiveApp</option>
                <option value={6}>SixApp</option>
                <option value={7}>SevenApp</option>
                <option value={8}>EightApp</option>
            </select>
            <br/>
            {
                idx === 1 ? <OneApp/> : idx === 2 ? <TwoApp/> :
                    idx === 3 ? <ThreeApp/> : idx === 4 ? <FourApp/> :
                        idx === 5 ? <FiveApp/> : idx === 6 ? <SixApp/> :
                            idx === 7 ? <SevenApp/> : <EightApp/>
            }

        </div>
    )
}
export default MainApp;