package service;

import model.Post;

import java.util.List;

public class PostService {

    private static List<Post> posts = List.of(
            new Post(1L, "Aenean eu dapibus odio", "Pierre B.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Maecenas tortor justo, varius at erat id, laoreet posuere diam. Cras pellentesque efficitur lectus"),
            new Post(2L, "vestibulum finibus felis sed", "Emma C.", "Suspendisse potenti." +
                    "Sed placerat, dui suscipit laoreet ornare, felis risus sollicitudin magna, et sodales arcu mauris ac magna. "),
            new Post(3L, "Proin eleifend lacinia luctus", "Isao L.", "nulla enim posuere mi, ac sagittis leo velit eget tortor. " +
                    "Donec mauris massa, finibus a tincidunt id, condimentum sed nibh"));

    public List<Post> fetchAllPosts(){
        return this.posts;
    }
}
