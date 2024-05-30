package data.mapper;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestMapperInter {

    public void insertGuest(GuestDto dto);
    public void insertGuestPhoto(GuestPhotoDto dto);
}
