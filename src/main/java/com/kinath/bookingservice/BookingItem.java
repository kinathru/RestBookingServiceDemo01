package com.kinath.bookingservice;

/**
 * Created by Kinath on 2/26/2017.
 */
public class BookingItem
{
    private long bookingId;
    private int itemNo;
    private String productType;

    public long getBookingId()
    {
        return bookingId;
    }

    public void setBookingId( long bookingId )
    {
        this.bookingId = bookingId;
    }

    public int getItemNo()
    {
        return itemNo;
    }

    public void setItemNo( int itemNo )
    {
        this.itemNo = itemNo;
    }

    public String getProductType()
    {
        return productType;
    }

    public void setProductType( String productType )
    {
        this.productType = productType;
    }

    @Override public String toString()
    {
        return "BookingItem{" + "bookingId=" + bookingId + ", itemNo=" + itemNo + ", productType='" + productType + '\'' + '}';
    }
}
