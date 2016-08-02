package Telas;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class NotaFiscal {
	
	public NotaFiscal(){
		
		//Definindo tamanho da página
		Document document = new Document(PageSize.A4.rotate(),10,10,10,10); 
		
		try { //tentativa de abrir o documento e escrever
			PdfWriter.getInstance(document, new FileOutputStream("C:\\dmr\\PDF_DevMedia.pdf")); 
			document.open(); 

			//criação de paragrafos e tabelas com suas características
					
			Paragraph Titulo = new Paragraph("Nota Fiscal de Compra\n\n");
			Titulo.setAlignment(Element.ALIGN_CENTER);
			
			PdfPTable Tabela = new PdfPTable(1);
			
			PdfPCell Emitente = new PdfPCell(new Paragraph("Emitente: "));
			Emitente.setHorizontalAlignment(Element.ALIGN_LEFT);
			Emitente.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell Emp = new PdfPCell(new Paragraph("DMR - Sistema Comercial / Informática Tecnologia\n"
													+ "Rua: Comendador, 325 - Centro - Lafaiete - MG \n"
													+ "CEP: 34300-00    Tel.: (32)3331-7777    CNPJ: XX.XXX.XXX/YYYY-ZZ" ));
			Emp.setHorizontalAlignment(Element.ALIGN_CENTER);
			Emp.setPadding(10);
			
			
			//dados do clinte
			PdfPTable dadosCliente = new PdfPTable(12);
			
			PdfPCell tituloCli = new PdfPCell(new Paragraph("Dados do Cliente"));
			tituloCli.setHorizontalAlignment(Element.ALIGN_LEFT);
			tituloCli.setBorder(PdfPCell.NO_BORDER);
			tituloCli.setColspan(12);
			tituloCli.setNoWrap(true);			
			
			PdfPCell nome = new PdfPCell(new Paragraph("Nome:\n"
														+ " "));
			nome.setHorizontalAlignment(Element.ALIGN_LEFT);
			nome.setColspan(8);
			nome.setNoWrap(true);
			
			PdfPCell cpf = new PdfPCell(new Paragraph("CPF:\n"
													  + "000.000.000-00"));
			cpf.setHorizontalAlignment(Element.ALIGN_LEFT);
			cpf.setColspan(2);
			cpf.setNoWrap(true);
			
			PdfPCell dataEmi = new PdfPCell(new Paragraph("Data Emissão:\n"
															+ "00/00/0000"));
			dataEmi.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataEmi.setColspan(2);
			dataEmi.setNoWrap(true);
			
			
			
			PdfPCell endereco = new PdfPCell(new Paragraph("Endereço:\n"
											+ " "));
			endereco.setColspan(6);
			endereco.setHorizontalAlignment(Element.ALIGN_LEFT);
			endereco.setNoWrap(true);
			
			PdfPCell bairro = new PdfPCell(new Paragraph("Bairro:\n"
											+ " "));
			bairro.setHorizontalAlignment(Element.ALIGN_LEFT);
			bairro.setColspan(2);
			bairro.setNoWrap(true);
			
			PdfPCell cep = new PdfPCell(new Paragraph("CEP:\n"
										+ "00.000-000"));
			cep.setHorizontalAlignment(Element.ALIGN_LEFT);
			cep.setColspan(2);
			cep.setNoWrap(true);			
			
			PdfPCell dataEnt = new PdfPCell(new Paragraph("Data da Entada:\n"
														+ "00/00/0000"));
			dataEnt.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataEnt.setColspan(2);
			dataEnt.setNoWrap(true);
			
			
			
			
			PdfPCell municipio = new PdfPCell(new Paragraph("Município:\n"
											+ " "));
			municipio.setHorizontalAlignment(Element.ALIGN_LEFT);
			municipio.setColspan(7);
			municipio.setNoWrap(true);
			
			PdfPCell estado = new PdfPCell(new Paragraph("Estado:\n"
											+ "MG"));
			estado.setHorizontalAlignment(Element.ALIGN_LEFT);
			estado.setColspan(1);
			estado.setNoWrap(true);
			
			PdfPCell insEstadual = new PdfPCell(new Paragraph("Insc. Estadual:\n"
												+ "000.000.000-0000"));
			insEstadual.setHorizontalAlignment(Element.ALIGN_LEFT);
			insEstadual.setColspan(2);
			insEstadual.setNoWrap(true);
			
			PdfPCell horaSaida = new PdfPCell(new Paragraph("Hora da Saída:\n"
												+ "00:00"));
			horaSaida.setHorizontalAlignment(Element.ALIGN_LEFT);
			horaSaida.setColspan(2);
			horaSaida.setNoWrap(true);
			
			
			
			//dados do produto
			PdfPTable dadosProduto = new PdfPTable(12);
			
			PdfPCell tituloProd = new PdfPCell(new Paragraph("Dados do Produto"));
			tituloProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			tituloProd.setBorder(PdfPCell.NO_BORDER);
			tituloProd.setColspan(12);
			tituloProd.setNoWrap(true);
			
			PdfPCell codigoProd = new PdfPCell(new Paragraph("Código"));
			codigoProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			codigoProd.setColspan(1);

			PdfPCell nomeProd = new PdfPCell(new Paragraph("Descrição do Produto"));
			nomeProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			nomeProd.setColspan(4);
			
			PdfPCell unidadeProd = new PdfPCell(new Paragraph(" Unidade"));
			unidadeProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			unidadeProd.setColspan(1);
			
			PdfPCell qtdeProd = new PdfPCell(new Paragraph(" Quantidade"));
			qtdeProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			qtdeProd.setColspan(2);
			qtdeProd.setNoWrap(true);
			
			PdfPCell valorUniProd = new PdfPCell(new Paragraph(" Valor Unitário"));
			valorUniProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			valorUniProd.setColspan(2);
			
			PdfPCell valorTotProd = new PdfPCell(new Paragraph(" Valor Total"));
			valorTotProd.setHorizontalAlignment(Element.ALIGN_LEFT);
			valorTotProd.setColspan(2);
			
			
			
			PdfPCell codProd = new PdfPCell(new Paragraph("01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"+"01\n"));
			codProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			codProd.setColspan(1);
			codProd.setMinimumHeight(230);
			
			PdfPCell descProd = new PdfPCell(new Paragraph(" "));
			descProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			descProd.setColspan(4);
			descProd.setMinimumHeight(230);
			
			PdfPCell uniProd = new PdfPCell(new Paragraph("und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"+"und\n"));
			uniProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			uniProd.setColspan(1);
			descProd.setMinimumHeight(230);
			
			PdfPCell qtdesProd = new PdfPCell(new Paragraph(" "));
			qtdesProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			qtdesProd.setColspan(2);
			descProd.setMinimumHeight(230);
			
			PdfPCell valUniProd = new PdfPCell(new Paragraph(" "));
			valUniProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			valUniProd.setColspan(2);
			descProd.setMinimumHeight(230);
			
			PdfPCell valTotProd = new PdfPCell(new Paragraph(" "));
			valTotProd.setHorizontalAlignment(Element.ALIGN_CENTER);
			valTotProd.setColspan(2);
			descProd.setMinimumHeight(230);
			
			
			
			PdfPCell espaco = new PdfPCell(new Paragraph(" "));
			espaco.setHorizontalAlignment(Element.ALIGN_CENTER);
			espaco.setBorder(PdfPCell.NO_BORDER);
			espaco.setColspan(10);
			
			PdfPCell valTotNota = new PdfPCell(new Paragraph("Total:"));
			valTotNota.setHorizontalAlignment(Element.ALIGN_LEFT);
			valTotNota.setColspan(2);
			
			PdfPTable dadosNota = new PdfPTable(12);
			
			PdfPCell tituloEntrega = new PdfPCell(new Paragraph("Dados do Entrega"));
			tituloEntrega.setHorizontalAlignment(Element.ALIGN_LEFT);
			tituloEntrega.setBorder(PdfPCell.NO_BORDER);
			tituloEntrega.setColspan(12);
			tituloEntrega.setNoWrap(true);
			
			PdfPCell dataEntrega = new PdfPCell(new Paragraph("Data de Entrega\n"
												+ " "));
			dataEntrega.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataEntrega.setColspan(2);
			
			PdfPCell assinatura = new PdfPCell(new Paragraph("Assinatura\n"
												+ " "));
			assinatura.setHorizontalAlignment(Element.ALIGN_LEFT);
			assinatura.setColspan(8);
			
			PdfPCell numNota = new PdfPCell(new Paragraph("Nº Nota Fiscal\n"
											+ " "));
			numNota.setHorizontalAlignment(Element.ALIGN_LEFT);
			numNota.setColspan(2);
			
			//adicionando os elementos ao documento e às tabelas
			Tabela.addCell(Emitente);
			Tabela.addCell(Emp);
			
			dadosCliente.addCell(tituloCli);
			dadosCliente.addCell(nome);
			dadosCliente.addCell(cpf);
			dadosCliente.addCell(dataEmi);
			
			dadosCliente.addCell(endereco);
			dadosCliente.addCell(bairro);
			dadosCliente.addCell(cep);
			dadosCliente.addCell(dataEnt);
			
			dadosCliente.addCell(municipio);
			dadosCliente.addCell(estado);
			dadosCliente.addCell(insEstadual);
			dadosCliente.addCell(horaSaida);
			
			dadosProduto.addCell(tituloProd);
			dadosProduto.addCell(codigoProd);
			dadosProduto.addCell(nomeProd);
			dadosProduto.addCell(unidadeProd);
			dadosProduto.addCell(qtdeProd);
			dadosProduto.addCell(valorUniProd);
			dadosProduto.addCell(valorTotProd);			
			
			dadosProduto.addCell(codProd);
			dadosProduto.addCell(descProd);
			dadosProduto.addCell(uniProd);
			dadosProduto.addCell(qtdesProd);
			dadosProduto.addCell(valUniProd);
			dadosProduto.addCell(valTotProd);
			dadosNota.addCell(espaco);
			dadosNota.addCell(valTotNota);
			
			dadosNota.addCell(tituloEntrega);
			dadosNota.addCell(dataEntrega);
			dadosNota.addCell(assinatura);
			dadosNota.addCell(numNota);
			
			document.add(Titulo);
			document.add(Tabela);
			document.add(dadosCliente);
			document.add(dadosProduto);
			document.add(dadosNota);
			
			//mesagens em caso de falha na abertura e tentativa de escrita
		} catch(DocumentException de) { 
				System.err.println(de.getMessage()); 
		} catch(IOException ioe) { 
				System.err.println(ioe.getMessage()); 
		}
		
		//fechando arquivo
		document.close();
	}
	public static void main(String[] args){
		new NotaFiscal();
	}
}
