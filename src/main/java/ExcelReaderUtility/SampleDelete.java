package ExcelReaderUtility;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class SampleDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  CellStyle numberStyle = new CellStyle(HorizontalAlign.right);

		    Table t = new Table(3, BorderStyle.DESIGN_FORMAL,
		        ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
		    t.setColumnWidth(0, 8, 14);
		    t.setColumnWidth(1, 7, 16);
		    t.setColumnWidth(2, 9, 16);
		    
		    t.addCell("Region");
		    t.addCell("Orders");
		    t.addCell("Sales", numberStyle);

		    t.addCell("North");
		    t.addCell("6,345", numberStyle);
		    t.addCell("$87.230", numberStyle);

		    t.addCell("Center");
		    t.addCell("837", numberStyle);
		    t.addCell("$12.855", numberStyle);

		    t.addCell("South");
		    t.addCell("5,344", numberStyle);
		    t.addCell("$72.561", numberStyle);

		    t.addCell("Total", numberStyle, 2);
		    t.addCell("$172.646", numberStyle);

		    System.out.println(t.render());
	}

}
