package App.Service.Teacher;

import App.Model.Teacher;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public interface TeacherDAO {

    public List<Teacher> findAllTeachers();

    public List<Teacher> findTeacherByName(String teacherName);

    public List<Teacher> findTeacherBySurname(String teacherSurname);

    public Teacher getTeacherByID(Integer teacherID);

    public void insertNewTeacher(Teacher newTeacher);

    public void deleteTeacher(Integer teacherID);

    public void update(Teacher updatedTeacher);
}
