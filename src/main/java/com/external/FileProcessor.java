package com.external;

import com.external.events.FileCreateEvent;
import com.external.events.FileDeleteEvent;
import com.external.events.FileEvent;
import com.external.events.FileReadEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by hlieu on 12/23/16.
 */
public class FileProcessor {
   private final Set<FileEventListener> listeners;

   public FileProcessor () {
      listeners = new CopyOnWriteArraySet<FileEventListener> ();
   }

   public void addListener (FileEventListener listener) {
      if(listeners != null) {
         listeners.add(listener);
      }
   }

   private void raiseEvent (FileEvent event) {
      for (FileEventListener listener : listeners) {
         event.accept(listener);
      }
   }

   public synchronized String read (String file) {
      try {
         Path path = Paths.get (file);
         String contents = new String (Files.readAllBytes (path));

         raiseEvent (new FileReadEvent (file));
         return contents;
      } catch (IOException ioe) {
         ioe.printStackTrace ();
      }
      return null;
   }

   public synchronized  void create (String file) {
      raiseEvent (new FileCreateEvent (file) );
   }

   public synchronized void delete () {
      raiseEvent (new FileDeleteEvent ("name"));
   }
}
