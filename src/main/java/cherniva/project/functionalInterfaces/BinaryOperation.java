package cherniva.project.functionalInterfaces;

@FunctionalInterface
public interface BinaryOperation<T> {
    T operate(T value1, T value2);
}
