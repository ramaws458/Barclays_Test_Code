package com;

import java.util.ArrayList;
import java.util.List;

public class AirportBaggage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Bags> bags= new ArrayList<Bags>();
		List<Departures> departures= new ArrayList<Departures>();
		List<ConveyorSystem> conveyorSystem= new ArrayList<ConveyorSystem>();
		outerLoop: for(Bags bag : bags){
			String gateOrder = "  "+ bag.getBagEntryPoint();
			String targetGate=bag.getBagEntryPoint();
			if(bag.getBagFlightID().equalsIgnoreCase("ARRIVAL")){
				
			}else{
				for(Departures dep : departures){
					int time = 0;
					
					if(bag.getBagFlightID().equalsIgnoreCase(dep.getFlightID())){
						for(ConveyorSystem cs : conveyorSystem){
							targetGate=cs.getGate2();
							if(targetGate.equalsIgnoreCase(cs.getGate1()) 
									&& cs.getGate2().equalsIgnoreCase(dep.getFlightGate())){
								time = time + cs.getTravelTime();
								System.out.println(bag.getBagEntryPoint()+"  "+gateOrder+" : "+ time);
								break outerLoop;
							}else{
								time = time + cs.getTravelTime();
								gateOrder = gateOrder + "  "+cs.getGate2();
								targetGate = cs.getGate2();
							}
						}
					}
				}
			}
		}

	}
	
	

}
