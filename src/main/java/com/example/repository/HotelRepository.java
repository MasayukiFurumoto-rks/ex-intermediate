package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するレポジトリクラスです。<br>
 * 
 * @author cyjoh
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

	/**
	 * @param price フォームに入力された価格です。もし入力されていなければ上限の300000円が渡されます。
	 * @return 入力された価格以下の価格を持つホテルのリストを返します。
	 * 
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		String sql = "SELECT * FROM hotels WHERE price <= :price ORDER BY price desc;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
}
