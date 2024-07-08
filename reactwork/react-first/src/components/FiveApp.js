import React, {useState} from "react";
import car1 from '../mycar13.png';

const FiveApp = ()=>{
    const [show, setShow] = useState(true);
    const [fname, setFname] = useState('Gamja Flower');
    const [fcolor, setFcolor] = useState('red');
    const [bcolor, setBcolor] = useState('#afeeee');

    let message = "오늘은 리액트를 공부중입니다";

    return(
     <div>
         <h1 className="alert alert-danger">FiveApp - 글꼴변경</h1>
         <button type={"button"} className={"btn btn-sm btn-info"} onClick={() => setShow(!show)}>show/hide</button>
         {
             show &&
             <img alt={"car"} src={car1} style={{width: '200px'}}/>
         }
         <hr/>
         <div style={{fontSize:'30px', color:fcolor, fontFamily:fname, backgroundColor:bcolor}}>
             {message}
         </div>
         <h5>select 이벤트를 이용해서 글꼴 변경하기</h5>

         <div className={'input-group'} style={{width:'300px'}}>
             <select className={"form-select"} style={{width:'120px',marginLeft:'20px'}}
             onChange={(e) => setFname(e.target.value)}>
                 <option value="East Sea Dokdo">East Sea Dokdo</option>
                 <option value="Jua">Jua</option>
                 <option value="Gaegu">Gaegu</option>
                 <option value="Gamja Flower" selected>Gamja Flower</option>
                 <option value="Single Day">Single Day</option>
             </select>
             &nbsp;&nbsp;
             <select className={"form-select"} style={{width:'120px'}}
             onChange={(e) => setFcolor(e.target.value)}>
                 <option value="hotpink">hotpink</option>
                 <option value="red" selected>red</option>
                 <option value="green">green</option>
                 <option value="orange">orange</option>
                 <option value="black">black</option>
             </select>
             <br/>
             &nbsp;&nbsp;
             <label htmlFor="">
                 <input type="radio" defaultValue="#afeeee" name={"bcolor"}
                 onClick={(e)=>setBcolor(e.target.value)}/>하늘색
             </label>
             &nbsp;&nbsp;
             <label htmlFor="">
                 <input type="radio" defaultValue="#fffacd" name={"bcolor"}
                        onClick={(e)=>setBcolor(e.target.value)}/>노랑색
             </label>
             &nbsp;&nbsp;
             <label htmlFor="">
                 <input type="radio" defaultValue="#90ee90" name={"bcolor"}
                        onClick={(e)=>setBcolor(e.target.value)}/>그린색
             </label>
             
         </div>
     </div>
    )
}
export default FiveApp;
