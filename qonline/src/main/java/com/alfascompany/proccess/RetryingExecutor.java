package com.alfascompany.proccess;

import java.util.concurrent.RunnableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RetryingExecutor {

	public static void execute(final int maxRetryingTimes, final int increasingTimeBetween, final Runnable runnable) throws Exception {

		executeImpl(maxRetryingTimes, 0, increasingTimeBetween, runnable);
	}

	public static <T> T execute(final int maxRetryingTimes, final int increasingTimeBetween, final RunnableFuture<T> runnable) throws Exception {

		executeImpl(maxRetryingTimes, 0, increasingTimeBetween, runnable);
		return runnable.get();
	}

	private static void executeImpl(final int maxRetryingTimes, int retryingTimes, final int increasingTimeBetween, final Runnable runnable) throws Exception {

		try {
			runnable.run();
		} catch (final Exception e) {

			retryingTimes++;
			if (maxRetryingTimes == retryingTimes) {
				throw new Exception("No more execution retries! Exception is [" + e.getMessage() + "]");
			}
			Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
			sleep(increasingTimeBetween * retryingTimes);
			executeImpl(maxRetryingTimes, retryingTimes, increasingTimeBetween, runnable);
		}
	}

	private static void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		} catch (final InterruptedException e) {
			// nothing to do
		}
	}
}
