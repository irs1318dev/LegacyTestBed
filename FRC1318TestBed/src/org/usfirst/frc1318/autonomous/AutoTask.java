package org.usfirst.frc1318.autonomous;

public interface AutoTask {
	void init(); // will run only once
	void run(); // presumably 
	void cancel();
	boolean hasFinished();
	boolean hasInitalized();
}
