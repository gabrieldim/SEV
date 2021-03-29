package mk.ukim.finki.sev.controller;

import mk.ukim.finki.sev.model.Candidate;
import mk.ukim.finki.sev.model.User;
import mk.ukim.finki.sev.repository.CandidateRepository;
import mk.ukim.finki.sev.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/vote")
public class VotingController {

    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    public VotingController(CandidateRepository candidateRepository, UserRepository userRepository) {
        this.candidateRepository = candidateRepository;
        this.userRepository = userRepository;
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

    @GetMapping("/hasvoted")
    public String getHasVotedPage() {
        return "has-voted";
    }

    @PostMapping
    public String vote(@RequestParam String vote, Principal principal) {

        String username = principal.getName();

        User user = this.userRepository.findByUsername(username).get();

        if(!user.getHasVoted()) {
            Candidate candidate = this.candidateRepository.findById(Long.parseLong(vote)).get();
            candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1);
            this.candidateRepository.save(candidate);
            user.setHasVoted(true);
            this.userRepository.save(user);
            return "redirect:/vote/results";
        }

        if(user.getHasVoted()) {
            return "redirect:/vote/hasvoted";
        }
        return "redirect:/";
    }



}
