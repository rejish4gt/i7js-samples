package com.itextpdf.samples.book.part3.chapter11;

import com.itextpdf.basics.font.PdfEncodings;
import com.itextpdf.core.font.PdfFont;
import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfWriter;
import com.itextpdf.core.testutils.annotations.type.SampleTest;
import com.itextpdf.model.Document;
import com.itextpdf.model.element.Paragraph;
import com.itextpdf.samples.GenericTest;

import org.junit.Ignore;
import org.junit.experimental.categories.Category;

@Ignore
@Category(SampleTest.class)
public class Listing_11_14_Diacritics2 extends GenericTest {
    public static final String DEST = "./target/test/resources/book/part3/chapter11/Listing_11_14_Diacritics2.pdf";
    public static final String MOVIE = "Tomten \u00a8ar far till alla barnen";
    public static final String[] FONTS = {
            /*"c:/windows/fonts/arial.ttf"*/"./src/test/resources/font/FreeSans.ttf",
            /*"c:/windows/fonts/cour.ttf"*/"./src/test/resources/font/LiberationMono-Regular.ttf"
    };

    public static void main(String[] agrs) throws Exception {
        new Listing_11_14_Diacritics2().manipulatePdf(DEST);
    }

    @Override
    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        doc.add(new Paragraph("Movie title: In Bed With Santa (Sweden)"));
        doc.add(new Paragraph("directed by Kjell Sundvall"));
        PdfFont f = PdfFont.createFont(pdfDoc, FONTS[0], PdfEncodings.CP1252, true);
        // TODO No setCharacterAdvance
        // f.setCharAdvance('\u00a8', -100);
        doc.add(new Paragraph(MOVIE).setFont(f));
        f = PdfFont.createFont(pdfDoc, FONTS[1], PdfEncodings.CP1252, true);
        // f.setCharAdvance('\u00a8', 0);
        doc.add(new Paragraph(MOVIE).setFont(f));
        doc.close();
    }
}