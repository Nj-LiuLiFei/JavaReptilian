package service;

import entity.CategoryThreeEntity;
import mapper.CategoryThreeMapper;

public class CategoryThreeService implements CategoryThreeMapper {

    private CategoryThreeMapper categoryThreeMapper;

    @Override
    public void insert(CategoryThreeEntity categoryThreeEntity) {
        categoryThreeMapper.insert(categoryThreeEntity);
    }

    public CategoryThreeMapper getCategoryThreeMapper() {
        return categoryThreeMapper;
    }

    public void setCategoryThreeMapper(CategoryThreeMapper categoryThreeMapper) {
        this.categoryThreeMapper = categoryThreeMapper;
    }
}
