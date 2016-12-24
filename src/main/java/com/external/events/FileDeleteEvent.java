package com.external.events;

import com.external.FileEventListener;

/**
 * Created by hlieu on 12/23/16.
 */
public class FileDeleteEvent extends FileEvent {

   public FileDeleteEvent (String fileName) {
      super(fileName);
   }

   public void accept(FileEventListener listener) {
      listener.delete(this);
   }
}
