import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    public String typMetody = "";

    public String lastLine = "";

    public void newIteration(String input) {
        char[] radek = input.toCharArray();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt"))) {
            for (int i = 0; i < radek.length; i++) {

                if (typMetody.contains("Binary tree")) {

                    if (radek[i] == 'F') {
                        bw.write("G[+F]--F");
                    }

                    if (radek[i] == 'G') {
                        bw.write("GG");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }

                    if (radek[i] == ']') {
                        bw.write("]");
                    }

                    if (radek[i] == '[') {
                        bw.write("[");
                    }
                }

                if (typMetody.contains("Kochova krivka")) {

                    if (radek[i] == 'F') {
                        bw.write("F+F--F+F");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                }

                if (typMetody.contains("Tree")) {

                    if (radek[i] == 'F') {
                        bw.write("FF");
                    }

                    if (radek[i] == 'X') {
                        bw.write("F-[[X]+X]+F[+FX]-X");
                    }


                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }

                    if (radek[i] == '[') {
                        bw.write("[");
                    }

                    if (radek[i] == ']') {
                        bw.write("]");
                    }

                }

                if (typMetody.contains("Gosperova krivka")) {

                    if (radek[i] == 'A') {
                        bw.write("A-B--B+A++AA+B-");
                    }

                    if (radek[i] == 'B') {
                        bw.write("+A-BB--B-A++A+B");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }
                }

                if (typMetody.contains("Dragon curve")) {
                    if (radek[i] == 'X') {
                        bw.write("X+YF+");
                    }

                    if (radek[i] == 'Y') {
                        bw.write("-FX-Y");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }
                }

                if (typMetody.contains("Crystal")) {

                    if (radek[i] == 'F') {
                        bw.write("FF+F++F+F");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }
                }

                if (typMetody.contains("Pentaplexity")) {
                    if (radek[i] == 'F') {
                        bw.write("F++F++F|F-F++F");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }

                    if (radek[i] == '|') {
                        bw.write("|");
                    }
                }

                if (typMetody.contains("Rings")) {
                    if (radek[i] == 'F') {
                        bw.write("FF+F+F+F+F+F-F");
                    }

                    if (radek[i] == '+') {
                        bw.write("+");
                    }

                    if (radek[i] == '-') {
                        bw.write("-");
                    }

                }

            }
            bw.newLine();
            bw.flush();

        } catch (Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }

    }

    public String returnLastLine() {

        List<String> radky = new ArrayList<>();

        System.out.println("\n");
        System.out.println("---------- VYPISUJI CELÝ SOUBOR ----------");

        try (BufferedReader br = new BufferedReader(new FileReader("soubor.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                radky.add(s);
            }
        } catch (Exception e) {
            System.err.println("Chyba při čtení ze souboru.");
        }

        lastLine = radky.get(radky.size() - 1);

        System.out.println(radky.get(radky.size() - 1));
        System.out.println("------------------------------------------");
        System.out.println("\n");
        return (radky.get(radky.size() - 1));
    }


    public void setFirstLine(String radek) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt"))) {
            bw.write(radek);
        } catch (Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }
    }

    public void sayTypeOfMethod() {
        System.out.println("Mas zvoleny : " + typMetody);
    }

    public String getLastLine() {
        return lastLine;
    }

    public void setTypeOfMethod(String typMetody) {
        this.typMetody = typMetody;
    }

    public String getTypeOfMethod() {
        return typMetody;
    }

}

