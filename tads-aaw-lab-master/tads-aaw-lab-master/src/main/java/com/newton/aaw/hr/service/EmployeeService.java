package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newtonpaiva.av2.microempresa.api.MicroEmpresaDto;
import br.newtonpaiva.av2.microempresa.domain.MicroEmpresa;
import br.newtonpaiva.av2.microempresa.domain.repository.MicroEmpresaRepository;
import br.newtonpaiva.av2.microempresa.exceptions.NotFoundException;

@Service
public class MicroEmpresaService {
	
	@Autowired
	private MicroEmpresaRepository microEmpresaRepository;

	public MicroEmpresa findById(String id) throws NotFoundException {
		MicroEmpresa microEmpresa = microEmpresaRepository.findById(id).orElse(null);
		if(microEmpresa == null)
			throw new NotFoundException("Não encontrada");
		return microEmpresa;
	}
	
	public List<MicroEmpresa> findAll() {
		return microEmpresaRepository.findAll();
	}
	
	public MicroEmpresa create(MicroEmpresaDto microEmpresaDto) {
		MicroEmpresa microEmpresa = new MicroEmpresa(microEmpresaDto);
		microEmpresa.setDataDeCadastro(LocalDateTime.now());
		return microEmpresaRepository.save(microEmpresa);
	}
	
	public void delete(String id) throws NotFoundException {
		MicroEmpresa microEmpresa = findById(id);
		
		microEmpresaRepository.delete(microEmpresa);
	}
}
