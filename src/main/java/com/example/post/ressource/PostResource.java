package com.example.post.ressource;

import com.example.post.model.Post;
import com.example.post.service.PostService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/myposts")
public class PostResource {
    // recupérer les posts
    List<Post> posts = new PostService().fetchAllPostsFromBdd();
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Post> getPosts() {
        return posts;
    }

    // Mettre en place la récupérations du post N
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("id") Long id) {
        if (id >= 1 && id <= posts.size()) {
            return Response
                    .status(Response.Status.CREATED) //
                    .entity(posts.get((int) (id - 1)))
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST).
                    entity("ID de message invalide").build();
        }
    }

    // le serveur va recevoir du json
    @POST
    // le serveur va produire du json
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response createPost() { // JSON ==> JAVA
        return Response
                .status(Response.Status.CREATED) //
                .entity(posts) //
                .build(); // construction JAVA ==> JSON
    }
}


