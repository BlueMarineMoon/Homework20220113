package day22.ch13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimerThread extends Thread {
   JLabel timerLabel;
   public TimerThread(JLabel timerLabel) {
      this.timerLabel = timerLabel;
   }

   @Override
   public void run() {
      // 쓰래드의 실행 메소드 재정의 - start()에 의해서 실행 됨.
      System.out.println("나의 쓰레드 >>> " + this.getName());
      int ssec = 0;
      int sec = 0;
      while(true) {
         try {
            if(ssec % 60 == 0) sec++;
            ssec %= 60;
            //System.out.println("Timer >>> " + sec +":"+ ssec++);
            timerLabel.setText("Timer >>> " + sec +":"+ ssec++);
            Thread.sleep(100/6);
         } catch (InterruptedException e) {}
      }
   }
}

public class ThreadTimerEx extends JFrame{
   JPanel contentPan = new JPanel();
   public ThreadTimerEx() {
      contentPan.setBackground(Color.white);
      this.setContentPane(contentPan);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Thread를 이용한 시계");
      setSize(300, 200);
      
      JLabel timerLabel = new JLabel(">>> 0초");
      contentPan.setLayout(new GridBagLayout());
      contentPan.add(timerLabel);
      
      JButton stopBtn = new JButton("Stop");
      JButton playBtn = new JButton("Paly");
      contentPan.add(stopBtn);
      contentPan.add(playBtn);
      
      stopBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// 타이머가 일시 중지 하도록 Thread 객체에 요청 한다.
			
		}
	});
      
      stopBtn.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			// 타이머가 재실행 하도록 Thread 객체에 요청 한다.

  		}
  	});
      
      // Thread생성하고 실행하기 - 업캐스팅
      Thread th = new TimerThread(timerLabel);
      // run()을 실행하기 위해서 start() 호출
      th.start();
      
      System.out.println("메인 >>> " + this.getName());
   }

   public static void main(String[] args) {
      new ThreadTimerEx().setVisible(true);
   }

}