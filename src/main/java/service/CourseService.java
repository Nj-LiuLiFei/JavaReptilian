package service;

import entity.CourseEntity;
import mapper.CourseMapper;

public class CourseService implements CourseMapper {

    private CourseMapper courseMapper;

    @Override
    public void insert(CourseEntity courseEntity) {
        courseMapper.insert(courseEntity);
    }

    public CourseMapper getCourseMapper() {
        return courseMapper;
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }
}
