/*

    This file is part of the iText (R) project.
    Copyright (c) 1998-2016 iText Group NV

*/

package com.itextpdf.samples.book.part2.chapter06;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.samples.GenericTest;
import com.itextpdf.test.annotations.type.SampleTest;
import org.junit.experimental.categories.Category;

import java.io.IOException;

@Category(SampleTest.class)
public class Listing_06_21_Concatenate extends GenericTest {
    public static final String DEST
            = "./target/test/resources/book/part2/chapter06/Listing_06_21_Concatenate.pdf";
    public static final String MOVIE_LINKS1 =
            "./src/test/resources/book/part1/chapter02/cmp_Listing_02_22_MovieLinks1.pdf";
    public static final String MOVIE_HISTORY =
            "./src/test/resources/book/part1/chapter02/cmp_Listing_02_24_MovieHistory.pdf";

    public static void main(String args[]) throws IOException {
        new Listing_06_21_Concatenate().manipulatePdf(DEST);
    }

    public void manipulatePdf(String dest) throws IOException {
        //Initialize source document 1
        PdfDocument sourceDoc1 = new PdfDocument(new PdfReader(MOVIE_LINKS1));
        int n1 = sourceDoc1.getNumberOfPages();

        //Initialize source document 2
        PdfDocument sourceDoc2 = new PdfDocument(new PdfReader(MOVIE_HISTORY));
        int n2 = sourceDoc2.getNumberOfPages();

        //Initialize destination document
        PdfDocument resultDoc = new PdfDocument(new PdfWriter(dest));

        for (int i = 1; i <= n1; i++) {
            PdfPage page = sourceDoc1.getPage(i).copyTo(resultDoc);
            resultDoc.addPage(page);
        }

        for (int i = 1; i <= n2; i++) {
            PdfPage page = sourceDoc2.getPage(i).copyTo(resultDoc);
            resultDoc.addPage(page);
        }

        //Close documents
        resultDoc.close();
        sourceDoc1.close();
        sourceDoc2.close();
    }
}
