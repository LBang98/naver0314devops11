package data.mapper;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestMapperInter {

    public void insertGuest(GuestDto dto);
    public void insertGuestPhoto(GuestPhotoDto dto);
    public List<GuestDto> getAllGuest();
    public List<String> getGuestPhoto(int guestidx);

}
