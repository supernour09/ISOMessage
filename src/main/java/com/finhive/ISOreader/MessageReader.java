package com.finhive.ISOreader;

import java.util.HashMap;
import java.util.Map;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

@RestController
public class MessageReader {

		
	@PostMapping("/IsoMessage")
	public Map<String, String> reader(@RequestBody Map<String, String> IsoMessage) throws ISOException   {
        GenericPackager packager = new GenericPackager(
                "../ISOreader/iso87ascii.xml");
 
        
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

	
	
}
