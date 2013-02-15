package org.usfirst.frc1318.FRC2013.shared;

public class SolenoidData 
{
	private boolean shouldShooterBeUp;
	private boolean shouldLifterBeUp;
	private boolean shouldFrisbeeBeExtended;
	private boolean isShooterUp;
	private boolean isLifterUp;
	private boolean isFrisbeeExtended;
	
	public boolean getShouldShooterBeUp()
	{
		return shouldShooterBeUp;
	}
	public void setShouldShooterBeUp(boolean shouldShooterBeUp)
	{
		this.shouldShooterBeUp = shouldShooterBeUp;
	}
	public boolean getShouldLifterBeUp()
	{
		return shouldLifterBeUp;
	}
	public void setShouldLifterBeUp(boolean shouldLifterBeUp)
	{
		this.shouldLifterBeUp = shouldLifterBeUp;
	}
	public boolean getShouldFrisbeeBeExtended()
	{
		return shouldFrisbeeBeExtended;
	}
	public void setShouldFrisbeeBeExtended(boolean shouldFrisbeeBeExtended)
	{
		this.shouldFrisbeeBeExtended = shouldFrisbeeBeExtended;
	}
	public boolean getShooterUp()
	{
		return isShooterUp;
	}
	public void setShooterUp(boolean isShooterUp)
	{
		this.isShooterUp = isShooterUp;
	}
	public boolean getLifterUp()
	{
		return isLifterUp;
	}
	public void setLifterUp(boolean isLifterUp)
	{
		this.isLifterUp = isLifterUp;
	}
	public boolean getFrisbeeExtended()
	{
		return isFrisbeeExtended;
	}
	public void setFrisbeeExtended(boolean isFrisbeeExtended)
	{
		this.isFrisbeeExtended = isFrisbeeExtended;
	}
}