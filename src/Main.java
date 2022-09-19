import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("�����-�����");

        File file = new File("voyna_i_mir.txt");

        Parser parser = new Parser();
        ArrayList<String> lines = parser.parse(file);

        Writer out = new OutputStreamWriter(System.out, "UTF-8");
        // �������� ����� ����� ����� ������ OutputStreamWriter, ������ ��� ��������� �� ��������� ������ System.out.println - windows-1251

        for (String line : lines) {
            out.write(line + "\n");
        }

        out.write("\n");


        out.write("����� ����� ��������� � ������ ���� ����� � ����\n");
        String input = "��������";      // ����� ������ ����� ��� ����� ��������� ��������

        int count = 0;
        String[] words = null;
        for (String s : lines) {
            words = s.toLowerCase().split("\\b");       // ����� ������ ����� ��� ����� ��������. \\b - ���������� ���������, ��������������� ������� �����
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
            out.write("������ ����� ����������� � ����� " + Integer.toString(count)+ " ���\n");
        }
        else
        {
            out.write("������ ����� �� ����������� � �����\n");
        }

        out.write("\n");


        count = 0;
        out.write("����� ����� ��������� � ������ ���� ����� � ���� ����� ����� Scanner\n");
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
            out.write("������ ����� ����������� � ����� " + Integer.toString(count)+ " ���\n");
        }
        else
        {
            out.write("������ ����� �� ����������� � �����\n");
        }
        scanner.close();
        out.close();
    }
}
