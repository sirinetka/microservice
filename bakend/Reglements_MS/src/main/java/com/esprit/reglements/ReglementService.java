package com.esprit.reglements;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ReglementService {
	private final String FACTURE_SERVICE_URL = "http://localhost:8888/FACTURE-SERVICE/Factures/"; // URL du microservice facture

	@Autowired
	private RestTemplate restTemplate;
	
    @Autowired
    private ReglementRepository reglementRepository;

    public List<Reglement> getAll() {
        return reglementRepository.findAll();
    }

    public Reglement save(Reglement reglement) {
        // Exemple de mise à jour du statut de la facture
        String updateUrl = FACTURE_SERVICE_URL + "/" + reglement.getFactureId() + "/update-statut";
        try {
            restTemplate.put(updateUrl, "payed"); // Appel PUT ou POST selon l’API cible
        } catch (Exception e) {
            System.out.println("Erreur lors de la mise à jour de la facture : " + e.getMessage());
        }

        // TODO: Vérifier facture via API externe (FactureService)
        return reglementRepository.save(reglement);
    }

    public List<Reglement> findByFactureId(Long id) {
        return reglementRepository.findByFactureId(id);
    }


}
