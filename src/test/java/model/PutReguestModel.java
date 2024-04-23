package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutReguestModel {
    int id;
    int userId;
    String title;
    String body;
}
