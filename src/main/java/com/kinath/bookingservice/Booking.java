package com.kinath.bookingservice;

import java.util.List;

/**
 * Created by Kinath on 2/25/2017.
 */
public class Booking
{
    private long bookingId;
    private String bookingType;
    private List<BookingItem> bookingItems;

    public long getBookingId()
    {
        return bookingId;
    }

    public void setBookingId( long bookingId )
    {
        this.bookingId = bookingId;
    }

    public String getBookingType()
    {
        return bookingType;
    }

    public void setBookingType( String bookingType )
    {
        this.bookingType = bookingType;
    }

    public List<BookingItem> getBookingItems()
    {
        return bookingItems;
    }

    public void setBookingItems( List<BookingItem> bookingItems )
    {
        this.bookingItems = bookingItems;
    }

    @Override
    public String toString()
    {
        return "Booking{" + "bookingId=" + bookingId + ", bookingType='" + bookingType + '\'' + ", bookingItems=" + bookingItems + '}';
    }
}
