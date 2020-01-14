package Example3;

import java.util.ArrayList;
import java.util.List;

class House {
    private String type = null;
    private List features = new ArrayList();

    public House() {

    }

    public House(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setProgress(String s) {
        features.add(s);
    }

    public String toString() {
        StringBuffer ff = new StringBuffer();
        String t = type.substring(6);
        ff.append(t + "\n ");
        for (int i = 0; i < features.size(); i ++) {
             ff.append(features.get(i) + "\n ");
        }
        return ff.toString();
    }
}