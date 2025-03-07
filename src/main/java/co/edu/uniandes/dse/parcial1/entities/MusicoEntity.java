package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

public class MusicoEntity {

    private String name;
    private String tipo;

    @PodamExclude
	@OneToMany(mappedBy = "trabajo", fetch = FetchType.LAZY)
	private List<RutaEntity> estaciones = new ArrayList<>();

}
