import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static Integer extremumInt(List<Integer> list, String extr) {
        Decider<Integer> deciderInt = new Decider<Integer>() {
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
        return findBest(list, deciderInt, extr);
    }

    public static Double extremumDouble(List<Double> list, String extr) {
        Decider<Double> deciderDouble = new Decider<>() {
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
        return findBest(list, deciderDouble, extr);
    }

    public static String findStr(List<String> list, String extr) {
        Decider<String> deciderStr = new Decider<>() {
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
        return findBest(list, deciderStr, extr);
    }


    public static DayOfWeek findDayOfWeek(List<DayOfWeek> list, String extr) {
        Decider<DayOfWeek> deciderDayOfWeek = new Decider<>() {
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
        return findBest(list, deciderDayOfWeek, extr);
    }

    public static Yokozuna findYokozuna(List<Yokozuna> list, String extr) {
        Decider<Yokozuna> deciderYokozuna = new Decider<>() {
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
        return findBest(list, deciderYokozuna, extr);
    }

    public static <T> T findBest(List<T> list, Decider<T> decider, String str) {
        T accum = list.get(0);
        for (T e: list) {
            if (decider.isBetter(e, accum, str)) {
                accum = e;
            }
        }
        return accum;
    }
}
