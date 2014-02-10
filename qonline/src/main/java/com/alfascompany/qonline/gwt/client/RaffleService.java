package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.VOID;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("raffle")
public interface RaffleService extends RemoteService {

	VOID createRaffle(final Raffle raffle) throws Exception;

	Raffle getRaffle(final String id);

}
