package App.Service.Teacher;

import App.Model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2016-11-22.
 */
public class TeacherMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rS, int i) throws SQLException {
        Teacher t = new Teacher();
        t.setTeacherID(rS.getInt("teacherid"));
        t.setTeacherName(rS.getString("teachername"));
        t.setTeacherSurname(rS.getString("teachersurname"));

        return t;
    }
}
