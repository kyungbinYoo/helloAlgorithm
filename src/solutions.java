import java.util.*;

public class solutions {
    //
    public solutions() {
    }

    public int[] solution(int[] arr) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        answer.push(arr[0]);  // 첫 번째 값은 항상 넣음

        // 중복된 값은 스킵하고 스택에 값 넣기
        for (int v : arr) {
            if (answer.peek() != v) {
                answer.push(v);
            }
        }

        // ArrayDeque를 ArrayList로 변환한 후 역순으로 변환
        List<Integer> list = new ArrayList<>(answer);  // Deque -> List로 변환
        Collections.reverse(list);  // 리스트를 역순으로 변경

        // 역순으로 변환된 리스트를 배열로 변환
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }

    public static void main(String[] args) {
        solutions solution = new solutions();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution.solution(arr);
        System.out.println(Arrays.toString(result));  // 출력: [1, 0, 3, 1]
    }
}
