package App.Service.Break;

import App.Model.Break;
import App.Service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Admin on 2016-11-22.
 */
public class BreakDAOJdbc implements BreakDAO {
    JdbcTemplate template;

    public BreakDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public List<Break> findAllBreaks() {
        return template.query("select * from break", new BreakMapper());
    }

    @Override
    public List<Break> findBreakByName(String breakName) {
        return template.query("select * from break where breakname=(?)",
                new Object[]{breakName},
                new BreakMapper());
    }

    @Override
    public Break getBreakByID(Integer breakID) {
        return template.queryForObject("select * from break where breakid=(?)",
                new Object[]{breakID},
                new BreakMapper());
    }

    @Override
    public void insertNewBreak(Break newBreak) {
        template.update("insert into break(breakname) values(?)",
                newBreak.getBreakName());
    }

    @Override
    public void deleteBreak(Integer breakID) {
        template.update("delete from break where breakid=(?)",
                breakID);
    }

    @Override
    public void updateBreak(Break updatedBreak) {
        template.update("update break set breakname=(?) where breakid=(?)",
                updatedBreak.getBreakName(),
                updatedBreak.getBreakID());
    }
}
