package App.Service.Break;

import App.Model.Break;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public interface BreakDAO {

    public List<Break> findAllBreaks();

    public List<Break> findBreakByName(String breakName);

    public Break getBreakByID(Integer breakID);

    public void insertNewBreak(Break newBreak);

    public void deleteBreak(Integer breakID);

    public void updateBreak(Break updatedBreak);
}
