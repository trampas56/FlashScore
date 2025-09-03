package com.example.matchApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.matchApp.DAO.MatchDAO;
import com.example.matchApp.DAO.MatchOddDAO;
import com.example.matchApp.model.Match;
import com.example.matchApp.model.MatchOdd;

@Service
public class MatchServiceImpl implements MatchService {
    
    @Autowired
    private MatchDAO matchDAO; 
    @Autowired
    private MatchOddDAO matchOddsDAO; 
    
    @Override
    public void saveMatch(Match match) {
        matchDAO.save(match);
    }

	@Override
	public List<Match> getMatches() {
		return matchDAO.findAll();
	}

	@Override
	public void deleteMatch(int id) {
		matchDAO.deleteById(id);
	}
	
	@Override
	public List<MatchOdd> getMatchOdds(int id) {
		Optional<Match> match = matchDAO.findById(id);
		if(match.isPresent()) {
			return match.get().getOdds();
		}else {
			throw new NullPointerException("Cannot find match odd with id = " + id);
		}
		
	}
	
	@Override
	public MatchOdd getMatchOdd(int id) {
		Optional<MatchOdd> matchOdd = matchOddsDAO.findById(id);
		if(matchOdd.isPresent()) {
			return matchOdd.get();
		}else {
			throw new NullPointerException("Cannot find match odd with id = " + id);
		}
	}
	
	@Override
	public void addOdd(MatchOdd odd, int matchId) {
		Match match = matchDAO.findById(matchId).get();
		odd.setMatch(match);
		matchOddsDAO.save(odd);
		return;
	}

	@Override
	public void deleteOdd(int id) {
		matchOddsDAO.deleteById(id);
	}
	
	@Override
	public Match getMatch(int id) {
		Optional<Match> match = matchDAO.findById(id);
		if(match.isPresent()) {
			return match.get();
		}else {
			throw new NullPointerException("Cannot find match with id = " + id);
		}
		
	}		
}