import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFtoText {
    public PDFtoText(File pdfFile, String fileName) throws IOException {
        Text myText = new Text();
        String text = null;

        try (PDDocument document = PDDocument.load(pdfFile)) {
            AccessPermission ap = document.getCurrentAccessPermission();
            if (!ap.canExtractContent())
                throw new IOException("You do not have permission to extract text");

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);

            for (int p=1; p <= document.getNumberOfPages(); ++p) {
                text = stripper.getText(document);
                String pageStr = String.format("page %d:", p);

                    // -----Code below creates a .TXT file-----
                    //File sylName = new File(fileName+".txt");
                    //FileWriter mySyl = new FileWriter(fileName+".txt");
                    //mySyl.write(text.trim());
                    //mySyl.close();
            }
            myText.setText(text);
            System.out.println("Finished txt!");
            //System.out.println(text);
            Grading grade = new Grading(myText.getText());
            DateSchedule dates = new DateSchedule(myText.getText());
        }
    }
}

class Text {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }
}

