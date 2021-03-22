package mk.ukim.finki.sev.service;

import mk.ukim.finki.sev.model.Voter;

import java.util.List;
import java.util.Optional;

public interface VoterElection {
    List<Voter> findAll();
    Voter findById(Long id);
    Voter save(Voter voter);
    Voter deleteById(Long id);
}
