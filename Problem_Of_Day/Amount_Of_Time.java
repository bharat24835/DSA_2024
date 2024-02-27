package Problem_Of_Day;

import javax.swing.tree.TreeNode;
import java.util.*;


public class Amount_Of_Time {
    public static   class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        System.out.println(amountOfTime(root,3));



    }
    public static int amountOfTime(TreeNode root, int start) {

        Map<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        // this map child -> {parents}
        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        // this map parents -> {child}

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    // work for map 1
                    // if (!map1.containsKey(node.left.val))
                    //     map1.put(node.val, new ArrayList<>());
                    // map1.put(node.left.val, map1.get(node.left.val).add(node.val));
                    if (map1.containsKey(node.left.val)) {
                        ArrayList<Integer> list = map1.get(node.left.val);
                        list.add(node.val);
                        map1.put(node.left.val, list);
                    } else {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(node.val);
                        map1.put(node.left.val, newList);
                    }

                    // work for map2
                    // if (!map2.containsKey(node.val)) {
                    //     map2.put(node.val, new ArrayList<>());
                    // }
                    // map2.put(node.val, map2.get(node.val).add(node.left.val));
                    q.offer(node.left);
                    if (map2.containsKey(node.val)) {
                        ArrayList<Integer> list = map2.get(node.val);
                        list.add(node.left.val);
                        map2.put(node.val, list);
                    } else {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(node.left.val);
                        map2.put(node.val, newList);
                    }



                }
                if (node.right != null) {
                    // work for map 1
                    // if (!map1.containsKey(node.right.val))
                    //     map1.put(node.val, new ArrayList<>());
                    // map1.put(node.right.val, map1.get(node.right.val).add(node.val));
                    if (map1.containsKey(node.right.val)) {
                        ArrayList<Integer> list = map1.get(node.right.val);
                        list.add(node.val);
                        map1.put(node.right.val, list);
                    } else {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(node.val);
                        map1.put(node.right.val, newList);
                    }


                    // work for map2

                    // if(!map2.containsKey(node.val)){
                    // map2.put(node.val , new ArrayList<>());
                    // }
                    // map2.put(node.val, map2.get(node.val).add(node.right.val));
                    q.offer(node.right);
                    if (map2.containsKey(node.val)) {
                        ArrayList<Integer> list = map2.get(node.val);
                        list.add(node.right.val);
                        map2.put(node.val, list);
                    } else {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(node.right.val);
                        map2.put(node.val, newList);
                    }
                }
            }

        }
        // after this our map is ready to Roll ON
        Set<Integer> set = new HashSet<>();

        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(start);
        set.add(start);
        int count = -1;
        while (!q1.isEmpty()) {
            int size = q1.size();

            for (int i = 0; i < size; i++) {
                Integer temp = q1.poll();

                // moving up mean child - parent
                if(map1.containsKey(temp)){
                    for (int x : map1.get(temp)) {
                        if (!set.contains(x)) {
                            q1.offer(x);
                            set.add(x);
                        }
                    }
                }
                // movinf from parent to child
                if(map2.containsKey(temp)){
                    for (int x : map2.get(temp)) {
                        if (!set.contains(x)) {
                            q1.offer(x);
                            set.add(x);
                        }
                    }

                }

            }
            count++;

        }
        return count;

    }
}
