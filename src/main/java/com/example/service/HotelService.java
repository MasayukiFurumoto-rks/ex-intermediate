package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * フォームに入力された情報を使って、検索業務を行うサービスクラスです。<br>
 * 
 * @author cyjoh
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;

	/**
	 * @param price　フォームに入力された価格です。もし入力されていなければ上限の300000円をレポジトリクラスに渡します。
	 * @return　入力された価格以下の価格を持つホテルのリストを返します。
	 * 
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		if (price == null) {
			return repository.searchByLessThanPrice(300000);
		}
		return repository.searchByLessThanPrice(price);
	}

}
