import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 4, 0, -49);
        System.out.println("Min=" + Utils.extremumInt(ints, "min"));
        System.out.println("Max=" + Utils.extremumInt(ints, "max"));

        List<Double> doubles = List.of(12.0, -14.2, 90990.3224);
        System.out.println("Max=" + Utils.extremumDouble(doubles, "max"));
        System.out.println("Min=" + Utils.extremumDouble(doubles,  "min"));

        List<String> strgs = List.of("Иван", "родил", "девчонку", "велел", "тащить", "пеленку");
        System.out.println("Min:" + Utils.findStr(strgs, "min"));
        System.out.println("Max:" + Utils.findStr(strgs, "max"));

        List<DayOfWeek> date = List.of(java.time.DayOfWeek.MONDAY, java.time.DayOfWeek.WEDNESDAY, java.time.DayOfWeek.TUESDAY);
        System.out.println("Min:" + Utils.findDayOfWeek(date, "min"));
        System.out.println("Max:" + Utils.findDayOfWeek(date, "max"));

        List<Yokozuna> wrestlers = Arrays.asList(
                new Yokozuna("Takonohana", 200),
                new Yokozuna("Amusasimaru", 190),
                new Yokozuna("Kisenosato", 250)
        );
        System.out.println("Min weight:" + Utils.findYokozuna(wrestlers, "min").getName());
        System.out.println("Max weight:" + Utils.findYokozuna(wrestlers, "max").getName());
    }
}

