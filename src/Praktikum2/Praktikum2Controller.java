/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author User
 */
public class Praktikum2Controller {
    
    private Praktikum2 view;
    private List<Integer> list = new ArrayList<>();
    
public Praktikum2Controller(Praktikum2 view){
        this.view = view;
        
            this.view.getBtnBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        }) ;
        
        this.view.getBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        
    }
    private JTextPane txtPane;
    
    private void save() {
        JFileChooser loadFile = view.getLoadFile();
         if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
             BufferedOutputStream writer = null;
             
                 try {
                 String contents = view.getTxtPane().getText();
                 if (contents != null && !contents.isEmpty()) {
                     writer = new BufferedOutputStream(new FileOutputStream(loadFile.getSelectedFile()));
                     
                     //writer.write(contents.getBytes());
                    File sel1 = loadFile.getSelectedFile();
                    int temp =0;
                    byte[] buffer1 = new byte[(int) sel1.length()];
                    writer.write(buffer1);
                    contents.getBytes();

                     JOptionPane.showMessageDialog(view, "File berhasil ditulis.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                 }

             } catch (FileNotFoundException ex) {
                Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE,null,ex);
            } catch (IOException ex){
                Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE,null,ex);
            }finally{
                if (writer != null) {
                    try {
                        writer.flush();
                        writer.close();
                        view.getTxtPane().setText("");
                    } catch (IOException ex) {
                        Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE,null,ex);
                    }
                 }
             }
         }
    }
    
    private void proses() {
        
        JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
             if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
                 BufferedInputStream reader = null;
                 try {
                     reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
                     File sel = loadFile.getSelectedFile();
                     doc.insertString(0, "", null);
                     int temp = 0;
                     List<Integer> list = new ArrayList<>();
                     byte[] buffer = new byte[(int) sel.length()];
                     reader.read(buffer);
                         list.add(temp);
//                     while ((temp=reader.read()) != -1) {                    
//                         list.add(temp);
//                     }
                     if (!list.isEmpty()) {
                         byte[] dt = new byte[list.size()];
                         int i = 0;
                         for (Integer integer : list) {
                             dt[i]=integer.byteValue();
                             i++;
                         }
                         doc.insertString(doc.getLength(), new String(buffer), null);
                         JOptionPane.showMessageDialog(view, "File berhasil dibaca.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                     } 
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException | BadLocationException ex) {
                     Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                 } finally {
                     if (reader != null) {
                         try {
                             reader.close();
                         } catch (IOException ex) {
                             Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                 }
             }
     }
}
             
    
