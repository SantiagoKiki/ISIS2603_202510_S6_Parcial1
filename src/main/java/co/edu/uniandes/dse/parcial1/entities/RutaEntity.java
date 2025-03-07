package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class RutaEntity extends BaseEntity {
    
    enum TIPO_RUTA {
		DIURNA, NOCTURNA, CIRCULAR
	}

    private String nombre;
    private String color;
    private String tipo;



    @PodamExclude
	@OneToMany(mappedBy = "estaciones", fetch = FetchType.LAZY)
	private List<EstacionEntity> estaciones = new ArrayList<>();


    @PodamExclude
	@ManyToOne
	private MusicoEntity musicoSubido;


    public void remove(RutaEntity rutaEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


}


