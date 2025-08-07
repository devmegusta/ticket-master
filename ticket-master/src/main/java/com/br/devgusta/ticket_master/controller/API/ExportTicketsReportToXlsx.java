package com.br.devgusta.ticket_master.controller.API;

import com.br.devgusta.ticket_master.DTO.TicketReponseDTO;
import com.br.devgusta.ticket_master.service.TicketService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ExportTicketsReportToXlsx {

    @Autowired
    TicketService ticketService;

    @GetMapping("/export/excel")
    public void exportTicketsReportToXlsx(HttpServletResponse response) throws IOException{
        response.setContentType("application/vnd.openxmlforms-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=chamados.xlsx");

        List<TicketReponseDTO> tickets = ticketService.getAllTickets();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Chamados abertos");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Título");
        header.createCell(2).setCellValue("Descrição");
        header.createCell(3).setCellValue("Status");
        header.createCell(4).setCellValue("Data");

        int rowCount = 1;

        for (TicketReponseDTO t : tickets){
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(t.getId());
            row.createCell(1).setCellValue(t.getTicketTitle());
            row.createCell(2).setCellValue(t.getTicketBody());
            row.createCell(3).setCellValue(t.getTicketStatus());
            row.createCell(4).setCellValue(t.getLocalDateTime().toString());
        }

        workbook.write(response.getOutputStream());
        workbook.close();


    }

}
