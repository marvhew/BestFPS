import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Bullet extends Thread {
	private List<JComponent> weapons;
	private JPanel area;

	public Bullet(JComponent weapon, JPanel area) {
		weapons = new ArrayList<JComponent>();
		weapons.add(weapon);
		this.area = area;
	}
	
	public boolean hasBullets()
	{
		if (weapons.size()==0)
				return false;
		else
			return true;
	}

	public void addBullet(JComponent weapon)
	{
		weapons.add(weapon);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for(JComponent weapon:weapons){
			Rectangle oldBounds = weapon.getBounds();
			oldBounds.x += 10;
			weapon.setBounds(oldBounds);
			if (weapon.getBounds().x >= area.getBounds().width) {
				area.remove(weapon);
			}
			if(weapons.size()==0)
				break;
			}
		}
	}

}
