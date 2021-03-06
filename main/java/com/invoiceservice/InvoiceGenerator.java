package com.invoiceservice;

public class InvoiceGenerator
{
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5;
    public RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository)
    {
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance, int time)
    {
        double totalFare = distance*MINIMUM_COST_PER_KILOMETER + time*COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides)
    {
        double totalFare = 0;
        for (Ride ride: rides) {
            totalFare += ride.cabRide.calcCostOfCabRide(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides)
    {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId)
    {
        return calculateFare(rideRepository.getRides(userId));
    }

}
