package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    // Controller -> Service -> Dao
    @Autowired
    private CourseService courseService; //offerService를 통해서 함수 호출

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = courseService.getAllCourses(); //table의 모든 레코드 가져오기
        model.addAttribute("id_courses", courses);

        return "courses";
    }


    @GetMapping("/createCourse")
    public String createCourse(Model model) {
        //새로운 bean을 만들어서 모델에 넣어주고, view쪽으로 넘겨줌
        model.addAttribute("course", new Course());

        return "createCourse";
    }


    //course는 model에 자동저장됨
    //Valid = 사용자가 입력한 값을 검증, 검증의 제약조건은 우리가 입력해야함
    //BindingResult = 검증한 결과를 여기에 넣어달라
    @PostMapping("/doCreate")
    public String doCreate(Model model, @Valid Course course, BindingResult result) {
        System.out.println(course);

        //에러가 있을경우
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();
            //각각의 에러를 출력
            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            System.out.println("==================================");
            return "createCourse";
        }

        //Controller -> Service 호출, Service -> Dao 통해서 저장
        courseService.insert(course);
        return "courseCreated";
    }
}
