package Example3;
import java.util.*;

class WorkShop {
    //force the order of building process
    public void construct(HouseBuilder hb) {
        hb.buildFoundation();
        hb.buildFrame();
        hb.buildExterior();
        hb.buildInterior();
    }
}