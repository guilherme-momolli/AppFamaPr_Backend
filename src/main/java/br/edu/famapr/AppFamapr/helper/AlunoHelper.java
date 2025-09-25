package br.edu.famapr.AppFamapr.helper;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoRequestDTO;
import br.edu.famapr.AppFamapr.model.Aluno;
import br.edu.famapr.AppFamapr.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoHelper {

    @Autowired
    private final AlunoService alunoService;

    public AlunoHelper(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

//    public Aluno resolveAluno(AlunoRequestDTO aluno){
//        if (aluno == null) return null;
//        return aluno.getId() == null
//                    ? alunoService.create(aluno)
//                    : alunoService.findById(aluno.getId());
//    }
}
