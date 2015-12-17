<jsp:include page="topo.jsp"></jsp:include>
<!-- Carregar as taglibs do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

			<h3 class="page-header">Sistema de Gerenciamento de Produtos</h3>
			<%
				if(request.getAttribute("msg") != null){
					out.print((String) request.getAttribute("msg"));
				}
			%>
			${msg }
<jsp:include page="rodape.jsp"></jsp:include>