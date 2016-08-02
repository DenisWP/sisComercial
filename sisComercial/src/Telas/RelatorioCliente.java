package Telas;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class RelatorioCliente {
	public RelatorioCliente(){
		
		//Definindo tamanho da página
		Document document = new Document(PageSize.A4.rotate()); 
		
		try { //tentativa de abrir o documento e escrever
			PdfWriter.getInstance(document, new FileOutputStream("C:\\dmr\\Relatório_Produto.pdf")); 
			document.open(); 

			//criação de paragrafos e tabelas com suas características
			Paragraph Titulo = new Paragraph("Relatório de Cliente\n\n");
			Titulo.setAlignment(Element.ALIGN_CENTER);
			
			PdfPTable Cabecalho = new PdfPTable(4);
			
			PdfPCell codigoCli = new PdfPCell(new Paragraph("Código:\n"
										+ " "));
			codigoCli.setHorizontalAlignment(Element.ALIGN_LEFT);
			codigoCli.setNoWrap(true);
			
			PdfPCell nomeCli = new PdfPCell(new Paragraph("Descrição:\n"
												+ " "));
			nomeCli.setHorizontalAlignment(Element.ALIGN_LEFT);
			nomeCli.setColspan(2);
			nomeCli.setNoWrap(true);

			PdfPCell registroCli = new PdfPCell(new Paragraph("Registro:\n"
												+ " "));
			registroCli.setHorizontalAlignment(Element.ALIGN_LEFT);
			registroCli.setNoWrap(true);
			
			Cabecalho.addCell(codigoCli);
			Cabecalho.addCell(nomeCli);
			Cabecalho.addCell(registroCli);
			
			
			document.add(Titulo);
			document.add(Cabecalho);
			//mesagens em caso de falha na abertura e tentativa de escrita
		} catch(DocumentException de) { 
				System.err.println(de.getMessage()); 
		} catch(IOException ioe) { 
				System.err.println(ioe.getMessage()); 
		}
		//fechando arquivo
		document.close(); 			
		
	}
	public static void main(String[] args) {
		new RelatorioCliente();
	}
}