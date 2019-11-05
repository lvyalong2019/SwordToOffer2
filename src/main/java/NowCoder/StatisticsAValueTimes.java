package NowCoder;

import java.util.*;

/**
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。
 * 假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，
 * 我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。
 * 因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 */

public class StatisticsAValueTimes {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] fav=new int[n];
        for(int i=0;i<n;i++){
            fav[i]=scan.nextInt();
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=fav[i];
            int value=i+1;
            if(!map.containsKey(key)){
                List<Integer> list=new LinkedList<>();
                list.add(value);
                map.put(key,list);
            }else{
                List<Integer> list=map.get(key);
                list.add(value);
            }
        }
        int m=scan.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            int lo=scan.nextInt();
            int hi=scan.nextInt();
            int des=scan.nextInt();
            List<Integer> list=map.get(des);
            int count=0;
            if(list!=null){
                for(Integer integer:list){
                    if(integer>=lo&&integer<=hi){
                        count++;
                    }
                }
            }

            queue.add(count);

        }
        for(int i:queue){
            System.out.println(i);
        }

    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if (n <= 0)
//            return;
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = in.nextInt();
//        }
//        int q = in.nextInt();
//
//        for (int i = 0; i < q; i++) {
//            int start = in.nextInt();
//            int end = in.nextInt();
//            int k = in.nextInt();
//
//            int sum = 0;
//            for (int j = start - 1; j <= end - 1; j++) {
//                if (array[j] == k) {
//                    sum++;
//                }
//            }
//
//            System.out.println(sum);
//        }
//
//    }

}

