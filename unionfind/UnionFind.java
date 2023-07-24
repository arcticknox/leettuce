package unionfind;

public class UnionFind {
    private int[] id;
    private int count;

    public int[] getId() {
        return id;
    }

    public int getComponentsCount() {
        return count;
    }

    // Initialize
    public UnionFind(int n) {
        count = n;
        id = new int[n];
        System.out.println("Initial array= ");
        for (int i = 0; i < n; i++) {
            id[i] = i;
            System.out.print(id[i]);
        }
    }

    public void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Invalid range");
        }
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];
        int qID = id[q];

        // Already connected
        if (pID == qID) return;

        // Find p, replace id[i] value with q
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(1, 2);
        uf.union(2, 4);
        int[] ids = uf.getId();
        System.out.println("\nAfter uf= ");
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i]);
        }
        System.out.println("\nConnected components= " + uf.getComponentsCount());
    }
}