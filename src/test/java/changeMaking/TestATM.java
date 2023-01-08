package changeMaking;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import ua.edu.ucu.apps.changeMaking.*;


public class TestATM {
    private static Handler handler50;

    @BeforeAll
    public static void setUp() {
        Handler handler5 = new Handler5();
        Handler handler10 = new Handler10();
        Handler handler25 = new Handler25();
        handler50 = new Handler50();

        handler50.setNextHandler(handler25);
        handler25.setNextHandler(handler5);
    }

    @Test
    public void testProcess() {
        ATM.process(100, handler50);
        ATM.process(80, handler50);
        ATM.process(60, handler50);
    }
}