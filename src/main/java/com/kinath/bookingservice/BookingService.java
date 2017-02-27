package com.kinath.bookingservice;

import com.kinath.bookingservice.util.BookingLoaderUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kinath on 2/25/2017.
 */
@RestController
public class BookingService
{
    public Booking loadBooking(long bookingId)
    {
        return BookingLoaderUtil.loadBooking( bookingId );
    }

    public List<Booking> loadAllBookings()
    {
        return BookingLoaderUtil.loadBookingsList();
    }

    public String addBooking(Booking booking)
    {
        return BookingLoaderUtil.addBooking(booking);
    }
}
