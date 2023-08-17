package filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileSystem {

    class Dir {
        Map<String, Dir> dirs = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }
    Dir root;

    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir t = root;
        List<String> result = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length - 1; i++) {
                t = t.dirs.get(d[i]);
            }
            // If path contains only file
            if (t.files.containsKey(d[d.length - 1])) {
                result.add(d[d.length - 1]);
                return result;
            } else {
                t = t.dirs.get(d[d.length - 1]);
            }
        }

        result.addAll(new ArrayList<>(t.dirs.keySet()));
        result.addAll(new ArrayList<>(t.files.keySet()));
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        Dir t = root;
        String[] directories = path.split("/");
        for (int i = 1; i < directories.length; i++) {
            if (!t.dirs.containsKey(directories[i])) {
                t.dirs.put(directories[i], new Dir());
            }
            // Next nested directory
            t = t.dirs.get(directories[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir t = root;
        String[] directories = filePath.split("/");
        // Reach the end of the file path
        for (int i = 1; i < directories.length - 1; i++) {
            t = t.dirs.get(directories[i]);
        }
        t.files.put(directories[directories.length - 1], t.files.getOrDefault(directories[directories.length - 1], "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir t = root;
        String[] directories = filePath.split("/");
        for (int i = 1; i < directories.length - 1; i++) {
            t = t.dirs.get(directories[i]);
        }
        return t.files.get(directories[directories.length - 1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
