import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FilePicker {
    public static void main(String []args) throws IOException {
        JFileChooser fc = new JFileChooser();
        int r = fc.showOpenDialog(new JFrame());

        String fileName = fc.getSelectedFile().getName();
        File fileDir = fc.getCurrentDirectory();

        File pdfFile = new File(fileDir + "\\" + fileName);

        PDFtoText pdf;
        try {
            pdf = new PDFtoText(pdfFile, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
