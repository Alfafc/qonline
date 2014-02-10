package com.alfascompany.qonline.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface RaffleServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.alfascompany.qonline.gwt.client.RaffleService
     */
    void createRaffle( com.alfascompany.qonline.bean.Raffle raffle, AsyncCallback<com.alfascompany.qonline.bean.VOID> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.alfascompany.qonline.gwt.client.RaffleService
     */
    void getRaffle( java.lang.String id, AsyncCallback<com.alfascompany.qonline.bean.Raffle> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static RaffleServiceAsync instance;

        public static final RaffleServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (RaffleServiceAsync) GWT.create( RaffleService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
