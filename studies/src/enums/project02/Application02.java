package enums.project02;

import enums.project02.entities.Comment;
import enums.project02.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application02 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Comment comment1 = new Comment("Have a nice studies");
        Comment comment2  = new Comment("Wow that's awesome!");
        Post post1 = new Post(sdf.parse("27/06/22 10:34:16"), "Studying enums on JAVA",
               "I'm improving myself with the JAVA language", 32);
        post1.addComment(comment1);
        post1.addComment(comment2);

        System.out.println(post1);
    }
}
