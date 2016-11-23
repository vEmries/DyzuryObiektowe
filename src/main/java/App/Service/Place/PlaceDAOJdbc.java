package App.Service.Place;

import App.Model.Place;
import App.Service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public class PlaceDAOJdbc implements PlaceDAO {
    JdbcTemplate template;

    public PlaceDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public List<Place> findAllPlaces() {
        return template.query("select * from place",
                new PlaceMapper());
    }

    @Override
    public List<Place> findPlaceByName(String placeName) {
        return template.query("select * from place where placename=(?)",
                new Object[]{placeName},
                new PlaceMapper());
    }

    @Override
    public List<Place> findPlaceByFloor(Integer placeFloor) {
        return template.query("select * from place where placefloor=(?)",
                new Object[]{placeFloor},
                new PlaceMapper());
    }

    @Override
    public Place getPlaceByID(Integer placeID) {
        return template.queryForObject("select * from place where placeid=(?)",
                new Object[]{placeID},
                new PlaceMapper());
    }

    @Override
    public void insertNewPlace(Place newPlace) {
        template.update("insert into place(placename, placefloor) values(?, ?)",
                newPlace.getPlaceName(),
                newPlace.getPlaceFloor());
    }

    @Override
    public void deletePlace(Integer placeID) {
        template.update("delete from place where placeid=(?)",
                placeID);
    }

    @Override
    public void updatePlace(Place updatedPlace) {
        template.update("update place set placename=(?), placefloor=(?) where placeid=(?)",
                updatedPlace.getPlaceName(),
                updatedPlace.getPlaceFloor(),
                updatedPlace.getPlaceID());
    }
}
