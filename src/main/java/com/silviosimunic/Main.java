package com.silviosimunic;

import com.silviosimunic.texttime.TextTime;
import com.silviosimunic.texttime.TimeType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No file name given.");
            return;
        }

        String fileName = args[0];

        try {
            String text = getText(new File(fileName));
            TextTime textTime = new TextTime(text);

            System.out.println("Given PDF has " + textTime.wordCount() + " words.");
            System.out.println("It will take about " + textTime.readTimeHuman(TimeType.FULL) + " to read it.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getText(File pdf) throws IOException {
        PDDocument document = PDDocument.load(pdf);
        return new PDFTextStripper().getText(document);
    }
}
