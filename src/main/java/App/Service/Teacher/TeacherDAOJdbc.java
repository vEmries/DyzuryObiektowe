package App.Service.Teacher;

import App.Model.Teacher;
import App.Service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public class TeacherDAOJdbc implements TeacherDAO {
    JdbcTemplate template;

    public TeacherDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return template.query("select * from teacher",
                new TeacherMapper());
    }

    @Override
    public List<Teacher> findTeacherByName(String teacherName) {
        return template.query("select * from teacher where teachername=(?)",
                new Object[]{teacherName},
                new TeacherMapper());
    }

    @Override
    public List<Teacher> findTeacherBySurname(String teacherSurname) {
        return template.query("select * from teacher where teachersurname=(?)",
                new Object[]{teacherSurname},
                new TeacherMapper());
    }

    @Override
    public Teacher getTeacherByID(Integer teacherID) {
        return template.queryForObject("select * from teacher where teacherid=(?)",
                new Object[]{teacherID},
                new TeacherMapper());
    }

    @Override
    public void insertNewTeacher(Teacher newTeacher) {
        template.update("insert into teacher(teachername, teachersurname) values(?, ?)",
                newTeacher.getTeacherName(),
                newTeacher.getTeacherSurname());
    }

    @Override
    public void deleteTeacher(Integer teacherID) {
        template.update("delete from teacher where teacherid=(?)",
                teacherID);
    }

    @Override
    public void update(Teacher updatedTeacher) {
        template.update("update teacher set teachername=(?), teachersurname=(?) where teacherid=(?)",
                updatedTeacher.getTeacherName(),
                updatedTeacher.getTeacherSurname(),
                updatedTeacher.getTeacherID());
    }
}
