package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository repository;

	public List<Team> showList() {
		return repository.findAll();
	}
	
	public Team showDetail(Integer id) {
		return repository.findById(id);
	}
	
}
