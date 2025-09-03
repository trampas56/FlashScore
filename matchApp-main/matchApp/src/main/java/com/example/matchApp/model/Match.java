package com.example.matchApp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="match")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="match_id")
	private int id;
	@Column(name="description")
	private String description;
	@Column(name="match_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate match_date;
	@Column(name="match_time")
	private String match_time;
	@Column(name="team_a")
	private String team_a;
	@Column(name="team_b")
	private String team_b;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sport")
	private Sport sport;
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	private List<MatchOdd> odds = new ArrayList<>();
	
	public List<MatchOdd> getOdds() {
		return odds;
	}
	public void setOdds(List<MatchOdd> odds) {
		this.odds = odds;
	}
	public String getMatch_time() {
		return match_time;
	}
	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getMatch_date() {
		return match_date;
	}
	public void setMatch_date(LocalDate match_date) {
		this.match_date = match_date;
	}
	public String getTeam_a() {
		return team_a;
	}
	public void setTeam_a(String team_a) {
		this.team_a = team_a;
	}
	public String getTeam_b() {
		return team_b;
	}
	public void setTeam_b(String team_b) {
		this.team_b = team_b;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
}
