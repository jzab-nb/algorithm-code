package 每日一题.Y2025.M09;

import java.util.*;

public class Q2025_09_20_3508 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.offer(1);
        list.offer(1);
        list.offer(4);
        list.offer(5);
        list.offer(1);
        list.offer(4);

        list.get(0);

        System.out.println(list);
    }
}


class Packte{
    public int source;
    public int destination;
    public int timestamp;

    public Packte(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Packte){
            Packte p = (Packte)obj;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }

    public int[] toArray(){
        return new int[]{source, destination, timestamp};
    }
}

class Pair{
    public List<Integer> timeStamps = new ArrayList<>();
    public int head = 0;
}

class Router {

    LinkedList<Packte> queue = new LinkedList<>();
    HashSet<Packte> set = new HashSet<>();
    HashMap<Integer, Pair> dstMap = new HashMap<>();

    int maxSize;

    public Router(int memoryLimit) {
        // 初始化大小为memoryLimit，超出大小则丢弃最早到的包
        maxSize = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
//        System.out.println("添加：" + source+" "+destination+" "+timestamp);

        Packte p = new Packte(source, destination, timestamp);

        // 判断是否重复，若有重复的则放弃添加，返回false
        if(set.contains(p)){
            return false;
        }

        if(queue.size()>=maxSize){
            // 超过大小了删除一个
//            System.out.println("大小超了，删除");
            forwardPacket();
        }

        queue.offer(p);
        set.add(p);
        // 添加一个包
        dstMap.computeIfAbsent(destination, k -> new Pair()).timeStamps.add(timestamp);
//        for (int j = 0; j < queue.size(); j++) {
//            System.out.print("["+j+">>>"+queue.get(j)[0]+" "+queue.get(j)[1]+" "+queue.get(j)[2]+"]");
//        }
//        System.out.println();
        return true;
    }

    public int[] forwardPacket() {
        // 转发最早到的包
        if(queue.isEmpty()){
            return new int[0];
        }else{
            Packte poll = queue.poll();
            set.remove(poll);
            dstMap.get(poll.destination).head++;
            return poll.toArray();
        }
    }

    private int binarySearch(Pair p,int target) {
        List<Integer> list = p.timeStamps;

        int start = p.head;
        int end = list.size();
        // 下标小，时间戳小，下标大，时间戳大
        while(start<end){
            int mid = (start+end)>>>1;
            // 中间值比要找的值小
            if(target > list.get(mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public int getCount(int destination, int startTime, int endTime) {

        Pair p = dstMap.get(destination);
        if(p==null){return 0;}

        // 获取目标为destination的且时间戳在两点之间的包的数量
        int start=binarySearch(p,startTime);
        int end=binarySearch(p,endTime+1);
        return end-start;
    }
}
// 1.4 / 3 =