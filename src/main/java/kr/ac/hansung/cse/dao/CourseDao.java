package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//dao 데이터베이스에서 실제 데이터 액세스
@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    //query and return a single object
    public Course getCourse(String name) {
        String sqlStatement = "select * from courses where name=?";

        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, new RowMapper<Course>() {
                    @Override
                    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Course course= new Course();

                        course.setCourseId(rs.getString("course_id"));
                        course.setYearTake(rs.getInt("year_take"));
                        course.setSemester(rs.getInt("semester"));
                        course.setCourseName(rs.getString("course_name"));
                        course.setCourseDiv(rs.getString("course_div"));
                        course.setProf(rs.getString("prof"));
                        course.setCredit(rs.getInt("credit"));

                        return course;
                    }
                });
    }

    //query and return multiple objects
    //cRud method - Read
    public List<Course> getCourses() {
        String sqlStatement = "select * from courses";

        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();

                course.setCourseId(rs.getString("course_Id"));
                course.setYearTake(rs.getInt("year_take"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseDiv(rs.getString("course_div"));
                course.setProf(rs.getString("prof"));
                course.setCredit(rs.getInt("credit"));

                return course;
            }
        }) ;
    }

    //Crud method - Create
    public boolean insert(Course course) {
        int yearTake = 2024;
        int semester = 2;
        String courseId = course.getCourseId();
        String courseName = course.getCourseName();
        String courseDiv = course.getCourseDiv();
        String prof = course.getProf();
        int credit = course.getCredit();

        String sqlStatement = "insert into courses(year_take, semester, course_id, course_name, course_div, prof, credit) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {yearTake, semester, courseId, courseName, courseDiv, prof, credit}) == 1);
    }

    //crUd method - Update
    public boolean update(Course course) {
        int yearTake = 2024;
        int semester = 2;
        String courseId = course.getCourseId();
        String courseName = course.getCourseName();
        String courseDiv = course.getCourseDiv();
        String prof = course.getProf();
        int credit = course.getCredit();

        String sqlStatement = "update courses set year_take=?, semester=?, course_id=?, course_name=?, course_div=?, prof=?, credit=? where course_id=?";

        return (jdbcTemplate.update(sqlStatement, new Object[]{yearTake, semester, courseId, courseName, courseDiv, prof, credit}) == 1);
    }

    //cruD method - delete
    public boolean delete(int courseId) {
        String sqlStatement = "delete from courses where course_id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{courseId}) == 1);
    }
}

