import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if(scoville.length<2){
            return -1;
        }
        for(int v : scoville){
            pq.add(v);
        }
        int answer = 0;
        while(true){
            Integer v1 = pq.poll();
            if(v1 >= K){
                break;
            }

            Integer v2 = pq.poll();
            if(v2 ==null){
                return -1;
            }
            pq.add(v1 + v2*2);
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scoville scoville = new Scoville();

        // 예시 1: 배열 [1, 2, 3, 9, 10, 12], K = 7
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;
        int result1 = scoville.solution(scoville1, K1);
        System.out.println("결과: " + result1); // 기대값: 2
    }
}
