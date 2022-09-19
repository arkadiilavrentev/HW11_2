import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Аддис-Абеба");

        File file = new File("voyna_i_mir.txt");

        Parser parser = new Parser();
        ArrayList<String> lines = parser.parse(file);

        Writer out = new OutputStreamWriter(System.out, "UTF-8");
        // Выводить будем через метод класса OutputStreamWriter, потому что кодировка по умолчанию метода System.out.println - windows-1251

        for (String line : lines) {
            out.write(line + "\n");
        }

        out.write("\n");


        out.write("Поиск слова страдание в первом томе Войны и Мира\n");
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
            out.write("Данное слово встречается в файле " + Integer.toString(count)+ " раз\n");
        }
        else
        {
            out.write("Данное слово не встречается в файле\n");
        }

        out.write("\n");


        count = 0;
        out.write("Поиск слова страдание в первом томе Войны и Мира через метод Scanner\n");
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
            out.write("Данное слово встречается в файле " + Integer.toString(count)+ " раз\n");
        }
        else
        {
            out.write("Данное слово не встречается в файле\n");
        }
        scanner.close();
        out.close();
    }
}
