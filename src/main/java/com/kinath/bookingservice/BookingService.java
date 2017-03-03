package com.kinath.bookingservice;

import com.kinath.bookingservice.util.BookingLoaderUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kinath on 2/25/2017.
 */
@CrossOrigin
@RestController
public class BookingService
{
    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public Booking loadBooking( @RequestParam(value = "bookingId", required = true) long bookingId )
    {
        return BookingLoaderUtil.loadBooking( bookingId );
    }

    @RequestMapping(value = "/{bookingId}/bookingItems", method = RequestMethod.GET)
    public List<BookingItem> getBookingItems( @PathVariable(value = "bookingId") long bookingId )
    {
        return BookingLoaderUtil.loadBookingItems( bookingId );
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.GET)
    public List<Booking> loadAllBookings()
    {
        return BookingLoaderUtil.loadBookingsList();
    }

    @RequestMapping(value = "/addbooking", method = RequestMethod.POST)
    public String addBooking( @RequestBody Booking booking )
    {
        return BookingLoaderUtil.addBooking( booking );
    }

    public ResponseEntity<List<Booking>> searchBookings( HttpServletRequest httpServletRequest)
    {
        List<Booking> filteredBookings = new ArrayList<Booking>();

        //TODO: Implement booking search method

        return new ResponseEntity<List<Booking>>( filteredBookings, HttpStatus.OK );
    }
}
