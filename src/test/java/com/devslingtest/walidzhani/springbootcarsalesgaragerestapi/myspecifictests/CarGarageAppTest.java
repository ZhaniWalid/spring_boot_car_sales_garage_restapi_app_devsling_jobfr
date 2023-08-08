package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.myspecifictests;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.enums.FuelType;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.enums.Transmission;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.pojo_dto_classes.CarDTO;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.CarServ.CarServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll; // This static import should be written manually @the 1st time else it will not be recognised by the IDE
import static org.junit.jupiter.api.Assertions.assertEquals; // This static import should be written manually @the 1st time else it will not be recognised by the IDE
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarGarageAppTest {
    private String failureMsgMakeName = "Failed because the ''Car Make'' for the -- carDtoObj -- is << ASTON MARTIN >>, but it's NOT";
    private String failureMsgRegistrationDate = "Failed because the ''Registration Date'' for the -- carDtoObj -- is << 2015 >>, but it's NOT";
    private String failureMsgFuelType = "Failed because the ''Fuel Type'' for the -- carDtoObj -- is << DIESEL >>, but it's NOT";

    private final CarDTO carDtoObj = new CarDTO(
        "ASTON MARTIN", "DB 9", 2015, 75000, FuelType.DIESEL.toString(), 152000, Transmission.SEMI_AUTOMATIC.toString(), "resources/static/images/1__2018-Honda-Civic-LX.jpg"
    );

    @Test
    void doSomeStandardAssertsTests() {
        // TESTS for the "MAKE" of the Car
        assertEquals(carDtoObj.getMake(), "ASTON MARTIN"); // PASS
        // assertEquals(carDtoObj.getMake(), "WALID", failureMsgMakeName); // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                           // Uncomment to see the case of TEST FAILURE

        // TESTS for the "Registration Date" of the Car
        assertEquals(carDtoObj.getRegistrationDate(), 2015); // PASS
        // assertEquals(carDtoObj.getRegistrationDate(), 2017, failureMsgRegistrationDate); // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                                           // Uncomment to see the case of TEST FAILURE

        // TESTS for the "Fuel Type" of the Car
        assertEquals(carDtoObj.getFuelType(), "DIESEL"); // PASS
        // assertEquals(carDtoObj.getFuelType(), "HYBRID", failureMsgFuelType); // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                                   // Uncomment to see the case of TEST FAILURE
    }

    @Test
    void doSomeGroupedAssertsTests() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("carDtoObj",
                //-- TESTS for the "MAKE" of the Car
                () -> assertEquals(carDtoObj.getMake(), "ASTON MARTIN"), // PASS
                // () -> assertEquals(carDtoObj.getMake(), "WALID", failureMsgMakeName), // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                                           // Uncomment to see the case of TEST FAILURE
                //-- TESTS for the "Registration Date" of the Car
                () -> assertEquals(carDtoObj.getRegistrationDate(), 2015), // PASS
                // () -> assertEquals(carDtoObj.getRegistrationDate(), 2017, failureMsgRegistrationDate), // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                                                            // Uncomment to see the case of TEST FAILURE
                //-- TESTS for the "Fuel Type" of the Car
                () -> assertEquals(carDtoObj.getFuelType(), "DIESEL") //, // PASS
                // () -> assertEquals(carDtoObj.getFuelType(), "HYBRID", failureMsgFuelType) // FAIL -- Commented to avoid failure when RUNNING TEST PROCESS
                                                                                                 // Uncomment to see the case of TEST FAILURE
        );
    }
}