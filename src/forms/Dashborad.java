
package forms;

import dao.EventMenuSelected;
import java.awt.Color;
import javax.swing.JComponent;



public class Dashborad extends javax.swing.JFrame {

  
    public Dashborad() {
        initComponents();
        menus1.initMoving(Dashborad.this);
        menus1.addEventMenuSelected(new EventMenuSelected() {

            @Override
            public void selected(int index) {
                System.out.println(index);
                if(index == 0){
                    //dash
                   setForms(new dasFrms());
                }else if(index == 2){
                     setForms(new FournisseurForms()); 
                  
                }else if(index == 4){
                     setForms(new  DemmandeForms());
                }else if(index == 6){
                    setForms(new   LigneDemmandeForms());
                   
                }else if(index == 8){
                    //sortie
                     setForms(new  CategoriesForm());
                    
                }else if(index == 10){
                    setForms(new produitForm());
                    
                }else if( index == 12){
                  setForms(new ClientForms());
                }else if( index == 14){
                      setForms(new  CommandeForms());
                }else if( index == 16){
                     setForms(new   LigneCommandeForms());
                }else if(index == 18){
                    setForms(new ProductAllForms());
                    
                }else if(index == 25){
                   
                    
                }else{
                    
                }
            }
        });
       
    }
    
     
    private void setForms(JComponent cm){
    jPanel1.removeAll();
    jPanel1.add(cm);
    jPanel1.repaint();
    jPanel1.revalidate();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menus1 = new component.Menus();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menus1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashborad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private component.Menus menus1;
    // End of variables declaration//GEN-END:variables
}
