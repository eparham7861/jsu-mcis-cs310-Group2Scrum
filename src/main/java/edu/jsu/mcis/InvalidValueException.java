package edu.jsu.mcis;

import java.util.*;

public class InvalidValueException extends RuntimeException
{
	private String usage;
	private String program;
	private String name;
	private String type;
	private Object currentValue;
	
	public void setProgramName(String programName) {
		program = programName;
	}
	public void setUsageLine(String usageLine) {
		usage = usageLine;
	}
	public void setInvalidValueInformation(String name, Object value, Argument.Type type) {
		this.name = name;
		currentValue = value;
		switch(type) {
			case INT:
				this.type = "integer";
				break;
			case FLOAT:
				this.type = "float";
				break;
			case BOOLEAN:
				this.type = "boolean";
				break;
			default:
				this.type = "string";
		}
	}
	
	public String getUsage()
	{
		return usage;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public <T> T getCurrentValue()
	{
		return (T)currentValue;
	}

	public String toString()
	{
		String errorMessage = usage + "\n";
		errorMessage = errorMessage + program + ".java: error: argument " + name;
		errorMessage = errorMessage + ": invalid " + type + " value: " + currentValue;
		return errorMessage;
	}
}