package Pyme;

public class Empleado {
    private String dni;
    private String apellido;
    private double sueldo;

    public Empleado(String dni, String apellido, double sueldo) {
        this.dni = dni;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    protected double getSueldo() {
        return sueldo;
    }

    protected String getDni() {
        return dni;
    }
}
