package view;

import controller.LatexEditorController;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;

public class LatexEditorView {

	private JFrame frame;
	private JEditorPane textField = new JEditorPane();;
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	static LatexEditorView window = new LatexEditorView();	
	LatexEditorController myController = new LatexEditorController(window);
	private JButton apply;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public LatexEditorView() {
		initialize();
	}
	/**
	 * @wbp.parser.entryPoint
	 */

	private void initialize() {
		frame = new JFrame("Latex Editor");
		frame.setBounds(0, 0, 629, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField.setBounds(134, 21, 469, 609);
		textField.setEnabled(false);
		frame.getContentPane().add(textField);

		
		
		JButton chapter = new JButton("chapter");
		chapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myController.setAddLine(getRow(textField));
				myController.enact("chapter");
				textField.setText(myController.getTextField());
			}
		});
		chapter.setBounds(0, 116, 124, 23);
		chapter.setEnabled(false);
		frame.getContentPane().add(chapter);
		
		JButton section = new JButton("section");
		section.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("section");
				textField.setText(myController.getTextField());
			}
		});
		section.setBounds(0, 150, 124, 23);
		section.setEnabled(false);
		frame.getContentPane().add(section);
		
		JButton subsection = new JButton("subsection");
		subsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("subsection");
				textField.setText(myController.getTextField());
			}
		});
		subsection.setBounds(0, 184, 124, 23);
		subsection.setEnabled(false);
		frame.getContentPane().add(subsection);
		
		JButton subsubsection = new JButton("subsubsection");
		subsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("subsubsection");
				textField.setText(myController.getTextField());
			}
		});
		subsubsection.setBounds(0, 218, 124, 23);
		subsubsection.setEnabled(false);
		frame.getContentPane().add(subsubsection);
		
		JButton enumlist = new JButton("enum list");
		enumlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("enum list");
				textField.setText(myController.getTextField());
			}
		});
		enumlist.setBounds(0, 283, 124, 23);
		frame.getContentPane().add(enumlist);
		
		JButton item = new JButton("item list");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("item list");
				textField.setText(myController.getTextField());
			}
		});
		item.setBounds(0, 252, 124, 23);
		frame.getContentPane().add(item);
		
		JButton table = new JButton("table");
		table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("table");
				textField.setText(myController.getTextField());
			}
		});
		table.setBounds(0, 317, 124, 23);
		frame.getContentPane().add(table);
		
		JButton figure = new JButton("figure");
		figure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.setAddLine(getRow(textField));
				myController.enact("figure");
				textField.setText(myController.getTextField());
			}
		});
		figure.setBounds(0, 351, 124, 23);
		frame.getContentPane().add(figure);
		
		JLabel lblAdd = new JLabel("add:");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(23, 91, 87, 14);
		frame.getContentPane().add(lblAdd);
		
		apply = new JButton("apply");
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myController.setTextField(textField.getText());
				myController.enact("edit");
			}
		});
		apply.setBounds(21, 403, 89, 23);
		frame.getContentPane().add(apply);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 446, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu fileVar = new JMenu("File");
		menuBar.add(fileVar);
		
		JMenu mnNewTemplate = new JMenu("New");
		fileVar.add(mnNewTemplate);
		
		JMenuItem mntmEmptyTemplate = new JMenuItem("Empty Template");
		mntmEmptyTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chapter.setEnabled(true);
				section.setEnabled(true);
				subsection.setEnabled(true);
				subsubsection.setEnabled(true);	
				
				myController.enact("empty");
				textField.setEnabled(true);
				textField.setText(myController.getDocument().getContents());
			}
		});
		mnNewTemplate.add(mntmEmptyTemplate);
		
		JMenuItem mntmReportTemplate = new JMenuItem("Report Template");
		mntmReportTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				
				chapter.setEnabled(true);
				section.setEnabled(true);
				subsection.setEnabled(true);
				subsubsection.setEnabled(true);	
			
				myController.enact("report");
				textField.setEnabled(true);
				System.out.println(myController.getDocument().getContents());
				textField.setText(myController.getDocument().getContents());
			}
		});
		
		mnNewTemplate.add(mntmReportTemplate);
		
		JMenuItem mntmBookTemplate = new JMenuItem("Book Template");
		mntmBookTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chapter.setEnabled(true);
				section.setEnabled(true);
				subsection.setEnabled(true);
				subsubsection.setEnabled(true);	
				
				myController.enact("book");
				textField.setEnabled(true);
				textField.setText(myController.getDocument().getContents());
			}
		});
		mnNewTemplate.add(mntmBookTemplate);
		
		JMenuItem mntmArticleTemplate = new JMenuItem("Article Template");
		mntmArticleTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myController.enact("article");	
				textField.setEnabled(true);
				textField.setText(myController.getDocument().getContents());
				
				chapter.setEnabled(false);
				section.setEnabled(true);
				subsection.setEnabled(true);
				subsubsection.setEnabled(true);	
			}
		});
		mnNewTemplate.add(mntmArticleTemplate);
		
		JMenuItem mntmLetterTemplate = new JMenuItem("Letter Template");
		mntmLetterTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myController.enact("letter");
				textField.setEnabled(true);		
				textField.setText(myController.getDocument().getContents());
				
				chapter.setEnabled(false);
				section.setEnabled(false);
				subsection.setEnabled(false);
				subsubsection.setEnabled(false);			
			}
		});
		mnNewTemplate.add(mntmLetterTemplate);
		
		JMenuItem load = new JMenuItem("Load File");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEX", "tex", "tex");
				fileChooser.setFileFilter(filter);
				fileChooser.setBounds(-18, -5, 582, 397);
				frame.getContentPane().add(fileChooser);
				String fileName;
				int retVal = fileChooser.showOpenDialog((Component)e.getSource());
				if (retVal == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        fileName = file.toString();
			        myController.setLoadDocument(fileName);
			        myController.enact("load");	
			   		textField.setText(myController.getDocument().getContents());
			   		textField.setEnabled(true);
			       
			    } 
			    else {
			        System.out.println("File access cancelled by user.");
			    }    
			}
		});
		fileVar.add(load);
		
		JMenuItem save = new JMenuItem("Save File");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEX", "tex", "tex");
				fileChooser.setFileFilter(filter);
				fileChooser.setBounds(-18, -5, 582, 397);
				frame.getContentPane().add(fileChooser);
				String fileName;
				int retVal = fileChooser.showSaveDialog((Component)e.getSource());
				if (retVal == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        fileName = file.toString();
			        myController.getDocument().setFileName(fileName);
			   		myController.enact("save");	
			    } 
			    else {
			        System.out.println("File access cancelled by user.");
			    }       
			}
		});
		fileVar.add(save);
		
		JMenu trackingVar = new JMenu("Version Tracking");
		menuBar.add(trackingVar);
		JCheckBoxMenuItem enableVersion = new JCheckBoxMenuItem("enable");
		JCheckBoxMenuItem stableVersion = new JCheckBoxMenuItem("Stable");
		JCheckBoxMenuItem volatileVersion = new JCheckBoxMenuItem("Volatile");
		
		trackingVar.add(enableVersion);
		JMenu strategyVar = new JMenu("Strategy");
		trackingVar.add(strategyVar);
		strategyVar.setEnabled(false);
		
/***********************************    TRACKING ENABLE    ******************************/
		enableVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enableVersion.getState()){
					strategyVar.setEnabled(true);
					myController.enact("enableVersionsManagement");
					volatileVersion.setState(true);
				}else {
					strategyVar.setEnabled(false);
					myController.enact("disableVersionsManagement");
				}
			}
		});
		
/************************************    STABLE    *************************************************/
		stableVersion.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (stableVersion.getState()) {
					volatileVersion.setState(false);
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("TEX", "tex", "tex");
					fileChooser.setFileFilter(filter);
					fileChooser.setBounds(-18, -5, 582, 397);
					frame.getContentPane().add(fileChooser);
					String fileName;
					int retVal = fileChooser.showSaveDialog((Component)e.getSource());
					if (retVal == JFileChooser.APPROVE_OPTION) {
				        File file = fileChooser.getSelectedFile();
				        fileName = file.toString();
				        myController.getDocument().setFileName(fileName);
				        myController.getVersionsManager().getStrategy().getVersion().setFileName(fileName);
				   		//myController.enact("save");	
				   		myController.enact("changeToStable");				    
				    } 
				    else {
				        System.out.println("File access cancelled by user.");
				    }
				}
			}
		});
		strategyVar.add(stableVersion);
		
/**********************************    VOLATILE    **************************************/
		volatileVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stableVersion.setState(false);
				myController.enact("changeToVolatile");
			}
		});
		strategyVar.add(volatileVersion);
	}
	
	public Integer getRow(JEditorPane text) {
		Integer rowNum = 0;
		try {
			int caretPos = textField.getCaretPosition();
			rowNum = (caretPos == 0) ? 1 : 0;
			for (int offset = caretPos; offset > 0;) {
				offset = Utilities.getRowStart(textField, offset) - 1;
				rowNum++;
			}  
			}catch (BadLocationException r) {
				 r.printStackTrace();
			}
		return rowNum;
	}
}
