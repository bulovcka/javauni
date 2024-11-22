package prac13.prac13_6;

import java.util.*;
import java.io.*;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название файла");
        String filename = sc.nextLine();

        List<String> words = readFromFile(filename);

        if (!words.isEmpty()) {
            String result = getLine(words);
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Файл пустой или не удалось прочитать.");
        }

    }

    public static List<String> readFromFile(String fileName){
        List<String> words = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null){
                String[] word = line.split("\\s+");
                words.addAll(Arrays.asList(word));
            }
            br.close();
        }catch(IOException e){
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return words;
    }
    public static String getLine(List<String> words){
        if (words.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        List<String> res = buildChain(words);
        for (String word : res) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(word);
        }

        return sb.toString();
        }
        public static List<String> buildChain(List<String> words){
            if (words.isEmpty()) {
                return new ArrayList<>();
            }

            List<String> chain = new ArrayList<>();
            chain.add(words.get(0));
            words.remove(0);

            boolean wordAdded;
            do {
                wordAdded = false;
                for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
                    String word = iterator.next();
                    String lastWord = chain.get(chain.size() - 1).toLowerCase();
                    char lastChar = lastWord.toLowerCase().charAt(lastWord.length() - 1);
                    char firstChar = word.toLowerCase().charAt(0);

                    if (lastChar == firstChar) {
                        chain.add(word);
                        iterator.remove();
                        wordAdded = true;
                        break;
                    }
                }
            } while (wordAdded && !words.isEmpty());

            return chain;
    }

}
