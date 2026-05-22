package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.exceptions.GrupoInvalidoException;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MiembrosDuplicadosSteps extends FastCucumberSteps {

    private Grupo grupo;
    private Exception excepcion;

    @Cuando("el usuario intenta crear un grupo con los miembros {string} y {string}")
    public void elUsuarioIntentaCrearUnGrupoConLosMiembros(String miembro1, String miembro2) {
        grupo = new Grupo();
        grupo.setMiembros(Arrays.asList(miembro1, miembro2));
        try {
            grupo.validar();
        } catch (GrupoInvalidoException e) {
            excepcion = e;
        }
    }

    @Entonces("el grupo queda formado correctamente")
    public void elGrupoQuedaFormadoCorrectamente() {
        assertThat(excepcion).isNull();
    }

    @Entonces("el sistema rechaza la creación del grupo")
    public void elSistemaRechazaLaCreacionDelGrupo() {
        assertThat(excepcion).isInstanceOf(GrupoInvalidoException.class);
    }
}
