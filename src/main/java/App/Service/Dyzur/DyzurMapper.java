package App.Service.Dyzur;

import App.Model.Dyzur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2016-11-22.
 */
public class DyzurMapper implements RowMapper<Dyzur> {

    @Override
    public Dyzur mapRow(ResultSet rS, int i) throws SQLException {
        Dyzur d = new Dyzur();
        d.setDyzurID(rS.getInt("dyzurid"));
        d.setTeacherID(rS.getInt("teacherid"));
        d.setBreakID(rS.getInt("breakid"));
        d.setPlaceID(rS.getInt("placeid"));

        return d;
    }
}
