package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Builder
@Alias("MemberDto")
@AllArgsConstructor
public class MemberDto {

    private int num;
    private String name;
    private String myid;
    private String passwd;
    private String addr;
    private String hp;
    private String email;
    private String photo;
    private String birthday;
    private Timestamp gaipday;

}
