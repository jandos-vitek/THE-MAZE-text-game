package Others;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RulesAndLore {
    public String readRules() {
        String line;
        String text="";
        try (
                BufferedReader br = new BufferedReader(new FileReader("Rules"))
        ) {
            while ((line = br.readLine()) != null) {
                text+=line+"\n";
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("soubor nenalezen");
        } catch (
                IOException e) {
            System.out.println("chyba pri cteni");
        }
        return text;
    }
}
