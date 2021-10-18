import java.util.Scanner;

public class ProcessThread {

	public static void main(String[] args) {
		int num;
		Scanner input = new Scanner(System.in);
		System.out.println("라면 몇 개 끓일까요?");
		num = input.nextInt();
		System.out.println(num + "개 주문 완료! 조리시작!");
		try {
			RamenCook ramenCook = new RamenCook(num);
			new Thread(ramenCook, "A").start();
			new Thread(ramenCook, "B").start();
			new Thread(ramenCook, "C").start();
			new Thread(ramenCook, "D").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface Runnable {
	public void run();
}

class currentThread extends Thread {
	public RamenCook ramenCook;
	static String nam;

	currentThread() {
		this(new RamenCook(5), "");
	}

	currentThread(RamenCook ramenCook, String nam) {
		this.ramenCook = ramenCook;
		this.nam = nam;
	}
}

class RamenCook extends Thread implements Runnable {
	private int ramenCount;
	private String[] burners = { "_", "_", "_", "_" };

	public RamenCook(int count) {
		ramenCount = count;
	}

	@Override
	public void run() {
		while (ramenCount > 0) {
			synchronized (this) {
				ramenCount--;
				System.out.println(Thread.currentThread().getName() + " : " + ramenCount + "개 남았습니다");
			}

			for (int i = 0; i < burners.length; i++) {
				if (!burners[i].equals("_")) {
					continue;
				}

				synchronized (this) {
					// if(burners[i].equals("_"))
					// {
					burners[i] = Thread.currentThread().getName();
					System.out.println(
							"                 " + Thread.currentThread().getName() + " : [" + (i + 1) + "]번 버너 ON");
					showBurners();
					// }
				}

				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				synchronized (this) {
					burners[i] = "_";
					System.out.println("                                  " + Thread.currentThread().getName() + " : ["
							+ (i + 1) + "]번 버너 OFF");
					showBurners();
				}
				break;
			}

			try {
				Thread.sleep(Math.round(1000 * Math.random()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void showBurners() {
		String stringToPrint = "                                                             ";
		for (int i = 0; i < burners.length; i++) {
			stringToPrint += (" " + burners[i]);
		}
		System.out.println(stringToPrint);
	}

}
