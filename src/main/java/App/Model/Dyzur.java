package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Admin on 2016-11-22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dyzur {

    Integer dyzurID;
    Integer teacherID;
    Integer breakID;
    Integer placeID;
}
