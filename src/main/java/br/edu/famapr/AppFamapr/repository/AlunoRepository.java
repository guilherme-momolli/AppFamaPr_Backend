package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {



}
