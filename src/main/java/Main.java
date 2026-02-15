import model.Category;
import service.CategoryService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryService();

        // SAVE CATEGORY

        System.out.println(categoryService.save("a"));

    }
}
