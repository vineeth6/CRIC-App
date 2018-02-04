
import java.awt.Color;
import javax.swing.JFrame;
import com.sun.org.apache.xerces.internal.dom.ParentNode;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sudar
 */
public class StartUp extends javax.swing.JFrame {
    boolean loginsuccess=true;
    int forgetpasswordclicked=0;
    boolean confirmsuccess=true;
    boolean registersuccess=true;
    /**
     * Creates new form StartUp
     */
    public StartUp() throws IOException {
        initComponents();
        jPanel6.setVisible(false);
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane[Enabled].backgroundPainter", new Color(32,47,90));
        jTextPane1.putClientProperty("Nimbus.Overrides", defaults);
        jTextPane1.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        jTextPane1.setBackground(new Color(32,47,90));
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(93,188,210));
        //updating scores to xml file
        URL url = new URL("http://static.cricinfo.com/rss/livescores.xml");


        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();
        PrintWriter writer = new PrintWriter(new File("C:\\Users\\sudar\\Documents\\NetBeansProjects\\SE Project\\src\\livescores.xml"));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        //forgetpasswordlink
        jLabel5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jCheckBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jLabel5.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
               
               if(forgetpasswordclicked==0)
               {
                   jPanel6.setVisible(true);
                   forgetpasswordclicked=1;
               }
               else
                {
                    jPanel6.setVisible(false);
                    forgetpasswordclicked=0
                            ;
                }

            }  
        }); 
        
        
        
        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            try{
                writer.println(line);

            }catch(Exception ex)
            {
                System.out.println("Couldn't write on the file");
            }
        }
        writer.close();
        
        String scores="";
        //description
        scores="\nWelcome to CricScores\n"
                + "Live Scores and match updates\n\n";
        scores=scores+"__________________________________________\n\n";
        scores=scores+"Ongoing Matches\n\n";
        
        try 
        {
            DOMParser parser = new DOMParser();
            parser.parse("C:\\Users\\sudar\\Documents\\NetBeansProjects\\SE Project\\src\\livescores.xml"); 

            org.w3c.dom.Document doc  = parser.getDocument();

            NodeList list = doc.getElementsByTagName("item");            
            
            for(int i = 1, length = list.getLength(); i < length; i++)
            {
                Element city  = (Element)list.item(i);
                ParentNode description = (ParentNode)doc.getElementsByTagName("description").item(i);
                scores=scores+description.getTextContent()+"\n\n";
            }
        }catch (Exception e) 
            {         
                System.out.println(e.getMessage());
            } 
        scores=scores+"__________________________________________\n";
        scores=scores+"\nLogin for more info!";
        jTextPane1.setText(scores);
        StyledDocument doc = jTextPane1.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jPasswordField5 = new javax.swing.JPasswordField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jPasswordField6 = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(29, 127, 176));

        jPanel1.setBackground(new java.awt.Color(146, 212, 248));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c44cd0b4-b1f3-4a4a-bb42-a617424278e0.png"))); // NOI18N

        jButton1.setText("Login ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sign Up - It's free!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View live score");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(158, 158, 158))
        );

        jPanel2.setBackground(new java.awt.Color(146, 212, 248));

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(32, 47, 90));
        jTextPane1.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(146, 212, 248));

        jPanel5.setBackground(new java.awt.Color(32, 47, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email Id");

        jTextField1.setBackground(new java.awt.Color(32, 47, 90));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(32, 47, 90));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(null);

        jButton6.setText("Or be our Guest!");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Need help? Learn more about retrieving lost accounts...");

        jPanel6.setBackground(new java.awt.Color(58, 56, 77));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Security Question");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("What was the name of your first school?");

        jTextField5.setBackground(new java.awt.Color(58, 56, 77));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("New Password");

        jPasswordField5.setBackground(new java.awt.Color(58, 56, 77));
        jPasswordField5.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField5.setBorder(null);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Confirm Password");

        jPasswordField6.setBackground(new java.awt.Color(58, 56, 77));
        jPasswordField6.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField6.setBorder(null);

        jButton7.setText("Confirm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(58, 56, 77));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Email Id");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Recover your account");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Enter your details to set a new password");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jButton7)
                    .addComponent(jSeparator9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator11)
                        .addComponent(jLabel16)
                        .addComponent(jSeparator10)
                        .addComponent(jLabel15)
                        .addComponent(jPasswordField5)
                        .addComponent(jPasswordField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addComponent(jLabel17)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField5, jPasswordField6, jSeparator10, jSeparator11, jSeparator3, jSeparator9, jTextField5, jTextField6});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(45, 45, 45)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(11, 11, 11)
                .addComponent(jPasswordField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(13, 13, 13)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jSeparator1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1)
                        .addComponent(jPasswordField1))
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(146, 212, 248));

        jPanel7.setBackground(new java.awt.Color(32, 47, 90));

        jTextField2.setBackground(new java.awt.Color(32, 47, 90));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Create a free account");

        jButton5.setText("Sign In");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email Id");

        jTextField3.setBackground(new java.awt.Color(32, 47, 90));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Confirm Password");

        jPasswordField3.setBackground(new java.awt.Color(32, 47, 90));
        jPasswordField3.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField3.setBorder(null);

        jPasswordField4.setBackground(new java.awt.Color(32, 47, 90));
        jPasswordField4.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField4.setBorder(null);

        jCheckBox1.setBackground(new java.awt.Color(32, 47, 90));
        jCheckBox1.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("By clicking on Sign In, you agree to our Terms and that you have read our Data Use Policy.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("What was the name of your first school?");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Security Question");

        jTextField4.setBackground(new java.awt.Color(32, 47, 90));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("(Firstname Lastname)");
        jLabel20.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator5)
                        .addComponent(jLabel8)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator4)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel20))
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator8)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(jButton5)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator7)
                        .addComponent(jLabel10)
                        .addComponent(jSeparator6)
                        .addComponent(jLabel9)
                        .addComponent(jPasswordField3)
                        .addComponent(jPasswordField4, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(684, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(13, 13, 13)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int retry=0;
        if(jTextField1.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Id cannot be left blank", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            loginsuccess=false;
            retry=1;
            jTextField1.setText("");
            jPasswordField1.setText("");
        
        }
        
        if(!isValidEmailAddress(jTextField1.getText())&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Address type mismatch", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            loginsuccess=false;
            retry=1;
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
        
        if(retry==0)
        {
            ResultSet rsemail,rspassword;
            DBConnect myDBConnect=new DBConnect();
            String emailid=jTextField1.getText();
            rsemail=myDBConnect.emailidpresence(emailid);
            String password=String.valueOf(jPasswordField1.getPassword());
            String passwordextracted=null;
            try {
                if(!rsemail.isBeforeFirst())
                {
                    loginsuccess=false;
                    JOptionPane.showMessageDialog(null, "Email ID not registered", "ERROR : Invalid login credentials", JOptionPane.INFORMATION_MESSAGE);
                    jTextField1.setText("");
                    jPasswordField1.setText("");
                    retry=1;
                }
                else{
                    rspassword=myDBConnect.confirmdata(emailid);
                    try {
                        rspassword.next();
                        passwordextracted=rspassword.getString("password");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "SQL connection error "+ex, "Value not accepted", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    if(passwordextracted.equals(password))
                    {
                        loginsuccess=true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Login Credentials Invalid", "Error : No such account", JOptionPane.INFORMATION_MESSAGE);
                        retry=1;
                        loginsuccess=false;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(loginsuccess==false&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email ID or password incorrect", "ERROR : Invalid login credentials", JOptionPane.INFORMATION_MESSAGE);
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
        retry=0;
        if(loginsuccess==true)
        {
            this.setVisible(false);
            String emailid=jTextField1.getText();
            DiscussionForum obj = new DiscussionForum(emailid);
            obj.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int retry=0;
        confirmsuccess=true;
        if(jTextField6.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Id cannot be left blank", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            confirmsuccess=false;
            retry=1;
            jTextField5.setText("");
            jPasswordField5.setText("");
            jTextField6.setText("");
            jPasswordField6.setText("");
        }
        if(jTextField5.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Answer the security question", "ERROR : Invalid Answer", JOptionPane.INFORMATION_MESSAGE);
            confirmsuccess=false;
            retry=1;
            jTextField5.setText("");
            jPasswordField5.setText("");
            
            jPasswordField6.setText("");
        }
        
        if(!isValidEmailAddress(jTextField6.getText())&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Address type mismatch", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            confirmsuccess=false;
            retry=1;
            jTextField5.setText("");
            jPasswordField5.setText("");
            jTextField6.setText("");
            jPasswordField6.setText("");
        }
        if(String.valueOf(jPasswordField5.getPassword()).equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Password cannot be left blank", "ERROR : Invalid Password", JOptionPane.INFORMATION_MESSAGE);
            confirmsuccess=false;
            retry=1;
            jTextField5.setText("");
            jPasswordField5.setText("");
            
            jPasswordField6.setText("");
        }
        if(!(String.valueOf(jPasswordField5.getPassword()).equals(String.valueOf(jPasswordField6.getPassword())))&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Passwords don't match", "ERROR : Invalid Password", JOptionPane.INFORMATION_MESSAGE);
            confirmsuccess=false;
            retry=1;
            jTextField5.setText("");
            jPasswordField5.setText("");           
            jPasswordField6.setText("");
        }
        
        if(retry==0)
        {
            String answer=jTextField5.getText();
            String emailid=jTextField6.getText();
            String password=String.valueOf(jPasswordField5.getPassword());
            ResultSet rsemail,rsanswer;
            DBConnect myDBConnect=new DBConnect();
            
            rsemail=myDBConnect.emailidpresence(emailid);
            String answerextracted=null;
            try {
                if(!rsemail.isBeforeFirst())
                {
                    confirmsuccess=false;
                    JOptionPane.showMessageDialog(null, "Email ID not registered", "ERROR : Invalid login credentials", JOptionPane.INFORMATION_MESSAGE);
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jPasswordField5.setText("");
                    jPasswordField6.setText("");
                    retry=1;
                }
                else
                {
                    rsanswer=myDBConnect.checksecurityanswer(emailid);
                    try {
                        rsanswer.next();
                        answerextracted=rsanswer.getString("forget_password");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "SQL connection error"+ex, "Security answer not detected properly", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    if(answerextracted.equals(answer))
                    {
                        confirmsuccess=true;
                    }
                    else
                    {
                        
                        JOptionPane.showMessageDialog(null, "Security credentials Invalid", "Error : Value not found", JOptionPane.INFORMATION_MESSAGE);
                        retry=1;
                        confirmsuccess=false;
                    }
                    
                }
            } catch (SQLException ex) {                
                Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(confirmsuccess==false&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Username or password incorrect", "ERROR : Invalid login credentials", JOptionPane.INFORMATION_MESSAGE);
            jTextField5.setText("");
            jPasswordField5.setText("");
            jPasswordField6.setText("");
        }
        retry=0;
        if(confirmsuccess)
        {
            String emailid=jTextField6.getText();
            String password=String.valueOf(jPasswordField5.getPassword());
            DBConnect myDBConnect=new DBConnect();         
            myDBConnect.updatepassword(emailid, password);
            JOptionPane.showMessageDialog(null, "Password updated successfully", "Operation Success", JOptionPane.INFORMATION_MESSAGE);
            jPanel6.setVisible(false);
            jTextField5.setText("");
            jTextField6.setText("");
            jPasswordField5.setText("");
            jPasswordField6.setText("");
           
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        int retry=0;
        registersuccess=true;

        if(jTextField2.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Name cannot be left blank", "ERROR : Invalid Name", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField3.setText("");
            jPasswordField3.setText("");
            jTextField4.setText("");
            jPasswordField4.setText("");
        }

        if(jTextField3.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Id cannot be left blank", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField3.setText("");
            jPasswordField3.setText("");
            jTextField4.setText("");
            jPasswordField4.setText("");
        }
        if(jTextField4.getText().equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Answer the security question", "ERROR : Invalid Answer", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }
        if(!isValidName(jTextField2.getText())&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Name type mismatch", "ERROR : Invalid Name", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField2.setText("");
            jTextField3.setText("");
            jPasswordField4.setText("");
            jTextField4.setText("");
            jPasswordField3.setText("");
        }
        if(!isValidEmailAddress(jTextField3.getText())&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email Address type mismatch", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField3.setText("");
            jPasswordField4.setText("");
            jTextField4.setText("");
            jPasswordField3.setText("");
        }
        if(String.valueOf(jPasswordField3.getPassword()).equals("")&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Password cannot be left blank", "ERROR : Invalid Password", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }
        if(!(String.valueOf(jPasswordField3.getPassword()).equals(String.valueOf(jPasswordField4.getPassword())))&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Passwords don't match", "ERROR : Invalid Password", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }
        if((String.valueOf(jPasswordField3.getPassword()).length()<5||String.valueOf(jPasswordField3.getPassword()).length()>14)&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Password length should be in between 5 to 14 characters", "ERROR : Password strength error", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }

        if(jTextField2.getText().length()>30&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Name too long", "ERROR : Invalid Name", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField2.setText("");
            jTextField3.setText("");
            jPasswordField3.setText("");
            jTextField4.setText("");
            jPasswordField4.setText("");
        }
        if(jTextField2.getText().length()>30&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Email ID too long", "ERROR : Invalid Email ID", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField3.setText("");
            jPasswordField3.setText("");
            jTextField4.setText("");
            jPasswordField4.setText("");
        }
        if(!jCheckBox1.isSelected()&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Please read and check the terms and conditions before proceeding", "ERROR : T&C apply", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }
        if(registersuccess==false&&retry==0)
        {
            JOptionPane.showMessageDialog(null, "Sorry, couldn't be registered due to technical issues. Try again.", "ERROR 404: Not found", JOptionPane.INFORMATION_MESSAGE);
            registersuccess=false;
            retry=1;
            jTextField4.setText("");
            jPasswordField3.setText("");
            jPasswordField4.setText("");
        }
        if(registersuccess==true)
        {
            DBConnect myDBConnect=new DBConnect();
            String name=jTextField2.getText();
            String email=jTextField3.getText();
            String pass=String.valueOf(jPasswordField3.getPassword());
            String sqans=jTextField4.getText();
            double vcbalance=500.00;
            try{
                boolean i=myDBConnect.insertdata(name,email,pass,sqans,vcbalance);
                if (i)
                {
                    JOptionPane.showMessageDialog(null, "Registered Successfully", "Congratulations! You are now a member.", JOptionPane.INFORMATION_MESSAGE);
                    jPanel2.setVisible(false);
                    jPanel3.setVisible(true);
                    jPanel4.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Registration Error, Try again", "Error : SQL connection broken", JOptionPane.INFORMATION_MESSAGE);

            }catch(Exception e){
                System.out.println(e);
            }
        }
        retry=0;

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
        public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
           
        }
        public boolean isValidName(String name) {
           String nPattern = "^[A-Za-zÀ-ú]+ [A-Za-zÀ-ú]+$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(nPattern);
           java.util.regex.Matcher m = p.matcher(name);
           return m.matches();
           
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartUp().setVisible(true);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Oops! It seems you have lost connection to the internet.", "ERROR : Unable to fetch data", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JPasswordField jPasswordField6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
