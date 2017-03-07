package com.kinath.bookingservice.util;

import com.kinath.bookingservice.Booking;
import com.kinath.bookingservice.BookingItem;
import com.kinath.bookingservice.search.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kinath on 2/26/2017.
 */
public class BookingLoaderUtil
{
    public static List<Booking> bookingList = new ArrayList<Booking>();

    static
    {
        long counter = 10500;
        for( int bookingCount = 0 ; bookingCount < 100 ; bookingCount++ )
        {
            Booking booking = new Booking();
            booking.setBookingId( counter++ );

            setBookingType( bookingCount, booking );
            addBookingItems( bookingCount, booking );

            bookingList.add( booking );
        }
    }

    public static void addBookingItems( int bookingCount, Booking booking )
    {
        for( int bookingItemCount = 0 ; bookingItemCount < 3 ; bookingItemCount++ )
        {
            BookingItem bookingItem = new BookingItem();
            bookingItem.setBookingId( booking.getBookingId() );
            bookingItem.setItemNo( bookingItemCount );

            setItemProductType( bookingCount, bookingItemCount, bookingItem );
            booking.getBookingItems().add( bookingItem );
        }
    }

    private static void setItemProductType( int i, int j, BookingItem bookingItem )
    {
        switch( ( i + j ) % 6 )
        {
            case 0:
                bookingItem.setProductType( Constants.ProductType.HTL.getProductCode() );
                break;
            case 1:
                bookingItem.setProductType( Constants.ProductType.FLT.getProductCode() );
                break;
            case 2:
                bookingItem.setProductType( Constants.ProductType.TOU.getProductCode() );
                break;
            case 3:
                bookingItem.setProductType( Constants.ProductType.CAR.getProductCode() );
                break;
            case 4:
                bookingItem.setProductType( Constants.ProductType.TRS.getProductCode() );
                break;
            case 5:
                bookingItem.setProductType( Constants.ProductType.GEN.getProductCode() );
                break;
        }
    }

    private static void setBookingType( int i, Booking booking )
    {
        switch( i%4 )
        {
            case 0:
                booking.setBookingType( Constants.BookingType.PKG.getCode() );
                break;
            case 1:
                booking.setBookingType( Constants.BookingType.TMD.getCode() );
                break;
            case 2:
                booking.setBookingType( Constants.BookingType.DP.getCode() );
                break;
            case 3:
                booking.setBookingType( Constants.BookingType.EP.getCode() );
                break;
        }
    }

    public static List<Booking> loadBookingsList()
    {
        return bookingList;
    }

    public static Booking loadBooking(long bookingId)
    {
        for( Booking booking : bookingList )
        {
            if( booking.getBookingId() == bookingId )
            {
                return booking;
            }
        }
        return null;
    }

    public static List<BookingItem> loadBookingItems(long bookingId)
    {
        for( Booking booking : bookingList )
        {
            if( booking.getBookingId() == bookingId )
            {
                return booking.getBookingItems();
            }
        }
        return null;
    }

    public static String createAndAddBooking()
    {
        Booking booking = new Booking();
        booking.setBookingId( bookingList.get( bookingList.size() -1 ).getBookingId() +1 );
        setBookingType( (bookingList.size() + 1),booking ) ;
        for( int j = 0 ; j < 3 ; j++ )
        {
            BookingItem bookingItem = new BookingItem();
            bookingItem.setBookingId( booking.getBookingId() );
            bookingItem.setItemNo( j );

            setItemProductType( (bookingList.size() + 1), j, bookingItem );
        }
        bookingList.add( booking );

        return String.format( "Booking Added Successfully : %s ", booking.toString() );
    }

    public static String addBooking(Booking booking)
    {
        booking.setBookingId( bookingList.get( bookingList.size() -1 ).getBookingId() +1 );
        bookingList.add( booking );

        return String.format( "Booking Added Successfully : %s ", booking.toString() );
    }

    public static List<Booking> searchBookings( SearchCriteria searchCriteria )
    {
        List<Booking> bookings = new ArrayList<Booking>();

        for( Booking booking : bookingList )
        {
            if( ( searchCriteria.getBookingId() > 0 && searchCriteria.getBookingId() == booking.getBookingId() )
                    || ( ( searchCriteria.getBookingType() != null && searchCriteria.getBookingType().length() > 0 ) && searchCriteria.getBookingType().equals( booking.getBookingType() ) ) )
            {
                bookings.add( booking );
            }
        }

        return bookings;
    }

}
