import java.util.PriorityQueue;

public class LexicographicallySmall {
    public static String smallestString(String s, int n) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int last = s.charAt(n-1) - '0';
      pq.add(last);

      for (int i = n - 2; i >= 0; i--) {
        int val = s.charAt(i) - '0';
        if (val > last) {
            val = Math.min(val+1, 9);
        } else {
            last = val;
        }
        pq.add(val);
      }

      StringBuilder str = new StringBuilder();
      while (pq.size() > 0) {
        str.append(pq.remove());
      }
      return str.toString();
    }

    public static void main(String[] args)
    {
        String s = "04829";
        int n = s.length();
        System.out.println(smallestString(s, n));
 
        s = "07";
        n = s.length();
        System.out.println(smallestString(s, n));
    }

}
