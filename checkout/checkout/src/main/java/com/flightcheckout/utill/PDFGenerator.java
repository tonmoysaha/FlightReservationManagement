package com.flightcheckout.utill;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.table.TableColumn;

import org.springframework.stereotype.Component;

import com.flightcheckout.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	
	public void generateItinerary(Reservation reservation, String filePath) throws FileNotFoundException, DocumentException {
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(filePath));
		
		document.open();
		document.add(new PdfPTable(2));
		document.close();
			
		
	}

}
