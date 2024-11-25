class arrayCut {
    //n^2 배열 자르기
    public int[] arrayCut(int n, long left, long right) {
        long size = right - left +1;
        int[] answer = new int[(int)size];

        int idx =0;
        for(long i=left; i<=right; i++){
            int row = (int)(i / n) +1;
            int col = (int)(i % n) +1;

            if(row < col){
                answer[idx++] = col;
            }else{
                answer[idx++] = row;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        arrayCut solution = new arrayCut();

        // Sample input values
        int n = 3;
        long left = 2;
        long right = 5;

        // Get the result array from the solution
        int[] result = solution.arrayCut(n, left, right);

        // Print the result
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}