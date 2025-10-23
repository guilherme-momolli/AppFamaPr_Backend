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


}
