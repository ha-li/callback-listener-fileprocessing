package com.external;

import com.external.events.FileCreateEvent;
import com.external.events.FileDeleteEvent;
import com.external.events.FileReadEvent;

/**
 * Created by hlieu.
 */
public class SimpleFileProcessor {

   private FileProcessor fileProcessor;
   public SimpleFileProcessor() {
      this.fileProcessor = new FileProcessor ();
   }

   private void addListener(FileEventListener listener) {
      this.fileProcessor.addListener (listener);
   }

   private void read (String file) {
      String content = this.fileProcessor.read(file);
      System.out.println (content);
   }

   public static void main (String[] args) {
      SimpleFileProcessor sfp = new SimpleFileProcessor ();
      sfp.addListener (new DatabaseLoginEventListener ());
      sfp.addListener (new SimpleFileProcessorEventListener ());
      sfp.read("./src/main/resources/sample.txt");
   }

   private static class DatabaseLoginEventListener extends FileAdapter {
      public void delete (FileDeleteEvent event) {
         System.out.println ("DB insert record for deleting " + event.getName());
      }

      public void create (FileCreateEvent event) {
         System.out.println ("DB insert record for creating " + event.getName());
      }

      public void read (FileReadEvent event) {
         System.out.println ("DB insert record for reading " + event.getName());
      }
   }

   private static class SimpleFileProcessorEventListener
           extends FileAdapter {

      @Override
      public void delete (FileDeleteEvent event) {
         System.out.println ("Deleting file " + event.getName());
      }

      @Override
      public void create (FileCreateEvent event) {
         System.out.println ("Creating file " + event.getName());
      }

      @Override
      public void read (FileReadEvent event) {
         System.out.println ("Reading file " + event.getName() );
      }
   }
}
