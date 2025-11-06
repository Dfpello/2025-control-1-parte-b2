package es.upm.grise.profunduzacion.cruiseController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import es.upm.grise.profundizacion.exceptions.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.exceptions.SpeedSetAboveSpeedLimitException;

class CruiseControlTest {
    Speedometer speedometer;
	CruiseControl cruiseControl = new CruiseControl(speedometer);
    
    @org.junit.jupiter.api.Test
    void testSetSpeedSetCorrect() {
        try {
            cruiseControl.setSpeedSet(80);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(80, cruiseControl.getSpeedSet());
    }

    @org.junit.jupiter.api.Test
    void testSetSpeedSetIncorrect() {
        assertThrows(IncorrectSpeedSetException.class, () -> {cruiseControl.setSpeedSet(-10);});
    }

    @org.junit.jupiter.api.Test
    void testSetSpeedSetAboveLimit() {
        cruiseControl.setSpeedLimit(100);
        assertEquals(100, cruiseControl.getSpeedLimit());
        assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {cruiseControl.setSpeedSet(120);});
    }
}
