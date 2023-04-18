package com.example.post.dao;

import com.example.post.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostJdbcDao implements PostDao {
    List<Post> postList = new ArrayList<>();

    @Override
    public boolean create(Post element) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = ConnexionManager.getINSTANCE();
        boolean insertOk = false;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO postList (title, author, content) VALUES (?,?,?)");
            preparedStatement.setString(1, element.getTitle()); // définir des paramètre
            preparedStatement.setString(2, element.getAuthor());
            preparedStatement.setString(3, element.getContent());
            int rowsAffected = preparedStatement.executeUpdate();
            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertOk;
    }

    @Override
    public List<Post> findAll() {
        try {
            Connection connection = ConnexionManager.getINSTANCE();
            Statement statement = connection.createStatement(); //statement permet d'executer la requête
            ResultSet resultSet = statement.executeQuery("SELECT id,title,author,content FROM postList"); // resultSet = reponse

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");


                Post post = new Post(id, title, author, content);
                post.getId();
                post.getTitle();
                post.getAuthor();
                post.getContent();

                postList.add(post); // ajout de la liste des utilisateurs dans userList
            }
            //ConnexionManager.closeConnection(); // fermer la connexion vers la base de données
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    @Override
    public Post findAllPosts(String title, String author, String content) {
        return null;
    }

    @Override
    public Post createAPost(String title, String author, String content) {
        return null;
    }

    @Override
    public Post findById(Long aLong) {
        return null;
    }

    // modifier
    @Override
    public void update(Post element) {

    }

    //
    @Override
    public void delete(Post element) {

    }
}
