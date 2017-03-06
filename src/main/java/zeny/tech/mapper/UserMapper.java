package zeny.tech.mapper;

import org.apache.ibatis.annotations.Param;

import zeny.tech.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /*-----------------------------------------------扩展方法-------------------------------------------------------*/

    User selectUserByOpenId(@Param("openId")String openId);

}