package com.example.post;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/new-posts-list-after-delete")
public class DeletePostServlet extends HttpServlet {
   /* @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btnDelete=req.getParameter("btnDelete");

        List<Post> newList = new PostService().fetchAllPosts();

        for (Post post: newList){
            new PostService().deletePost(post.getId());
        }resp.sendRedirect(req.getContextPath() + "/userSession/posts-list");
    }*/
}
