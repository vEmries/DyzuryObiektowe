package App.Service.Place;

import App.Model.Place;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 2016-11-30.
 */
@RestController
public class PlaceController {

    PlaceDAO placeDAO;

    public PlaceController() {
        this.placeDAO = new PlaceDAOJdbc();
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> listAllPlaces() {
        return placeDAO.findAllPlaces();
    }

    @RequestMapping(value = "/places/byname", method = RequestMethod.GET)
    public List<Place> listPlacesByName(
            @RequestParam(value = "name", defaultValue = "") String placeName) {
        return placeDAO.findPlaceByName(placeName);
    }

    @RequestMapping(value = "/places/byfloor", method = RequestMethod.GET)
    public List<Place> listPlacesByFloor(
            @RequestParam(value = "floor", defaultValue = "") Integer placeFloor) {
        return placeDAO.findPlaceByFloor(placeFloor);
    }

    @RequestMapping(value = "/places/{id}", method = RequestMethod.GET)
    public Place getPlaceInfo(
            @PathVariable Integer id) {
        return placeDAO.getPlaceByID(id);
    }

    @RequestMapping(value = "/places/new", method = RequestMethod.POST)
    public void createPlace(
            @RequestParam(value = "name", defaultValue = "") String placeName,
            @RequestParam(value = "floor", defaultValue = "") Integer placeFloor) {
        placeDAO.insertNewPlace(new Place(0, placeName, placeFloor));
    }

    @RequestMapping(value = "/places/delete", method = RequestMethod.DELETE)
    public void deletePlace(
            @RequestParam(value = "id") Integer placeID) {
        placeDAO.deletePlace(placeID);
    }

    @RequestMapping(value = "/places/update", method = RequestMethod.POST)
    public void updatePlace(
            @RequestParam(value = "id", defaultValue = "") Integer placeID,
            @RequestParam(value = "name", defaultValue = "") String placeName,
            @RequestParam(value = "floor", defaultValue = "") Integer placeFloor) {
        placeDAO.updatePlace(new Place(placeID, placeName, placeFloor));
    }

}
