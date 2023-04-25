package com.example.post.ressource;

import com.example.post.model.Post;
import com.example.post.service.PostService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/posts")
public class PostResource {
  private  List<Post> posts = new PostService().fetchAllPostsFromBdd();
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getPosts() {
        return Response
                .status(Response.Status.CREATED)
                .entity(posts)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("id") int id) {
        if (id >= 1 && id <= posts.size()) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(posts.get(id-1))
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST).
                    entity("Id invalide")
                    .build();
        }
    }

     @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response createPost(PostDto dto) {
        PostService postService = new PostService();
        Boolean postCreated = postService.createNewPost(dto.getTitle(), dto.getAuthor(), dto.getContent());
        if (postCreated) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(posts)
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST).
                    entity("error")
                    .build();
        }
    }

}

  /* exemple correction
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        Post postToDelete = postJdbcDao.findById(id);
        if(postToDelete == null){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        postJdbcDao.delete(postToDelete);
        return Response.noContent().build;
    }

    @PUT
    @Path("/{id}")
    public Post update(@PathParam("id") int id){
        postJdbcDao.update(post);
    }
*/





