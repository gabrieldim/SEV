package mk.ukim.finki.sev.controller;

import mk.ukim.finki.sev.model.Candidate;
import mk.ukim.finki.sev.repository.CandidateRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vote")
public class VotingController {

    private final CandidateRepository candidateRepository;

    public VotingController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping
    public String getVotingPage(Model model) {
        model.addAttribute("candidates", this.candidateRepository.findAll());
        return "vote-for-candidate";
    }

    @GetMapping("/results")
    public String getResultsPage(Model model) {
        model.addAttribute("candidates", this.candidateRepository.findAll());
        return "results";
    }

    @PostMapping
    public String vote(@RequestParam String vote) {
        Candidate candidate = this.candidateRepository.findById(Long.parseLong(vote)).get();
        candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1);
        this.candidateRepository.save(candidate);
        return "redirect:/vote/results";
    }



}
