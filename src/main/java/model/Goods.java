package model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
    private int id;
    private String name;
    private int inventory;
    private int categoryId;

    public Goods(String name, int inventory, int categoryId) {
        this.name = name;
        this.inventory = inventory;
        this.categoryId = categoryId;
    }
}
