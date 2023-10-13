import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 4, 0, -49);

        Decider<Integer> decider = new Decider<Integer>() {
            @Override
            public boolean isBetter(Integer first, Integer second, String str) {
                if (Objects.equals(str, "min")) {
                    return first < second;
                }
                if (Objects.equals(str, "max")) {
                    return first > second;
                }
                else return false;
            }
        };

        System.out.println("Min=" + Utils.findBest(ints, decider, "min"));
        System.out.println("Max=" + Utils.findBest(ints, decider, "max"));

        List<Double> doubles = List.of(12.0, -14.2, 90990.3224);

        Decider<Double> deciderD = new Decider<Double>() {
            @Override
            public boolean isBetter(Double first, Double second, String str) {
                if (Objects.equals(str, "min")) {
                    return first < second;
                }
                if (Objects.equals(str, "max")) {
                    return first > second;
                }
                else return false;
            }
        };

        System.out.println("Max=" + Utils.findBest(doubles, deciderD, "max"));
        System.out.println("Min=" + Utils.findBest(doubles, deciderD, "min"));

        List<String> strgs = List.of("Иван", "родил", "девчонку", "велел", "тащить", "пеленку");
        Decider<String> deciderS = new Decider<String>() {
            @Override
            public boolean isBetter(String first, String second, String str) {
                if (Objects.equals(str, "min")) {
                    return first.length() < second.length();
                }
                if (Objects.equals(str, "max")) {
                    return first.length() > second.length();
                }
                else return false;
            }
        };

        System.out.println("Min:" + Utils.findBest(strgs, deciderS, "min"));
        System.out.println("Max:" + Utils.findBest(strgs, deciderS, "max"));

        List<DayOfWeek> date = List.of(java.time.DayOfWeek.MONDAY, java.time.DayOfWeek.WEDNESDAY, java.time.DayOfWeek.TUESDAY);
        Decider<DayOfWeek> deciderDW = new Decider<DayOfWeek>() {
            @Override
            public boolean isBetter(DayOfWeek first, DayOfWeek second, String str) {
                if (Objects.equals(str, "min")) {
                    return first.getValue() < second.getValue();
                }
                if (Objects.equals(str, "max")) {
                    return first.getValue() > second.getValue();
                }
                else return false;
            }
        };

        System.out.println("Min:" + Utils.findBest(date, deciderDW, "min"));
        System.out.println("Max:" + Utils.findBest(date, deciderDW, "max"));

        List<Yokozuna> wrestlers = Arrays.asList(
                new Yokozuna("Takonohana", 200),
                new Yokozuna("Amusasimaru", 190),
                new Yokozuna("Kisenosato", 250)
        );
        Decider<Yokozuna> deciderY = new Decider<>() {
            @Override
            public boolean isBetter(Yokozuna first, Yokozuna second, String str) {
                if (Objects.equals(str, "min")) {
                    return first.getWeight() < second.getWeight();
                }
                if (Objects.equals(str, "max")) {
                    return first.getWeight() > second.getWeight();
                }
                else return false;
            }
        };
        System.out.println("Min weight:" + Utils.findBest(wrestlers, deciderY, "min").getName());
        System.out.println("Max weight:" + Utils.findBest(wrestlers, deciderY, "max").getName());
    }
}

