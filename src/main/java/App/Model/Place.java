package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Admin on 2016-11-22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    Integer placeID;
    String placeName;
    Integer placeFloor;
}
