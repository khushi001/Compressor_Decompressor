package comp_decomp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static String compressFile(String inputFile,String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            FileOutputStream fileOutputStream = new FileOutputStream(getOutputFilePath(inputFile,filename));
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                gzipOutputStream.write(buffer, 0, bytesRead);
            }

            fileInputStream.close();
            gzipOutputStream.finish();
            gzipOutputStream.close();

            return("File compressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return("error");
        }
    }

    private static String getOutputFilePath(String inputFile,String filename) {
        String parentDirectory = new java.io.File(inputFile).getParent();
        String outputFileName = filename+"_compressed.gz";
        return parentDirectory + java.io.File.separator + outputFileName;
    }
}
