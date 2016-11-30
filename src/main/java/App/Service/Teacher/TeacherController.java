package App.Service.Teacher;

import App.Model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 2016-11-28.
 */
@RestController
public class TeacherController {

    TeacherDAO teacherDAO;

    public TeacherController() {
        this.teacherDAO = new TeacherDAOJdbc();
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public List<Teacher> listAllTeachers() {
        return teacherDAO.findAllTeachers();
    }

    @RequestMapping(value = "/teachers/byname", method = RequestMethod.GET)
    public List<Teacher> listTeachersByName(
            @RequestParam(value = "name", defaultValue = "") String teacherName) {
        return teacherDAO.findTeacherByName(teacherName);
    }

    @RequestMapping(value = "/teachers/bysurname", method = RequestMethod.GET)
    public List<Teacher> listTeachersBySurname(
            @RequestParam(value = "surname", defaultValue = "") String teacherSurname) {
        return teacherDAO.findTeacherBySurname(teacherSurname);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public Teacher getTeacherInfo(
            @PathVariable Integer id) {
        return teacherDAO.getTeacherByID(id);
    }

    @RequestMapping(value = "/teachers/new", method = RequestMethod.POST)
    public void createTeacher(
            @RequestParam(value = "name", defaultValue = "") String teacherName,
            @RequestParam(value = "surname", defaultValue = "") String teacherSurname) {
        teacherDAO.insertNewTeacher(new Teacher(0, teacherName, teacherSurname));
    }

    @RequestMapping(value = "/teachers/delete", method = RequestMethod.DELETE)
    public void deleteTeacher(
            @RequestParam(value = "id", defaultValue = "") Integer teacherID) {
        teacherDAO.deleteTeacher(teacherID);
    }

    @RequestMapping(value = "/teachers/update", method = RequestMethod.POST)
    public void updateTeacher(
            @RequestParam(value = "id", defaultValue = "") Integer teacherID,
            @RequestParam(value = "name", defaultValue = "") String teacherName,
            @RequestParam(value = "surname", defaultValue = "") String teacherSurname) {
        teacherDAO.update(new Teacher(teacherID, teacherName, teacherSurname));
    }


}
