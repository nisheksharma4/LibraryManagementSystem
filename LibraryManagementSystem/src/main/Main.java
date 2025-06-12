package main;

import java.lang.System.Logger;

import log.ConsoleLogger;
import log.ILogger;

public class Main {
	
	public static void main(String[] args) {
		ILogger ilogger = new ConsoleLogger();
		ilogger.log("Library Management System Started.");
	}

}
