package com.nsbm.controller;

import com.nsbm.model.Participant;
import com.nsbm.dao.ParticipantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/ParticipantServlet")
public class ParticipantServlet extends HttpServlet {
    private ParticipantDAO participantDAO;

    public void init() {
        participantDAO = new ParticipantDAO();
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String event = request.getParameter("event");

        Participant participant = new Participant();
        participant.setName(name);
        participant.setEmail(email);
        participant.setEvent(event);

        participantDAO.insertParticipant(participant);

        // Set success message
        request.setAttribute("message", "Participant registered successfully!");

        // Forward back to form with success message
        request.getRequestDispatcher("eventForm.jsp").forward(request, response);
}


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Participant> participantList = participantDAO.listParticipants();
        request.setAttribute("ParticipantList", participantList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("participantList.jsp");
        dispatcher.forward(request, response);
    }
}
 