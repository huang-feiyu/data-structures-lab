import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    /**
     * @Source github.com/lijian12345/cs61b-sp18/blob/master/proj1gold/TestArrayDequeGold.java
     */
    @Test
    public void weirdTest() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();

        StringBuilder msg = new StringBuilder();

        int s = 0;
        for (int i = 0; i < 500; i++) {
            if (i % 5 == 0) {
                msg.append("size()\n");
                assertEquals(msg.toString(), solutionDeque.size(), studentDeque.size());
            }

            double selector = StdRandom.uniform();
            if (selector < 0.25) {
                studentDeque.addFirst(i);
                solutionDeque.addFirst(i);
                s++;
                msg.append("addFirst(").append(i).append(")\n");
                assertEquals(msg.toString(), solutionDeque.get(0), studentDeque.get(0));
            } else if (selector < 0.5) {
                studentDeque.addLast(i);
                solutionDeque.addLast(i);
                s++;
                msg.append("addLast(").append(i).append(")\n");
                assertEquals(msg.toString(), solutionDeque.get(s - 1), studentDeque.get(s - 1));
            } else if (selector < 0.75) {
                if (solutionDeque.isEmpty()) {
                    msg.append("isEmpty()\n");
                    assertTrue(msg.toString(), studentDeque.isEmpty());
                    continue;
                }
                Integer x = solutionDeque.removeFirst();
                Integer y = studentDeque.removeFirst();
                s--;
                msg.append("removeFirst()\n");
                assertEquals(msg.toString(), x, y);
            } else {
                if (solutionDeque.isEmpty()) {
                    msg.append("isEmpty()\n");
                    assertTrue(msg.toString(), studentDeque.isEmpty());
                    continue;
                }
                Integer x = solutionDeque.removeLast();
                Integer y = studentDeque.removeLast();
                s--;
                msg.append("removeLast()\n");
                assertEquals(msg.toString(), x, y);
            }
        }
    }
}
