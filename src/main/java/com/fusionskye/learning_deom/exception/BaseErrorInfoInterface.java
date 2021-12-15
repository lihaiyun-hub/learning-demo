package com.fusionskye.learning_deom.exception;

public interface BaseErrorInfoInterface {
    /** 错误码*/
	 String getResultCode();
	
	/** 错误描述*/
	 String getResultMsg();
}