import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.ImageCell;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;

public class PDFGenWithPDFBox {
    public static void main(String[] args) throws IOException {

        try (PDDocument document = new PDDocument()) {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/logo.png", document);

                Table billingTable = Table.builder()
                        .addColumnsOfWidth(45,45,45,45,45,45,45,45,45,45,45,45)
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("Detailed Bill").colSpan(12).borderWidth(1).backgroundColor(Color.blue).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(ImageCell.builder().image(pdImage).colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Address").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Bill Number").colSpan(3).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(ImageCell.builder().image(pdImage).colSpan(3).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("DateTime").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Shipping").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Some Info").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).backgroundColor(Color.green).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("Sender").colSpan(4).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Receiver").colSpan(4).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("Pin").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("A111111111").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("A111111111").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("A111111111").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("A111111111").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(4).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text("A111111111").colSpan(2).borderWidth(1).backgroundColor(Color.green).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .add(TextCell.builder().text(" ").colSpan(2).borderWidth(1).horizontalAlignment(HorizontalAlignment.CENTER).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("More Details").colSpan(12).borderWidth(1).backgroundColor(Color.blue).horizontalAlignment(HorizontalAlignment.LEFT).build())
                                .build())
                        .build();

                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(20f)
                        .startY(page.getMediaBox().getUpperRightY() - 20f)
                        .table(billingTable)
                        .build();

                tableDrawer.draw();
            }

            document.save("src/main/resources/pdfBoxEasyTable.pdf");
            document.close();
        }
    }

}
