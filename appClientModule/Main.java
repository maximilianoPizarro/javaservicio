
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.javaservicio.modelo.Usuario;
import com.javaservicio.negocio.Facade;
import com.javaservicio.negocio.UsuarioABM;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static JFrame mainFrame;

	private static void showFrame() {
		mainFrame = new JFrame("SME");
		mainFrame.setFont(new Font("Chalet", Font.BOLD, 22));
		mainFrame.setIconImage(createImage("/META-INF/static/favicon_ba.png", "Icono"));
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setSize(300, 200);
		mainFrame.setVisible(true);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
	    JScrollPane pane = new JScrollPane(list);
		
		Facade facade= new Facade();
		UsuarioABM adm= facade.getUsuarioABM();
		mainFrame.add(pane, BorderLayout.NORTH);
		JLabel tabla = new JLabel("Lista de espera");
		mainFrame.add(tabla);
		
		
		try {
			List<Usuario> users = adm.traerUsuarios();
			for(Usuario user:users){
		        model.addElement("- " + user.getApellido()+" "+user.getNombre() +" "+ user.getDni());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addElement("No se pudo conectar al servidor");	
			}
		
		mainFrame.addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent arg0) {
				if (arg0.getNewState() == Frame.ICONIFIED) {
					mainFrame.dispose();
				}

			}
		});
	}

	private static void createAndShowGUI() {
		// Check the SystemTray support
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray no soportado");
			return;
		}
		final PopupMenu popup = new PopupMenu();
		final TrayIcon trayIcon = new TrayIcon(createImage("/META-INF/static/favicon_ba.png", "Icono"));
		final SystemTray tray = SystemTray.getSystemTray();

		// Create a popup menu components
		MenuItem aboutItem = new MenuItem("Abrir ventana");

		MenuItem exitItem = new MenuItem("Salir");

		// Add components to popup menu
		popup.add(aboutItem);
		popup.addSeparator();

		popup.add(exitItem);

		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		trayIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hay 3 personas para atender");
			}
		});

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFrame();
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tray.remove(trayIcon);
				System.exit(0);
			}
		});
	}

	// Obtain the image URL
	protected static Image createImage(String path, String description) {
		URL imageURL = Main.class.getResource(path);

		if (imageURL == null) {
			System.err.println("Resource not found: " + path);
			return null;
		} else {
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}