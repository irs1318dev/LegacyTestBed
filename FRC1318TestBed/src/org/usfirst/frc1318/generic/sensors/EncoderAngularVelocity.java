package org.usfirst.frc1318.generic.sensors;



import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc1318.FRC2013.reference.PortRef;


public class EncoderAngularVelocity extends Encoder
{
    
    Timer timer;
    double previousTicks = 0, previousTime = 0, currentTime = 0, currentTicks = 0, 
    		dt = 0, previousOmega = 0;
    
    public EncoderAngularVelocity(int slotA, int sourceA, int slotB, int sourceB) {
    	super(slotA, sourceA, slotB, sourceB);
    	init();
    }
    
    public EncoderAngularVelocity(int sourceA, int sourceB) {
    	//super(sourceA, sourceB); old testing new
    	super(PortRef.SIDECAR_SLOT, sourceA, PortRef.SIDECAR_SLOT, sourceB);
    	init();
    }

	public EncoderAngularVelocity(int slotA, int slotB, boolean reversed,
			EncodingType encodingType) {
		super(slotA, slotB, reversed, encodingType);
		init();
	}

	private void init() {
		timer = new Timer();
    	timer.start();
    	this.start();
    	
	}
    
    public double getRate() {
    	if(this.getStopped())
    		this.start();
    	//getRate cannot be called in short time periods for the same encoder because
    	//the time will be too small.
    	currentTime = timer.get();
    	currentTicks = getDistance();
    	dt = currentTime - previousTime;
    	double omega = (currentTicks - previousTicks) / (dt);
    	if(Double.isNaN(omega)) {
    		//dt could be zero, so you could get some sketchy stuff
    		System.err.println("omega is NaN. returning previouse omega");
    		return previousOmega;
    	}else {
    		previousOmega = omega;
	    	previousTicks = currentTicks;
	    	previousTime = currentTime;
	    	return omega;
    	}
    }
    
    public double getValue() {
    	if(this.getStopped())
    		this.start();
    	return this.get();
    }
    
}
