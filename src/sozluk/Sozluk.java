//Çoklu ağaç yapısı kullanılarak yapılmıştır.
package sozluk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Sozluk {
    public static void main(String[] args) throws IOException {

        System.out.println("Sözlük Yükleniyor, Lütfen Bekleyin...");
        Agac agac = new Agac();
        String text = "resource/sozluk.txt";
        BufferedReader oku = new BufferedReader((new FileReader(text)));
        String okunanSatir;
        while ((okunanSatir = oku.readLine()) != null) {
            agac.insert(okunanSatir);
        }
        System.out.println("Sözlük Yüklendi.");
        Scanner tara = new Scanner(System.in);
        while (true) {
            System.out.println("Bir Kelime Yazıp Enter Tuşuna Basınız : ");
            String word = tara.nextLine();
            List<String> a = agac.autocomplete(word.toUpperCase(Locale.ROOT));
            if (a.size() != 0) {
                System.out.println("Olası Kelimeler"+" ("+a.size()+") "+"adet");
                System.out.println("Olası Kelimelerin Sayısı:" + a.size());
                System.out.println("----------------");
            } else {
                System.out.println("Aradığınız kelime bulunamadı!");
                System.out.println("----------------------------");
            }

            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i));
            }
        }
    }
}
