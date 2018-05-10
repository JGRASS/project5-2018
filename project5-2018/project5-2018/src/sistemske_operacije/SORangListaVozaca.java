package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;

public class SORangListaVozaca {
	
	public static LinkedList<Vozac> izvrsi() throws Exception{
        LinkedList<Vozac> v=SistemskiKontroler.deserijalVozaceIzJson();
        LinkedList<Vozac> vSort=new LinkedList<>();
        
        Vozac max=v.getFirst();
       int j=0;
        for (int i = 0; i <v.size(); i++) {
       	 max=new Vozac();
       	 max.setPoeni(-1);
			 for (j = 0; j < v.size(); j++) {
				 if(!vSort.contains(v.get(j)) && max.getPoeni()<=v.get(j).getPoeni()) {
					 if(max.getPoeni()==v.get(j).getPoeni()) {
						 if(max.getPobede()>v.get(j).getPobede()) {
							 continue;
							 
						 }
						 
					 }
					 max=v.get(j);
       		
				 	}
        	}
			 vSort.addLast(max);	 	 
     }
        
        return vSort;
   }

}
