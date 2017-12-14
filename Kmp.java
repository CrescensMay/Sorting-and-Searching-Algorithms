package design.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Kmp {

    public Kmp(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        int lps[] = new int[m];

        lpsArray(pattern, m, lps);

        int i = 0;
        int j = 0;
        while (i < n)
        {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("\n\t\t\t\tFound pattern at index: " + (i - j));
                j = lps[j - 1];

            }else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lpsArray[0..lpsArray[j-1]] characters,
                // they will match anyway
                if (j > 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
    }

    private void lpsArray(String pattern, int m, int lps[]) {

        int j = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                lps[i] = j;
                j++;
                i++;

            } else{

                if (j != 0) {
                    j = lps[j - 1];

                }else{
                    lps[i] = j;
                    i++;
                }
            }
        }
    }

    private void BeforeAndAfter(String text, String pattern){

        String[] splitter = text.split(" ");
        for (int i = 0; i < splitter.length; i++){
            if (splitter[i].equals(pattern)){

                StringBuilder stringBuilder = new StringBuilder();
                if(i - 1 > 0){
                    stringBuilder.append("\t\t\t\t{ ").append(splitter[i - 1]);
                }else {
                    stringBuilder.append("\t\t\t\t{'?'");
                }
                if (i + 1 < splitter.length){
                    stringBuilder.append(" : ");
                    stringBuilder.append(splitter[i + 1]).append(" }");
                }else {
                    stringBuilder.append(" : '?' }");
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }

    //Not important
    private static int countWord(String str){
        int count = 0;
//        if(str.charAt(0) != ' '){
//            count++;
//        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }

    // Driver program to test above function
    public static void main(String args[]) throws InterruptedException, IOException {

        System.out.println("\t\t\t\n**************WELCOME TO THE Kmp ALGORITHM**************");
        Scanner scanner = new Scanner(System.in);
        String filename = "/Users/mac/Desktop/test5.txt";
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        List<String> words = new ArrayList<>();
        String line;
        String text = null;
        while ((line = bufferedReader.readLine()) != null){
//            String[] wordsLine = line.split(" ");
            text = line;
        }
        System.out.println("\n\t\t\t\tTotal Number of Words in the File: " + countWord(text));
        Random random = new Random(System.currentTimeMillis());
//        String randomWord = words1.get(random.nextInt(words1.size()));
        System.out.print("\n\t\t\t\tInputting Pattern: ");
        String pattern = scanner.next();
//        Thread.sleep(3000);
//        System.out.print(randomWord);
        System.out.println("\n\t\t\t\t---------------------------");
        System.out.println();
        Kmp kmp = new Kmp(text,pattern);
        Thread.sleep(2000);
        System.out.println("\n\t\t\tList Before and After the intended pattern");
        System.out.println("\t\t\t------------------------------------------");
        kmp.BeforeAndAfter(text, pattern);
    }
}
