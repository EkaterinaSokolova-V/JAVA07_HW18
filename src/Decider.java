public interface Decider<T> {
    boolean isLess(T first, T second);
    boolean isMore(T first, T second);
}

