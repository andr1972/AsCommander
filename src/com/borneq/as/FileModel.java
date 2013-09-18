package com.borneq.as;

import javax.swing.table.AbstractTableModel;

public class FileModel extends AbstractTableModel {
	private static final long serialVersionUID = -4701896100426290392L;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return "Abc";
	}
	
	
	@Override
	public String getColumnName(int col) {
		return "aaa";
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
}

