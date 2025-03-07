package co.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.entities.RutaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.services.EstacionRutaService;
import co.edu.uniandes.dse.parcial1.services.EstacionService;
import co.edu.uniandes.dse.parcial1.services.RutaService;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
public class EstacionRutaServiceTest {

@Autowired
	private EstacionRutaService authorBookService;

	@Autowired
	private RutaService bookService;
    
	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();



	private RutaEntity author = new RutaEntity();
	private EstacionEntity editorial = new EstacionEntity();
    private List<RutaEntity> rutaList = new ArrayList<>();


    @BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

    private void clearData() {
		entityManager.getEntityManager().createQuery("delete from PrizeEntity").executeUpdate();
		entityManager.getEntityManager().createQuery("delete from BookEntity").executeUpdate();
		entityManager.getEntityManager().createQuery("delete from AuthorEntity").executeUpdate();
	}

    private void insertData() {
		for (int i = 0; i < 3; i++) {
			RutaEntity authorEntity = factory.manufacturePojo(RutaEntity.class);
			entityManager.persist(authorEntity);
			rutaList.add(authorEntity);
		}
	}


    @Test
	void testAddEstacionRuta() throws EntityNotFoundException, IllegalOperationException {
		EstacionEntity newBook = factory.manufacturePojo(EstacionEntity.class);
		newBook.setRutas(rutaList);

		bookService.createRuta(newBook);

		RutaEntity bookEntity = authorBookService.addEstacionRuta(editorial.getId(), newBook.getId());
		assertNotNull(bookEntity);

		assertEquals(bookEntity.getId(), newBook.getId());

	}

    	@Test
	void testRemoveBook() throws EntityNotFoundException {
		for (RutaEntity book : rutaList) {
			authorBookService.removeEstacionRuta(author.getId(), book.getId());
		}
		assertTrue(authorBookService.getRutas(author.getId()).isEmpty());
	}
}
