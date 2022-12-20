
package component;

import dao.EventMenuSelected;
import entities.Model_Menu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;




public class Menus extends javax.swing.JPanel {

   private EventMenuSelected event ;
   public void addEventMenuSelected(EventMenuSelected event ){
       this.event= event;  
       listMenu1.addEventMenuSelected(event);
   }
   
    public Menus() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
   
    }
    private void init(){
        listMenu1.addItem(new Model_Menu("4","Dashboard",Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("4","Gestion Fournisseur",Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("4","Gestion des Demmades ",Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu("4"," Categories",Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu("4","Gestion Produit ",Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("4","Gestion Client ",Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
             listMenu1.addItem(new Model_Menu("4","Gestion des Commandes ",Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("4"," Produit ",Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
         listMenu1.addItem(new Model_Menu("10","Deconnexion  ",Model_Menu.MenuType.MENU));
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new swing.ListMenu();

        setBackground(new java.awt.Color(255, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stock.png"))); // NOI18N
        jLabel1.setText("      Gestion Stock");

        listMenu1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(113, Short.MAX_VALUE))
            .addComponent(listMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private swing.ListMenu listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D  g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gr = new GradientPaint(0 , 0, Color.decode("#44A08D"),0, getHeight(),Color.decode("#093637"));
        g2.setPaint(gr);
   
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int x;
  private int y;
  
  public void initMoving(JFrame MouseAdapter){
      panelMoving.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent me){
               x=me.getX();
               y = me.getY();
           }
        });
         panelMoving.addMouseMotionListener(new MouseMotionAdapter (){
         
        
           @Override
           public void mouseDragged(MouseEvent me){
      //      fram.setLocation(me.getXOnScreen()-x , me.getYOnScreen()-y);
           }
        });
      
  }
}


