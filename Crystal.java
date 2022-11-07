package Thread.HomeTask;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Crystal {


    private CrystalColorEnum color;

    public Crystal() {
    }

    public Crystal(CrystalColorEnum color) {
        this.color = color;
    }

    public CrystalColorEnum getColor() {
        return color;
    }

    public void setColor(CrystalColorEnum color) {
        this.color = color;
    }


}
