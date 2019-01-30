package As2;

public class TimerMonteVerde {

	long duration;
	long start;
	long stop;

	public TimerMonteVerde() {
		start = 0;
		stop = 0;

	}

	public void start() {
		this.start = System.currentTimeMillis();
	}

	public void stop() {
		this.stop = System.currentTimeMillis();
	}

	public long getDuration() {
		duration = this.stop - this.start;
		return duration;
	}

}