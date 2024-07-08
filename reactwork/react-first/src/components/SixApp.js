import * as React from 'react';
import car1 from '../mycar11.png';
import car2 from '../mycar12.png';
import car3 from '../mycar13.png';
import {useState} from "react";

export const SixApp = () => {

    const [show, setShow] = useState(true);
    const [size, setSize] = useState("40");
    const [msg, setMsg] = useState("");
    const [photo, setPhoto] = useState(car1);
    const [border, setBorder] = useState("solid");


    return (
        <div style={{width: "400px"}}>
            <h1>오늘의 문제</h1>
            <hr/>
            <div>
                <input type="checkbox" onClick={(e)=> setShow(!show) }/>사진 숨김
                &nbsp;&nbsp;
                <button type={"button"} onClick={()=> setSize(size-2)} className={"btn btn-info btn-sm"}>점점작게</button>
                &nbsp;&nbsp;
                <button type={"button"} onClick={()=> setSize(size+2)} className={"btn btn-info btn-sm"}>점점크게</button>
                <br/><br/>
                <input type="text" className="form-control" style={{width: '400px'}}
                       value={msg}
                       onChange={(e)=>setMsg(e.target.value)}/>
                <br/><br/>
            </div>
            <div style={{marginLeft:'30px'}}>
                <select onChange={(e)=> setPhoto(e.target.value)}>
                    <option value={car1} selected>car1</option>
                    <option value={car2}>car2</option>
                    <option value={car3}>car3</option>
                </select>
                {
                    show &&
                    <img alt={"car"} src={photo} style={{width:"auto", height:"150px", marginLeft: "50px", border:`10px ${border} pink`}}/>
                }
                <br/>
                <select onChange={(e)=> setBorder(e.target.value)}>
                    <option selected>solid</option>
                    <option>dotted</option>
                    <option>double</option>
                    <option>dashed</option>
                    <option>inset</option>
                </select>
            </div>
            <br/>
            <h1 style={{backgroundColor: "skyblue", color: "blue", fontSize: `${size}px`}}>{msg}</h1>

        </div>
    );
};