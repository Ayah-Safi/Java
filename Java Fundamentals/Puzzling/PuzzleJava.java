import java.util.Random;

public class PuzzleJava{
    
    public int[] getTenRolls(){
        int[] randomNumbersArray = new int[10];
        Random randMachine = new Random();
        for (int i=0; i < randomNumbersArray.length; i++){
           int randomNumber =  1+randMachine.nextInt(21);
           randomNumbersArray[i] = randomNumber;
        }
        return randomNumbersArray;   
    }

    public char getRandomLetter(){
        char[] randomLetterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random randMachine = new Random();
        int randomIndex =  randMachine.nextInt(26);
        char letter = randomLetterArray[randomIndex];
        return letter;
    }

    public String generatePassword(){
        int i = 0;
        String randomPassword = "";
        while (i < 8){
            char randomLetter = getRandomLetter();
            randomPassword  = randomPassword+randomLetter;
            i++;
        }
        return randomPassword;

    }

    public String[] getNewPasswordSet(int arrayLength){
        int i = 0;
        String[] randomPasswordsArray = new String[arrayLength];
        for (i = 0; i < randomPasswordsArray.length; i++){
            String randomPassword = generatePassword();
            randomPasswordsArray[i]  = randomPassword;
        }

        return randomPasswordsArray;
    }

}