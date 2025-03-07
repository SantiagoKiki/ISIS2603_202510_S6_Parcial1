package co.edu.uniandes.dse.parcial1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.repositories.EstacionRepository;
import co.edu.uniandes.dse.parcial1.repositories.RutaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RutaService {

    @Autowired
	RutaRepository rutaRepository;

    public void createRuta(EstacionEntity newBook) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createRuta'");
    }
    

    
}
