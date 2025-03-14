package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Help implements Command {

    String line="";
    String text="";

public String reading() {
    try (BufferedReader br = new BufferedReader(new FileReader("ListOfCommands"))) {
        while ((line = br.readLine()) != null) {
            text+=line+"\n";
        }
    } catch (FileNotFoundException e) {
        System.out.println("Soubor nebyl nalezen");
    } catch (IOException e) {
        System.out.println("chyba pri cteni");
    }
    return text;
}





    @Override
    public String execute() {
        return reading();
    }

    @Override
    public Boolean end() {
        return false;
    }
}
