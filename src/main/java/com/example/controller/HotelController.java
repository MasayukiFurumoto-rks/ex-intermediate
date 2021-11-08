package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String index() {
		return "ex02/hotel-search";
	}

	@RequestMapping("/searching")
	public String searchByLessThanPrice(HotelForm form, RedirectAttributes redirectAttributes) {
		List<Hotel> resultList;
		if (form.getPrice().isEmpty()) {
			resultList = service.searchByLessThanPrice(300000);
		} else {
			resultList = service.searchByLessThanPrice(form.getIntPrice());
		}

		redirectAttributes.addFlashAttribute("resultList", resultList);
		return "redirect:/ex02";
	}

}
