public interface Decider<T> {
    boolean isBetter(T first, T second, String str);
}

