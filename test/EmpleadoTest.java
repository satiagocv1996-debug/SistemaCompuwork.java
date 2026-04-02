import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    @Test
    public void testCrearEmpleado() {

        Empleado e = new EmpleadoPermanente(1, "Juan", "Dev");

        assertEquals(1, e.getId());
        assertEquals("Juan", e.getNombre());
        assertEquals("Dev", e.getCargo());
        assertEquals("Permanente", e.getTipo());
    }
}