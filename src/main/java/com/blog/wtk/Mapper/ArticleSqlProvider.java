package com.blog.wtk.Mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.blog.wtk.Model.Article;

public class ArticleSqlProvider {

    public String insertSelective(Article record) {
        BEGIN();
        INSERT_INTO("article");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescribes() != null) {
            VALUES("describes", "#{describes,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            VALUES("created_date", "#{createdDate,jdbcType=DATE}");
        }
        
        if (record.getCommentcount() != null) {
            VALUES("commentCount", "#{commentcount,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            VALUES("category", "#{category,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Article record) {
        BEGIN();
        UPDATE("article");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescribes() != null) {
            SET("describes = #{describes,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            SET("created_date = #{createdDate,jdbcType=DATE}");
        }
        
        if (record.getCommentcount() != null) {
            SET("commentCount = #{commentcount,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            SET("category = #{category,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}