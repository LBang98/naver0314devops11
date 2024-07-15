import React from 'react';
import { DeleteForeverOutlined } from '@mui/icons-material';
import MyCarWriteForm from "./MyCarWriteForm";

const MyCarRowItem = ({idx,row,onDelete}) => {

    const photopath1 = "https://vdeghj5x3716.edge.naverncp.com/iI0wM9dyqa/mycar";
    const photopath2 = "?type=f&w=40&h=40&ttype=jpg";
    const storagepath="https://kr.object.ncloudstorage.com/bitcamp-bh-98/mycar";    //스토리지 주

    const deleteMycar = (num)=>{
        let a = window.confirm("해당 상품을 삭제할까요?");

        if(a){
            onDelete(num);
        }
    }

    return (
        <tr style={{fontSize:'14px'}}>
            <td>
                <img src={`${photopath1}/${row.carphoto}/${photopath2}`} alt=""
                border={'1'}/>
                <span style={{marginLeft:'5px'}}>{row.carname}</span>
            </td>
            <td align={'right'}>
                {row.carprice}만원
            </td>
            <td align={'center'}>
                <div style={{width:'30px',height:'30px', background:row.carcolor}}></div>
            </td>
            <td>
                {row.carguip}
            </td>
            <td>
                <span style={{color: 'gray', fontSize: '13px'}}>
                    {row.writeday}
                    &nbsp;
                    <DeleteForeverOutlined
                        style={{cursor: 'pointer'}}
                    onClick={()=>deleteMycar(row.num)}/>/>
                </span>
            </td>
        </tr>

    );
};

export default MyCarRowItem;