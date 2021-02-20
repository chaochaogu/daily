package com.chaochaogu.dao.db1;

import com.chaochaogu.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据主键Id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 选择性插入
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主键Id查询
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据主键Id选择性更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键Id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}