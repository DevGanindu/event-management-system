package com.nsbm.dao;

import com.nsbm.model.Participant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/eventdb?useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";
    private Connection jdbcConnection;

    // Establish database connection
    private void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (ClassNotFoundException e) {
                throw new SQLException("JDBC Driver not found", e);
            }
        }
    }

    // Close connection
    private void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    // Insert participant into database
    public void insertParticipant(Participant participant) {
        String sql = "INSERT INTO participants (name, email, event) VALUES (?, ?, ?)";

        try {
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, participant.getName());
            statement.setString(2, participant.getEmail());
            statement.setString(3, participant.getEvent());

            statement.executeUpdate();
            statement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Participant> listParticipants() {
    List<Participant> participants = new ArrayList<>();
    String sql = "SELECT * FROM participants;";

    try {
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Participant participant = new Participant();
            participant.setId(resultSet.getInt("id"));
            participant.setName(resultSet.getString("name"));
            participant.setEmail(resultSet.getString("email"));
            participant.setEvent(resultSet.getString("event"));

            participants.add(participant);
        }

        resultSet.close();
        statement.close();
        disconnect();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return participants;
}


}
