package cherniva.project.functionalInterfaces;

@FunctionalInterface
public interface UnaryOperation<T> {
    T operate(T value);
}
