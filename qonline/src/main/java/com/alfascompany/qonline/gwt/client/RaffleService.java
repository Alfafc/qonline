package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.gwt.shared.Raffle;
import com.alfascompany.qonline.gwt.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;

public interface RaffleService extends RemoteService {

	Raffle createRaffle(User user, String name, float percentageProfit);

	Raffle getRaffle(String id);

}
