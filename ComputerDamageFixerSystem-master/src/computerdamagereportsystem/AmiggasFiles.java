package computerdamagereportsystem;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class AmiggasFiles {

    public void confidential() throws FileNotFoundException, IOException {
        String pathDirectory = "ComputerDamageFixerSystem-master/AmiggasConfidential.txt";
        File amiggas = new File(pathDirectory);
        String newFileName = "source.txt";

        File newFile = new File(pathDirectory, newFileName);
        try (FileReader fileReader = new FileReader(amiggas); FileWriter fileWriter = new FileWriter(newFileName)) {
            InputStream in = new FileInputStream(amiggas);
            OutputStream out = new FileOutputStream(newFileName);

            if (newFile.createNewFile()) {
                System.out.println("New file created successfully.");
            } else {
                System.out.println("File already exists in the directory.");
            }

            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
