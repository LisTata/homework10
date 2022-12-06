import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vocab {
    public static void main(String[] args) {
        int count = 'z' - 'a' + 1;
       // System.out.println(count);

        List<String> vocab = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/vocab.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null)
                    vocab.add(s);

            }
            while (s != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //  System.out.println(vocab.size());

        vocab.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
/*for(String s:vocab)
          System.out.println(s);*/


        //Частота встречаемости букв в словах
        System.out.println("Частота встречаемости букв в словах");
        int countLetter=0;

        int[] letters = new int['z'-'A'+1];
        

        char c;
        for (String s : vocab){
            for (int i = 0; i < s.length(); i++){
                c=s.charAt(i);
            if (Character.isLetter(c))
                letters[c-'A']++;

        }
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0)
                System.out.println( (char) (i+'A') +": " + letters[i]);

        }







//Количество слов, начинающихся на определенную букву (от 'a' до 'z')
        System.out.println("Количество слов, начинающихся на определенную букву (от 'a' до 'z')");

        int countWord = 1;
        for (int i = 0; i < vocab.size(); i++) {


            if (i == vocab.size() - 1) {
                System.out.println((vocab.get(i)).charAt(0) + " - " + countWord);
                break;
            }


            if (vocab.get(i).charAt(0)==vocab.get(i + 1).charAt(0))
                countWord++;

            else {
                System.out.println((vocab.get(i)).charAt(0) + " - " + countWord);
                countWord = 1;
            }
        }

    }

}




