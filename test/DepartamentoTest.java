import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DepartamentoTest {

    @Test
    public void testAgregarEmpleado() {

        Departamento d = new Departamento("IT");
        Empleado e = new EmpleadoTemporal(2, "Ana", "QA");

        d.agregarEmpleado(e);

        assertEquals(1, d.getEmpleados().size());
    }

    @Test
    public void testPromedio() {

        Departamento d = new Departamento("IT");

        Empleado e1 = new EmpleadoPermanente(1, "Carlos", "Dev");
        Empleado e2 = new EmpleadoTemporal(2, "Luis", "QA");

        e1.setRendimiento(4);
        e2.setRendimiento(3);

        d.agregarEmpleado(e1);
        d.agregarEmpleado(e2);

        assertEquals(3.5, d.calcularPromedio(), 0.01);
    }
}