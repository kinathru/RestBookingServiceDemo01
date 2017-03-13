package com.kinath.bookingservice.util;

/**
 * Created by Kinath on 3/13/2017.
 */
public class Logger
{
    public enum LoggerType
    {
        BKG_SERVICE( "Booking Service", "BKG_SERVICE" );

        String loggerType;
        String loggerTypeCode;

        LoggerType( String loggerType, String loggerTypeCode )
        {
            this.loggerType = loggerType;
            this.loggerTypeCode = loggerTypeCode;
        }

        public String getLoggerType()
        {
            return loggerType;
        }

        public String getLoggerTypeCode()
        {
            return loggerTypeCode;
        }
    }
}
