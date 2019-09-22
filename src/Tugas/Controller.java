/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Controller {
private hitungpersegipanjang view;
    private List<Integer> list = new ArrayList<>();
    
    public Controller (hitungpersegipanjang view){
        
        this.view = view;
        
        this.view.getHasilLuas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitung();
            }
        }) ;
        
        this.view.getHasilKeliling().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               hapus();
            }
        });
        
    }
    int panjang, lebar, luas, keliling;
    void hitung() {
        panjang = Integer.parseInt(view.getPanjang().getText());
        lebar = Integer.parseInt(view.getLebar().getText());
        luas = panjang*lebar;
        keliling = 2 *(panjang + lebar);
        view.getHasilLuas().setText(String.valueOf(luas));
        view.getHasilKeliling().setText(String.valueOf(keliling));

        view.getPanjang().setText(""+panjang);
        view.getLebar().setText(""+lebar);
        view.getHasilLuas().setText(""+luas);
        view.getHasilKeliling().setText(""+keliling);
        
    }
    
    void hapus() {
        view.getPanjang().setText("");
        view.getLebar().setText("");
        view.getHasilKeliling().setText("");
        view.getHasilLuas().setText("");
    }
        
 }
    


