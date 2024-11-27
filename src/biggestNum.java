import java.util.*;
class biggestNum {
    public String biggestNum(int[] numbers) {
        //string[]으로 만들고 정렬하면 끝이네ㄴㄴ
        // [9 5 34 30 3] -> 9534303 틀림
        // 9534330 이게 답임 
        int size = numbers.length;
        String strings[] = new String[size];
        for(int i=0; i<size; i++){
            strings[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strings, (a,b)->(b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(s);
        }
        if(sb.toString().charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // biggestNum 클래스의 객체 생성
        biggestNum bn = new biggestNum();

        // 테스트용 숫자 배열
        int[] numbers1 = {9, 5, 34, 30, 3};
        int[] numbers2 = {0, 0, 0};
        int[] numbers3 = {10, 2};
        int[] numbers4 = {3, 30, 34, 5, 9};

        // 메서드 호출 및 출력
        System.out.println("Result for numbers1: " + bn.biggestNum(numbers1)); // 예상 결과: 9534330
        System.out.println("Result for numbers2: " + bn.biggestNum(numbers2)); // 예상 결과: 0
        System.out.println("Result for numbers3: " + bn.biggestNum(numbers3)); // 예상 결과: 210
        System.out.println("Result for numbers4: " + bn.biggestNum(numbers4)); // 예상 결과: 9534330
    }
}