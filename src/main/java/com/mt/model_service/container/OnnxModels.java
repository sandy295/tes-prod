package com.mt.model_service.container;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import ai.onnxruntime.OrtSession;
import lombok.Data;
@Data
public class OnnxModels {
	private ConcurrentHashMap<String,OrtSession> map;
	
	public OrtSession getSession(String predictQuantity) {
		return map.get(predictQuantity);
//		return map.getOrDefault(map.get(predictQuantity), null);
	}
	
	public String getavailabelModels() {
		String availableModel = new String();
		Iterator<ConcurrentHashMap.Entry<String, OrtSession>>
        itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			ConcurrentHashMap.Entry<String,OrtSession> entry = itr.next();
			availableModel += "," + entry.getKey();
		}
		return availableModel.substring(1);
	}
}
