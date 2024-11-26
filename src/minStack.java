import java.util.Stack;

class minStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }

    }

    public Integer pop() {
        if(!stack.isEmpty()){
            int poppedVal = stack.pop();
            if(poppedVal == minStack.peek()){
                minStack.pop();
            }
            return poppedVal;
        }
        return null;
    }

    public Integer top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return null;

    }

    public Integer getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return null;

    }
    /*
    minStack.push(val): 각 push 후 스택에 값이 추가된 후 top과 getMin을 출력하여 스택의 상단과 최소값을 확인합니다.
    minStack.pop(): pop 후, 팝된 값과 함께 현재 스택의 top과 min을 출력합니다.
    top(): 현재 스택의 상단에 있는 값을 반환합니다. 스택이 비어있다면 null을 반환합니다.
    getMin(): 스택의 최소값을 반환합니다. 스택이 비어있다면 null을 반환합니다.
     */
    public static void main(String[] args) {
        // MinStack 객체 생성
        minStack minStack = new minStack();

        // 푸시 동작
        System.out.println("Push 5:");
        minStack.push(5);
        System.out.println("Top: " + minStack.top());      // Expected output: 5
        System.out.println("Min: " + minStack.getMin());    // Expected output: 5

        System.out.println("Push 3:");
        minStack.push(3);
        System.out.println("Top: " + minStack.top());      // Expected output: 3
        System.out.println("Min: " + minStack.getMin());    // Expected output: 3

        System.out.println("Push 7:");
        minStack.push(7);
        System.out.println("Top: " + minStack.top());      // Expected output: 7
        System.out.println("Min: " + minStack.getMin());    // Expected output: 3

        System.out.println("Push 2:");
        minStack.push(2);
        System.out.println("Top: " + minStack.top());      // Expected output: 2
        System.out.println("Min: " + minStack.getMin());    // Expected output: 2

        // 팝 동작
        System.out.println("Pop:");
        System.out.println("Popped value: " + minStack.pop());  // Expected output: 2
        System.out.println("Top: " + minStack.top());      // Expected output: 7
        System.out.println("Min: " + minStack.getMin());    // Expected output: 3

        System.out.println("Pop:");
        System.out.println("Popped value: " + minStack.pop());  // Expected output: 7
        System.out.println("Top: " + minStack.top());      // Expected output: 3
        System.out.println("Min: " + minStack.getMin());    // Expected output: 3

        System.out.println("Pop:");
        System.out.println("Popped value: " + minStack.pop());  // Expected output: 3
        System.out.println("Top: " + minStack.top());      // Expected output: 5
        System.out.println("Min: " + minStack.getMin());    // Expected output: 5

        System.out.println("Pop:");
        System.out.println("Popped value: " + minStack.pop());  // Expected output: 5
        System.out.println("Top: " + minStack.top());      // Expected output: null (stack is empty)
        System.out.println("Min: " + minStack.getMin());    // Expected output: null (stack is empty)
    }

}
