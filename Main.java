import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JFrame frame = new JFrame("File Compressor and Decompressor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);


        JButton compressButton = new JButton("Compress File");
        compressButton.setBackground(new Color(0,255,255));
        compressButton.setForeground(Color.black);
        JButton decompressButton = new JButton("Decompress File");
        decompressButton.setForeground(Color.black);
        decompressButton.setBackground(new Color(255,255,0));

        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(compressButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    String filename = selectedFile.getName();
                    String op=Compressor.compressFile(filePath,filename);
                    JOptionPane.showMessageDialog(frame, op);
                }
            }
        });

        decompressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(decompressButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    String filename = selectedFile.getName();
                    String op=Decompressor.decompressFile(filePath,filename);
                    JOptionPane.showMessageDialog(frame, op);
                }
            }
        });

        panel.add(compressButton);
        panel.add(decompressButton);
        frame.pack();
        frame.setVisible(true);

    }
}
