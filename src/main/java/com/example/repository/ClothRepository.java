package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * clothesテーブルを操作するレポジトリクラスです。<br>
 * 
 * @author cyjoh
 *
 */
@Repository
public class ClothRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<Cloth> CLOTH_ROW_MAPPER = new BeanPropertyRowMapper<>(Cloth.class);

	/**
	 * clothesテーブルから、外部で指定されたcolorとgenderを使って検索を行うメソッドです。<br>
	 * 
	 * @param color  検索画面で指定された色
	 * @param gender 検索画面で指定された性別
	 * @return 該当する色と性別を持つ洋服のリスト
	 */
	public List<Cloth> findByColorAndGender(String color, Integer gender) {
		String sql = "SELECT * FROM clothes WHERE color = :color and gender = :gender ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);

		return template.query(sql, param, CLOTH_ROW_MAPPER);

	}
}
