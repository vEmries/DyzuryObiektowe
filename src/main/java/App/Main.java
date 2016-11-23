package App;

import App.Model.Place;
import App.Model.Teacher;
import App.Service.Break.BreakDAO;
import App.Service.Break.BreakDAOJdbc;
import App.Service.CombinedFunctions;
import App.Service.Dyzur.DyzurDAO;
import App.Service.Dyzur.DyzurDAOJdbc;
import App.Service.Place.PlaceDAO;
import App.Service.Place.PlaceDAOJdbc;
import App.Service.Teacher.TeacherDAO;
import App.Service.Teacher.TeacherDAOJdbc;

/**
 * Created by Admin on 2016-11-22.
 */
public class Main {
    public static void main(String[] args) {

        TeacherDAO teacherDAO = new TeacherDAOJdbc();
        BreakDAO breakDAO = new BreakDAOJdbc();
        PlaceDAO placeDAO = new PlaceDAOJdbc();
        DyzurDAO dyzurDAO = new DyzurDAOJdbc();
        CombinedFunctions functions = new CombinedFunctions();

        System.out.println(teacherDAO.findAllTeachers());
//        teacherDAO.findTeacherByName("Andrzej");
//        teacherDAO.insertNewTeacher(new Teacher(0, "Mikołaj", "Kopernik"));
//        teacherDAO.deleteTeacher(4);
//        teacherDAO.update(new Teacher(4, "Mikołaj", "Kopernikkkk"));

        System.out.println(breakDAO.findAllBreaks());

//        placeDAO.insertNewPlace(new Place(0, "Korytarz Boczny", 2));
        System.out.println(placeDAO.findAllPlaces());
        System.out.println(placeDAO.findPlaceByFloor(2));

        System.out.println(dyzurDAO.findAllDyzury());

        System.out.println(functions.findDyzurByFloor(2));
        System.out.println(functions.findDyzurBySurname("Nowak"));
        System.out.println(functions.findTeacherByFloor(2));
    }
}
