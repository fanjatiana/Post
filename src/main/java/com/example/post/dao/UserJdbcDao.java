package com.example.post.dao;

import com.example.post.model.User;
import com.example.post.model.UserLogin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {

List<User> userList = new ArrayList<>();



    public List<User> findAll() {

        try {
            Connection connection = ConnexionManager.getINSTANCE();
            Statement statement = connection.createStatement(); //statement permet d'executer la requête
            ResultSet resultSet = statement.executeQuery("SELECT id,firstname,lastname,email,password FROM userList"); // resultSet = reponse

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                User newUser = new User(id, firstname, lastname, email, password);
                newUser.getId();
                newUser.getFirstname();
                newUser.getLastname();
                newUser.getPassword();
                newUser.getEmail();

                userList.add(newUser); // ajout de la liste des utilisateurs dans userList
            }
            //ConnexionManager.closeConnection(); // fermer la connexion vers la base de données
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public UserLogin findByUserEmailAndPassword(String inputValueEmail, String inputValuePassword) {

        UserLogin userLogin = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = ConnexionManager.getINSTANCE();
        try {
            preparedStatement = connection.prepareStatement("SELECT id,email, password FROM userList WHERE email = ? AND password = ?");
            preparedStatement.setString(1, inputValueEmail); // définir des paramètre
            preparedStatement.setString(2, inputValuePassword);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userLogin = new UserLogin(resultSet.getString("email"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userLogin;
    }

    @Override
    public boolean create(User newUser) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = ConnexionManager.getINSTANCE();
        boolean insertOk = false;
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO userList (firstname, lastname, email, password) VALUES (?,?,?,?)");
            preparedStatement.setString(1, newUser.getFirstname()); // définir des paramètre
            preparedStatement.setString(2, newUser.getLastname());
            preparedStatement.setString(3, newUser.getEmail());
            preparedStatement.setString(4, newUser.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            insertOk = rowsAffected>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertOk;
    }
}