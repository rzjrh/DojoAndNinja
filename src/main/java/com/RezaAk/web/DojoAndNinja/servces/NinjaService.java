package com.RezaAk.web.DojoAndNinja.servces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RezaAk.web.DojoAndNinja.models.Ninja;
import com.RezaAk.web.DojoAndNinja.repositories.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	public void add(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	public List<Ninja> all() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
}