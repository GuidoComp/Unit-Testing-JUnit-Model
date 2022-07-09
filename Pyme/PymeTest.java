package Pyme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PymeTest {

    @Test
    void agregarPrimerEmpleadoDeberiaDarCero() {
        Pyme p = new Pyme();
        assertEquals(0, p.altaDeEmpleado("36158190", "Companc", 100000));
    }

    @Test
    void agregarSegundoEmpleadoDeberiaDarUno() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Companc", 100000);
        assertEquals(1, p.altaDeEmpleado("34295648", "Perez", 100000));
    }

    @Test
    void agregarCuartoEmpleadoDeberiaDarMenosUno() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Companc", 100000);
        p.altaDeEmpleado("26598623", "Gimenez", 95000);
        p.altaDeEmpleado("12345689", "Suarez", 95000);
        assertEquals(-1, p.altaDeEmpleado("25648956", "Rodriguez", 100000));
    }

    @Test
    void bajaEmpleadoConocidoDeberiaDevolverAlEmpleado() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Companc", 100000);
        p.altaDeEmpleado("26598623", "Gimenez", 95000);
        assertEquals(p.getEmpleados()[0], p.bajaDeEmpleado("36158190"));
    }

    @Test
    void bajaEmpleadoDesconocidoDeberiaDevolverNull() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Companc", 100000);
        p.altaDeEmpleado("26598623", "Gimenez", 95000);
        assertNull(p.bajaDeEmpleado("654"));
    }

    @Test
    void bajaEmpleadoConocidoDespuesDeUnNullDevuelveAlEmpleado() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Companc", 100000);
        p.altaDeEmpleado("26598623", "Gimenez", 95000);
        p.bajaDeEmpleado("36158190");
        assertEquals(p.getEmpleados()[1], p.bajaDeEmpleado("26598623"));
    }

    @Test
    void cantVacantesDeberiaDarDos() {
        Pyme p = new Pyme();
        p.altaDeEmpleado("36158190", "Gomez", 150000);
        assertEquals(2, p.cantVacantes());
    }

    @Test
    void sueldoTotal() {
        Pyme p = new Pyme();
        double[] arrayEsperado = new double[3];
        p.altaDeEmpleado("65498", "Perez", 250000);
        p.altaDeEmpleado("4952", "Gonzalez", 180000);
        p.altaDeEmpleado("8462", "Sanchez", 120000);
        arrayEsperado[0] = 250000;
        arrayEsperado[1] = 180000;
        arrayEsperado[2] = 120000;
        assertArrayEquals(arrayEsperado, p.sueldoTotal());
    }
}