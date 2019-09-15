package com.RezaAk.web.DojoAndNinja.servces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RezaAk.web.DojoAndNinja.models.Dojo;
import com.RezaAk.web.DojoAndNinja.repositories.DojoRepo;


@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	public void add(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	public List<Dojo> all() {
		return (List<Dojo>) dojoRepo.findAll();
	}
	public Optional<Dojo> getOne(Long id) {
		return dojoRepo.findById(id);
		
	}
}