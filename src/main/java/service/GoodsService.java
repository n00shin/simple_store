package service;

import model.Goods;
import org.example.DynamicArray;
import repository.GoodsRepository;

import java.sql.SQLException;

public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService() {
        this.goodsRepository = new GoodsRepository();
    }

    public int save(Goods goods) throws SQLException{
       return goodsRepository.save(goods);
    }

    public int removeById(int id) throws SQLException {
        if(!goodsRepository.iaExistsById(id))
            return -1;
        return goodsRepository.removeById(id);
    }

    public DynamicArray findByName(String name) throws SQLException {
        return goodsRepository.findByName(name);
    }

    }
