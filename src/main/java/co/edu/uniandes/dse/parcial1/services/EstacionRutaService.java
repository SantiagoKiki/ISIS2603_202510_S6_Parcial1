package co.edu.uniandes.dse.parcial1.services;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.entities.RutaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.repositories.EstacionRepository;
import co.edu.uniandes.dse.parcial1.repositories.RutaRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EstacionRutaService {


    @Autowired
	private EstacionRepository estacionRepository;

	@Autowired
	private RutaRepository rutaRepository;


    @Transactional
    public void removeEstacionRuta(Long bookId, Long authorId) throws EntityNotFoundException {
		log.info("Inicia proceso de borrar un autor del libro con id = {0}", bookId);
		Optional<RutaEntity> authorEntity = rutaRepository.findById(authorId);
		Optional<EstacionEntity> bookEntity = estacionRepository.findById(bookId);

		if (authorEntity.isEmpty())
			throw new EntityNotFoundException("Ruta no encontrada");

		if (bookEntity.isEmpty())
			throw new EntityNotFoundException("Estaciòn no encontrada");

		bookEntity.get().getRutas().remove(authorEntity.get());

		log.info("Termina proceso de borrar un autor del libro con id = {0}", bookId);
	}


    @Transactional
	public RutaEntity addEstacionRuta (Long bookId, Long authorId) throws EntityNotFoundException {
		log.info("Inicia proceso de asociarle un autor al libro con id = {0}", bookId);
		Optional<RutaEntity> authorEntity = rutaRepository.findById(authorId);
		if (authorEntity.isEmpty())
			throw new EntityNotFoundException("No encontrado");

		Optional<EstacionEntity> bookEntity = estacionRepository.findById(bookId);
		if (bookEntity.isEmpty())
			throw new EntityNotFoundException("No encontrado");

		bookEntity.get().getRutas().add(authorEntity.get());
		log.info("Termina proceso de asociarle una ruta a una estacion = {0}", bookId);
		return authorEntity.get();
	}


    public List<RutaEntity> getRutas(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRutas'");
    }

}
