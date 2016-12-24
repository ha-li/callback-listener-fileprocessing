package com.external.exceptions;

/**
 * Created by hlieu on 12/23/16.
 */
public class FileProcessingException
       extends RuntimeException {
   public FileProcessingException() {
      this("FileProcessingException");
   }

   public FileProcessingException (String message) {
      this(message, null);
   }

   public FileProcessingException (String message, Throwable cause) {
      this(message, cause, false, true);
   }

   public FileProcessingException (String message,
                                   Throwable cause,
                                   boolean enableSuppression,
                                   boolean writeableStraceTrace) {
      super(message, cause, enableSuppression, writeableStraceTrace);
   }

   public FileProcessingException (Throwable cause){
      this("FileProcessingException", cause, false, true);
   }

}
