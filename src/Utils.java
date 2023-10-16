import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static Integer extremumInt(List<Integer> list, String extr) {
        Decider<Integer> decider = new Decider<>() {
            @Override
            public boolean isLess(Integer first, Integer second) {
                return first < second;
            }

            public boolean isMore(Integer first, Integer second) {
                return first > second;
            }
        };
        return findBest(list, decider, extr);
    }

    public static Double extremumDouble(List<Double> list, String extr) {
        Decider<Double> decider = new Decider<>() {
            @Override
            public boolean isLess(Double first, Double second) {
                return first < second;
            }

            public boolean isMore(Double first, Double second) {
                return first > second;
            }
        };
        return findBest(list, decider, extr);
    }

    public static String findStr(List<String> list, String extr) {
        Decider<String> decider = new Decider<>() {
            @Override
            public boolean isLess(String first, String second) {
                return first.length() < second.length();
            }

            @Override
            public boolean isMore(String first, String second) {
                return first.length() > second.length();
            }
        };
        return findBest(list, decider, extr);
    }

    public static DayOfWeek findDayOfWeek(List<DayOfWeek> list, String extr) {
        Decider<DayOfWeek> decider = new Decider<>() {
            @Override
            public boolean isLess(DayOfWeek first, DayOfWeek second) {
                return first.getValue() < second.getValue();
            }

            @Override
            public boolean isMore(DayOfWeek first, DayOfWeek second) {
                return first.getValue() > second.getValue();
            }
        };
        return findBest(list, decider, extr);
    }

    public static Yokozuna findYokozuna(List<Yokozuna> list, String extr) {
        Decider<Yokozuna> decider = new Decider<>() {
            @Override
            public boolean isLess(Yokozuna first, Yokozuna second) {
                return first.getWeight() < second.getWeight();
            }

            @Override
            public boolean isMore(Yokozuna first, Yokozuna second) {
                return first.getWeight() > second.getWeight();
            }
        };
        return findBest(list, decider, extr);
    }

    public static <T> T findBest(List<T> list, Decider<T> decider, String str) {
        T accum = list.get(0);
        for (T e: list) {
            if (Objects.equals(str, "min")) {
                if (decider.isLess(e, accum)) {
                    accum = e;
                }
            } else if (Objects.equals(str, "max")) {
                if (decider.isMore(e, accum)) {
                    accum = e;
                }
            }
        }
        return accum;
    }
}
