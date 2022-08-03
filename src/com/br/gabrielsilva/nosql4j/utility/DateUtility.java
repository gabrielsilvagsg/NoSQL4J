package com.br.gabrielsilva.nosql4j.utility;

public class DateUtility {

	public static String getElapsed(Long started, Long nanoTime) {
	    Long now = System.currentTimeMillis();
	    Long time = now - started;
	    
	    long seconds = time / 1000L % 60L;
	    long minutes = time / (60L * 1000L) % 60L;
	    StringBuilder string = new StringBuilder();

	    if (minutes != 0L) {
	    	string.append(minutes + " minuto" + (minutes > 1 ? "s" : "") + " e");
	    }
	    if (seconds != 0L) {
	    	string.append(seconds + " minuto" + (minutes > 1 ? "s" : "") + " e");
	    } else {
	    	if (minutes == 0L && seconds == 0L) {
	    		String ms = String.valueOf(started - now).replaceAll("-", "");
	    		if (ms.equals("0")) {
	    			Long nano = System.nanoTime();
	    			String nanoSegundos = String.valueOf((nanoTime - nano)).replaceAll("-", "");
	    			return nanoSegundos + "ns";
	    		}
	    		
	    		return ms + "ms";
	    	}
	    }
		return string.toString().replaceAll("-", "") + ".";
	}
}