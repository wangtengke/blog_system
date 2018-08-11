package com.blog.wtk.Mapper;

import com.blog.wtk.Model.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ArticleMapper {
    @Delete({
        "delete from article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into article (id, title, ",
        "describes, content, ",
        "created_date, commentCount, ",
        "category)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{describes,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{createdDate,jdbcType=DATE}, #{commentcount,jdbcType=INTEGER}, ",
        "#{category,jdbcType=VARCHAR})"
    })
    int insert(Article record);

    @InsertProvider(type=ArticleSqlProvider.class, method="insertSelective")
    int insertSelective(Article record);

    @Select({
        "select",
        "id, title, describes, content, created_date, commentCount, category",
        "from article",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="describes", property="describes", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.DATE),
        @Result(column="commentCount", property="commentcount", jdbcType=JdbcType.INTEGER),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR)
    })
    Article selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, title, describes, content, created_date, commentCount, category",
            "from article"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="describes", property="describes", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="created_date", property="createdDate", jdbcType=JdbcType.DATE),
            @Result(column="commentCount", property="commentcount", jdbcType=JdbcType.INTEGER),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR)
    })
    List<Article> selectAll();

    @UpdateProvider(type=ArticleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Article record);

    @Update({
        "update article",
        "set title = #{title,jdbcType=VARCHAR},",
          "describes = #{describes,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "created_date = #{createdDate,jdbcType=DATE},",
          "commentCount = #{commentcount,jdbcType=INTEGER},",
          "category = #{category,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Article record);
}