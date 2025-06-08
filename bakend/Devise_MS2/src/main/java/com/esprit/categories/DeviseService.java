package com.esprit.categories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.categories.dto.ConversionRequest;
import com.esprit.categories.dto.ConversionResponse;

@Service
public class DeviseService {
    @Autowired
    private DeviseRepository repo;

    public ConversionResponse convertir(ConversionRequest req) {
        Devise source = repo.findById(req.getDeviseSource()).orElseThrow();
        Devise cible = repo.findById(req.getDeviseCible()).orElseThrow();

        double montantConverti = req.getMontant() * (cible.getTauxChange() / source.getTauxChange());

        return new ConversionResponse(req.getMontant(), montantConverti, 
                                      cible.getTauxChange(), cible.getDateMaj());
    }

    public List<Devise> getAll() {
        return repo.findAll();
    }

    public Devise updateTaux(String code, double taux) {
        Devise d = repo.findById(code).orElseThrow();
        d.setTauxChange(taux);
        d.setDateMaj(LocalDateTime.now());
        return repo.save(d);
    }

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
