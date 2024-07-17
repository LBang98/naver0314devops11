import React from 'react';
import {Alert} from "@mui/material";
import mainphoto1 from '../image/K-041.png';
import mainphoto2 from '../image/K-053.png';


const Home = () => {
    return (
        <div>
            <Alert>Home</Alert>
            <div style={{marginTop: '30px'}}>
                <img src={mainphoto1} alt=""
                     style={{width: '200px', height: '200px'}}/>
                <img src={mainphoto2} alt=""
                     style={{width: '200px', height: '200px'}}/>
            </div>
        </div>
    );
};

export default Home;