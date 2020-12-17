package com.invoiceservice;

public class Ride
{
    public final double distance;
    public final int time;
    public CabRide cabRide;

    public Ride(CabRide cabRide, double distance, int time)
    {
        this.cabRide = cabRide;
        this.distance = distance;
        this.time = time;
    }

}
