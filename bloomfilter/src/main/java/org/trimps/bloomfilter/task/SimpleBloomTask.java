package org.trimps.bloomfilter.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;
import org.trimps.bloomfilter.util.impl.SimpleBloomFilter; 

public class SimpleBloomTask {
	private static Logger log = Logger.getLogger(SimpleBloomTask.class);	 

	public void begin() {
		try {
            LineIterator lineIterator = FileUtils.lineIterator(new File("src.txt"));
            SimpleBloomFilter filter  =   new  SimpleBloomFilter();
            long curLine = 0l;
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
