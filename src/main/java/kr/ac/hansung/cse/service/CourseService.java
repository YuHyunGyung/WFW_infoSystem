package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    //table 모든 레코드 가져오기
    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    //table 레코드 추가하기
    public void insert(Course course) {
        courseDao.insert(course);
    }
}
