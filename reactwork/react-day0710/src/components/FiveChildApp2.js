import React from 'react';
import './MyStyle.css';

const FiveChildApp2 = ({photo,msg}) => {
    return (
        <div className='box1'>
            <img alt="" src={require(`../mycar/${photo}`)} className='small'/>
            <b>{msg}</b>
        </div>
    );
};

export default FiveChildApp2;