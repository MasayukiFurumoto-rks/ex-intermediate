package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテル検索アプリケーションを動かすためのコントローラークラス。
 * 
 * @author cyjoh
 *
 */
@Controller
@RequestMapping("/ex02")
public class HotelController {

	@Autowired
	private HotelService service;

	@ModelAttribute
	private HotelForm setUpForm() {
		return new HotelForm();
	}

	/**
	 * ex-intermediate/ex02にアクセスした時に実行されるメソッド。<br>
	 * 結果のない検索画面を表示する。
	 * 
	 * @param model リクエストスコープ
	 * @return ホテル検索画面のURL
	 */
	@RequestMapping("")
	public String index(Model model) {
		return "ex02/hotel-search";
	}

	/**
	 * 検索を実行するメソッド。<br>
	 * フォームに送られたものが空欄の場合は300000を、そうでなければ入力値をエラーチェックしてからサービスクラスに送る。
	 * 検索結果が0件の場合はメッセージを、そうでなければ検索結果をリクエストスコープに格納。
	 * 検索&結果表示画面に遷移します。
	 * 
	 * @param form　フォームの入力内容
	 * @param result 入力値エラーチェックの結果
	 * @param model リクエストスコープ
	 * @return 検索&結果表示画面
	 */
	@RequestMapping("/searching")
	public String searchByLessThanPrice(@Validated HotelForm form,BindingResult result,Model model) {
		
		List<Hotel> resultList;
			if(result.hasErrors()) {
				return index(model);
			}
			resultList = service.searchByLessThanPrice(form.getPrice());
		
		//	検索結果が0件の場合はメッセージを表示
		if(resultList.size() == 0) {
			model.addAttribute("message", "該当するデータはありません。");
		}else {
			model.addAttribute("resultList", resultList);
		}
		return "/ex02/hotel-search";
	}

}
