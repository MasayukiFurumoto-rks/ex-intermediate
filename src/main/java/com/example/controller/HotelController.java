package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/ex02")
public class HotelController {

	@Autowired
	private HotelService service;

	@ModelAttribute
	private HotelForm setUpForm() {
		return new HotelForm();
	}

	@RequestMapping("")
	public String index(Model model) {
		return "ex02/hotel-search";
	}

	@RequestMapping("/searching")
	public String searchByLessThanPrice(@Validated HotelForm form,BindingResult result,Model model, RedirectAttributes redirectAttributes) {
		
		
		List<Hotel> resultList;
		if (form.getPrice().isEmpty()) {
			resultList = service.searchByLessThanPrice(300000);
		} else {
			if(result.hasErrors()) {
				return index(model);
			}
			resultList = service.searchByLessThanPrice(form.getIntPrice());
		}
		
//		データベースに1件もホテルが登録されてない場合はメッセージを表示したい
		if(resultList.size() == 0) {
			model.addAttribute("message", "該当するデータはありません。");
		}else {
			model.addAttribute("resultList", resultList);
		}
		return "/ex02/hotel-search";
	}

}
