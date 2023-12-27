public class PuzzleJavaTest {
    public static void main(String[] args){

        PuzzleJava appTest = new PuzzleJava();


        System.out.println("----Display getTenRolls Method----");
        int[] randomNumbers = appTest.getTenRolls();
        for (int number : randomNumbers) {
            System.out.println(number + " ");

    }

        System.out.println("----Get Random Letter Method----");
        char letter = appTest.getRandomLetter();
        System.out.println(letter);

        System.out.println("----Generate Random Password----");
        String randomPassword = appTest.generatePassword();
        System.out.println(randomPassword);

        System.out.println("----Get New Password Set Method----");
        String[] randomPasswordsArray = appTest.getNewPasswordSet(3);
        for (String password : randomPasswordsArray) {
            System.out.println(password + " ");

    }
    
    }
}
