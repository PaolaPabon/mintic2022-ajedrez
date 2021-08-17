package co.edu.utp.misiontic2022.c2.reto3.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.reto3.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;

public class FormularioConsulta extends JFrame {
    
    private ReportesController controller;
    private JTable tabla;
    
    public FormularioConsulta () {
        controller = new ReportesController();
        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setTitle("Consultas Proyecto Construccion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800, 600);
        
        var op1 = new JTabbedPane();
        getContentPane().add(op1,BorderLayout.CENTER);

        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        op1.addTab("Consulta Proyectos Bancos", panel1);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("banco"));
        var textBanco = new JTextField(20);
        panelEntrada.add(textBanco);

        var botonConsulta = new JButton("Genera Consulta");
        botonConsulta.addActionListener( e -> consultarProyectosPorBancos (textBanco.getText().trim()));                

        panelEntrada.add(botonConsulta);
        panel1.add(panelEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel1.add(new JScrollPane(tabla),BorderLayout.CENTER);
    } 
    private void consultarProyectosPorBancos(String banco){
        try {
            var lista = controller.listadoProyectoBanco(banco);
            var tableModel = new ProyectosTableModel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private class ProyectosTableModel extends AbstractTableModel {
        
        private List<ProyectoBancoVo> data;              
        
        public void setData(List<ProyectoBancoVo> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        
        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "ID";
                case 1:
                    return "Constructora";
                case 2:
                    return "Ciudad";
                case 3:
                    return "Clasificacion";
                case 4:
                    return "Estrato";
                case 5:
                    return "Lider";
                }
                return super.getColumnName(column);
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           
            var project = data.get(rowIndex);
            switch (columnIndex){
                case 0:
                    return project.getId();
                case 1:
                    return project.getConstructora();
                case 2:
                    return project.getCiudad();
                case 3:
                    return project.getClasificacion();
                case 4:
                    return project.getEstrato();
                case 5:
                    return project.getLider();
                }
            return null;
        }


    }
}
