package App.Service.Place;

import App.Model.Place;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public interface PlaceDAO {

    public List<Place> findAllPlaces();

    public List<Place> findPlaceByName(String placeName);

    public List<Place> findPlaceByFloor(Integer placeFloor);

    public Place getPlaceByID(Integer placeID);

    public void insertNewPlace(Place newPlace);

    public void deletePlace(Integer placeID);

    public void updatePlace(Place updatedPlace);
}
