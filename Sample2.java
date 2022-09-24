package ZipApp;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Sample2 {

    public static void main(String[] args) throws FileNotFoundException {

        File fileInput = new File("Testing.txt");
        File fileSource = fileInput;

        // Check if the file exists
        if (fileInput.exists()) {

            System.out.println("File loading successful!");

            try{


                // Declare output source
                FileOutputStream out = new FileOutputStream("Folder Compressed.zip");
                // Perform file or folder compression
                ZipOutputStream zipOut = new ZipOutputStream(out);

                // Declare file object
                File compressZip = new File(fileSource.toURI());
                System.out.println("File or Folder compress to Zip successful ~.~!");

                FileInputStream in = new FileInputStream(compressZip);
                ZipEntry zipEntry = new ZipEntry(compressZip.getName());

                // Cache byte arrays
                byte[] byt = new byte[1024];

                int i;
                while ((i = in.read(byt)) >= 0) {
                    zipOut.write(byt,0, i);
                }
                zipOut.close();
                in.close();
                out.close();


            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        } else {
            try {

                // Create file when file source is not available
                fileSource.createNewFile();
                System.err.println("File successful create!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
