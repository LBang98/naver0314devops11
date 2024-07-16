import React, {useEffect, useState} from 'react';
import axios from "axios";
import {ImageList} from "@mui/material";
import {ImageListItem} from "@mui/material";
import {ImageListItemBar} from "@mui/material";

const MyCarPhoto = () => {

    const [list, setList] = useState([]);
    const storage = "https://kr.object.ncloudstorage.com/bitcamp-bh-98/mycar";

    const dataList = () => {
        axios.get("/mycar/list")
            .then(res=>{
                setList(res.data);
            })
    }

    useEffect(() => {
        dataList();
    }, []);

    return (
        <ImageList sx={{ width: 450, height: 450 }}>
            {list.map((item, idx) => (
                <ImageListItem key={item.img}>
                    <img
                        srcSet={`${storage}/${item.carphoto}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
                        src={`${storage}/${item.carphoto}?w=164&h=164&fit=crop&auto=format`}
                        alt={item.carname}
                        loading="lazy"
                    />
                    <ImageListItemBar position="below" title={item.carname}
                    subtitle={<span>Price: {item.carprice}만</span>}
                        />
                </ImageListItem>
            ))}
        </ImageList>
    );
};

export default MyCarPhoto;