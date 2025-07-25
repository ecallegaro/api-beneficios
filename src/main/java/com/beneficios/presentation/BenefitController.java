package com.beneficios.presentation;

import com.beneficios.application.BeneficioService;
import com.beneficios.domain.model.Benefit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefits")
public class BenefitController {
    //TODO: criar controle de autenticacao caso chamada seja fora do cluster
    //TODO: Não usar a entidade de domínio diretamente nos endpints, usar dto.
    //TODO: Mapear campos uteis na entidade Beneficio com time de negocios.

    private final BeneficioService service;

    public BenefitController(BeneficioService service) {
        this.service = service;
    }

    @PostMapping
    public Benefit criar(@RequestBody Benefit beneficio) {
        return service.criar(beneficio);
    }

    @GetMapping
    public List<Benefit> listar() {
        return service.listar();
    }

    @PutMapping("/{id}/activate")
    public void ativar(@PathVariable Long id) {
        service.ativar(id);
    }

    @PutMapping("/{id}/deactivate")
    public void desativar(@PathVariable Long id) {
        service.desativar(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
