import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("voyna_i_mir.txt");

        Parser parser = new Parser();
        ArrayList<String> lines = parser.parse(file);

        for (String line : lines) {
            System.out.println(line);
        }

        System.out.println("");


        System.out.println("Поиск слова страдание в первом томе Войны и Мира");
        String input = "страдани";      // Будем искать слово без учёта последних символов

        int count = 0;
        String[] words = null;
        for (String s : lines) {
            words = s.toLowerCase().split("\\b");       // Будем искать слово без учёта регистра. \\b - регулярное выражение, соответствующее границе слова
            for (String word : words)
            {
                if (word.startsWith(input))
                {
                    count++;
                }
            }

        }
        if(count!=0)
        {
            System.out.println("Данное слово встречается в файле " + Integer.toString(count)+ " раз");
        }
        else
        {
            System.out.println("Данное слово не встречается в файле");
        }

        System.out.println("");


        count = 0;
        System.out.println("Поиск слова страдание в первом томе Войны и Мира через метод Scanner");
        Scanner scanner = new Scanner(file).useDelimiter(Pattern.compile(" "));
        words = null;
        while(scanner.hasNext()){
            words = scanner.nextLine().toLowerCase().split("\\b");
            for(String word : words){
                if (word.startsWith(input))
                {
                    count++;
                }
            }
        }
        if(count!=0)
        {
            System.out.println("Данное слово встречается в файле " + Integer.toString(count)+ " раз");
        }
        else
        {
            System.out.println("Данное слово не встречается в файле");
        }
        scanner.close();
    }
}
