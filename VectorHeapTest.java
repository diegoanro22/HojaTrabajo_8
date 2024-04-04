import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VectorHeapTest {
    @Test
    public void testAddAndRemove() {
        VectorHeapCollection<Paciente> heap = new VectorHeapCollection<>();
        heap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        
        assertEquals("Maria Ramirez, apendicitis, A", heap.remove().toString());
        assertEquals("Juan Perez, fractura de pierna, C", heap.remove().toString());
    }
}