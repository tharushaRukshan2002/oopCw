import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Race implements Serializable {
    private Date date;
    private String name;
    private int position;

    public Race(Date date, String name, int position){
        this.date =  date;
        this.name = name;
        this.position = position;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
