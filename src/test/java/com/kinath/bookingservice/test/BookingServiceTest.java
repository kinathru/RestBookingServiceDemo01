package com.kinath.bookingservice.test;

import com.google.gson.Gson;
import com.kinath.bookingservice.Booking;
import com.kinath.bookingservice.search.SearchCriteria;
import com.kinath.bookingservice.util.BookingLoaderUtil;
import com.kinath.bookingservice.util.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by kinath on 07/03/2017.
 */
public class BookingServiceTest
{
    public static void addBookingTest()
    {
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost( "http://localhost:8080/RestBookingServiceDemo01/addbooking" );
        Gson gson = new Gson();

        Booking booking = new Booking();
        booking.setBookingId( 11403 );
        booking.setBookingType( Constants.BookingType.TMD.getCode() );
        BookingLoaderUtil.addBookingItems( BookingLoaderUtil.bookingList.size() + 1, booking );

        try
        {
            StringEntity params = new StringEntity( gson.toJson( booking ) );
            request.setEntity( params );
            request.setHeader( "Content-type","application/json" );
            HttpResponse response = client.execute( request );
        }
        catch( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        catch( ClientProtocolException e )
        {
            e.printStackTrace();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    public static void searchBookingTest()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setBookingId( 10503 );
        searchCriteria.setBookingType( Constants.BookingType.EP.getCode() );

        String postUrl = "http://localhost:8080/RestBookingServiceDemo01/searchBooking";
        HttpClient httpClient = HttpClientBuilder.create().build();
        Gson gson = new Gson();

        try
        {
            String jsonString = gson.toJson( searchCriteria );
            System.out.println(jsonString);

            HttpPost postRequest = new HttpPost( postUrl );
            StringEntity entity = new StringEntity( jsonString );
            postRequest.setEntity( entity );
            HttpResponse response = httpClient.execute( postRequest );

            System.out.println("Completed Successfully");
        }
        catch( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        catch( ClientProtocolException e )
        {
            e.printStackTrace();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        //addBookingTest();
        searchBookingTest();
    }
}
