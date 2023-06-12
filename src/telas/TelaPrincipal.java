/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import processamento.ProcessamentoImagem;
import processamento.DeteccaoCorPixel;
//import org.opencv.core.Core;

/**
 *
 * @author Christian Oliveira
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    public File arqImagemOriginal;
    public BufferedImage imagemAtual;
    public boolean imagemFoiCarregada;
    public boolean extRedness, extOtsu, extRenyi;
    public File caminho = new File("/home/");
    public int posx, posy;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();     
        jLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                posx = e.getX();
                posy = e.getY();
                if(imagemAtual!=null){
                    Color color = new Color(imagemAtual.getRGB(posx, posy));
                    jPanel1.setBackground(color);
                }        
            }
        });     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem12.setText("jMenuItem12");

        jMenuItem14.setText("jMenuItem14");

        jMenuItem15.setText("jMenuItem15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detecção Por Índice Redness - \"Smolka\" - Christian Jonas Oliveira");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Carregar imagem");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Restaurar original");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem9.setText("Salvar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("RedEye Detection");

        jMenuItem18.setText("Imagem carregada");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuItem20.setText("Em lote");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Binarização");

        jMenu6.setText("Renyi");

        jMenuItem7.setText("Imagem Carregada");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("Em lote");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenu2.add(jMenu6);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Outros");

        jMenuItem13.setText("Sobre o programa");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem13);

        jMenuBar1.add(jMenu9);

        jMenu3.setText("Otsu");

        jMenuItem4.setText("Imagem Carregada");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Em lote");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TelaOtsuBinarization TOTSUBin = new TelaOtsuBinarization();
        TOTSUBin.setLocationRelativeTo(null);
        TOTSUBin.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JFrame f=new JFrame();
        if(imagemFoiCarregada){
            try{
                BufferedImage imagemPosterizada = ProcessamentoImagem.OtsuBinarization(imagemAtual);
                if(imagemPosterizada == null) {
                    JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                }else{
                    //                    BufferedImage imagemGrayscale = ProcessamentoImagem.OtsuBinarization(imagemPosterizada);
                    imagemAtual = imagemPosterizada;
                    jLabel1.setIcon(new javax.swing.ImageIcon(imagemPosterizada));
                    extOtsu = true;
                }
            }catch( NullPointerException | IllegalArgumentException ex){
                JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(f, "A imagem não foi carregada!");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f, "Programa desenvolvido e implementado por Christian Oliveira em 2022/2, \nNa Disciplina de PDI tendo sido ministrada pelo Prof. Jacques Facon.");
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        TelaRenyiBinarization TRENYIBin = new TelaRenyiBinarization();
        TRENYIBin.setLocationRelativeTo(null);
        TRENYIBin.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JFrame f=new JFrame();
        if(imagemFoiCarregada){
            try{
                BufferedImage imagemPosterizada = ProcessamentoImagem.RenyiBinarization(imagemAtual);
                if(imagemPosterizada == null) {
                    JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                }else{
                    //                    BufferedImage imagemGrayscale = ProcessamentoImagem.RenyiBinarization(imagemPosterizada);
                    imagemAtual = imagemPosterizada;
                    jLabel1.setIcon(new javax.swing.ImageIcon(imagemPosterizada));
                    extRenyi = true;
                }
            }catch( NullPointerException | IllegalArgumentException ex){
                JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(f, "A imagem não foi carregada!");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        TelaDetectaRednessIndex TDPP = new TelaDetectaRednessIndex();
        TDPP.setLocationRelativeTo(null);
        TDPP.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        JFrame f=new JFrame();
        if(imagemFoiCarregada){
            try{
                BufferedImage imagemPosterizada = ProcessamentoImagem.riRedSmolka(imagemAtual);
                if(imagemPosterizada == null) {
                    JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                }else{
                    imagemAtual = imagemPosterizada;
                    jLabel1.setIcon(new javax.swing.ImageIcon(imagemAtual));
                    extRedness = true;
                }
            }catch( NullPointerException | IllegalArgumentException ex){
                JOptionPane.showMessageDialog(f, "Não foi possível realizar a RI!");
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(f, "A imagem não foi carregada!");
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        JFrame f=new JFrame();
        if(imagemFoiCarregada){
            JFileChooser fs = new JFileChooser(new File(arqImagemOriginal.getParent()));
            fs.setFileFilter(new FileNameExtensionFilter("PNG Images","png"));
            fs.setDialogTitle("Escolha onde salvar a imagem posterizada:");
            int retorno = fs.showSaveDialog(this);
            if(retorno ==JFileChooser.APPROVE_OPTION){
                File fo = new File(fs.getSelectedFile().getPath() + (extRedness ? "_RedSmolka" : "") + (extOtsu ? "_OTSU" : "") + (extRenyi ? "_BinRenyi" : "") + ".png");
                try {
                    ImageIO.write(imagemAtual, "png", fo);
                    extOtsu = extRedness = extRenyi = false;

                    JOptionPane.showMessageDialog(f, "Imagem salva com sucesso");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(f, "Não foi possível salvar a imagem!");
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(f, "A imagem não foi carregada!");
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFrame f=new JFrame();
        if(imagemFoiCarregada){
            try {
                extRenyi = extOtsu = false;
                imagemAtual = ImageIO.read(arqImagemOriginal);
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(f, "Imagem Restaurada!");
            //jLabel1.setIcon(new javax.swing.ImageIcon(imagemAtual));
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFrame f=new JFrame();
        // Substituir a declaração explicita do local da pasta pelo objeto "File", vai utilizar a ultima pasta aberta
        JFileChooser fs = new JFileChooser(caminho);

        fs.setFileFilter(new FileNameExtensionFilter("Arquivos de Imagem (png, jpg, jpeg, bmp)","png","jpg","jpeg","bmp"));
        fs.setAcceptAllFileFilterUsed(false);
        fs.setDialogTitle("Selecione o arquivo de imagem...");
        int retorno = fs.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            try {
                arqImagemOriginal = fs.getSelectedFile();
                imagemAtual = ImageIO.read(arqImagemOriginal);
                jLabel1.setIcon(new javax.swing.ImageIcon(imagemAtual));
                imagemFoiCarregada = true;
                JOptionPane.showMessageDialog(f, "Imagem Carregada!");
                // Atualizar o caminho para não reiniciar a pesquisa da pasta raiz do sistema
                caminho = fs.getCurrentDirectory();

            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
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
                if ("FlatLaf".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}



/*




*/