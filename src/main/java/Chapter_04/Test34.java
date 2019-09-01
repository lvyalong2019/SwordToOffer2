package Chapter_04;

import java.util.ArrayList;

public class Test34 {
    static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode pRoot, int Sum) {
        if (pRoot == null && Sum != 0)
            return null;

        int subSum = Sum;
        ArrayList<Integer> path = new ArrayList<>();
        findPathCore(path,subSum,pRoot);

        return ret;
    }

    public static void findPathCore(ArrayList path,int subSum,TreeNode pNode) {
        if (pNode == null)
            return;


        path.add(pNode.val);
        subSum = subSum - pNode.val;
        if (subSum == 0 && pNode.left == null && pNode.right == null){
//            ret.add(path1);
            ret.add(new ArrayList<>(path));//新建ArrayList的原因是接下来还要对该list进行操作
        }

        else {
            findPathCore(path,subSum,pNode.left);
            findPathCore(path,subSum,pNode.right);
        }
        path.remove(path.size()-1);
    }

}
