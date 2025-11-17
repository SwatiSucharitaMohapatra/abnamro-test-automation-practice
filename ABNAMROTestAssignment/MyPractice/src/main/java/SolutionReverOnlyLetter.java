class SolutionReverseOnlyLetter {
    // Main method to run and test the solution with an example input
    public static void main(String[] args) {
        // Create an instance of the Solution class
        SolutionReverseOnlyLetter solution = new SolutionReverseOnlyLetter();

        // Example Test Case 1: T = [3, 1, 2]
        String letter = ",ab$wewd344ddd_";
        String result1 = solution.reverseLetters(letter);
        System.out.println("Total wait time for T1: " + result1);

//        String letter2 = "1ab2";
//        String result2 = solution.reverseLetters(letter2);
//        System.out.println("Total wait time for T1: " + result2);
////


    }

    public String reverseLetters(String string) {
        int left = 0;
        int right = string.length()-1;
        char[] chars = string.toCharArray(); // Add this to note for String to Char array

        while (left < right) {
            if (!Character.isLetter(chars[left])) left++;
            else if (!Character.isLetter(chars[right])) right--;
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;

            }
        }


        return new String(chars); // To convert char array to String
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j;) {
            if (!Character.isLetter(sb.charAt(i))) {
                ++i;
            } else if (!Character.isLetter(sb.charAt(j))) {
                --j;
            } else {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j--, S.charAt(i++));
            }
        }
        return sb.toString();
    }

}


