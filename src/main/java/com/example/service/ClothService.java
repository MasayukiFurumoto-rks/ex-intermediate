package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 検索処理に伴う業務を行うメソッドです。<br>
 * 
 * @author cyjoh
 * 
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository repository;
	
	/**
	 * 色と性別を使った検索処理を行うメソッドです。
	 * 
	 * @param color 検索画面で指定された色です。
	 * @param gender 検索画面で指定された性別です。
	 * @return List<Cloth> 指定された色と性別を持つ洋服のリストを返します。
	 */
	public List<Cloth> searchByColorAndGender(String color, Integer gender){
		return repository.findByColorAndGender(color, gender);
	}
	
}
