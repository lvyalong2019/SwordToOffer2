package Chapter_02;

/**旋转数组的最小数字
 * 解法：
 * 1、判断数组第一个和最后一个大小，如果first<last,min=first
 * 2、如果first>=last,进入循环mid=（f+l）/2，
 * 2.1如果mid等于f与l，直接遍历f到l，否则去2.2
 * 2.2如果mid大于等于f，f=mid
 * 2.3如果mid<=l，l=mid
 * 3、当f=l-1，退出循环，l为最小值，f为最大值
 *
 */

public class Test11 {

    public static int min(int[] numbers) throws Exception{
        if (numbers == null || numbers.length==0){
            throw new Exception("Invalid Parameters");
        }
        int first = 0;
        int last = numbers.length - 1;
        int mid = first;
        while (numbers[first] >= numbers[last]){
            if (first == last - 1) {
                mid = last;
                break;
            }
            mid = (first + last) / 2;
            if (mid == first && mid == last){
                return minInOrder(numbers, first, last);
            }
            if (numbers[mid] >= numbers[first])
                first = mid;
            if (numbers[mid] <= numbers[last])
                last = mid;
        }
        return numbers[mid];
    }

    public static int minInOrder(int[] numbers, int first, int last){
        int min = first;
        for (int i = first; i <= last; i++) {
            if (numbers[min] > numbers[i])
                numbers[min] = numbers[i];
        }
        return numbers[min];
    }

}