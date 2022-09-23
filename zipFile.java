package fileCompressZip;

import java.io.*;

public class zipFile {

    public static void main(String[] args) {
        File fileInput = new File("Test.txt");

        try{
            String zipFileName = fileInput.getName().concat(".zip");
            FileInputStream fis = new FileInputStream(zipFileName);
            System.out.println("File loading successful!");

            ByteArrayOutputStream baos = new ByteArrayOutputStream(fis.available());
            byte[] array = new byte[fis.available()];
            int i;
            while ((i = fis.read(array)) != -1) {
                baos.write(array,0, i);
            }
            baos.close();



        } catch (FileNotFoundException fnfe) {
            System.err.println("File loading error!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
