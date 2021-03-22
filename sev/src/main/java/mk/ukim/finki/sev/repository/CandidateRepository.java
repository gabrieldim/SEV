package mk.ukim.finki.sev.repository;

import mk.ukim.finki.sev.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
