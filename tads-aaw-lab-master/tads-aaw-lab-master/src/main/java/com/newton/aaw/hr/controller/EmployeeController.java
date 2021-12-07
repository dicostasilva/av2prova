package com.newton.aaw.hr.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.av2.microempresa.api.MicroEmpresaDto;
import br.newtonpaiva.av2.microempresa.exceptions.NotFoundException;
import br.newtonpaiva.av2.microempresa.service.MicroEmpresaService;

@RestController
@RequestMapping("/microempresas")
public class MicroEmpresaController {

	@Autowired
	private MicroEmpresaService microEmpresaService;
	
	@GetMapping()
	public ResponseEntity<List<MicroEmpresaDto>> get() {
		List<MicroEmpresaDto> microEmpresaDtos = microEmpresaService.findAll().stream()
				.map(MicroEmpresaDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(microEmpresaDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MicroEmpresaDto> get(@PathVariable String id) throws NotFoundException {
		return ResponseEntity.ok(new MicroEmpresaDto(microEmpresaService.findById(id)));
	}
	
	@PostMapping()
	public ResponseEntity<MicroEmpresaDto> save(@RequestBody MicroEmpresaDto microEmpresaDto) {
		return ResponseEntity.ok(new MicroEmpresaDto(microEmpresaService.create(microEmpresaDto)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) throws NotFoundException {
		microEmpresaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
