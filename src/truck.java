import java.util.*;
//다리를 지나는 트럭
class truck {
    public int truck(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;        // 시간(결과)
        int curWeight = 0;   // 다리 위에 있는 트럭들의 총 무게
        int truckSize = truck_weights.length; //대기트럭
        int remainTrucks = truckSize;

        //다리의 현상황을 큐로 표현한거고 그것의 초기화 로작
        Queue<Integer> q = new ArrayDeque<>(); //[0,0,0]
        for(int i=0; i<bridge_length; i++){
            q.add(0);
        }

        //트럭의 큐
        Queue<Integer> truckQ = new ArrayDeque<>();
        Arrays.stream(truck_weights).forEach(truckQ::add);

        while (!q.isEmpty() && remainTrucks!=0){
            Integer outWeight = q.poll(); //cur ==10, outWeight ==5
            curWeight -= outWeight; //cur ==5
            if(truckQ.isEmpty())
            {
            //do nothing
            }else if(curWeight + truckQ.peek() <= weight){
                int truckWeight = truckQ.poll();
                curWeight += truckWeight;
                q.add(truckWeight);
            }else {
                q.add(0);
            }
            ++time;
        }

        return time;
    }

    public static void main(String[] args) {
        truck truck = new truck();
        System.out.println("총 시간: ");
        System.out.println(truck.truck(3, 10, new int[]{10, 8, 5, 4}));
    }
}
