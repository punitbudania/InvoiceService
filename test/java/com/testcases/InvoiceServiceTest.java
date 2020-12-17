package com.testcases;


import com.invoiceservice.InvoiceGenerator;
import com.invoiceservice.InvoiceSummary;
import com.invoiceservice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest
{
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() throws Exception
    {
        invoiceGenerator = new InvoiceGenerator();
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
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        Ride[] rides = { new Ride(2, 5),
                            new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
