import model.Category;
import model.Goods;
import org.example.DynamicArray;
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
//        Goods goods2 = new Goods("cc",30,3);
//        System.out.println(goodsService.save(goods2));

        // DELETE GOODS BY ID
//        System.out.println(goodsService.removeById(2));

        //SEARCH GOODS BY NAME
//        DynamicArray dynamicArray = goodsService.findByName("aa");
//        for (int i = 0; i < dynamicArray.getSize(); i++) {
//            System.out.println(dynamicArray.getByIndex(i));
//
//        }

        //INCREMENT INVENTORY GOODS WITH ID
//        System.out.println(goodsService.incrementInventory(1, 2));


        //Decrement inventory
//        System.out.println(goodsService.decrementInventory(1, 1));

        //SUM OF INVENTORY
        System.out.println(goodsService.sumOFALllGoods());


    }
}
