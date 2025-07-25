package com.beneficios.application;

import com.beneficios.domain.Beneficio;
import com.beneficios.domain.BeneficioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficioService {
    private final BeneficioRepository repository;

    public BeneficioService(BeneficioRepository repository) {
        this.repository = repository;
    }

    public Beneficio criar(Beneficio beneficio) {
        beneficio.setAtivo(true);
        return repository.save(beneficio);
    }

    public List<Beneficio> listar() {
        return repository.findAll();
    }

    public void ativar(Long id) {
        repository.findById(id).ifPresent(b -> {
            b.setAtivo(true);
            repository.save(b);
        });
    }

    public void desativar(Long id) {
        repository.findById(id).ifPresent(b -> {
            b.setAtivo(false);
            repository.save(b);
        });
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
