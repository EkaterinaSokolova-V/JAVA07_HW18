import java.util.List;

public class Utils {
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
