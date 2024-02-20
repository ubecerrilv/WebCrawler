package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import control.Comandos;
import modelo.Correo;
import modelo.Descargador;
import modelo.Pagina;



@SuppressWarnings("serial")
public class Ventana extends VentanaAGeneral{
	
	
	JPanel panelCent, panelCab, panelBot;
	JLabel paginas, correos, eBuscar, cred;
	JTextArea pag, pagMap, corMap;
	JButton bBuscar;
	JScrollPane sP, sC;
	
	Descargador descargador;
	Pagina aPagina;
	Correo aCorreo;
	
	
	
	public Ventana() {
		super("Web Crawler");
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setExtendedState(MAXIMIZED_BOTH);
		
		//CREAR PANELES
		
		//PANEL CENTRAL
		panelCent = new JPanel(new GridLayout(1,2));
		panelCent.setBorder(new EmptyBorder(5,5,5,5));
		panelCent.setBackground(Color.BLACK);
		
		//PANEL DE CABECERA
		panelCab = new JPanel(new GridLayout(2,2));
		panelCab.setBorder(new EmptyBorder(5,5,5,5));
		
		//SUBPANEL PARA EL BOTON
		panelBot = new JPanel(new GridLayout(1,3));
		panelBot.setBorder(new EmptyBorder(5,5,5,5));
		
		
		//CREAR ETIQUETAS
		
		paginas = new JLabel("PÁGINAS:");
		correos = new JLabel("CORREOS:");
		eBuscar = new JLabel("INGRESA EL URL A MAPEAR:");
		cred = new JLabel("Realizado por Ulises Becerril Valdés");
		
		//CREAR TEXTAREAS
		pag = new JTextArea("");
		pagMap = new JTextArea("");
			pagMap.setEditable(false);
		corMap = new JTextArea("");
			corMap.setEditable(false);
			
		//CREAR BOTON DE MAPEAR
		bBuscar = new JButton("Mapear página");
		bBuscar.setActionCommand(Comandos.BUSCA);
		bBuscar.addActionListener(this);
		
		//CREAR SCROLLS
		sP = new JScrollPane(pagMap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		sC = new JScrollPane(corMap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		//AGREAGAR LOS ELEMENTOS A LOS PANELES
		
		//SUBPANEL BUSCAR
			panelBot.add(eBuscar);
			panelBot.add(pag);
			panelBot.add(bBuscar);
			
		//PANEL DE CABECERA
			panelCab.add(panelBot);
			panelCab.add(new JLabel());
			panelCab.add(paginas);
			panelCab.add(correos);
	
		//PANEL CENTRAL
			panelCent.add(sP);
			panelCent.add(sC);
		
		//AGREGAR LOS PANELES A LA VENTANA
		this.add(panelCab, BorderLayout.NORTH);
		this.add(panelCent, BorderLayout.CENTER);
		this.add(cred, BorderLayout.SOUTH);
		
	
		//this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case Comandos.BUSCA:
			this.pagMap.setText("");
			this.corMap.setText("");
			
			descargador = new Descargador();
			aPagina = new Pagina();
			aCorreo = new Correo();
			
			
			ArrayList<String> paginas = new ArrayList<String>();
			ArrayList<String> correos = new ArrayList<String>();
			
			if(pag.getText().compareToIgnoreCase("")==0) {
				JOptionPane.showMessageDialog(this, "Coloca un URL");
			}else {
				String HTML = descargador.obtenerHTML(pag.getText());
							
				paginas = aPagina.analiza(HTML);
				correos= aCorreo.analiza(HTML);
				
				for(int i =0; i<paginas.size();i++) {
					this.pagMap.setText(this.pagMap.getText()+"\n"+paginas.get(i));
				}
				
				for(int i =0; i<correos.size();i++) {
					this.corMap.setText(this.corMap.getText()+"\n"+correos.get(i));
				}
			
				
				if(!paginas.isEmpty()) {
					for(int i =0; i<paginas.size();i++) {
						
						recursivo(paginas.get(i));
					}
				}
			}
			
			
			
			
			
			break;
	
				
			}
		}
	
	public void recursivo(String pag) {
		ArrayList<String> paginas = new ArrayList<String>();
		ArrayList<String> correos = new ArrayList<String>();
		descargador = new Descargador();
		aPagina = new Pagina();
		aCorreo = new Correo();
		
		
		String HTML = descargador.obtenerHTML(pag);
		paginas = aPagina.analiza(HTML);
		correos = aCorreo.analiza(HTML);
		
		for(int i =0; i<paginas.size();i++) {
			this.pagMap.setText(this.pagMap.getText()+"\n"+paginas.get(i));
		}
		
		for(int i =0; i<correos.size();i++) {
			this.corMap.setText(this.corMap.getText()+"\n"+correos.get(i));
		}
		
		

	}
	

}
