import javax.swing.JComponent;
import javax.swing.JPanel;


public class BulletManager {
	private Bullet bullet=null;
	public void addBullet(JComponent weapon, JPanel area)
	{
		if(bullet!=null)
			if(bullet.hasBullets())
				bullet.addBullet(weapon);
		else
		{
				bullet = new Bullet(weapon,area);
				bullet.start();
		}
		else
		{
			bullet = new Bullet(weapon,area);
			bullet.start();
		}
	}
}
