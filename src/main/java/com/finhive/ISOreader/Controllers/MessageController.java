package com.finhive.ISOreader.Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/IsoMessage")
public class MessageController {

		
	
	public Map<String, String> reader(@RequestBody Map<String, String> IsoMessage) throws ISOException, IOException   {
		Resource resource = new ClassPathResource("iso87ascii.xml");

		InputStream input = resource.getInputStream();
		GenericPackager packager = new GenericPackager(input);
 
        
        String TempStr = IsoMessage.get("IsoMessage");
        System.out.println(TempStr);
        Map<String, String> ret = new HashMap<String,String>();
        // Setting packager
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
 
        // first, we must convert ISO8583 Message String to byte[]
        byte[] bIsoMessage = new byte[TempStr.length()];
        for (int i = 0; i < bIsoMessage.length; i++) {
            bIsoMessage[i] = (byte) (int) TempStr.charAt(i);
        }
 
        // second, we unpack the message
        isoMsg.unpack(bIsoMessage);     
 
        // last, print the unpacked ISO8583
        System.out.println("MTI='"+isoMsg.getMTI()+"'");
        for(int i=1; i<=isoMsg.getMaxField(); i++){
            if(isoMsg.hasField(i)) {
            	 Integer IInteger = new Integer(i);
            	 ret.put(IInteger.toString(), isoMsg.getString(i));
            	 System.out.println(i+"='"+isoMsg.getString(i)+"'");
            }
        }
        return ret;
		
    }
    
    
    public String getMethodName() {
        return "Get Functions";
    }
    

	
	
}
