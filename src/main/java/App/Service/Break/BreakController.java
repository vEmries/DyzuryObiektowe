package App.Service.Break;

import App.Model.Break;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 2016-11-30.
 */
@RestController
public class BreakController {

    BreakDAO breakDAO;

    public BreakController() {
        this.breakDAO = new BreakDAOJdbc();
    }

    @RequestMapping(value = "/breaks", method = RequestMethod.GET)
    public List<Break> listAllBreaks() {
        return  breakDAO.findAllBreaks();
    }

    @RequestMapping(value = "/breaks/byname", method = RequestMethod.GET)
    public List<Break> listBreaksByName(
            @RequestParam(value = "name", defaultValue = "") String breakName) {
        return breakDAO.findBreakByName(breakName);
    }

    @RequestMapping(value = "/breaks/{id}", method = RequestMethod.GET)
    public Break getBreakInfo(
            @PathVariable Integer id) {
        return breakDAO.getBreakByID(id);
    }

    @RequestMapping(value = "/breaks/new", method = RequestMethod.POST)
    public void createBreak(
            @RequestParam(value = "name", defaultValue = "") String breakName) {
        breakDAO.insertNewBreak(new Break(0, breakName));
    }

    @RequestMapping(value = "/breaks/delete", method = RequestMethod.DELETE)
    public void deleteBreak(
            @RequestParam(value = "id", defaultValue = "") Integer breakID) {
        breakDAO.deleteBreak(breakID);
    }

    @RequestMapping(value = "/breaks/update", method = RequestMethod.POST)
    public void updateBreak(
            @RequestParam(value = "id", defaultValue = "") Integer breakID,
            @RequestParam(value = "name", defaultValue = "") String breakName) {
        breakDAO.updateBreak(new Break(breakID, breakName));
    }

}
