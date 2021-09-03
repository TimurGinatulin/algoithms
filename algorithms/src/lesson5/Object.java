package lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Object {
    private String title;
    private Integer width;
    private Integer price;
}