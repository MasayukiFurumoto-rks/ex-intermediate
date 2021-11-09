package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

/**
 * 衣類検索アプリケーションを動かすためのコントローラークラスです。<br>
 * 
 * @author cyjoh
 *
 */
@Controller
@RequestMapping("/ex03")
public class ClothController {
	
	@Autowired
	private ClothService service;
	
	@Autowired
	private ServletContext application;
	
	/**
	 * /intermediate/ex03にアクセスした時に実行されるメソッド。
	 * 検索用画面を返します。
	 * 
	 * @return 検索用画面のURL
	 */
	@RequestMapping("")
	public String index() {
		Map<Integer,String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		application.setAttribute("genderMap",genderMap);
		
		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黃");
		application.setAttribute("colorList",colorList);
		
		return "/ex03/clothes-search";
		
	}
	
	/**
	 * 指定された色と性別を使って検索を行い、結果をリクエストスコープに格納するメソッドです。
	 * 
	 * @param color　指定された色
	 * @param gender　指定された性別
	 * @param model リクエストスコープ
	 * @return
	 */
	@RequestMapping("/searching")
	public String searchByColorAndGender(String color ,Integer gender,Model model) {
		List<Cloth> clothList = service.searchByColorAndGender(color, gender);
		
		if(clothList.size()==0) {
			model.addAttribute("message", "お探しの商品はありません");
		}else{
			model.addAttribute("clothList", clothList);
		}
		return "/ex03/clothes-search";
	}
}
