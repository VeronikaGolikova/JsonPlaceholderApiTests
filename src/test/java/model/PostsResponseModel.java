package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsResponseModel {
    int userId;
    int id;
    String title;
    String body;
}
