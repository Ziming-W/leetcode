public class Test {
    public static String findResultantString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // Pair up odd counts
        for (int i = 0; i < 26 && oddCount > 1; i++) {
            if (freq[i] % 2 == 1) {
                for (int j = 0; j < 26; j++) {
                    if (freq[j] % 2 == 0 && freq[j] > 0) {
                        freq[i]--;
                        freq[j]++;
                        oddCount--;
                        break;
                    }
                }
            }
        }

        StringBuilder leftHalf = new StringBuilder();
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            int times = freq[i] / 2;
            for (int j = 0; j < times; j++) {
                leftHalf.append((char) (i + 'a'));
            }
            if (freq[i] % 2 == 1) {
                middle = (char) (i + 'a');
            }
        }

        String rightHalf = leftHalf.reverse().toString();

        return middle == 0 ? leftHalf + rightHalf : leftHalf + ("" + middle) + rightHalf;
    }

    public static void main(String[] args) {
        System.out.println(findResultantString("aebcd")); // Expected output: abcba
    }
}