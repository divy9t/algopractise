package udemy;

import java.math.BigInteger;

public class ThreadUd {

	public static void main(String[] args) {

	}

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {

		PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
		thread1.start();
		thread2.start();

		try {
			thread1.setDaemon(true);
			thread2.setDaemon(true);
			thread1.join(2000);
			thread2.join(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return thread1.getResult().add(thread2.getResult());


	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ONE;
		private final BigInteger base;
		private final BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			result = base.pow(power.intValue());
		}

		public BigInteger getResult() {
			return result;
		}
	}
}
