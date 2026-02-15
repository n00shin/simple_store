import model.Category;
import model.Goods;
import repository.GoodsRepository;
import service.CategoryService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryService();
        GoodsRepository goodsRepository = new GoodsRepository();

        // SAVE CATEGORY
//        System.out.println(categoryService.save("c"));

        // SAVE GOODS
        Goods goods = new Goods("aa",10,1);
        Goods goods1 = new Goods("bb",20,2);
        System.out.println(goodsRepository.save(goods1));

    }
}
