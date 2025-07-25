package com.beneficios.application;

import com.beneficios.domain.exception.BeneficioException;
import com.beneficios.domain.exception.BeneficioNotFoundException;
import com.beneficios.domain.model.Benefit;
import com.beneficios.domain.model.BenefitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BeneficioService {
    public static final String MSG_ERRO_AO_SALVAR_O_BENEFICIO = "Erro ao salvar o beneficio: ";
    public static final String MSG_BENEFICIO_NAO_LOCALIZADO = "Benefício não localizado.";
    private final BenefitRepository repository;

    public BeneficioService(BenefitRepository repository) {
        this.repository = repository;
    }

    public Benefit criar(Benefit beneficio) {
        try {
            beneficio.setAtivo(true);
            return repository.save(beneficio);
        } catch(Exception e) {
            throw new BeneficioException(MSG_ERRO_AO_SALVAR_O_BENEFICIO, e);
        }
    }

    public List<Benefit> listar() {
        return repository.findAll();
    }

    public void ativar(Long id) {
        var beneficio = repository.findById(id).orElseThrow(() -> new BeneficioNotFoundException(MSG_BENEFICIO_NAO_LOCALIZADO));
        beneficio.setAtivo(true);
        repository.save(beneficio);
    }

    public void desativar(Long id) {
        var beneficio = repository.findById(id).orElseThrow(() -> new BeneficioNotFoundException(MSG_BENEFICIO_NAO_LOCALIZADO));
        beneficio.setAtivo(false);
        repository.save(beneficio);
    }

    public void excluir(Long id) {
        var beneficio = repository.findById(id).orElseThrow(() -> new BeneficioNotFoundException(MSG_BENEFICIO_NAO_LOCALIZADO));
        log.info("Beneficio exclusão: %s".formatted(beneficio));
        if (beneficio.isAtivo()) throw new BeneficioException("Benefício não pode ser removido porque está ativo.");
        repository.deleteById(id);
    }
}
