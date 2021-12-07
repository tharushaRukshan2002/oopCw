import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * solves Oop course work.
 *
 * @author Tharusha Rukshan Ravindran
 * @version 1.00 2021-11-07
 */

public class Main {

    public static void main(String[] args) {

        Formula1ChampionshipManager one = new Formula1ChampionshipManager();
//        one.loadData();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/y");
//
//        System.out.println("==============Before Sorting===========");
//        for (Race k : one.getRaces()) {
//            Date d1 = k.getDate();
//             System.out.println(dateFormat.format(d1));
//        }
//        one.getRaces().sort(new Comparator<Race>() {
//            public int compare(Race o1, Race o2) {
//                return o1.getDate().compareTo(o2.getDate());
//            }
//        });
//        System.out.println("==============After Sorting===========");
//        for (Race k : one.getRaces()) {
//            Date d1 = k.getDate();
//            System.out.println(dateFormat.format(d1));
//        }
        one.mainMethod();
        new MainGui();

    }


}

