import java.util.HashSet;

public class Phoneketmon {
        public int solution(int[] nums) {
            int answer = 0;
            int max = nums.length / 2; // 최대 선택 가능한 폰켓몬 수
            HashSet<Integer> hashSet = new HashSet<>();

            // 중복 제거를 위해 HashSet 사용
            for (int n : nums) {
                hashSet.add(n);
            }

            // 조건에 따라 답을 계산
            if (max >= hashSet.size()) {
                answer = hashSet.size();
            } else {
                answer = max;
            }

            return answer;

            //int uniqueCount = hashSet.size();
            //return Math.min(max, uniqueCount);
        }

        public static void main(String[] args) {
            Phoneketmon phoneketmon = new Phoneketmon();
            int[] nums1 = {3, 1, 2, 3};
            int[] nums2 = {3, 3, 3, 3};
            int[] nums3 = {3, 1, 2, 3, 4, 5};

            System.out.println(phoneketmon.solution(nums1)); // 출력: 2
            System.out.println(phoneketmon.solution(nums2)); // 출력: 1
            System.out.println(phoneketmon.solution(nums3)); // 출력: 3
        }


}
