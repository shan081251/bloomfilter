package org.trimps.bloomfilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class CreatTest {

	private static Logger log = Logger.getLogger(CreatTest.class);	 
	
	public static void main(String[] args) throws IOException {
		//写一个包含1亿字符串的文件   20%概率字符串相同
		File destFile = new File("src.txt");
		List<String> tempList = new ArrayList<String>(100000);
		for(long index=0;index<100000000l;index=index+100000){
			tempList.clear();
			for(int subIndex = 0 ; subIndex <100000;subIndex++ ){
				String md5 ;
				if(	tempList.size() == 0 || Math.random()>0.2 ){
					md5 = DigestUtils.md5Hex(UUID.randomUUID().toString());
				}else{
					md5 = tempList.get((int) (Math.random()*tempList.size()));
				}
				tempList.add(md5);
			}
			FileUtils.writeLines(destFile, tempList,true);
			log.info(String.format("cur index %d", index));
		}
		
		
		
		
		
	}

}
