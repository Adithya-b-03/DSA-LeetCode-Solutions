import java.util.*;

class MinStack {
    private Stack<Long> s = new Stack<>();
    private long min;

    public MinStack() { }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push((long) val);
            min = val;
        } else if (val >= min) {
            s.push((long) val);
        } else {
            long encoded = 2L * val - min; // use long math
            s.push(encoded);
            min = val;
        }
    }

    public void pop() {
        long x = s.pop();
        if (x < min) {                // popped an encoded value
            min = 2L * min - x;       // restore previous min (long math)
        }
    }

    public int top() {
        long x = s.peek();
        return (x < min) ? (int) min : (int) x;
    }

    public int getMin() {
        return (int) min;
    }
}
