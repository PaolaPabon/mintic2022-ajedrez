package co.edu.utp.misiontic2022.c2.reto3.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

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
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;

public class FormularioConsulta extends JFrame {
    
    private ReportesController controller;
    private JTable tabla1;
    private JTable tabla2;
    private JTable tabla3;

    public FormularioConsulta () {
        controller = new ReportesController();
        initUI1();
        setLocationRelativeTo(null);
    }

    private void initUI1() {
        setTitle("Consultas Proyecto Construccion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800, 600);
        
        var op1 = new JTabbedPane();
        getContentPane().add(op1,BorderLayout.CENTER);

        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        op1.addTab("Consulta Proyectos Financiados - Bancos", panel1);

        var panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        op1.addTab("Listado Total Pagado por Proyectos", panel2);

        var panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        op1.addTab("Top 10 de los Lideres que menos gastan", panel3);
        
        //
        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Banco"));
        var textBanco = new JTextField(20);
        panelEntrada.add(textBanco);
       
        var botonConsulta = new JButton("Genera Consulta");
        botonConsulta.addActionListener( e -> consultarProyectosPorBancos (textBanco.getText().trim()));                

        panelEntrada.add(botonConsulta);
        panel1.add(panelEntrada, BorderLayout.PAGE_START);

        tabla1 = new JTable();
        panel1.add(new JScrollPane(tabla1),BorderLayout.CENTER);

        //
        var panelEntrada2 = new JPanel();
        panelEntrada2.add(new JLabel("Superiores a (Limite)"));
        var textlimit = new JTextField(20);
        panelEntrada2.add(textlimit);
       
        var botonConsulta2 = new JButton("Genera Consulta");
        botonConsulta2.addActionListener( 
            e -> consultarProyectosPagados(Double.parseDouble(textlimit.getText().trim())));                

        panelEntrada2.add(botonConsulta2);
        panel2.add(panelEntrada2, BorderLayout.PAGE_START);

        tabla2 = new JTable();
        panel2.add(new JScrollPane(tabla2),BorderLayout.CENTER);
        
        //
        var panelEntrada3 = new JPanel();
             
        var botonConsulta3 = new JButton("Generar Consulta");
        botonConsulta3.addActionListener( e -> consultarComprasDeLider());             
        
        panelEntrada3.add(botonConsulta3);
       
        panel3.add(panelEntrada3, BorderLayout.PAGE_START);

        tabla3 = new JTable();
        panel3.add(new JScrollPane(tabla3),BorderLayout.CENTER);
    } 
    private void consultarProyectosPorBancos(String banco){
        try {
            var lista = controller.listadoProyectoBanco(banco);
            var tableModel = new ProyectosTableModel1();
            tableModel.setData(lista);
            tabla1.setModel(tableModel);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void consultarProyectosPagados(Double limiteInferior){
        try {
            var lista = controller.listadoPagosPorProyectos(limiteInferior);
            var tableModel2 = new ProyectosTableModel2();
            tableModel2.setData(lista);
            tabla2.setModel(tableModel2);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarComprasDeLider(){
        try {
            var lista = controller.listadoComprasDeLider();
            var tableModel3 = new ProyectosTableModel3();
            tableModel3.setData(lista);
            tabla3.setModel(tableModel3);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    // Bancos

    private class ProyectosTableModel1 extends AbstractTableModel {
        
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
    private class ProyectosTableModel2 extends AbstractTableModel {
        
        private List<PagadoPorProyectoVo> data;              
        
        public void setData(List<PagadoPorProyectoVo> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        
        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "ID";
                case 1:
                    return "VALOR";
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
                DecimalFormat df = new DecimalFormat("$ ###,###.0");
                return df.format(project.getValor());
                }
            return null;
        }


    }
    private class ProyectosTableModel3 extends AbstractTableModel {
        
        private List<ComprasDeLiderVo> data;              
        
        public void setData(List<ComprasDeLiderVo> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }
       
        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "LIDER";
                case 1:
                    return "VALOR";
                }
                return super.getColumnName(column);
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           
            var project = data.get(rowIndex);
            switch (columnIndex){
                case 0:
                    return project.getLider();
                case 1:
                    DecimalFormat df = new DecimalFormat("$ ###,###.0");
                    return df.format(project.getValor());
                }
            return null;
        }
    }
    
}
