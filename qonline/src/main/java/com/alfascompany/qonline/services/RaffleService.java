package com.alfascompany.qonline.services;

import java.util.List;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.services.VOID;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("raffle")
public interface RaffleService extends RemoteService {

	VOID createRaffle(final Raffle raffle) throws Exception;

	Raffle getRaffle(final String id) throws Exception;

	List<Raffle> getRaffles() throws Exception;
}
