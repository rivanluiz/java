package control;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Produto;
import persistence.ProdutoDao;

@WebServlet("/ControleProduto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleProduto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("gravar".equals(request.getParameter("cmd"))) {
			gravar(request, response);
		}
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Produto p = new Produto();
			p.setNome(request.getParameter("nome"));
			p.setPreco(new Double(request.getParameter("preco")));
			p.setQuantidade(new Integer(request.getParameter("quantidade")));

			int ano = new Integer(request.getParameter("dataCompra").substring(0, 4));
			int mes = new Integer(request.getParameter("dataCompra").substring(5, 7));
			int dia = new Integer(request.getParameter("dataCompra").substring(8, 10));
			p.setDataCompra(new GregorianCalendar(ano, mes-1,dia).getTime());
			
			ProdutoDao d = new ProdutoDao();
			d.create(p);
			
			request.setAttribute("msg", "Dados gravados.");
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

}
