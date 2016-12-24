package com.external;

import com.external.events.FileCreateEvent;
import com.external.events.FileDeleteEvent;
import com.external.events.FileReadEvent;

/**
 * Created by hlieu on 12/23/16.
 */
public class SimpleFileProcessor {

   private FileProcessor fileProcessor;
   public SimpleFileProcessor() {
      this.fileProcessor = new FileProcessor ();
      this.fileProcessor.addListener (new SimpleFileProcessorEventListener ());
   }

   public void read (String file) {
      String content = this.fileProcessor.read(file);
      System.out.println (content);
   }

   public static void main (String[] args) {
      SimpleFileProcessor sfp = new SimpleFileProcessor ();
      sfp.read("./src/main/resources/sample.txt");
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
