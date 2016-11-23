package App.Service.Dyzur;

import App.Model.Dyzur;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public interface DyzurDAO {

    public List<Dyzur> findAllDyzury();

    public List<Dyzur> findDyzurByTeacherID(Integer teacherID);

    public List<Dyzur> findDyzurByBreakID(Integer breakID);

    public List<Dyzur> findDyzurByPlaceID(Integer placeID);

    public Dyzur getDyzurByID(Integer dyzurID);

    public void insertNewDyzur(Dyzur newDyzur);

    public void deleteDyzur(Integer dyzurID);

    public void update(Dyzur updatedDyzur);
}
