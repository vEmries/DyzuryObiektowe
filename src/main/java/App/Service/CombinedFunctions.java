package App.Service;

import App.Model.Break;
import App.Model.Dyzur;
import App.Model.Place;
import App.Model.Teacher;
import App.Service.Break.BreakDAO;
import App.Service.Break.BreakDAOJdbc;
import App.Service.Dyzur.DyzurDAO;
import App.Service.Dyzur.DyzurDAOJdbc;
import App.Service.Place.PlaceDAO;
import App.Service.Place.PlaceDAOJdbc;
import App.Service.Teacher.TeacherDAO;
import App.Service.Teacher.TeacherDAOJdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public class CombinedFunctions {

    TeacherDAO teacherDAO = new TeacherDAOJdbc();
    BreakDAO breakDAO = new BreakDAOJdbc();
    PlaceDAO placeDAO = new PlaceDAOJdbc();
    DyzurDAO dyzurDAO = new DyzurDAOJdbc();

    public List<Dyzur> findDyzurByFloor(Integer placeFloor) {
        List<Dyzur> rs = new ArrayList<>();

        for (int i = 0; i < placeDAO.findPlaceByFloor(placeFloor).size(); i++) {
            Place tempPlace = placeDAO.findPlaceByFloor(placeFloor).get(i);
            rs.addAll(dyzurDAO.findDyzurByPlaceID(tempPlace.getPlaceID()));
        }

        return rs;
    }

    public List<Dyzur> findDyzurBySurname(String teacherSurname) {
        List<Dyzur> rs = new ArrayList<>();

        for (int i = 0; i < teacherDAO.findTeacherBySurname(teacherSurname).size(); i++) {
            Teacher tempTeacher = teacherDAO.findTeacherBySurname(teacherSurname).get(i);
            rs.addAll(dyzurDAO.findDyzurByTeacherID(tempTeacher.getTeacherID()));
        }

        return rs;
    }

    public List<Dyzur> findDyzurByBreakName(String breakName) {
        List<Dyzur> rs = new ArrayList<>();

        for (int i = 0; i < breakDAO.findBreakByName(breakName).size(); i++) {
            Break tempBreak = breakDAO.findBreakByName(breakName).get(i);
            rs.addAll(dyzurDAO.findDyzurByBreakID(tempBreak.getBreakID()));
        }

        return rs;
    }

    public List<Teacher> findTeacherByFloor(Integer placeFloor) {
        List<Teacher> rs = new ArrayList<>();
        List<Dyzur> tempDyzury = new ArrayList<>();

        for (int i = 0; i < placeDAO.findPlaceByFloor(placeFloor).size(); i++) {
            Place tempPlace = placeDAO.findPlaceByFloor(placeFloor).get(i);
            tempDyzury.addAll(dyzurDAO.findDyzurByPlaceID(tempPlace.getPlaceID()));
        }

        for (int i = 0; i < tempDyzury.size(); i++) {
            Dyzur temptDyzur = tempDyzury.get(i);
            rs.add(teacherDAO.getTeacherByID(temptDyzur.getTeacherID()));
        }

        return rs;
    }
}
