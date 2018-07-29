package service;

import entity.CategoryOneEntity;
import mapper.CategoryOneMapper;

public class CategoryOneService implements CategoryOneMapper {

    private CategoryOneMapper categoryOneMapper;

    @Override
    public void insert(CategoryOneEntity categoryOneEntity) {
        categoryOneMapper.insert(categoryOneEntity);
    }

    public CategoryOneMapper getCategoryOneMapper() {
        return categoryOneMapper;
    }

    public void setCategoryOneMapper(CategoryOneMapper categoryOneMapper) {
        this.categoryOneMapper = categoryOneMapper;
    }
}
