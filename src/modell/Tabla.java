package modell;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Tabla {

    private char[][] T = new char[8][8];
    private char ÜresCella;

    public Tabla(char üresCella) {
        this.ÜresCella = üresCella;
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                T[i][j] = ÜresCella;
            }
        }
    }

    public void Elhelyez(int N) {
        Random rnd = new Random();
        int placed = 0;
        while (placed < N) {
            int i = rnd.nextInt(T.length);
            int j = rnd.nextInt(T[0].length);
            if (T[i][j] == ÜresCella) {
                T[i][j] = 'K';
                placed++;
            }
        }
    }

    public boolean ÜresOszlop(int oszlop) {
        for (char[] chars : T) {
            if (chars[oszlop] != ÜresCella) {
                return false;
            }
        }
        return true;
    }

    public boolean ÜresSor(int sor) {
        for (int j = 0; j < T[0].length; j++) {
            if (T[sor][j] != ÜresCella) {
                return false;
            }
        }
        return true;
    }

    public int ÜresOszlopokSzáma() {
        int count = 0;
        for (int i = 0; i < T[0].length; i++) {
            if (ÜresOszlop(i)) {
                count++;
            }
        }
        return count;
    }

    public int ÜresSorokSzáma() {
        int count = 0;
        for (int i = 0; i < T.length; i++) {
            if (ÜresSor(i)) {
                count++;
            }
        }
        return count;
    }

    public char[][] getTabla() {
        return T;
    }

    public void tablakAllapotanakMentese(String filename) throws IOException {
        File file = new File(filename);
        // Ha a fájl létezik, töröljük.
        if (file.exists()) {
            file.delete();
        }

        try (FileWriter writer = new FileWriter(file)) {
            // Létrehozunk 64 táblát.
            for (int n = 1; n <= 64; n++) {
               
                Tabla tabla = new Tabla('*');
           
                tabla.Elhelyez(n);
              
                for (char[] sor : tabla.getTabla()) {
                    writer.write(new String(sor) + "\n");
                }
              
                if (n < 64) {
                    writer.write("\n\n");
                }
            }
        }
    }

}
