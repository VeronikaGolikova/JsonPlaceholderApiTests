package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsResponseModel {
    int postId;
    int id;
    String name;
    String email;
    String body;
}
