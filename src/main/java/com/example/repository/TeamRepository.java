package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

@Repository
public class TeamRepository {
	@Autowired
	private NamedParameterJdbcTemplate template ;
	
	private final RowMapper<Team> TEAM_ROW_MAPPER = (rs,i)->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	public Team findById(Integer id) {
		String sql = "SELECT * FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
	}
	
	public List<Team> findAll() {
		String sql = "SELECT * FROM teams ORDER BY inauguration asc ;";
		return template.query(sql,TEAM_ROW_MAPPER);
	}
	
}
