package com.alfascompany.process;

public interface RetryableFuture<T> extends Retryable {

	T getValue();
}
