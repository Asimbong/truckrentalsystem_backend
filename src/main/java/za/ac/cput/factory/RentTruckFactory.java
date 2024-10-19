package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class RentTruckFactory {
    public static RentTruck buildRentTruck(int rentId, LocalDate rentDate, LocalDate returnDate,
                                           double totalCost, boolean isPaymentMade,boolean isReturned,
                                           Customer customer,
                                           Truck truck,
                                           Branch pickUp, Branch dropOff,
                                           RentalStatus status ) {


        if (Helper.isIntNotValid(rentId)
                || returnDate == null
                || customer == null
                || truck == null
                || pickUp == null
                || dropOff == null) {
            return null;
        }

        return new RentTruck.Builder()
                .setRentId(rentId)
                .setRentDate(rentDate)
                .setReturnDate(returnDate)
                .setTotalCost(totalCost)
                .setPaymentMade(isPaymentMade)
                .setReturned(isReturned)
                .setCustomerID(customer)
                .setVin(truck)
                .setPickUp(pickUp)
                .setDropOff(dropOff)
                .setStatus(RentalStatus.ACTIVE)
                .build();
    }
}
