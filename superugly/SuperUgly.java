import java.util.PriorityQueue;

public class SuperUgly {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int count = 1;
        while (count < n) {
            count++;
            int num = pq.remove();
            if (pq.size() > 0 && pq.peek() == num) pq.remove();
            for (int i: primes) {
                pq.add(i*num);
            }
        }
        return pq.remove();
    }

    public static void main(String[] args)
  {
    int[] primes = { 2, 5 };
    int n = 5;
    System.out.println(nthSuperUglyNumber(n, primes));
  }
}
