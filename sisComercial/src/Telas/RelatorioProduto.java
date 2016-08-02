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

public class RelatorioProduto {

	
	public RelatorioProduto(){
		
		//Definindo tamanho da página
		Document document = new Document(PageSize.A4.rotate(),0, 0, 0, 0); 
		
		try { //tentativa de abrir o documento e escrever
			PdfWriter.getInstance(document, new FileOutputStream("C:\\dmr\\Relatório_Produto.pdf")); 
			document.open(); 

			//criação de paragrafos e tabelas com suas características
			Paragraph Titulo = new Paragraph("Relatório de Produtos\n\n");
			Titulo.setAlignment(Element.ALIGN_CENTER);
			
			PdfPTable Cabecalho = new PdfPTable(4);
			
			PdfPCell codigoProd = new PdfPCell(new Paragraph("Código:\n"
										+ " "));
			codigoProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			codigoProd.setNoWrap(true);
			
			PdfPCell nomeProd = new PdfPCell(new Paragraph("Descrição:\n"
												+ " "));
			nomeProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			nomeProd.setColspan(2);
			nomeProd.setNoWrap(true);

			PdfPCell qtdeEstoque = new PdfPCell(new Paragraph("Qtde em Estoque:\n"
												+ " "));
			qtdeEstoque.setHorizontalAlignment(Element.ALIGN_LEFT);
			qtdeEstoque.setNoWrap(true);
			
			Cabecalho.addCell(codigoProd);
			Cabecalho.addCell(nomeProd);
			Cabecalho.addCell(qtdeEstoque);
			
			
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
		new RelatorioProduto();

	}

}
