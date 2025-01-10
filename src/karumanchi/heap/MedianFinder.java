package karumanchi.heap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MedianFinder {


    ConcurrentHashMap <Integer, Integer> map = new ConcurrentHashMap<>();


    public MedianFinder() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {
        List<Integer> list = new ArrayList<>();
        Collection<Integer> integers = Collections.unmodifiableCollection(list);
        integers.add(1);
        map.put(1, 1);
        return 0;

    }
}
