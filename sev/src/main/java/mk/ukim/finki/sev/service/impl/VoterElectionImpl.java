package mk.ukim.finki.sev.service.impl;

import mk.ukim.finki.sev.model.Voter;
import mk.ukim.finki.sev.repository.VoterRepository;
import mk.ukim.finki.sev.service.VoterElection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterElectionImpl implements VoterElection {

    private final VoterRepository voterRepository;

    public VoterElectionImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public List<Voter> findAll() {
        return this.voterRepository.findAll();
    }

    @Override
    public Voter findById(Long id) {
        return this.voterRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Voter save(Voter voter) {
        return this.voterRepository.save(voter);
    }

    @Override
    public Voter deleteById(Long id) {
        Voter voter = this.voterRepository.findById(id).orElseThrow(RuntimeException::new);
        this.voterRepository.deleteById(id);
        return voter;
    }
}
