import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PDFGenerator {
    public static void main(String[] args) throws Exception {
        PDDocument document = new PDDocument();
        document.addPage(new PDPage());
        document.save("src/main/resources/pdfBoxOutput.pdf");
        System.out.println("PDF created");

        attributeSetter(document);
        document.save("src/main/resources/pdfBoxOutput.pdf");
        System.out.println("Properties added successfully ");

        document.load(new File("src/main/resources/pdfBoxOutput.pdf"));
        PDPage page = document.getPage(0);
        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/logo.png", document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        Object[][] tableContent = { {pdImage, "b", "1"},
                                    {"c", "d", "2"},
                                    {"e", "f", "3"},
                                    {"g", "h", "4"},
                                    {"i", "j", "5"}};
        drawTable(page, contentStream, 700.0f, 100.0f, tableContent);
        System.out.println("Table created successfully ");

        contentStream.close();
        document.save("src/main/resources/pdfBoxOutput.pdf");
        document.close();
    }

    private static void attributeSetter(PDDocument document) {
        PDDocumentInformation pdd = document.getDocumentInformation();
        pdd.setAuthor("Vikas Lalwani");
        pdd.setTitle("Sample PDF document");
        pdd.setCreator("Vikas Lalwani Json2PDF");
        pdd.setSubject("Sample document");
        Calendar date = new GregorianCalendar();
        date.setTime(Date.from(Instant.now()));
        pdd.setCreationDate(date);
        date.setTime(Date.from(Instant.now()));
        pdd.setModificationDate(date);
    }

    private static void drawTable(PDPage page, PDPageContentStream contentStream,
                                 float y, float margin, Object[][] content) {
        try {
            final int rows = content.length;
            final int cols = content[0].length;
            final float rowHeight = 20.0f;
            final float tableWidth = page.getMediaBox().getWidth() - 2.0f * margin;
            final float tableHeight = rowHeight * (float) rows;
            final float colWidth = tableWidth / (float) cols;

            //draw the rows
            float nexty = y;
            for (int i = 0; i <= rows; i++) {
                contentStream.moveTo(margin, nexty);
                contentStream.lineTo(margin + tableWidth, nexty);
                contentStream.stroke();
                nexty -= rowHeight;
            }

            //draw the columns
            float nextx = margin;
            for (int i = 0; i <= cols; i++) {
                contentStream.moveTo(nextx, y);
                contentStream.lineTo(nextx, y - tableHeight);
                contentStream.stroke();
                nextx += colWidth;
            }

            //now add the data
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12.0f);

            final float cellMargin = 5.0f;
            float textx = margin + cellMargin;
            float texty = y - 15.0f;
            for (final Object[] aContent : content) {
                for (Object data : aContent) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(textx, texty);
                    if (data instanceof String) {
                        contentStream.showText((String) data);
                    } else if (data instanceof PDImageXObject) {
                        contentStream.endText();
                        contentStream.drawImage((PDImageXObject) data, textx, texty);
                        contentStream.beginText();
                    }
                    contentStream.endText();
                    textx += colWidth;
                }
                texty -= rowHeight;
                textx = margin + cellMargin;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
