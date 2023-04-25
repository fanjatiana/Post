package com.example.post.dao;

import com.example.post.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostJdbcDao implements PostDao {
    private List<Post> postList = new ArrayList<>();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List<Post> findAll() {
        try {
            Connection connection = ConnexionManager.getINSTANCE();
            Statement statement = connection.createStatement(); //statement permet d'executer la requête
            ResultSet resultSet = statement.executeQuery("SELECT id,title,author,content FROM postList"); // resultSet = reponse
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                //int categoryId=resultSet.getInt(categoryId)
                // Category categories = new Categories(categoryId, categoryName)
                Post post = new Post(id, title, author, content);
                postList.add(post);
            }
            //ConnexionManager.closeConnection(); // fermer la connexion vers la base de données
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    @Override
    public boolean create(Post element) {
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
    public Post findById(Integer integer) {
        try {
            Connection connection = ConnexionManager.getINSTANCE();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM postList");
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                Post post = new Post(id, title, author, content);
                return post;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Integer id) {
        Connection connection = ConnexionManager.getINSTANCE();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM postList WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public void update(Post element) {
        Connection connection = ConnexionManager.getINSTANCE();
        try {
            preparedStatement = connection.prepareStatement("UPDATE postList SET title=?,author=?, content=? WHERE id=?");
            preparedStatement.setInt(1, element.getId());
            preparedStatement.setString(2, element.getTitle());
            preparedStatement.setString(3, element.getAuthor());
            preparedStatement.setString(4, element.getContent());
            // définir des paramètre
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Post findAllPosts(String title, String author, String content) {
        return null;
    }

    @Override
    public Post createAPost(String title, String author, String content) {
        return null;
    }
}
