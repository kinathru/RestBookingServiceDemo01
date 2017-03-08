package com.kinath.bookingservice.search;

/**
 * Created by Kinath on 3/7/2017.
 */
public class SearchCriteria
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

    @Override public String toString()
    {
        return "SearchCriteria{" + "bookingId=" + bookingId + ", bookingType='" + bookingType + '\'' + '}';
    }
}
