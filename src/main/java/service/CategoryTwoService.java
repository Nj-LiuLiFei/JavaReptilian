package service;

import entity.CategoryTwoEntity;
import mapper.CategoryTwoMapper;

public class CategoryTwoService implements CategoryTwoMapper {

    private CategoryTwoMapper categoryTwoMapper;

    @Override
    public void insert(CategoryTwoEntity categoryTwoEntity) {
        categoryTwoMapper.insert(categoryTwoEntity);
    }

    public CategoryTwoMapper getCategoryTwoMapper() {
        return categoryTwoMapper;
    }

    public void setCategoryTwoMapper(CategoryTwoMapper categoryTwoMapper) {
        this.categoryTwoMapper = categoryTwoMapper;
    }
}
