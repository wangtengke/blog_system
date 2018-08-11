package com.blog.wtk.Mapper;

import com.blog.wtk.Model.User_Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface User_InfoMapper {
    @Delete({
        "delete from user_info",
        "where User_Id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user_info (User_Id, UserName, ",
        "password, age, sex, ",
        "email, role)",
        "values (#{userId,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{sex,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR})"
    })
    int insert(User_Info record);

    @InsertProvider(type=User_InfoSqlProvider.class, method="insertSelective")
    int insertSelective(User_Info record);

    @Select({
        "select",
        "User_Id, UserName, password, age, sex, email, role",
        "from user_info",
        "where User_Id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="User_Id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR)
    })
    User_Info selectByPrimaryKey(Integer userId);

    @Select({
            "select",
            "count(*)",
            "from user_info",
            "where UserName = #{username,jdbcType=VARCHAR}"
    })
    int selectAll(User_Info record); //查询username相同的个数

    @Select({
            "select",
            "count(*)",
            "from user_info",
            "where UserName = #{username,jdbcType=VARCHAR} and Password = #{password,jdbcType=VARCHAR}"
    })
    int Username_Password_Is_Same(User_Info record); //查询username相同的个数
    @UpdateProvider(type=User_InfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User_Info record);

    @Update({
        "update user_info",
        "set UserName = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=VARCHAR}",
        "where User_Id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User_Info record);
}