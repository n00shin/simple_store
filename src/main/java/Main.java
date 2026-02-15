import model.Category;
import model.Goods;
import repository.GoodsRepository;
import service.CategoryService;
import service.GoodsService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryService();
      GoodsService goodsService = new GoodsService();

        // SAVE CATEGORY
//        System.out.println(categoryService.save("c"));

        // SAVE GOODS
//        Goods goods = new Goods("aa",10,1);
//        Goods goods1 = new Goods("bb",20,2);
//        System.out.println(goodsRepository.save(goods1));

        // DELETE GOODS BY ID
        System.out.println(goodsService.removeById(2));

    }
}
