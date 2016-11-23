package App.Service.Dyzur;

import App.Model.Dyzur;
import App.Service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public class DyzurDAOJdbc implements DyzurDAO {
    JdbcTemplate template;

    public DyzurDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public List<Dyzur> findAllDyzury() {
        return template.query("select * from dyzur",
                new DyzurMapper());
    }

    @Override
    public List<Dyzur> findDyzurByTeacherID(Integer teacherID) {
        return template.query("select * from dyzur where teacherid=(?)",
                new Object[]{teacherID},
                new DyzurMapper());
    }

    @Override
    public List<Dyzur> findDyzurByBreakID(Integer breakID) {
        return template.query("select * from dyzur where breakid=(?)",
                new Object[]{breakID},
                new DyzurMapper());
    }

    @Override
    public List<Dyzur> findDyzurByPlaceID(Integer placeID) {
        return template.query("select * from dyzur where placeid=(?)",
                new Object[]{placeID},
                new DyzurMapper());
    }

    @Override
    public Dyzur getDyzurByID(Integer dyzurID) {
        return template.queryForObject("select * from dyzur where dyzurid=(?)",
                new Object[]{dyzurID},
                new DyzurMapper());
    }

    @Override
    public void insertNewDyzur(Dyzur newDyzur) {
        template.update("insert into dyzur(teacherid, breakid, placeid) values(?, ?, ?)",
                newDyzur.getTeacherID(),
                newDyzur.getBreakID(),
                newDyzur.getPlaceID());
    }

    @Override
    public void deleteDyzur(Integer dyzurID) {
        template.update("delete from dyzur where dyzurid=(?)",
                dyzurID);
    }

    @Override
    public void update(Dyzur updatedDyzur) {
        template.update("update dyzur set teacherid=(?), breakid=(?), placeid=(?) where dyzurid=(?)",
                updatedDyzur.getTeacherID(),
                updatedDyzur.getBreakID(),
                updatedDyzur.getPlaceID(),
                updatedDyzur.getDyzurID());
    }
}
