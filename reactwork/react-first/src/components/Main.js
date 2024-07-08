//Main  에 각종 컴포넌트를 배치해보자
//이번에는 함수형으로 만들어보자

import { OneApp } from "./OneApp"
import ThreeApp from "./ThreeApp";
import TwoApp from "./TwoApp";

const Main=()=>{
    return (
        <div>
            <ThreeApp/>
            <hr/>
            <TwoApp/>
            <hr/>
            <OneApp/>
            <hr/>
        </div>
    )
}

export default Main;