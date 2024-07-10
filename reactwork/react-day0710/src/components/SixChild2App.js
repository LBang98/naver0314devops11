import React from 'react';
import './MyStyle.css';
import { Button } from '@mui/material';
import { DeleteForeverOutlined } from '@mui/icons-material';

const SixChild2App = ({row,idx,onDelete}) => {
    return (
        <tr style={{backgroundColor:row.color}}>
            <td>{row.cname}</td>
            <td align='center'>
                <img alt="" src={require(`../mycar/${row.cphoto}`)}
                     className='small'/>
            </td>
            <td align='right'>{row.cprice}만원</td>
            <td align='center'>
                <Button size="small" color="error" variant='contained'
                        startIcon={<DeleteForeverOutlined/>}
                        onClick={()=>onDelete(idx)}>Del</Button>
            </td>
        </tr>
    );
};

export default SixChild2App;