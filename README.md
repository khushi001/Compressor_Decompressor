# File Compressor and Decompressor

This Java program provides a graphical user interface (GUI) for compressing and decompressing files. It utilizes the `Compressor` and `Decompressor` classes from the `comp_decomp` package to perform file compression and decompression operations.

## Prerequisites
- Java Development Kit (JDK) installed on your system
- Java Swing library

## How to Run
1. Compile the Java source file:
   ```shell
   javac Main.java
   ```

2. Execute the compiled class file:
   ```shell
   java Main
   ```

## Usage
Upon running the program, a GUI window titled "File Compressor and Decompressor" will appear. The window provides two buttons: "Compress File" and "Decompress File".

- **Compress File**: Clicking this button opens a file chooser dialog. Select a file you want to compress, and the program will compress it using the `Compressor.compressFile()` method. A message dialog will display the output message from the compression process.

- **Decompress File**: Clicking this button opens a file chooser dialog. Choose a previously compressed file (in the same format generated by the program) for decompression. The program uses the `Decompressor.decompressFile()` method to decompress the file. A message dialog will display the output message from the decompression process.

**Note**: The compressed and decompressed files will be created in the same directory as the original file.

## Additional Information
- The program utilizes the Java Swing library for creating the GUI components.
- The `Compressor` and `Decompressor` classes in the `comp_decomp` package handle the actual compression and decompression operations respectively.
- The program uses `JFileChooser` to provide a file selection dialog for choosing the files to compress or decompress.
- Messages related to the compression and decompression processes are displayed using `JOptionPane` message dialogs.

## License
This project is licensed under the [MIT License](LICENSE).
