public class Counter {

    private int value;
    private int value2;

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    public void inc() {
        synchronized (monitor1) {
            value++;
        }
    }
    public synchronized void dec() {
        synchronized (monitor1) {
            value--;
        }
    }

    public void inc2() {
        synchronized (monitor2) {
            value2++;
        }
    }
    public synchronized void dec2() {
        synchronized (monitor2) {
            value2--;
        }
    }

    public int getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }
}
