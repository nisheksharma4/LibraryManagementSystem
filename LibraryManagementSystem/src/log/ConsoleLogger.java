package log;

public class ConsoleLogger implements ILogger {
	
	public void log(String message) {
		System.out.println("[Log]: "+ message);
	}
}
