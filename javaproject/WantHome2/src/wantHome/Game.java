package wantHome;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 해야할 일
// 게임화면에 창닫기 버튼 만들기

public class Game extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	
	public static Image introBackground = new ImageIcon(Main.class.getResource("../images/mainImage.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/PressedExitButton.png"));
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exitButton.png"));
	
	JLabel la1 =new JLabel("Areum");
    JLabel la2 =new JLabel("Aromi");
    
    final int FLYING_UNIT=10;
    
    private JButton exitButton = new JButton(exitButtonImage);
	
	Game() {
		setUndecorated(true);
		setTitle("I want go home");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setLocation(0,0);
		addKeyListener(new MyKeyListener());
		
		la1.setLocation(50,50);
        la1.setSize(100,20);
        
        la2.setLocation(50,370);
        la2.setSize(100,20);
        
        add(la1);
		add(la2);
		
		exitButton.setBounds(870, 2, 25, 25);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);		
		introBackground = new ImageIcon(Main.class.getResource("../images/map.png")).getImage();		
    }	
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
	
	class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode =e.getKeyCode();
            
            switch(keyCode){
                case KeyEvent.VK_UP:
                	if(la1.getY() < 40)
                		la1.setLocation(la1.getX(), la1.getY()+FLYING_UNIT);
                    la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_DOWN:
                	if(la1.getY() > 210)
                		la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT);
                    la1.setLocation(la1.getX(), la1.getY()+FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_RIGHT:
                    la1.setLocation(la1.getX()+FLYING_UNIT, la1.getY()); break;
                case KeyEvent.VK_LEFT:
                    la1.setLocation(la1.getX()-FLYING_UNIT, la1.getY()); break;
                case 87:
                	if(la2.getY() < 310)
                		la2.setLocation(la2.getX(), la2.getY()+FLYING_UNIT);
	                la2.setLocation(la2.getX(), la2.getY()-FLYING_UNIT); System.out.println(la2.getX()+" "+la2.getY()); break;
	            case 83:
	            	if(la2.getY() > 510)
                		la2.setLocation(la2.getX(), la2.getY()-FLYING_UNIT);
	                la2.setLocation(la2.getX(), la2.getY()+FLYING_UNIT); System.out.println(la2.getX()+" "+la2.getY()); break;
	            case 68:
	                la2.setLocation(la2.getX()+FLYING_UNIT, la2.getY()); break;
	            case 65:
	                la2.setLocation(la2.getX()-FLYING_UNIT, la2.getY()); break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
	}
}
