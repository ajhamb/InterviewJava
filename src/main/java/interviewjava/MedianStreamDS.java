package interviewjava;

import java.util.LinkedList;

public class MedianStreamDS {

    LinkedList<Integer> list;
    public MedianStreamDS() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == num) {
                list.add(mid, num);
                return;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        list.add(left, num);
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2);
        } else {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        }
    }
    
    
}
