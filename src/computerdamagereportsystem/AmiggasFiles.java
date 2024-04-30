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
        String primaryPathDirectory = "C:\\Users\\Harayku\\Downloads\\ComputerDamageFixerSystem-master\\src\\AmiggasConfidential.txt";

        File AmiggasConfidential = new File(primaryPathDirectory);

        try (InputStream inputStream = new FileInputStream(AmiggasConfidential); 
                OutputStream outputStream = new FileOutputStream(AmiggasConfidential)) {

            if (AmiggasConfidential.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(AmiggasConfidential);
            System.out.println("READING FILE...");
            writer.write("Ang user ay admin tas admin123 ang password waw confidential\n");
            writer.close();

            FileReader reader = new FileReader(AmiggasConfidential);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();

            int byteData;
            while ((byteData = inputStream.read()) != -1) {

            }
            // Process the byte data
            System.out.println("Processed Data Finished!");

            // Write data to the file
            String newData = "TWICE FOREVER<3";
            byte[] convertBytes = newData.getBytes(); // Convert string to bytes
            outputStream.write(convertBytes);

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
