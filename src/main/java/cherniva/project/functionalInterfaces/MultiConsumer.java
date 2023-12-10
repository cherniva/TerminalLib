package cherniva.project.functionalInterfaces;

@FunctionalInterface
public interface MultiConsumer<T> {
    void accept(T... t);
}
