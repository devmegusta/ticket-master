package com.br.devgusta.ticket_master.controller.API;
import com.br.devgusta.ticket_master.DTO.TicketReponseDTO;
import com.br.devgusta.ticket_master.service.TicketService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ExportTicketsReportToPdf {

    @Autowired
    TicketService ticketService;

    @GetMapping("/export/pdf")
    public void exportTicketsReportToPdf(HttpServletResponse response) throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=chamados.pdf");

        List<TicketReponseDTO> tickets = ticketService.getAllTickets();

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        Paragraph title = new Paragraph("Relatório de chamados criados", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20f);
        document.add(title);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);

        Stream.of("ID", "Título", "Descrição", "Status", "Data")
                .forEach(headerTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setPhrase(new Phrase(headerTitle));
                    table.addCell(header);
        });

        for (TicketReponseDTO t : tickets){
            table.addCell(String.valueOf(t.getId()));
            table.addCell(t.getTicketTitle());
            table.addCell(t.getTicketBody());
            table.addCell(t.getTicketStatus());
            table.addCell(t.getLocalDateTime().toString());

        }

        document.add(table);
        document.close();
    }
}
