package com.douzone.doki.exception;

public class MemoServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MemoServiceException() {
		super("GalleryServiceException Occurs");
	}

	public MemoServiceException(String message) {
		super(message);
	}
	
}