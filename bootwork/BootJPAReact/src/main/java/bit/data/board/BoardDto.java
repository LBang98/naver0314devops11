package bit.data.board;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reactboard")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardnum;

    @Column(length = 30)
    private String writer;

    @Column(length = 20,updatable = false)
    private String pass;

    @Column(length = 1000)
    private String subject;

    @Column(length = 2000)
    private String content;

    @Column(updatable = false)
    private int readcount=0;

    @Column(length = 100)
    private String photo;

    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    @Transient  //컬럼 생성 안함
    private int answercount;
}