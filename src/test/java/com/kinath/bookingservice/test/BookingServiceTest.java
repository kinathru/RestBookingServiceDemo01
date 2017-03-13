package com.kinath.bookingservice.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kinath.bookingservice.Booking;
import com.kinath.bookingservice.search.SearchCriteria;
import com.kinath.bookingservice.util.BookingLoaderUtil;
import com.kinath.bookingservice.util.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

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

    public static void searchBookingTestWithBookingId()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setBookingId( 10505 );
        List<Booking> responseBookings = searchBookingsAndGetResults( searchCriteria );
        Booking resultBooking = null;
        if( responseBookings != null && responseBookings.size() > 0 )
        {
            resultBooking = responseBookings.get( 0 );
            Assert.assertEquals( String.format( "Search with Criteria : %s ", searchCriteria.toString()  ), searchCriteria.getBookingId(),resultBooking.getBookingId() );
        }
    }

    private static List<Booking> searchBookingsAndGetResults( SearchCriteria searchCriteria )
    {
        List<Booking> responseBookings = null;
        String postUrl = "http://localhost:8080/RestBookingServiceDemo01/searchBooking";
        HttpClient httpClient = HttpClientBuilder.create().build();
        Gson gson = new Gson();
        String jsonString = gson.toJson( searchCriteria );
        System.out.println( jsonString );

        Type bookingListType = new TypeToken<List<Booking>>()
        {
        }.getType();

        HttpPost postRequest = new HttpPost( postUrl );
        try
        {
            StringEntity stringEntity = new StringEntity( jsonString );
            postRequest.setEntity( stringEntity );
            HttpResponse response = httpClient.execute( postRequest );

            HttpEntity responseEntity = response.getEntity();
            InputStream responseStream = responseEntity.getContent();
            InputStreamReader inputStreamReader = new InputStreamReader( responseStream );
            JsonReader jsonReader = new JsonReader( inputStreamReader );
            responseBookings = gson.fromJson( jsonReader, bookingListType );
            System.out.println( "Completed Successfully" );

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

        return responseBookings;
    }

    public static void main( String[] args )
    {
        //addBookingTest();
        //searchBookingTest();
        searchBookingTestWithBookingId();
    }
}
