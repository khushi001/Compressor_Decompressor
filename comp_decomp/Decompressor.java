package comp_decomp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static String decompressFile(String inputFile,String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            FileOutputStream fileOutputStream = new FileOutputStream(getOutputFilePath(inputFile,filename));
            GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            gzipInputStream.close();
            fileOutputStream.close();

            return("File decompressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return("error "+e);
        }
    }

    private static String getOutputFilePath(String inputFile,String filename) {
        String parentDirectory = new java.io.File(inputFile).getParent();
        String outputFileName = filename+"_decompressed.txt";
        return parentDirectory + java.io.File.separator + outputFileName;
    }
}
