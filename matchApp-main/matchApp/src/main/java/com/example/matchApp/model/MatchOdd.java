package com.example.matchApp.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matchOdds")
public class MatchOdd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
	private Match match;
	@Column(name="specifier")
	private String specifier; 
	@Column(name="odd")
	private double odd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public String getSpecifier() {
		return specifier;
	}
	public void setSpecifier(String specifier) {
		this.specifier = specifier;
	}
	public double getOdd() {
		return odd;
	}
	public void setOdd(double odd) {
		this.odd = odd;
	}
}
