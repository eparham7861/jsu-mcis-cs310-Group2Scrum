package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class XMLFactoryTest 
{
	@Test
	public void testParseXML() 
	{
		ArgumentParser p = XMLFactory.loadArgumentParser("Volume Calculator", "\\XMLTest\\xmlTest.xml");
		p.parse("7.5");
		assertEquals(7.5f, p.getArgumentValue("length"));
	}
	
	@Test
	public void testParseXMLNamedArgument() 
	{
		ArgumentParser p = XMLFactory.loadArgumentParser("Volume Calculator", "\\XMLTest\\xmlNamedTest.xml");
		p.parse("7.5 --type box");
		assertEquals("box", p.getArgumentValue("type"));
	}
	
	@Test
	public void testParseXMLShortNamedArgument() 
	{
		ArgumentParser p = XMLFactory.loadArgumentParser("Volume Calculator", "\\XMLTest\\xmlShortNamedTest.xml");
		p.parse("7.5 -t box");
		assertEquals("box", p.getArgumentValue("t"));
	}
	
	@Test
	public void testParseXMLDefaultValueArgument()
	{
		ArgumentParser p = XMLFactory.loadArgumentParser("Volume Calculator", "\\XMLTest\\xmlNamedDefaultValueTest.xml");
		p.parse("7.5");
		assertEquals("box", p.getArgumentValue("type"));
	}
	
	@Test
	public void testParseXMLRequiredArgument() 
	{
		ArgumentParser p = XMLFactory.loadArgumentParser("Volume Calculator", "\\XMLTest\\xmlNamedRequiredTest.xml");
		p.parse("7.5 --type box");
		assertEquals("box", p.getArgumentValue("type"));
	}
}