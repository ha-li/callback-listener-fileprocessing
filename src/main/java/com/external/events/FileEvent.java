package com.external.events;

import com.external.FileEventListener;

/**
 * Created by hlieu on 12/23/16.
 */
public abstract class FileEvent {
   String name;

   public FileEvent (String name) {
      this.name = name;
   }

   public abstract void accept(FileEventListener listener);

   public String getName() {
      return this.name;
   }
}
