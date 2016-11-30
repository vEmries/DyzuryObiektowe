package App.Service.Dyzur;

import App.Model.Dyzur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 2016-11-30.
 */
@RestController
public class DyzurController {

    DyzurDAO dyzurDAO;

    public DyzurController() {
        this.dyzurDAO = new DyzurDAOJdbc();
    }

    @RequestMapping(value = "/dyzury", method = RequestMethod.GET)
    public List<Dyzur> listAllDyzury() {
        return dyzurDAO.findAllDyzury();
    }

    @RequestMapping(value = "/dyzury/byteacherid/{id}", method = RequestMethod.GET)
    public List<Dyzur> listDyzuryByTeacherID(
            @PathVariable Integer id) {
        return dyzurDAO.findDyzurByTeacherID(id);
    }

    @RequestMapping(value = "/dyzury/bybreakid/{id}", method = RequestMethod.GET)
    public List<Dyzur> listDyzuryByBreakID(
            @PathVariable Integer id) {
        return dyzurDAO.findDyzurByBreakID(id);
    }

    @RequestMapping(value = "/dyzury/byplaceid/{id}", method = RequestMethod.GET)
    public List<Dyzur> listDyzuryByPlaceID(
            @PathVariable Integer id) {
        return dyzurDAO.findDyzurByPlaceID(id);
    }

    @RequestMapping(value = "/dyzury/{id}", method = RequestMethod.GET)
    public Dyzur getDyzurInfo(
            @PathVariable Integer id) {
        return dyzurDAO.getDyzurByID(id);
    }

    @RequestMapping(value = "/dyzury/new", method = RequestMethod.POST)
    public void createDyzur(
            @RequestParam(value = "teacherid", defaultValue = "") Integer teacherID,
            @RequestParam(value = "breakid", defaultValue = "") Integer breakID,
            @RequestParam(value = "placeid", defaultValue = "") Integer placeID) {
        dyzurDAO.insertNewDyzur(new Dyzur(0, teacherID, breakID, placeID));
    }

    @RequestMapping(value = "/dyzury/delete", method = RequestMethod.DELETE)
    public void deleteDyzur(
            @RequestParam(value = "id", defaultValue = "") Integer dyzurID) {
        dyzurDAO.deleteDyzur(dyzurID);
    }

    @RequestMapping(value = "/dyzury/update", method = RequestMethod.POST)
    public void updateDyzur(
            @RequestParam(value = "id", defaultValue = "") Integer dyzurID,
            @RequestParam(value = "teacherID", defaultValue = "") Integer teacherID,
            @RequestParam(value = "breakid", defaultValue = "") Integer breakID,
            @RequestParam(value = "placeid", defaultValue = "") Integer placeID) {
        dyzurDAO.update(new Dyzur(dyzurID, teacherID, breakID, placeID));
    }

}
