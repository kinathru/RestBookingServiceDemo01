package com.kinath.bookingservice.util;

/**
 * Created by Kinath on 2/26/2017.
 */
public class Constants
{
    public static enum BookingType
    {
        PKG( "PKG", "Pre-built package" ), TMD( "TMD", "Tailer-made package" ), DP( "DP", "Dynamic Package" ), EP( "EP", "Elite Package" );

        private final String code;
        private final String name;

        BookingType( String code, String name )
        {
            this.code = code;
            this.name = name;
        }

        public String getCode()
        {
            return code;
        }

        public String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return "BookingType{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
        }
    }

    public static enum ProductType
    {
        TOU( "TOU", "Tour" ), FLT( "FLT", "Flight" ), HTL( "HTL", "Hotel" ), GEN( "GEN", "Generic" ), CAR( "CAR", "Car" ), TRS( "TRS", "Transfer" ),;

        private String productCode;
        private String productName;

        ProductType( String productCode, String productName )
        {
            this.productCode = productCode;
            this.productName = productName;
        }

        public String getProductCode()
        {
            return productCode;
        }

        public String getProductName()
        {
            return productName;
        }

        @Override
        public String toString()
        {
            return "ProductType{" + "productCode='" + productCode + '\'' + ", productName='" + productName + '\'' + '}';
        }
    }
}
