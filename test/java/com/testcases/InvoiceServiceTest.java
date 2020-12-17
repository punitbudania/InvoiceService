package com.testcases;


import com.invoiceservice.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest
{
    Ride[] rides = null;
    InvoiceGenerator invoiceGenerator = null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository =null;

    @Before
    public void setUp() throws Exception
    {
        invoiceGenerator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        invoiceGenerator.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.4, fare, 0.4);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare()
    {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.4, fare, 0.4);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary()
    {
        String userId = "a@b.com";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
