import java.util.Arrays;

public class phoneNumber {
    //전화번호 목록
    public boolean phoneNumber(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].startsWith(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        phoneNumber solution = new phoneNumber();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        System.out.println(solution.phoneNumber(phone_book1));  // false (겹치는 접두어 있음)

        String[] phone_book2 = {"123", "456", "789"};
        System.out.println(solution.phoneNumber(phone_book2));  // true (겹치는 접두어 없음)
    }
}
