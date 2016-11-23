package App.Service.Break;

import App.Model.Break;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2016-11-22.
 */
public class BreakMapper implements RowMapper<Break> {

    @Override
    public Break mapRow(ResultSet rS, int i) throws SQLException {
        Break b = new Break();
        b.setBreakID(rS.getInt("breakid"));
        b.setBreakName(rS.getString("breakname"));

        return b;
    }
}
