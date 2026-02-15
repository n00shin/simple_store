package service;

import dto.GoodsInventory;
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

    public int incrementInventory(int id,int number) throws SQLException {
        if(!goodsRepository.iaExistsById(id))
            return -1;
        return goodsRepository.incrementInventory(id, number);
    }

    public int decrementInventory(int id,int number) throws SQLException {
        GoodsInventory byId = goodsRepository.findById(id);
        if(byId == null)
            return -1;
        if(byId.inventory()<number)
            return -2;

       return goodsRepository.decrementInventory( id, number);

    }

    public int sumOFALllGoods() throws SQLException {
       return goodsRepository.sumOFALllGoods();
    }



    }
