package mk.ukim.finki.sev.service;

import mk.ukim.finki.sev.model.Election;

import java.util.List;

public interface ElectionService {
    List<Election> findAll();
    Election findById(Long id);
    Election save(Election election);
    Election deleteById(Long id);
}
