package com.br.devgusta.ticket_master.service.notification;
import com.br.devgusta.ticket_master.model.Analyst;
import com.br.devgusta.ticket_master.model.Client;
import com.br.devgusta.ticket_master.model.Ticket;
import com.br.devgusta.ticket_master.repository.AnalystRepository;
import com.br.devgusta.ticket_master.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketNotificationsService {

    private final EmailService emailService;
    private final ClientRepository clientRepository;
    private final AnalystRepository analystRepository;

    public TicketNotificationsService(EmailService emailService,
                                      ClientRepository clientRepository,
                                      AnalystRepository analystRepository){
        this.emailService = emailService;
        this.clientRepository = clientRepository;
        this.analystRepository = analystRepository;
    }

    public void sendCreatedNotificationEmail(Ticket ticket){
        Client client = ticket.getClient();
        String subject = "Nova solicitação criada com sucesso!";
        String body = "Olá, " + client.getName() + "\n\n"
                + "Sua solicitação foi registrada com sucesso!\n"
                + "Título: " + ticket.getTicketTitle() + "\n"
                + "Descrição: " + ticket.getTicketBody() + "\n"
                + "Um dos nossos analistas entrará em contanto em breve para atendimento.\nObrigado!";
        emailService.sendEmailToClient(client.getEmail(), subject, body);
    }
    public void sendAssignedNotificationEmail(Ticket ticket) {
        Client client = ticket.getClient();
        Analyst analyst = ticket.getAnalyst();
        if (analyst == null) return; // ou lance exceção

        String subject = "Sua solicitação foi atribuída a um analista";
        String body = "Olá, " + client.getName() + "\n\n"
                + "Sua solicitação: " + ticket.getTicketTitle()
                + " foi atribuída ao analista responsável: " + analyst.getAnalystName() + ".\n"
                + "Ele entrará em contato em breve.\n\n"
                + "Equipe suporte.";

        emailService.sendEmailToClient(client.getEmail(), subject, body);
    }


    public void sendUpdatedNotificationEmail(Ticket ticket){
        Client client = ticket.getClient();
        String subject = "Houve atualização na sua solicitação";
        String body = "Olá, " + client.getName() + "\n\n"
                + "Sua solicitação obteve uma atualização!\n"
                + "Título: " + ticket.getTicketTitle() + "\n"
                + "Descrição: " + ticket.getTicketBody();
        emailService.sendEmailToClient(client.getEmail(), subject, body);
    }

    public void sendStatusNotificationEmail(Ticket ticket){
        Client client = ticket.getClient();
        String subject = "Status da sua solicitação";
        String body = "Olá, " + client.getName() + "\n\n"
                + "Houve uma alteração de status da solicitação: " + ticket.getTicketTitle() + "\n"
                + "Descrição: " + ticket.getTicketBody() + "\n"
                + "A situação da sua solicitação é: " + ticket.getTicketStatus() + "\n"
                + "Continue atenta há plataforma de chamados e seu e-mail para mais atualizações! Obrigado!\n"
                + "Equipe suporte.";
        emailService.sendEmailToClient(client.getEmail(), subject, body);
    }

    public void sendResolvedNotificationEmail(Ticket ticket){
    Client client = ticket.getClient();
    String subject = "Solicitação atendida com sucesso!";
    String body = "Olá, " + client.getName() + "\n\n"
            + "Sua solicitação: " + ticket.getTicketTitle() + " Foi solucionada com sucesso!\n"
            + "Se ainda precisar de ajuda, fique à vontade para registrar outro ticket!\n\n"
            + "Equipe suporte.";
    emailService.sendEmailToClient(client.getEmail(), subject, body);
}
}
