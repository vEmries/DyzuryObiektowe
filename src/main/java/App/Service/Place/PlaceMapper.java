package App.Service.Place;

import App.Model.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2016-11-22.
 */
public class PlaceMapper implements RowMapper<Place> {

    @Override
    public Place mapRow(ResultSet rS, int i) throws SQLException {
        Place p = new Place();
        p.setPlaceID(rS.getInt("placeid"));
        p.setPlaceName(rS.getString("placename"));
        p.setPlaceFloor(rS.getInt("placefloor"));

        return p;
    }
}
