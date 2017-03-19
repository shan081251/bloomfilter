package org.trimps.bloomfilter.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger; 
import org.trimps.bloomfilter.util.impl.SimpleHashSetFilter;

public class SimpleHashTask {

	private static Logger log = Logger.getLogger(SimpleHashTask.class);	 
	
	public void begin() {
		try {
            LineIterator lineIterator = FileUtils.lineIterator(new File("src.txt"));
            long curLine = 0l;
            SimpleHashSetFilter filter = new SimpleHashSetFilter();
            while (lineIterator.hasNext()) {
               String line = lineIterator.nextLine();
               curLine++;
               if(!filter.contains(line)){
            	   filter.add(line);
               }
               if(curLine%100000 == 0){
            	   log.info(String.format("current line : %d ,current size : %d ", curLine,filter.size()));
               }
            }
            log.info("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
