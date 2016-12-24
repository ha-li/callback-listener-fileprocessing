package com.external.events;

import com.external.FileEventListener;

/**
 * Created by hlieu on 12/23/16.
 */
public class FileReadEvent extends FileEvent {

   public FileReadEvent (String name) {
      super(name);
   }

   public void accept (FileEventListener listener) {
      listener.read(this);
   }
}
