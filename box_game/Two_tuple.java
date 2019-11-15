package box_game;

public class Two_tuple<A, C> {
	public final A first;
	public final C third;
	public Two_tuple(A a,C c) {
		this.first = a;
		this.third = c;
	}
    public A getA() {
        return first;
    }

    public C getC() {
        return third;
    }
}