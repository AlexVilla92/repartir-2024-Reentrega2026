package ar.com.grupoesfera.repartir.steps.gastos;

import ar.com.grupoesfera.repartir.exceptions.GrupoInvalidoException;
import ar.com.grupoesfera.repartir.model.Gasto;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MontoNegativoSteps extends FastCucumberSteps {

    private Grupo grupo;
    private Gasto gasto;
    private Exception excepcion;

    @Dado("que existe un grupo con los miembros {string} y {string}")
    public void queExisteUnGrupoConLosMiembros(String miembro1, String miembro2) {
        grupo = new Grupo();
        grupo.setMiembros(Arrays.asList(miembro1, miembro2));
    }

    @Cuando("{string} registra un gasto de {int} pesos")
    public void registraUnGastoDePesos(String miembro, Integer monto) {
        gasto = new Gasto();
        gasto.setMonto(new BigDecimal(monto));
        try {
            grupo.agregarGasto(gasto);
        } catch (GrupoInvalidoException e) {
            excepcion = e;
        }
    }

    @Cuando("{string} intenta registrar un gasto de {int} pesos")
    public void intentaRegistrarUnGastoDePesos(String miembro, Integer monto) {
        gasto = new Gasto();
        gasto.setMonto(new BigDecimal(monto));
        try {
            grupo.agregarGasto(gasto);
        } catch (GrupoInvalidoException e) {
            excepcion = e;
        }
    }

    @Entonces("el gasto queda registrado en el grupo")
    public void elGastoQuedaRegistradoEnElGrupo() {
        assertThat(excepcion).isNull();
    }

    @Entonces("el sistema rechaza el gasto")
    public void elSistemaRechazaElGasto() {
        assertThat(excepcion).isInstanceOf(GrupoInvalidoException.class);
    }
}
