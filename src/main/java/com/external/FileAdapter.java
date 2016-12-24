package com.external;

import com.external.events.FileCreateEvent;
import com.external.events.FileDeleteEvent;
import com.external.events.FileReadEvent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by hlieu on 12/23/16.
 *
 * Your file processing class should extend this class,
 * and override the default method implementation
 */
public class FileAdapter
        implements FileEventListener {

   public void delete (FileDeleteEvent event) {
      throw new NotImplementedException ();
   }

   public void create (FileCreateEvent event) {
      throw new NotImplementedException ();
   }

   public void read (FileReadEvent event) {
      throw new NotImplementedException ();
   }
}
