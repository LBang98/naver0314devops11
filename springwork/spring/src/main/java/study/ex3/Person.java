package study.ex3;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Person {
    @NonNull
    private String name;
    private String phone;



}
