import java.util.*;

class Ksort {
    public int[] solution(int[] array, int[][] commands) {
        int commandSize = commands.length;
        int[] answer = new int[commandSize];
        for(int i =0; i<commandSize; ++i){
            int[] subArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            //quick sort이용
            Arrays.sort(subArr);
            System.out.println(Arrays.toString(subArr));
            answer[i] = subArr[commands[i][2]-1];
            System.out.println(answer[i]);

            /*
            //merge sort 해결법
            List<Integer> list = Arrays.stream(subArr).sorted().boxed().collect(Collectors.toList());
            answer[i] = list.get(commands[i][2]-1);
            */
        }
        return answer;
    }

    public static void main(String[] args) {
        Ksort ksort = new Ksort();

        // 예시 배열과 명령어
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        // solution 메서드 호출 및 결과 출력
        int[] result = ksort.solution(array, commands);

        // 결과 배열 출력
        System.out.println("Result: " + Arrays.toString(result));
    }
}