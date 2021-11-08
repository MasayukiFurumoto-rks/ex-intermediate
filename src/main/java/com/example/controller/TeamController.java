package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

@Controller
@RequestMapping("/ex01")
public class TeamController {

	@Autowired
	private TeamService service;
	
	@RequestMapping("")
	public String showList(Model model) {
		List<Team> teamList = service.showList();
		model.addAttribute("teamList",teamList);
		return "/ex01/team-list";
	}
	
	@RequestMapping("show-detail")
	public String showDetail(Model model,Integer id) {
		Team team = service.showDetail(id);
		model.addAttribute("team",team);
		return "/ex01/team-detail";
	}
}
