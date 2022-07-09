package Pyme;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Pyme {
    private static final int CANT_EMPLEADOS_PYME = 3;
    private Empleado[] empleados;

    public Pyme() {
        this.empleados = new Empleado[CANT_EMPLEADOS_PYME];
    }

    //SOLO PARA TESTING. BORRAR!!!!!
    protected Empleado[] getEmpleados() {
        return empleados;
    }

    protected double[] sueldoTotal() {
        double[] vector = new double[CANT_EMPLEADOS_PYME - this.cantVacantes()];
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null) {
                vector[i] = empleados[i].getSueldo();
            }
        }
        return vector;
    }

    protected int cantVacantes() {
        int cantVacantes = 0;
        int index = 0;

        while (index < empleados.length) {
            if (empleados[index] == null) {
                cantVacantes++;
            }
            index++;
        }
        return cantVacantes;
    }

    protected int altaDeEmpleado(String dni, String apellido, double sueldo) {
        int pos = -1;
        int index = 0;
        boolean agregado = false;

        while (index < empleados.length && !agregado) {
            if (empleados[index] == null) {
                empleados[index] = new Empleado(dni, apellido, sueldo);
                agregado = true;
                pos = index;
            } else {
                index++;
            }
        }
        return pos;
    }

    protected Empleado bajaDeEmpleado(String dni) {
        int pos = -1;
        Empleado e = null;
        pos = getPosEmpleado(dni);

        if (pos != -1) {
            e = empleados[pos];
            empleados[pos] = null;
        }
        return e;
    }

    private int getPosEmpleado(String dni) {
        int pos = -1;
        int index = 0;
        boolean encontrado = false;

        while (index < empleados.length && !encontrado) {
            if (empleados[index] != null) {
                if (empleados[index].getDni().equals(dni)) {
                    encontrado = true;
                    pos = index;
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }
        return pos;
    }
}
