package com.external;

import com.external.events.FileCreateEvent;
import com.external.events.FileDeleteEvent;
import com.external.events.FileReadEvent;

/**
 * Created by hlieu on 12/23/16.
 *
 * The event listener abstraction.
 * Implements methods for capturing events sourced from File class.
 * <p/>
 * Typically your application will implement this interface to capture
 * the follwoing events:
 * <br/>
 * <code>FileDeletedEvent</code>
 * <code>FileCreatedEvent</code>
 * <code>FileReadEvent</code>
 * <p/>
 * <p/>
 * In addition to implementing this interface, your
 * application should register itself as an FileEventListener which
 * may look somewhat like this:
 *
 * public class MyFileListener implements FileEventListener {
 *
 *    public void delete (FileDeletedEvent event) {
 *       System.out.println ("File has been deleted");
 *    }
 *
 *    public void create (FileCreatedEvent event) {
 *       System.out.println ("File has been created");
 *    }
 *
 *    public void read (FileReadEvent event) {
 *       System.out.println ("File has been read");
 *    }
 *
 * }
 */
public interface FileEventListener {

   /**
    * Invoked when a file is deleted.
    * @param event a <code>FileDeleteEvent</code>
    */
   public void delete(FileDeleteEvent event);

   /**
    * Invoke when a file is created.
    * @param event a <code>FileCreateEvent</code>
    */
   public void create(FileCreateEvent event);

   /**
    * Invoke when a file is read.
    * @param event a <code>FileReadEvent</code>
    */
   public void read (FileReadEvent event);
}
