package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor //인자없는 contraint를 만
public class Course {
    private int yearTake; //수강년도
    private int semester; //학기

    @Size(min=7, max=7, message = "교과코드는 7자입니다.")
    @NotEmpty(message = "The courseId cannot be emptpy")
    private String courseId; //교과코드

    @NotEmpty(message = "The courseName cannot be empty")
    private String courseName; //교과목명

    @Size(min=2, max=2, message = "교과구분은 2자입니다.")
    private String courseDiv; //교과구분

    private String prof; //담당교수

    @Min(1)
    @Max(3)
    @Positive
    private int credit; //학점
}