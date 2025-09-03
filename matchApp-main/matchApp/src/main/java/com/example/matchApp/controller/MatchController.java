package com.example.matchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.matchApp.model.Match;
import com.example.matchApp.model.MatchOdd;
import com.example.matchApp.service.MatchService;

@Controller
public class MatchController {
	@Autowired
	private MatchService matchService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String addMatch(Model model) {
		model.addAttribute("match", new Match());
		return "match/add-match";
	}
	
	@RequestMapping("/updateMatch")
	public String addMatch(Model model, @RequestParam("matchId") int matchId) {
		model.addAttribute("match", matchService.getMatch(matchId));
		return "match/add-match";
	}
	
	@RequestMapping("/showMatches")
	public String showMatches(Model model) {
		
		model.addAttribute("matches", matchService.getMatches());
		return "match/show-matches";
	}
	
	@RequestMapping("/deleteMatch")
	public String deleteMatch(@RequestParam("matchId") int matchId) {
		
		matchService.deleteMatch(matchId);
		return "redirect:/showMatches";
	}
	
	@RequestMapping("/showOdds")
	public String showOdds(Model model, @RequestParam("matchId") int matchId) {
		model.addAttribute("odds", matchService.getMatchOdds(matchId));
		model.addAttribute("matchId", matchId);
		return "odds/show-odds";
	}
	
	@RequestMapping("/addOdd")
	public String addOdd(Model model, @RequestParam("matchId") int matchId) {
		model.addAttribute("odd", new MatchOdd());
		model.addAttribute("matchId", matchId);
		return "odds/add-odd";
	}
	
	@PostMapping("/addOdd")
    public String addOdd(@RequestParam("matchId") int matchId, @ModelAttribute MatchOdd odd) {
		matchService.addOdd(odd, matchId);
        return "redirect:/showOdds?matchId="+matchId;
    }
	
	@RequestMapping("/save")
    public String createMatch(@ModelAttribute("match") Match match) {
        matchService.saveMatch(match);
        return "redirect:/showMatches";
    }
	
	@RequestMapping("/updateOdd")
	public String updateOdd(Model model, @RequestParam("matchId") int matchId, @RequestParam("oddId") int oddId) {
		model.addAttribute("odd", matchService.getMatchOdd(oddId));
		model.addAttribute("matchId", matchId);
		
		return "odds/add-odd";
	}

	@RequestMapping("/deleteOdd")
	public String deleteOdd(@RequestParam("matchId") int matchId, @RequestParam("oddId") int oddId) {
		matchService.deleteOdd(oddId);
		return "redirect:/showOdds?matchId="+matchId;
	}
}
