package service;

import model.Category;
import repository.CategoryRepository;

import java.sql.SQLException;

public class CategoryService {

private final CategoryRepository categoryRepository;
public CategoryService() {
        this.categoryRepository = new CategoryRepository();
}
    public int save(String name) throws SQLException {
        if (categoryRepository.isExistByName( name))
        return -1;
    return categoryRepository.save(name);

    }
}