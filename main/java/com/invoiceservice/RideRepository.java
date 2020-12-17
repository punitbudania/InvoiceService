package com.invoiceservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository
{
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository()
    {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides)
    {
        userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRides(String userId)
    {
        return userRides.get(userId).toArray(new Ride[0]);
    }
}
