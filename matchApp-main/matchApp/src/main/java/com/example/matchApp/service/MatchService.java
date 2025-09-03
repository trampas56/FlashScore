package com.example.matchApp.service;

import java.util.List;

import com.example.matchApp.model.Match;
import com.example.matchApp.model.MatchOdd;

public interface MatchService {
	void saveMatch(Match match);
	List<Match> getMatches();
	void deleteMatch(int id);
	List<MatchOdd> getMatchOdds(int id);
	void addOdd(MatchOdd odd, int matchId);
	void deleteOdd(int id);
	MatchOdd getMatchOdd(int oddId);
	Match getMatch(int id);
}
