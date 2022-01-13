package day22.ch13;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	@Override
	public void run() {
		// 쓰래드의 실행 메소드 재정의 - start()에 의해서 실행 됨.
		System.out.println("나의 쓰레드 >>> " + this.getName());
		int ssec = 0;
		int sec = 0;
		while(true) {
			try {
				if(ssec % 10 == 0) sec++;
				//System.out.println("Timer >>> " + sec + ":" + ssec++);
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		
	}
}

public class ThreadTimerEx extends JFrame{

	public ThreadTimerEx() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Thread를 이용한 시계");
		setSize(300, 200);
		
		JLabel timerLabel = new JLabel(">>> ");
		add(BorderLayout.NORTH, timerLabel);
		
		// Thread생성하고 실행하기 - 업캐스팅
		Thread th = new TimerThread();
		// run()을 실행하기 위해서 start() 호출
		th.start();
		
		System.out.println("메인 >>> " + this.getName());
	}
	
	public static void main(String[] args) {
		new ThreadTimerEx().setVisible(true);

	}

}
