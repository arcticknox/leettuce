import java.util.PriorityQueue;

public class MaxDiamonds {
    public static int maxDiamonds(int k, int[] diamonds){
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
      for (int i: diamonds) {
        pq.add(i);
      }

      int solution = 0;
      while (pq.size() > 0 && k > 0) {
        k--;
        // pick a diamond
        int diamond = pq.remove();
        solution += diamond;
        pq.add(diamond/2);
      }
      System.out.println(solution);
      return solution;
    }

    public static void main(String[] args)
{
    int A[] = { 2, 1, 7, 4, 2 };
    int K = 3;
     
    maxDiamonds(K, A);
}
}
