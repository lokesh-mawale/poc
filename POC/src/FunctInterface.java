
@FunctionalInterface
public interface FunctInterface {

	void print();	

	default void defaultMethod1() {
		System.out.println("");
	}
}
