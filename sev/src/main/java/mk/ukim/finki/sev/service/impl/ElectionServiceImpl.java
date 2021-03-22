package mk.ukim.finki.sev.service.impl;

import mk.ukim.finki.sev.model.Election;
import mk.ukim.finki.sev.repository.ElectionRepository;
import mk.ukim.finki.sev.service.ElectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;

    public ElectionServiceImpl(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @Override
    public List<Election> findAll() {
        return this.electionRepository.findAll();
    }

    @Override
    public Election findById(Long id) {
        return this.electionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Election save(Election election) {
        return this.electionRepository.save(election);
    }

    @Override
    public Election deleteById(Long id) {
        Election election = this.electionRepository.findById(id).orElseThrow(RuntimeException::new);
        this.electionRepository.deleteById(id);
        return election;
    }
}
