package Use_Case_Model;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;


public class Quadro_Pro {

	private JFrame frame_CockpitPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quadro_Pro window = new Quadro_Pro();
					window.frame_CockpitPro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quadro_Pro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_CockpitPro = new JFrame();
		frame_CockpitPro.setTitle("Cockpit PRO");
		frame_CockpitPro.setBounds(100, 100, 941, 768);
		frame_CockpitPro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_CockpitPro.getContentPane().setLayout(null);
		
		JLabel label_Motorleistung = new JLabel("Motorleistung");
		label_Motorleistung.setFont(new Font("Arial", Font.BOLD, 14));
		label_Motorleistung.setBounds(10, 11, 105, 17);
		frame_CockpitPro.getContentPane().add(label_Motorleistung);
		
		JButton btn_quadro_mode = new JButton("Auto / Manuell");
		btn_quadro_mode.setBounds(571, 342, 174, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_mode);
		
		
		final JProgressBar hight_quadro = new JProgressBar();
		//hight_quadro.setValue(0);
		hight_quadro.setValue(0);
		hight_quadro.setMaximum(100);
		hight_quadro.setBounds(157, 454, 273, 47);
		frame_CockpitPro.getContentPane().add(hight_quadro);
		
		
		final JButton btn_quadro_up = new JButton("+");
		btn_quadro_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn_quadro_up){
					hight_quadro.setValue(hight_quadro.getValue()+1);
				}
		}});
		btn_quadro_up.setBounds(520, 292, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_up);
		
		final JButton btn_quadro_down = new JButton("-");
		btn_quadro_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn_quadro_down){
					hight_quadro.setValue(hight_quadro.getValue()-1);
				}
			}
		});
		btn_quadro_down.setBounds(520, 342, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_down);
		
		JButton btn_quadro_right = new JButton(">");
		btn_quadro_right.setBounds(857, 342, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_right);
		
		JButton btn_quadro_back = new JButton("v");
		btn_quadro_back.setBounds(806, 342, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_back);
		
		JButton btn_quadro_left = new JButton("<");
		btn_quadro_left.setBounds(755, 342, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_left);
		
		JButton btn_quadro_forward = new JButton("^");
		btn_quadro_forward.setBounds(806, 292, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_forward);
		
		JButton btn_quadro_left_rotation = new JButton("\\");
		btn_quadro_left_rotation.setBounds(755, 292, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_left_rotation);
		
		JButton btn_quadro_right_rotation = new JButton("/");
		btn_quadro_right_rotation.setBounds(857, 292, 41, 39);
		frame_CockpitPro.getContentPane().add(btn_quadro_right_rotation);
		
		JLabel label_Ultraschallsensor = new JLabel("Ultraschallsensor");
		label_Ultraschallsensor.setFont(new Font("Arial", Font.BOLD, 14));
		label_Ultraschallsensor.setBounds(593, 405, 129, 17);
		frame_CockpitPro.getContentPane().add(label_Ultraschallsensor);
		
		JLabel label_Lagesensor = new JLabel("Lagesensor");
		label_Lagesensor.setFont(new Font("Arial", Font.BOLD, 14));
		label_Lagesensor.setBounds(10, 552, 90, 17);
		frame_CockpitPro.getContentPane().add(label_Lagesensor);
		
		JLabel label_hoehe = new JLabel("H\u00F6he");
		label_hoehe.setFont(new Font("Arial", Font.BOLD, 14));
		label_hoehe.setBounds(10, 420, 50, 17);
		frame_CockpitPro.getContentPane().add(label_hoehe);
		
		JSeparator separator_hor = new JSeparator();
		separator_hor.setBounds(0, 392, 925, 2);
		frame_CockpitPro.getContentPane().add(separator_hor);
		
		JSeparator separator_ver = new JSeparator();
		separator_ver.setOrientation(SwingConstants.VERTICAL);
		separator_ver.setBounds(479, 11, 2, 708);
		frame_CockpitPro.getContentPane().add(separator_ver);
		
		JProgressBar power_VL = new JProgressBar();
		power_VL.setValue(4);
		power_VL.setMaximum(12);
		power_VL.setBounds(157, 71, 273, 47);
		frame_CockpitPro.getContentPane().add(power_VL);
		
		JProgressBar power_VR = new JProgressBar();
		power_VR.setValue(6);
		power_VR.setMaximum(12);
		power_VR.setBounds(157, 129, 273, 47);
		frame_CockpitPro.getContentPane().add(power_VR);
		
		JProgressBar power_HL = new JProgressBar();
		power_HL.setValue(8);
		power_HL.setMaximum(12);
		power_HL.setBounds(157, 187, 273, 47);
		frame_CockpitPro.getContentPane().add(power_HL);
		
		JProgressBar power_HR = new JProgressBar();
		power_HR.setValue(12);
		power_HR.setMaximum(12);
		power_HR.setBounds(157, 245, 273, 47);
		frame_CockpitPro.getContentPane().add(power_HR);
		
		JLabel label_Vornelinks = new JLabel("Vorne-Links");
		label_Vornelinks.setFont(new Font("Arial", Font.BOLD, 14));
		label_Vornelinks.setBounds(10, 71, 105, 47);
		frame_CockpitPro.getContentPane().add(label_Vornelinks);
		
		JLabel label_Vornerechts = new JLabel("Vorne-Rechts");
		label_Vornerechts.setFont(new Font("Arial", Font.BOLD, 14));
		label_Vornerechts.setBounds(10, 129, 105, 47);
		frame_CockpitPro.getContentPane().add(label_Vornerechts);
		
		JLabel label_Hintenlinks = new JLabel("Hinten-Links");
		label_Hintenlinks.setFont(new Font("Arial", Font.BOLD, 14));
		label_Hintenlinks.setBounds(10, 187, 105, 47);
		frame_CockpitPro.getContentPane().add(label_Hintenlinks);
		
		JLabel label_Hintenrechts = new JLabel("Hinten-Rechts");
		label_Hintenrechts.setFont(new Font("Arial", Font.BOLD, 14));
		label_Hintenrechts.setBounds(10, 245, 105, 47);
		frame_CockpitPro.getContentPane().add(label_Hintenrechts);
		
		JLabel label_0V = new JLabel("0 V");
		label_0V.setFont(new Font("Arial", Font.BOLD, 14));
		label_0V.setBounds(133, 43, 41, 17);
		frame_CockpitPro.getContentPane().add(label_0V);
		
		JLabel label_5V = new JLabel("5 V");
		label_5V.setFont(new Font("Arial", Font.BOLD, 14));
		label_5V.setBounds(257, 43, 41, 17);
		frame_CockpitPro.getContentPane().add(label_5V);
		
		JLabel label_12V = new JLabel("12 V");
		label_12V.setFont(new Font("Arial", Font.BOLD, 14));
		label_12V.setBounds(411, 43, 41, 17);
		frame_CockpitPro.getContentPane().add(label_12V);
		
	
		JLabel label_0m = new JLabel("0 m");
		label_0m.setFont(new Font("Arial", Font.BOLD, 14));
		label_0m.setBounds(133, 422, 41, 17);
		frame_CockpitPro.getContentPane().add(label_0m);
		
		JLabel label_50m = new JLabel("50 m");
		label_50m.setFont(new Font("Arial", Font.BOLD, 14));
		label_50m.setBounds(270, 422, 41, 17);
		frame_CockpitPro.getContentPane().add(label_50m);
		
		JLabel label_100m = new JLabel("100 m");
		label_100m.setFont(new Font("Arial", Font.BOLD, 14));
		label_100m.setBounds(411, 422, 41, 17);
		frame_CockpitPro.getContentPane().add(label_100m);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(545, 314, 1, 2);
		frame_CockpitPro.getContentPane().add(separator);
	}
}
