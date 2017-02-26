package com.kinath.bookingservice;

/**
 * Created by Kinath on 2/25/2017.
 */
public class Booking
{
    private long bookingId;
    private String bookingType;

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
}
